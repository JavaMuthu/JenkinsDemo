/**
 * 
 */
package com.changepond.jenkins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.changepond.jenkins.service.IndexService;

/**
 * @author muthukumar.m
 *
 */
@Controller
public class IndexController {

	@Autowired
	IndexService indexService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET )
	public String hello(Model model){
		model.addAttribute("title", "Spring Boot - Jenkins Demo Application");
		return "index";
	}
	
	/**
	 * Webservice method will redirect to hello url 
	 * @return
	 */
	@RequestMapping(value= "/hello", method = RequestMethod.GET)
	public @ResponseBody String greetingMsg() {
		return indexService.welcomeMessage();
	}
}
