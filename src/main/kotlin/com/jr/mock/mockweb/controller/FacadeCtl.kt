package com.jr.mock.mockweb.controller

import com.jr.mock.mockweb.entity.Facade
import com.jr.mock.mockweb.repository.FacadeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*

@Controller
@RequestMapping("facade")
class FacadeCtl {
    @Autowired
    lateinit var facadeRepository: FacadeRepository

    @RequestMapping("list")
    fun list(model: Model, pageable: Pageable, facade: Facade):String {
        var page = facadeRepository.findAll(Example.of(facade), pageable)
        model.addAttribute("page", page)
        model.addAttribute("facade", facade)
        return "facade/list"
    }

    @GetMapping("save")
    fun toSave(id: Int?, model: Model, facade: Facade):String {
        model.addAttribute("facade", facade)
        if (id != null) {
            model.addAttribute("facade", facadeRepository.findById(id).get())
        }
        return "facade/save"
    }

    @PostMapping("save")
    fun doSave(facade: Facade):String {
        facade.lastModifiedDate = Date()
        facadeRepository.save(facade)
        return "redirect:/facade/list?projectId=${facade.projectId}"
    }

    @GetMapping("params")
    fun params(facadeId: Int?, model: Model):String {
        if (facadeId != null) {
            model.addAttribute("facade", facadeRepository.findById(facadeId).get())
        }
        return "forward:/param/list"
    }
}