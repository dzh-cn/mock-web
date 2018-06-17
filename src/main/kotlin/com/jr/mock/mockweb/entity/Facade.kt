package com.jr.mock.mockweb.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "mk_facade")
class Facade: OperatorCommon() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    @Column
    var projectId: Int? = null
    @Column
    var uri: String? = null
    @Column
    var name: String? = null
    @Column
    var desc: String? = null
    @Column
    var method: String? = null
    @Column
    var status: String? = null

    var params: Array<Param>? = null

    override fun toString(): String {
        return "Facade(id=$id, projectId=$projectId, uri=$uri, name=$name, desc=$desc, method=$method, status=$status, params=${Arrays.toString(params)})"
    }

}