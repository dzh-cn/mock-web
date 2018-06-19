package com.jr.mock.mockweb.service

import com.jr.mock.mockweb.entity.Param
import com.jr.mock.mockweb.repository.ParamRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.stereotype.Service
import java.util.*

@Service
class ParamService {
    @Autowired
    lateinit var paramRepository: ParamRepository

    fun save(param: Param) {
        paramRepository.save(param)
        if (param.pid == null) { // 根节点逻辑
            param.code = param.facadeId?.toString() + "_" + String.format("%02d", param.id) //pam.id?.toString()
        } else {
            var parent = paramRepository.findById(param.pid?:0).get()
            param.code = parent.code + "_" + String.format("%02d", param.id)
        }
        param.lastModifiedDate = Date()
        paramRepository.save(param)
    }

    /**
     * 获取参数:按照层次排序，子跟着父
     */
    fun queryByGradation(param: Param) {
        var list = paramRepository.findAll(Example.of(param))

        var parents = ArrayList<Param>()
        for (l in parents) {
            if (l.pid == null) {
                parents.add(l)
            }
        }
    }

    var inited = false

    fun initData() {
        if (inited) {
            return
        }
        inited = true
        var map = mutableMapOf<Int?, Param>()
        for (param in paramRepository.findAll()) {
            map[param.id] = param
        }
        initCode(map, null)
    }

    fun initCode(all: MutableMap<Int?, Param>, id: Int?) {
        if (id != null) {
            var pam = all[id]
            if (pam == null || pam.code != null) {
                return
            }

            if (pam.pid == null) {
                pam.code = pam.facadeId?.toString() + "_" + String.format("%02d", pam.id) //pam.id?.toString()
                paramRepository.save(pam)
                return
            }

            if (all[pam.pid!!]?.code == null) {
                initCode(all, pam.pid)
            }

            pam.code = all[pam.pid!!]?.code + "_" + String.format("%02d", pam.id)
            paramRepository.save(pam)
        }
        for (key in all.keys) {
            initCode(all, key)
        }
    }
}