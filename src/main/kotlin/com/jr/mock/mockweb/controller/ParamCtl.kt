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
import java.util.*

@Controller
@RequestMapping("param")
class ParamCtl {
    @Autowired
    lateinit var paramRepository: ParamRepository

    @RequestMapping("list")
    fun list(model: Model, param: Param):String {
        param.model = "REQUEST"
        model.addAttribute("pageRequest", paramRepository.findAll(Example.of(param)))
        param.model = "RESPONSE"
        model.addAttribute("pageResponse", paramRepository.findAll(Example.of(param)))
        return "param/list"
    }

    @GetMapping("save")
    fun toSave(id: Int?, model: Model, param: Param):String {
        model.addAttribute("parameter", param)
        if (id != null) {
            model.addAttribute("parameter", paramRepository.findById(id).get())
        }
        model.addAttribute("abc", "阿根廷")
        return "param/save"
    }

    @PostMapping("save")
    fun doSave(param: Param):String {
        param.lastModifiedDate = Date()
        paramRepository.save(param)
        return "redirect:/facade/params?facadeId=${param.facadeId}"
    }
}