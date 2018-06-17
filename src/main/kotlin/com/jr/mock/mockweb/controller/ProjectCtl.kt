package com.jr.mock.mockweb.controller

import com.jr.mock.mockweb.entity.Project
import com.jr.mock.mockweb.repository.ProjectRepository
import org.omg.CORBA.Object
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.util.*
import kotlin.collections.HashMap

/**
 * 项目控制器
 */
@Controller
@RequestMapping("project")
class ProjectCtl {

    @Autowired
    lateinit var projectRepository:ProjectRepository

    @RequestMapping("list")
    fun list(model: Model, pageable: Pageable): String {
        var page = projectRepository.findAll(pageable)
        model.addAttribute("page", page)


        return "/project/list"
    }

    @GetMapping("save")
    fun toSave(id: Int?, model: Model):String {
        if (id != null) {
            model.addAttribute(projectRepository.findById(id).get())
        }
        return "project/save"
    }

    @PostMapping("save")
    fun doSave(project: Project):String {
        project.lastModifiedDate = Date()
        projectRepository.save(project)
        return "redirect:/facade/list?projectId=${project.id}"
    }

    @PostMapping("save.biz")
    @ResponseBody
    fun bizSave(project: Project):Any {
        project.lastModifiedDate = Date()
        projectRepository.save(project)
        return hashMapOf("success" to true, "code" to "success", "message" to "请求成功")
    }
}