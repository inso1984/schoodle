package ch.schoodle.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.schoodle.data.UserDAO;
import ch.schoodle.model.User;

public class AuthController {
	
	private User user = null;
	public AuthController(HttpServletRequest request) {
		this.user = (User) request.getSession().getAttribute("user");
	}
	
	public boolean checkAuth() throws IOException {
		return this.user != null;
	}
	
	public boolean doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException{
		UserDAO userdao = new UserDAO();
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		Optional<User> loginUser = userdao.login(email,pw);
		if(loginUser.isPresent()) {
			request.getSession().setAttribute("user", loginUser.get());
			return true;
		}else {
			return false;
			//response.sendRedirect("/Schoodle/?loginError=true");
		}
	}
	
	public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		UserDAO userdao = new UserDAO();
		User newUser = new User();
		
		newUser.seteMail(request.getParameter("email"));
		newUser.setName(request.getParameter("name"));
		newUser.setPw(request.getParameter("pw"));
		newUser.setSex(request.getParameter("sex"));
		if(userdao.register(newUser)) {
			response.sendRedirect("/Schoodle/?register=true");
		}else {
			response.sendRedirect("/Schoodle/?register=false");
		}
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("user");
		response.sendRedirect("/Schoodle/");
	}
		
	public String getUserName() {
		return this.user.getName();
	}
	
	public void redirectToHome(HttpServletResponse response) throws IOException {
		response.sendRedirect("/Schoodle/");
	}
}
