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

@Controller
@RequestMapping("facade")
class FacadeCtl {
    @Autowired
    lateinit var facadeRepository: FacadeRepository

    @RequestMapping("list")
    fun list(model: Model, pageable: Pageable, facade: Facade):String {
        var page = facadeRepository.findAll(Example.of(facade), pageable)
        model.addAttribute("page", page)
        return "facade/list"
    }

    @GetMapping("save")
    fun toSave(id: Int?, model: Model):String {
        if (id != null) {
            model.addAttribute("facade", facadeRepository.findById(id).get())
        }
        return "facade/save"
    }

    @PostMapping("save")
    fun doSave(facade: Facade):String {
        facadeRepository.save(facade)
        for (i in 1..24) {
            var p = Facade()
            p.name = facade.name + i
            facadeRepository.save(p)
        }
        return "redirect:/facade/list"
    }

    @GetMapping("params")
    fun params(facadeId: Int?, model: Model):String {
        if (facadeId != null) {
            model.addAttribute("facade", facadeRepository.findById(facadeId).get())
        }
        return "forward:/param/list"
    }
}