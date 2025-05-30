/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApkJARAN.model;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Silvio
 */
public class PelaporModel {
    private Connection conn;

    public PelaporModel() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/laporan_banjir", "root", "");
    }

    public void tambahPelapor(String tipe, String alamat, String kebutuhan, int jumlahKK, String telp, String tingkatKeparahan, String status, String username, Date tanggal) throws SQLException {
        String sql = "INSERT INTO pelapor_table (tipe_pelapor, alamat, kebutuhan_khusus, jumlah_kk, no_telp, tingkat_keparahan, status, username, tanggal_lapor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tipe);
        ps.setString(2, alamat);
        ps.setString(3, kebutuhan);
        ps.setInt(4, jumlahKK);
        ps.setString(5, telp);
        ps.setString(6, tingkatKeparahan);
        ps.setString(7, status);
        ps.setString(8, username);
        ps.setDate(9, tanggal);
        ps.executeUpdate();
    }


    public ArrayList<String[]> ambilDataPelapor(String username) throws SQLException {
        String sql = "SELECT * FROM pelapor_table WHERE username = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();

        ArrayList<String[]> dataList = new ArrayList<>();
        while (rs.next()) {
            dataList.add(new String[]{
                rs.getString("tipe_pelapor"),
                rs.getString("alamat"),
                rs.getString("kebutuhan_khusus"),
                rs.getString("jumlah_kk"),
                rs.getString("no_telp"),
                rs.getString("status"),
                rs.getString("tanggal_lapor"),
                rs.getString("id")
            });
        }
        return dataList;
    }
}
