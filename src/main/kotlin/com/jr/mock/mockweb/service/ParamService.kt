package com.jr.mock.mockweb.service

import com.jr.mock.mockweb.entity.Param
import com.jr.mock.mockweb.repository.ParamRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.stereotype.Service
import java.util.*

/**
 * 参数Service
 * @author: dongzhihua
 * @time: 2018/6/19 10:01:54
 */
@Service
class ParamService {
	@Autowired
	lateinit var paramRepository: ParamRepository

	/**
	 * 保存参数，并生成code
	 * @author: dongzhihua
	 * @time: 2018/6/19 10:02:40
	 */
	fun save(param: Param) {
		param.modifiedDate = Date()
		paramRepository.save(param)
		if (param.pid == null) { // 根节点逻辑
			param.code = param.facadeId?.toString() + "_" + String.format("%02d", param.id) //pam.id?.toString()
		} else {
			var parent = paramRepository.findById(param.pid ?: 0).get()
			param.code = parent.code + "_" + String.format("%02d", param.id)
		}
		param.modifiedDate = Date()
		paramRepository.save(param)
	}

	/**
	 * 初始化数据，如果是手动提交sql工单，生成code比较麻烦，可以通过这个方法初始化
	 * @author: dongzhihua
	 * @time: 2018/6/19 10:09:48
	 */
	fun initData(param: Param) {
		var map = mutableMapOf<Long?, Param>()
		for (param in paramRepository.findAll(Example.of(param))) {
			map[param.id] = param
		}
		initCode(map, null)
	}

	/**
	 * 初始化code
	 * @author: dongzhihua
	 * @time: 2018/6/19 10:10:16
	 */
	fun initCode(all: MutableMap<Long?, Param>, id: Long?) {
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