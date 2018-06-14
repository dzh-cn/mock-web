package com.jr.mock.mockweb.controller

import com.jr.mock.mockweb.document.Project
import com.jr.mock.mockweb.repository.ProjectRepository
import com.jr.mock.mockweb.service.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 * 项目控制器
 */
@Controller
@RequestMapping("project")
class ProjectCtl {
    @Autowired
    lateinit var projectService: ProjectService

    @Autowired
    lateinit var projectRepository:ProjectRepository

    @RequestMapping("list")
    fun list(model: Model): String {
        model.addAttribute("list", projectRepository.findAll())
        println(model)
        return "project/list"
    }

    @GetMapping("save")
    fun toSave(id: Int?, model: Model):String {
        if (id != null) {
            model.addAttribute(projectRepository.findById(id))
        }
        return "project/save"
    }

    @PostMapping("save")
    fun doSave(project: Project):String {
        println(project)
        var project1 = projectRepository.save(project)
        println(project1)
        return "redirect:/project/list"
    }
}