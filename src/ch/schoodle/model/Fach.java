package ch.schoodle.model;

/**
 * @author Janet Eberlein Model Class für Faecher
 *
 */
public class Fach {

	private int idFach;
	private String fach;
	private String abkuerzung;

	public int getIdFach() {
		return idFach;
	}

	public void setIdFach(int idFach) {
		this.idFach = idFach;
	}

	public String getFach() {
		return fach;
	}

	public void setFach(String fach) {
		this.fach = fach;
	}

	public String getAbkuerzung() {
		return abkuerzung;
	}

	public void setAbkuerzung(String abkuerzung) {
		this.abkuerzung = abkuerzung;
	}

}
