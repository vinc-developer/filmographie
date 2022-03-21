/**
 * @author Jean-yves Chaillou <jeanyves.chaillou@gmail.com>
 * @copyright Copyright (c) 2022>
 * @link https://kwabounga.fr
 */

package com.film.tdfilmographie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Controller
@RequestMapping("/admin/mapping")
public class EndpointDocController {
	private final RequestMappingHandlerMapping handlerMapping;

	@Autowired
	public EndpointDocController(RequestMappingHandlerMapping handlerMapping) {
		this.handlerMapping = handlerMapping;
	}

	@GetMapping
	public String show() {
		return "redirect:/admin/mapping/" + "*";
	}

	@GetMapping("/{filter}")
	public String show(@PathVariable(name = "filter") String pack, Model model) {
		System.out.println(pack);
		model.addAttribute("handlerMethods", this.handlerMapping.getHandlerMethods());
		if(!"*".equals(pack)) {
			model.addAttribute("package", pack);
		} else {
			model.addAttribute("nofilter", true);
		}	

		return "/mapping/endpointdoc.html";
	}
}
