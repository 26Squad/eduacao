package br.com.EduAcao.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/")
public class HomeController {
	
	
	    @GetMapping
	    public ModelAndView home() {
	        ModelAndView modelAndView = new ModelAndView("/index");

	        return modelAndView;
	    }

	 @GetMapping("/sobre")
	    public ModelAndView sobre() {
	        ModelAndView modelAndView = new ModelAndView("/sobre");


	        return modelAndView;
	    }
	
	 
	 @GetMapping("/contato")
	    public ModelAndView contato() {
	        ModelAndView modelAndView = new ModelAndView("/contato");


	        return modelAndView;
	    }
	 
	 @GetMapping("/galeria")
	    public ModelAndView promocoes() {
	        ModelAndView modelAndView = new ModelAndView("/galeria");


	        return modelAndView;
	    }
	 
	

	   

}
