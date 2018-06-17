package com.jr.mock.mockweb.entity

import javax.persistence.*

@Entity
@Table(name = "mk_param")
class Param: OperatorCommon() {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int? = null
    @Column
    var facadeId:Int? = null // 接口id
    @Column
    var fid:Int? = null // 父id
    @Column
    var name:String? = null
    @Column
    var desc:String? = null
    @Column
    var model:String? = null // 参数、返回值
    @Column
    var type:String? = null // 字符串、对象、数字、数字
    @Column
    var mock:String? = null

    override fun toString(): String {
        return "Param(id=$id, facadeId=$facadeId, fid=$fid, name=$name, desc=$desc, model=$model, type=$type, mock=$mock)"
    }
}