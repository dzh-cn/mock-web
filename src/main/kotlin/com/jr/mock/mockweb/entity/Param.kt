package com.jr.mock.mockweb.entity

import javax.persistence.*

@Entity
@Table(name = "mk_param")
class Param: OperatorCommon() {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null
    @Column
    var facadeId:Int? = null
    @Column
    var fid:String? = null
    @Column
    var name:String? = null
    @Column
    var desc:String? = null
    @Column
    var model:String? = null
    @Column
    var type:String? = null
    @Column
    var mock:String? = null

    override fun toString(): String {
        return "Param(id=$id, facadeId=$facadeId, fid=$fid, name=$name, desc=$desc, model=$model, type=$type, mock=$mock)"
    }


}