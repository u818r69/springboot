package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class TestController {

	private UserService userService;

	public TestController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/test")
	public String test(Model model) {
		List<User> userList = userService.getAll();

		model.addAttribute("userList", userList);
		model.addAttribute("title", "ユーザ一覧");

		return "test";
	}
}
