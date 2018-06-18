package com.jr.mock.mockweb.controller

import com.jr.mock.mockweb.entity.Param
import com.jr.mock.mockweb.repository.ParamRepository
import com.jr.mock.mockweb.service.ParamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.util.*

@Controller
@RequestMapping("param")
class ParamCtl {
    @Autowired
    lateinit var paramRepository: ParamRepository

    @Autowired
    lateinit var paramService: ParamService

    @RequestMapping("list")
    fun list(model: Model, param: Param): String {
        var sort = Sort(Sort.Direction.ASC, "code")
        param.model = "REQUEST"
        model.addAttribute("pageRequest", paramRepository.findAll(Example.of(param), sort))
        param.model = "RESPONSE"
        model.addAttribute("pageResponse", paramRepository.findAll(Example.of(param), sort))
        return "param/list"
    }

    @GetMapping("save")
    fun toSave(id: Int?, model: Model, param: Param): String {
        model.addAttribute("parameter", param)
        if (id != null) {
            model.addAttribute("parameter", paramRepository.findById(id).get())
        }
        return "param/save"
    }

    @GetMapping("append")
    fun toAppend(pid: Int, model: Model): String {
        var parent = paramRepository.findById(pid).get()
        var param = Param()
        param.pid = pid
        param.facadeId = parent.facadeId
        param.model = parent.model
        model.addAttribute("parameter", param)
        return "param/save"
    }

    @PostMapping("save")
    fun doSave(param: Param): String {
        paramService.save(param)
        return "redirect:/facade/params?facadeId=${param.facadeId}"
    }

    @PostMapping("save.biz")
    @ResponseBody
    fun bizSave(param: Param): Any {
        paramService.save(param)
        return hashMapOf("success" to true, "code" to "success", "message" to "请求成功")
    }
}