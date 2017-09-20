package com.todolists;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.*;

@SpringBootApplication
@RestController
public class TodolistsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistsApplication.class, args);
	}

	private final Map<String, List<String>> userDb = new HashMap<>();

	public TodolistsApplication() {
		userDb.put("tom", Arrays.asList("user"));
		userDb.put("sally", Arrays.asList("user", "admin"));
	}

	@RequestMapping(value = "/login1", method = RequestMethod.POST)
	public String login(@RequestBody UserLogin login) throws ServletException
	{
		return login.name;
//		String jwtToken;
//
//		if (login.name == "tom" && login.password == "user")
//			jwtToken = Jwts.builder().setSubject(login.name)
//					.claim("roles", "user").setIssuedAt(new Date())
//					.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
//		else
//			jwtToken = "123";
//
//		return jwtToken;
//		return new LoginResponse(Jwts.builder().setSubject(login.name)
//				.claim("roles", userDb.get(login.name)).setIssuedAt(new Date())
//				.signWith(SignatureAlgorithm.HS256, "secretkey").compact());
	}

	private static class UserLogin {
		public String name;
		public String password;
	}

	private static class LoginResponse {
		public String token;

		public LoginResponse(final String token) {
			this.token = token;
		}
	}
}



