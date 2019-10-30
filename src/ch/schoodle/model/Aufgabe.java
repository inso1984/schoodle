package ch.schoodle.model;

import java.util.Date;

/**
 * @author Janet Eberlein
 * Model Class für Aufgaben
 *
 */
public class Aufgabe {
	private Integer idAufgaben;
	private Integer fach;
	private String titel;
	private String beschreibung;
	private Date zuErledigenBis;
	private Float geplanteZeit;
	private Float benoetigteZeit;
	private boolean wiederholend;
	private boolean erledigt;
	private Integer user;
	public int getIdAufgaben() {
		return idAufgaben;
	}
	public void setIdAufgaben(Integer idAufgaben) {
		this.idAufgaben = idAufgaben;
	}
	public Integer getFach() {
		return fach;
	}
	public void setFach(Integer fach) {
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
	public Float getGeplanteZeit() {
		return geplanteZeit;
	}
	public void setGeplanteZeit(Float geplanteZeit) {
		this.geplanteZeit = geplanteZeit;
	}
	public Float getBenoetigteZeit() {
		return benoetigteZeit;
	}
	public void setBenoetigteZeit(Float benoetigteZeit) {
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
	public Integer getUser() {
		return user;
	}
	public void setUser(Integer user) {
		this.user = user;
	}
}
