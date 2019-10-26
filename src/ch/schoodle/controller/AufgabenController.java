package ch.schoodle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ch.schoodle.data.AufgabenDAO;
import ch.schoodle.model.Aufgabe;
import ch.schoodle.model.User;

public class AufgabenController {
	private HttpServletRequest request;
	public AufgabenController(HttpServletRequest request) {
		this.request = request;
	}
	
	public List<Aufgabe> getMeineAufgaben(User user){
		AufgabenDAO aufgabenDAO = new AufgabenDAO();
		System.out.println(user);
		return aufgabenDAO.getAllAufgabenForUser(user.getIdUser());
	}
}
