package com.jr.mock.mockweb.controller

import com.jr.mock.mockweb.entity.Facade
import com.jr.mock.mockweb.repository.FacadeRepository
import com.jr.mock.mockweb.repository.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.util.*

@Controller
@RequestMapping("facade")
class FacadeCtl {
	@Autowired
	lateinit var facadeRepository: FacadeRepository

	@Autowired
	lateinit var projectRepository: ProjectRepository

	@RequestMapping("list")
	fun list(model: Model, pageable: Pageable, facade: Facade): String {
		if (facade.projectId == null) {
			facade.projectId = 1
		}
		var page = facadeRepository.findAll(Example.of(facade), pageable)
		model.addAttribute("page", page)
		model.addAttribute("currentProjectId", facade.projectId)
		model.addAttribute("projectList", projectRepository.findAll())
		return "facade/list"
	}

	@GetMapping("save")
	fun toSave(id: Long?, model: Model, facade: Facade): String {
		model.addAttribute("facade", facade)
		if (id != null) {
			model.addAttribute("facade", facadeRepository.findById(id).get())
		}
		return "facade/save"
	}

	@PostMapping("save")
	fun doSave(facade: Facade): String {
		facade.modifiedDate = Date()
		facadeRepository.save(facade)
		return "redirect:/facade/list?projectId=${facade.projectId}"
	}

	@PostMapping("save.biz")
	@ResponseBody
	fun bizSave(facade: Facade): Any {
		facade.modifiedDate = Date()
		facadeRepository.save(facade)
		return hashMapOf("success" to true, "code" to "success", "message" to "请求成功")
	}

	@GetMapping("params")
	fun params(facadeId: Long?, model: Model): String {
		if (facadeId != null) {
			model.addAttribute("facade", facadeRepository.findById(facadeId).get())
		}
		return "forward:/param/list"
	}
}