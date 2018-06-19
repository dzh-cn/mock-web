package com.jr.mock.mockweb.entity

import javax.persistence.*

/**
 * 接口参数
 * @author: dongzhihua
 * @time: 2018/6/19 10:00:14
 */
@Entity
@Table(name = "mk_param")
class Param : OperatorCommon() {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Long? = null
	@Column
	var facadeId: Long? = null // 接口id
	@Column
	var pid: Long? = null // 父id
	@Column
	var name: String? = null // 参数
	@Column
	var explaination: String? = null // 参数说明
	@Column
	var model: String? = null // 参数、返回值
	@Column
	var type: String? = null // 字符串、对象、数字、数字
	@Column
	var mock: String? = null // mock规则，可参照node.js mock
	@Column
	var code: String? = null // 编码，根据上级编码生成，为了计算参数级别和排序，实现页面效果

	override fun toString(): String {
		return "Param(id=$id, facadeId=$facadeId, pid=$pid, name=$name, explaination=$explaination, model=$model, type=$type, mock=$mock, code=$code)"
	}
}