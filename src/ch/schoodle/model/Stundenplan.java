package ch.schoodle.model;

import java.sql.Time;
/**
 * @author Sascha Wechsler 
 * Model Class für Stundenplan
 *
 */
public class Stundenplan {

	private int idStundenplanNummer;
	private Time von;
	private Time bis;
	private int wochentag_idWochentag;
	private int fach_idFach;
	private int user_idUser;
	
	public int getIdStundenplanNummer() {
		return idStundenplanNummer;
	}
	public void setIdStundenplanNummer(int idStundenplanNummer) {
		this.idStundenplanNummer = idStundenplanNummer;
	}
	public Time getVon() {
		return von;
	}
	public void setVon(Time von) {
		this.von = von;
	}
	public Time getBis() {
		return bis;
	}
	public void setBis(Time bis) {
		this.bis = bis;
	}
	public int getWochentag_idWochentag() {
		return wochentag_idWochentag;
	}
	public void setWochentag_idWochentag(int wochentag_idWochentag) {
		this.wochentag_idWochentag = wochentag_idWochentag;
	}
	public int getFach_idFach() {
		return fach_idFach;
	}
	public void setFach_idFach(int fach_idFach) {
		this.fach_idFach = fach_idFach;
	}
	public int getUser_idUser() {
		return user_idUser;
	}
	public void setUser_idUser(int user_idUser) {
		this.user_idUser = user_idUser;
	}
	
}
