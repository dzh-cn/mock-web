package com.jr.mock.mockweb.entity

import javax.persistence.*

/**
 * 项目
 * @author: dongzhihua
 * @time: 2018/6/19 10:00:27
 */
@Entity
@Table(name = "mk_project")
class Project : OperatorCommon() {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Int? = null // 主键
	@Column
	var name: String? = null // 项目名
	@Column
	var role: String? = null // 隶属角色，与security角色对应
	@Column
	var desc: String? = null // 项目说明
}