package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class ftpController {
	public String showSampleHome(){
		return "home";
	}
}
