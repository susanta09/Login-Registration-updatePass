package com.example.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = Exception.class)
	public String handlerBookNotFountException( Model m,RedirectAttributes redirectAttrs)
	{
//		m.addAttribute("errMsg", "Email and Password must be unique..");
//		return "error";
		redirectAttrs.addFlashAttribute("msg", "Registration is Fail.Enter  the unique  Email and Password..... ");
		return "redirect:/regis";
	}
	
//	@ExceptionHandler(value = NullPointerException.class)
//	public String handlerNullPointerException( Model m)
//	{
//		m.addAttribute("errMsg", "Nullpointer Exception");
//		return "error";
//	}

}
