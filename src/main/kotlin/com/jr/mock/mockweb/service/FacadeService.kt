package com.jr.mock.mockweb.service

import com.jr.mock.mockweb.entity.Facade
import com.jr.mock.mockweb.repository.FacadeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FacadeService {
    @Autowired
    lateinit var facadeRepository:FacadeRepository

    @Autowired
    lateinit var paramRepository: FacadeRepository

    fun save(facade: Facade?) {
    }
}