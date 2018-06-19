package com.jr.mock.mockweb.entity

import javax.persistence.*

@Entity
@Table(name = "mk_project")
class Project: OperatorCommon() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null
    @Column
    var name: String? = null
    @Column
    var role: String? = null
    @Column
    var desc: String? = null
}