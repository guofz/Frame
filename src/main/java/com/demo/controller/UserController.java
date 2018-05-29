package com.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.User;
import com.demo.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

//	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	Logger logger = LogManager.getLogger(UserController.class.getName());
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/jumpUser")
	public String jumpUser(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("333333333333333333333333333333333");
		System.out.println(logger.getClass());
		return "userHome";
	}
	
	@RequestMapping("/getUser")
	@ResponseBody
	public String testUser(HttpServletRequest request, HttpServletResponse response) {
		Long userId = Long.parseLong(request.getParameter("userId"));
		User user = null;
		try {
			user = userService.getUserById(userId);
		} catch (Exception e) {
			logger.info("/user/getUser", e.toString(), e);
			e.printStackTrace();
		}
		return user.getName();
	}
}
