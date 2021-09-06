package com.cos.blogappTest.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.blogappTest.domain.user.User;
import com.cos.blogappTest.domain.user.UserRepository;
import com.cos.blogappTest.web.dto.JoinReqDto;
import com.cos.blogappTest.web.dto.LoginReqDto;

@Controller
public class UserController {

	private UserRepository userRepository;
	private HttpSession      httpSession;

public UserController(UserRepository userRepository, HttpSession httpSession) {
  this.userRepository = userRepository;
  this.httpSession = httpSession;
}

@GetMapping("/home")
public String home() {
	return "/home";
}


@GetMapping("/join")
 public String join() {
	return "user/joinForm";
}

@PostMapping("/join")
 public String join(JoinReqDto dto) {
	User user = new User();
	user.setUsername(dto.getUsername());
	user.setPassword(dto.getPassword());
	user.setEmail(dto.getEmail());
	
	userRepository.save(user);
	
	return  "redirect:/loginForm";
}

@GetMapping("/login")
 public String login() {
	return "user/loginForm";
}
@PostMapping("/login")
public String login(LoginReqDto dto) {
	System.out.println(dto.getUsername());
	System.out.println(dto.getPassword());
	
	User UEntity = userRepository.mLoing(dto.getUsername(), dto.getPassword());
	if( UEntity == null ) {
		return "redirect:/loginForm";
	}else {
		httpSession.setAttribute("principal", UEntity);
		return "redirect:/home";
	}
	
}


}
