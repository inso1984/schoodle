package ch.schoodle.applicationdata;

import java.util.List;

import ch.schoodle.data.FaecherDAO;
import ch.schoodle.model.Fach;

public enum Faecher {
	INSTANCE;
	
	private List<Fach> faecher = null;
	
	
	public List<Fach> getFaecher() {
		if(faecher == null) {
			initFaecher();
		}
		return faecher;
	}


	private void initFaecher() {
		FaecherDAO faecherDAO = new FaecherDAO();
		this.faecher = faecherDAO.getFaecherList();
	}
	
	public Fach getFachById(int id) {
		if(this.faecher == null) {
			initFaecher();
		}
		return this.faecher.stream()
				.filter(fach -> {
					return fach.getIdFach() == id;
				}).findFirst().get();
	}
}
