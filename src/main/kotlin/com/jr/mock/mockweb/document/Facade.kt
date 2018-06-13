package com.jr.mock.mockweb.document

import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "facades")
class Facade{
    lateinit var name:String
    lateinit var desc:String
    lateinit var uri:String
    lateinit var method:String
    lateinit var status:String
    lateinit var operator:String
    lateinit var params:String
    lateinit var createData: Date
}