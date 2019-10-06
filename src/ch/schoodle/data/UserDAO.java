package ch.schoodle.data;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import ch.schoodle.model.User;


public class UserDAO  extends DBConnector{

	public boolean register(User user) {
		String sql = "INSERT INTO user (`name`,`eMail`,`pw`,`sex`) VALUES(?,?,?,?)";
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(0, user.getName());
			pstmt.setString(1, user.geteMail());
			pstmt.setString(2, createPWHash(user.getPw()));
			pstmt.setString(3, user.getSex());
			return pstmt.execute();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	private String createPWHash(String pw) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update("mysalt".getBytes());
		byte[] hashedPassword = md.digest(pw.getBytes(StandardCharsets.UTF_8));
		return hashedPassword.toString();
	}
	
	public boolean login(String user, String pw) {
		String sql = "SELECT * FROM user WHERE email=? AND pw=?";
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(0, user);
			pstmt.setString(1, createPWHash(pw));
			return pstmt.execute();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
}
