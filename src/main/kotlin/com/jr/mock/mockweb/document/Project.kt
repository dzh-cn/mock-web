package com.jr.mock.mockweb.document

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "mk_project")
class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Int? = null
    @Column
    var name: String? = null
    @Column
    var role: String? = null
    @Column
    var desc: String? = null
    @Column
    var createdDate: Date? = Date()
}