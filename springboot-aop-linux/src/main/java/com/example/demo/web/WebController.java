package com.example.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {
	private final Logger logger = LoggerFactory.getLogger(WebController.class);
	@RequestMapping("/hello")
	public String sayHelloe() {
		String str = "hello world";
		logger.error("sayHelloo()目标方法执行==="+str);
		return "person";
	}
	
}
