package com.cos.blogappTest.web.dto;

import org.springframework.boot.SpringApplication;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LoginReqDto {
private String username;
private String password;

public static void main(String[] args) {

}
}
