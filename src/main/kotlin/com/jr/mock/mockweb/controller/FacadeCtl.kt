package com.jr.mock.mockweb.controller

import com.jr.mock.mockweb.document.Facade
import com.jr.mock.mockweb.service.FacadeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("facade")
class FacadeCtl {

    @Autowired
    lateinit var facadeService: FacadeService

    fun list():List<Facade> {
        return facadeService.list(null)
    }
}