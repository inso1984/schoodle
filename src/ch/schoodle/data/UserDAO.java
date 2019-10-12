package ch.schoodle.data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

import ch.schoodle.model.User;


public class UserDAO  extends DBConnector{

	public boolean register(User user) {
		String sql = "INSERT INTO user (`name`,`eMail`,`pw`,`sex`) VALUES(?,?,?,?)";
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			if(!this.userExist(user.geteMail())) {
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.geteMail());
				pstmt.setString(3, createPWHash(user.getPw()));
				pstmt.setString(4, user.getSex());
				pstmt.execute();
				return true;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	
	 private String createPWHash(String passwordToHash){
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            //Get the hash's bytes
            byte[] bytes = md.digest(passwordToHash.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
	    
	private boolean userExist(String email){
		String sql = "SELECT * FROM user where eMail=?";
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	 
	public Optional<User> login(String email, String pw) {
		String sql = "SELECT * FROM user WHERE eMail=? AND pw=?";
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			String pwHash = createPWHash(pw);
			pstmt.setString(1, email);
			System.out.println(createPWHash(pw));
			pstmt.setString(2, pwHash);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setIdUser(rs.getInt("idUser"));
				user.seteMail(rs.getString("eMail"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				return Optional.ofNullable(user);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return Optional.ofNullable(null);
	}
}
