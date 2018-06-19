package com.jr.mock.mockweb.controller

import com.jr.mock.mockweb.entity.Param
import com.jr.mock.mockweb.service.ParamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping
class IndexCtl {

	@Autowired
	lateinit var paramService: ParamService

	@GetMapping("/")
	fun index(): String {
		return "redirect:facade/list"
	}

	@GetMapping("/mock")
	@ResponseBody
	fun mock(param: Param): Any? {
		return paramService.getMockFacadeId(param)
	}
}