package com.jr.mock.mockweb.repository

import com.jr.mock.mockweb.document.Facade
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface FacadeRepository:MongoRepository<Facade, ObjectId> {
    fun findOneByApiKey(apiKey:String)
}