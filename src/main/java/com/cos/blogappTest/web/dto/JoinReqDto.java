package com.cos.blogappTest.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoinReqDto {
private String Username;
private String password;
private String Email;
}
