package com.jr.mock.mockweb.controller

import com.jr.mock.mockweb.entity.Param
import com.jr.mock.mockweb.repository.ParamRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("param")
class ParamCtl {
    @Autowired
    lateinit var paramRepository: ParamRepository

    @RequestMapping("list")
    fun list(model: Model, pageable: Pageable, param: Param):String {
        var page = paramRepository.findAll(Example.of(param), pageable)
        model.addAttribute("page", page)
        return "param/list"
    }

    @GetMapping("save")
    fun toSave(id: Int?, model: Model, param: Param):String {
//        model.addAttribute("param", param)
        if (id != null) {
            model.addAttribute("param", paramRepository.findById(id).get())
        }
        return "param/save"
    }

    @PostMapping("save")
    fun doSave(project: Param):String {
        var project1 = paramRepository.save(project)
        return "redirect:/param/list"
    }
}