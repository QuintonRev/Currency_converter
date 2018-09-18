package com.pnpStore.controller;

//import LoginController used files
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.pnpStore.model.User;
import com.pnpStore.repository.UserRepository;
import com.pnpStore.service.UserService;


@Controller
public class LoginController {
	

	@Autowired
	private UserService userService;


	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	
	@RequestMapping(value={"/pnpStore/guest"}, method = RequestMethod.GET)
	public ModelAndView guest(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("pnpStore/guest");
		return modelAndView;
	}
	
	
	@RequestMapping(value={"/"}, method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	

	@CrossOrigin("*")
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}

	
	//Register Admin by Admin
	@RequestMapping(value="/pnpStore/registerAdmin", method = RequestMethod.GET)
	public ModelAndView registerAdmin(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("pnpStore/registerAdmin");
		return modelAndView;
	}
	
	@RequestMapping(value = "/pnpStore/registerAdmin", method = RequestMethod.POST)
	public ModelAndView createNewAdmin(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("pnpStore/registerAdmin");
		} else {
			userService.saveAdmin(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("pnpStore/registerAdmin");
			
		}
	return modelAndView;
	}
	
	@RequestMapping(value="/pnpStore/registerDriver", method = RequestMethod.GET)
	public ModelAndView registerDriver(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("pnpStore/registerDriver");
		return modelAndView;
	}
	
	@RequestMapping(value = "/pnpStore/registerDriver", method = RequestMethod.POST)
	public ModelAndView createNewDriver(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("pnpStore/registerDriver");
		} else {
			userService.saveDriver(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("pnpStore/registerDriver");
			
		}
    
	return modelAndView;
	}
	

	@RequestMapping(value="/pnpStore/registerSupplier", method = RequestMethod.GET)
	public ModelAndView registerSupplier(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("pnpStore/registerSupplier");
		return modelAndView;
	}
	
	@RequestMapping(value = "/pnpStore/registerSupplier", method = RequestMethod.POST)
	public ModelAndView createNewSupplier(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("pnpStore/registerSupplier");
		} else {
			userService.saveSupplier(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("pnpStore/registerSupplier");
			
		}
    
	return modelAndView;
	}
	
	
		@RequestMapping(value="/pnpStore/client", method = RequestMethod.GET)
	public ModelAndView client(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome customer: " + user.getName() + " " + user.getLastName());
		modelAndView.setViewName("pnpStore/client");
		return modelAndView;
	}
		
		@RequestMapping(value="/pnpStore/driver", method = RequestMethod.GET)
	public ModelAndView driver(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome Driver: " + user.getName() + " " + user.getLastName());
		modelAndView.setViewName("pnpStore/driver");
		return modelAndView;
	}
		
		@RequestMapping(value="/pnpStore/supplier", method = RequestMethod.GET)
	public ModelAndView supplier(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome Supplier: " + user.getName() + " " + user.getLastName());
		modelAndView.setViewName("pnpStore/supplier");
		return modelAndView;
	}


		
	@RequestMapping(value="/pnpStore/admin", method = RequestMethod.GET)
	public ModelAndView admin(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome Administrator: " + user.getName() + " " + user.getLastName());
		modelAndView.setViewName("pnpStore/admin");
		return modelAndView;
	}

	
	@RequestMapping(value="/default")
	 protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
	        // Get the role of logged in user
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        String role = auth.getAuthorities().toString();

	        //checks If role is CLIENT/ADMIN
	        String targetUrl = "";
	        if(role.contains("CLIENT")) {
	            targetUrl = "redirect:/pnpStore/client";
	        } else if(role.contains("ADMIN")) {
	            targetUrl = "redirect:/pnpStore/admin";
	        } else if(role.contains("DRIVER")) {
	            targetUrl = "redirect:/pnpStore/driver";
	        } else if(role.contains("SUPPLIER")) {
	            targetUrl = "redirect:/pnpStore/supplier";
	        }
	        
	        return targetUrl;
	    }
		
	@RequestMapping(value="/pnpStore/Cart", method = RequestMethod.GET)
	public ModelAndView Cart(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("pnpStore/Cart");
		return modelAndView;
	}
	
	@CrossOrigin("http://localhost:4200")
	@RequestMapping(value = "/GetUser/{lastName}", method = RequestMethod.GET)
	public @ResponseBody User find(@PathVariable String lastName) {
	    return this.userService.findUserBylastName(lastName);
	}
	

}

