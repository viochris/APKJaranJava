/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApkJARAN.model;

import java.sql.*;

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
    
    public Login login(String username, String password) throws SQLException {        
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
