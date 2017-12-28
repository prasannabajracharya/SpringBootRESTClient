package com.example.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springrest.domain.User;
import com.example.springrest.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/{id}")
	public String getUser(@PathVariable("id") Long id, Model model){
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		return "userProfile";
	}
	
	@GetMapping("/")
	public String getAllUsers(Model model){
		List<User> users = userService.getAllUsers();
		model.addAttribute("userList", users);
		return "listOfUsers";
	}

	@GetMapping("/create")
	public String createUser(){
		return "registerUser";
	}
	
	@PostMapping("/create")
	public String createUser(User user, Model model){
		userService.createUser(user);
		model.addAttribute("user", user);
		return "userProfile";
	}
	
	@GetMapping("/update/{id}")
	public String editUser(@PathVariable("id") Long id, Model model){
		User user = userService.getUser(id);
		user.setId(id);
		model.addAttribute(user);
		//System.out.println(user);
		return "userUpdate";
	}
	
	@PutMapping("/update/{id}")
	public String updateUser(@PathVariable("id") Long id, User user){
		userService.updateUser(user, id);
		return "userProfile";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id){
		User user = userService.getUser(id);
		userService.deleteUser(user, id);
		return "redirect:/user/";
	}
}
