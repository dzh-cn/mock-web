package com.jr.mock.mockweb.service

import com.jr.mock.mockweb.document.Facade
import com.jr.mock.mockweb.repository.FacadeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FacadeService {
    @Autowired
    lateinit var facadeRepository:FacadeRepository

    fun list(roles: Array<String>?):List<Facade> {
        return facadeRepository.findAll()
    }
}