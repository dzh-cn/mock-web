package com.jr.mock.mockweb.service

import com.google.gson.Gson
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

	var gson = Gson()

	/**
	 * 保存参数，并生成code
	 * @author: dongzhihua
	 * @time: 2018/6/19 10:02:40
	 */
	fun save(param: Param) {
		param.modifiedDate = Date()
		paramRepository.save(param) // 先保存，因为生成code需要id
		if (param.pid == null) { // 根节点逻辑
			param.code = param.facadeId?.toString() + "_" + String.format("%02d", param.id) //pam.id?.toString()
		} else {
			var parent = paramRepository.findById(param.pid ?: 0).get()
			param.code = parent.code + "_" + String.format("%02d", param.id)
		}
		param.modifiedDate = Date()
		paramRepository.save(param) // 再保存一次，因为生成了code
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
		initCode(map, null) // 初始化code
	}

	/**
	 * 初始化code，项目id_父code_id
	 * @author: dongzhihua
	 * @time: 2018/6/19 10:10:16
	 */
	fun initCode(all: MutableMap<Long?, Param>, id: Long?) {
		if (id != null) {
			var pam = all[id]
			if (pam == null || pam.code != null) {
				return
			}

			if (pam.pid == null) { // 如果pid为空
				pam.code = pam.facadeId?.toString() + "_" + String.format("%02d", pam.id) //pam.id?.toString()
				paramRepository.save(pam)
				return
			}

			if (all[pam.pid!!]?.code == null) { // 如果上级code为空，则先初始化上级code
				initCode(all, pam.pid)
			}

			// 生成code
			pam.code = all[pam.pid!!]?.code + "_" + String.format("%02d", pam.id)
			paramRepository.save(pam)
		}
		for (key in all.keys) {
			initCode(all, key) // 遍历所有
		}
	}

	/**
	 * 根据参数获取mock别表达式
	 * @author: dongzhihua
	 * @time: 2018/6/20 12:15:12
	 */
	fun getMock(param: Param): Any? {
		var map = mutableMapOf<Long?, MutableList<Param>>()
		for (param in paramRepository.findAll(Example.of(param))) {
			if (map[param.pid] == null) {
				map[param.pid] = mutableListOf()
			}
			map[param.pid]?.add(param)
		}

		return getMock(map[null], map)
	}

	/**
	 * 获取集合的mock表达式
	 * @author: dongzhihua
	 * @time: 2018/6/20 12:15:20
	 */
	fun getMock(paramList: List<Param>?, paramMap: MutableMap<Long?, MutableList<Param>>): MutableMap<Any?, Any?>? {
		var mockMap = mutableMapOf<Any?, Any?>()
		paramList ?: return null
		paramList?.forEach({

			var mock: Any? = when (it.type) {
				"Array" -> listOf(getMock(paramMap[it.id], paramMap))
				"Object" -> getMock(paramMap[it.id], paramMap)
				else -> null
			}
			// 如果mock为空，则获取自身mock表达式，用gson解析,偷个懒
			mock = mock?:gson.fromJson(it.mock, Any::class.java)
			mockMap[it.name] = mock?:it.mock
		})
		return mockMap
	}
}