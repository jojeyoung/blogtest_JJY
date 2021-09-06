package com.cos.blogappTest.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.blogappTest.domain.user.User;
import com.cos.blogappTest.domain.user.UserRepository;
import com.cos.blogappTest.web.dto.JoinReqDto;

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
	user.setPassoword(dto.getPassword());
	user.setEmail(dto.getEmail());
	
	userRepository.save(user);
	
	return  "redirect:/loginForm";
}


}
