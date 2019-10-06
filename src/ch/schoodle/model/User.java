package ch.schoodle.model;

/**
 * @author Janet Eberlein Model Class für User
 *
 */

public class User {

	private int idUser;
	private String name;
	private String pw;
	private String eMail;
	private String sex;

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String nameUser) {
		this.name = nameUser;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	

}
