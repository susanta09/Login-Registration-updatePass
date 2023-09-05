package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entity.User;
import com.example.service.UserService;

import jakarta.validation.Valid;


@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String showLogin( Model model)
	{
		
		User u=new User();
		//userService.saveUser(u);
		model.addAttribute("user",u);
		System.out.println(u);
		return "login";
	}
	@PostMapping("/login")
	public String login(@Valid User user,BindingResult result,Model m,RedirectAttributes redirectAttrs)
	{
		System.out.println("login"+user);
		if(result.hasErrors())
		{
			return "login";
		}
		User b=userService.checkUser(user);
		System.out.println("save "+b);
		
		if(b!=null)
		{
			m.addAttribute("user", b);
			return "success";
		}else {
			redirectAttrs.addFlashAttribute("msg", "Please Sign Up or Enter your correct Email and Password");
			return "redirect:/";
		}
	}
	
	@GetMapping("/regis")
	public String showForm( Model model)
	{
		User u=new User();
		model.addAttribute("user",u);
		System.out.println(u);
		return "regis";
	}
	@PostMapping("/userSave")
	public String getUiData(@Valid User user,BindingResult result,Model m,RedirectAttributes redirectAttrs)
	{
		if(result.hasErrors())
		{
			return "regis";
		}
		//System.out.println("save "+user);
		Boolean b=userService.saveUser(user);
		
		if(b)
		{
			redirectAttrs.addFlashAttribute("msg", "Registration is Successfull");
			return "redirect:/";
		}else {
			m.addAttribute("msg", "Registration is fail");
			return "regis";
		}
	}
	
	@GetMapping("/updatePasswordForm")
	public String updatePasswordForm( Model model)
	{
		User u=new User();
		model.addAttribute("user",u);
		System.out.println(u);
		return "updatePassword";
	}
	@PostMapping("/updatePassword")
	public String updatePassword(@Valid User user,BindingResult result,Model m,RedirectAttributes redirectAttrs)
	{
		Boolean b=userService.updatePass(user);
		if(b)
		{
			redirectAttrs.addFlashAttribute("msg", "Your password is updated successfuly");
			return "redirect:/";
		}else {
			redirectAttrs.addFlashAttribute("msg", "Please Sign Up");
			return "redirect:/";
		}
	}
}
