package ch.schoodle.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.schoodle.model.User;

public class AuthController {
	
	private User user = null;
	public AuthController(HttpServletRequest request) {
		this.user = (User) request.getSession().getAttribute("user");
	}
	
	public void checkAuth(HttpServletResponse response) throws IOException {
		System.out.println(this.user);
		if(this.user == null) {
			System.out.println("check user is null fuck");
			response.sendRedirect("/Schoodle/login.jsp");
		}
	}
}
