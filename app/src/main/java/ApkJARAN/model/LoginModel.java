/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApkJARAN.model;

import java.sql.*;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Silvio
 */
class BaseModel {
    protected Connection conn;

    public BaseModel() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/laporan_banjir";
        String user = "root";
        String pass = "";
        conn = DriverManager.getConnection(url, user, pass);
    }
}

public class LoginModel extends BaseModel {

    public LoginModel() throws SQLException {
        super();
    }
    
    // 🛡️ Fungsi hashing password pakai SHA-256
//    private String hashPassword(String password) {
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            byte[] hashed = md.digest(password.getBytes());
//            StringBuilder sb = new StringBuilder();
//            for (byte b : hashed) {
//                sb.append(String.format("%02x", b)); // ubah byte ke format hex
//            }
//            return sb.toString();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    public Login login(String username, String password) throws SQLException {
//        String hashedPassword = hashPassword(password);
        
        String sql = "SELECT posisi FROM users WHERE username = ? AND password = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, username);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String posisi = rs.getString("posisi");
            return new Login(username, posisi);
        } else {
            return null;
        }
    }
}
