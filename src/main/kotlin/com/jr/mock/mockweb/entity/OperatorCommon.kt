package com.jr.mock.mockweb.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class OperatorCommon {
    @Column
    var operator: String? = null
    @Column
    var createdDate: Date? = null
    @Column
    var lastModifiedDate: Date? = null
}