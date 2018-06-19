package com.jr.mock.mockweb.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping
class IndexCtl {

	@GetMapping("/")
	fun index(): String {
		return "redirect:facade/list"
	}
}