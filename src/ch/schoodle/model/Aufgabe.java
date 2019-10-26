package ch.schoodle.model;

import java.util.Date;

/**
 * @author Janet Eberlein
 * Model Class für Aufgaben
 *
 */
public class Aufgabe {
	private int idAufgaben;
	private int fach;
	private String titel;
	private String beschreibung;
	private Date zuErledigenBis;
	private float geplanteZeit;
	private float benoetigteZeit;
	private boolean wiederholend;
	private boolean erledigt;
	private int user;
	public int getIdAufgaben() {
		return idAufgaben;
	}
	public void setIdAufgaben(int idAufgaben) {
		this.idAufgaben = idAufgaben;
	}
	public int getFach() {
		return fach;
	}
	public void setFach(int fach) {
		this.fach = fach;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public Date getZuErledigenBis() {
		return zuErledigenBis;
	}
	public void setZuErledigenBis(Date zuErledigenBis) {
		this.zuErledigenBis = zuErledigenBis;
	}
	public float getGeplanteZeit() {
		return geplanteZeit;
	}
	public void setGeplanteZeit(float geplanteZeit) {
		this.geplanteZeit = geplanteZeit;
	}
	public float getBenoetigteZeit() {
		return benoetigteZeit;
	}
	public void setBenoetigteZeit(float benoetigteZeit) {
		this.benoetigteZeit = benoetigteZeit;
	}
	public boolean isWiederholend() {
		return wiederholend;
	}
	public void setWiederholend(boolean wiederholend) {
		this.wiederholend = wiederholend;
	}
	public boolean isErledigt() {
		return erledigt;
	}
	public void setErledigt(boolean erledigt) {
		this.erledigt = erledigt;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
}
