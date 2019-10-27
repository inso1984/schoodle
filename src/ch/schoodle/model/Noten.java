package ch.schoodle.model;

import java.util.Date;

/**
 * @author Sascha Wechsler
 * Model Class für Noten
 *
 */
public class Noten {
	private int idNoten;
	private float noten;
	private int fach;
	private int user;
	private Date datum;
	
	public int getIdNoten() {
		return idNoten;
	}
	public void setIdNoten(int idNoten) {
		this.idNoten = idNoten;
	}
	public float getNoten() {
		return noten;
	}
	public void setNoten(float noten) {
		this.noten = noten;
	}
	public int getFach() {
		return fach;
	}
	public void setFach(int fach) {
		this.fach = fach;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}	
	
}
