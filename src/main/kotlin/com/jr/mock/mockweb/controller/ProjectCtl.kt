package com.jr.mock.mockweb.controller

import com.jr.mock.mockweb.entity.Project
import com.jr.mock.mockweb.repository.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
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
    lateinit var projectRepository:ProjectRepository

    @RequestMapping("list")
    fun list(model: Model, pageable: Pageable): String {
        var page = projectRepository.findAll(pageable)
        model.addAttribute("page", page)

        return "project/list"
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
        var project1 = projectRepository.save(project)
        for (i in 1..24) {
            var p = Project()
            p.name = project.name + i
            p.role = project.role + i
            projectRepository.save(p)
        }
        return "redirect:/project/list"
    }
}