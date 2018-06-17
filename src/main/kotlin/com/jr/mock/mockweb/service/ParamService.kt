package com.jr.mock.mockweb.service

import com.jr.mock.mockweb.entity.Param
import com.jr.mock.mockweb.repository.ParamRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.stereotype.Service

@Service
class ParamService {
    @Autowired
    lateinit var paramRepository: ParamRepository

    /**
     * 获取参数树形结构
     */
    fun queryTrue(param: Param) {
        var list = paramRepository.findAll(Example.of(param))

        var parents = ArrayList<Param>()
        for (l in parents) {
            if (l.fid == null) {
                parents.add(l)
            }
        }
    }
}