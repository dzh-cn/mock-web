package com.jr.mock.mockweb.entity

import javax.persistence.*

/**
 * 接口
 * @author: dongzhihua
 * @time: 2018/6/19 9:59:41
 */
@Entity
@Table(name = "mk_facade")
class Facade : OperatorCommon() {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Long? = null
	@Column
	var projectId: Long? = null // 项目id
	@Column
	var uri: String? = null // 请求路径 /oder/query.biz
	@Column
	var name: String? = null // 名称
	@Column
	var explaination: String? = null // 说明
	@Column
	var method: String? = null // 方法 get post put
	@Column
	var status: String? = null // 状态 生效，下线，不建议使用

	override fun toString(): String {
		return "Facade(id=$id, projectId=$projectId, uri=$uri, name=$name, explaination=$explaination, method=$method, status=$status})"
	}

}