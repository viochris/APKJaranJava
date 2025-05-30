/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApkJARAN.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/**
 *
 * @author Silvio
 */
public class InputModel {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/laporan_banjir";
        String user = "root";
        String pass = "";
        return DriverManager.getConnection(url, user, pass);
    }

    public List<Object[]> getAllData() throws SQLException {
        List<Object[]> data = new ArrayList<>();
        String sql = "SELECT * FROM pelapor_table";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                data.add(new Object[]{
                    rs.getString("tipe_pelapor"),
                    rs.getString("alamat"),
                    rs.getString("kebutuhan_khusus"),
                    rs.getString("jumlah_kk"),
                    rs.getString("no_telp"),
                    rs.getString("tingkat_keparahan"),
                    rs.getString("status"),
                    rs.getDate("tanggal_lapor"), // Tambahkan ini 🥰
                    rs.getString("id")
                });
            }
        }
        return data;
    }

    public boolean insertPelapor(String tipe, String alamat, String kebutuhan, String status, String jumlahKK, String telp, String keparahan, String username) throws SQLException {
        String sql = "INSERT INTO pelapor_table (tipe_pelapor, alamat, kebutuhan_khusus, status, jumlah_kk, no_telp, tingkat_keparahan, username, tanggal_lapor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, tipe);
            pst.setString(2, alamat);
            pst.setString(3, kebutuhan);
            pst.setString(4, status);
            pst.setString(5, jumlahKK);
            pst.setString(6, telp);
            pst.setString(7, keparahan);
            pst.setString(8, username);
            pst.setDate(9, java.sql.Date.valueOf(LocalDate.now())); // 🗓️ Tambahkan tanggal hari ini
            return pst.executeUpdate() > 0;
        }
    }

    public boolean updatePelapor(int id, String tipe, String alamat, String kebutuhan, String status, String jumlahKK, String telp) throws SQLException {
        String sql = "UPDATE pelapor_table SET tipe_pelapor=?, alamat=?, kebutuhan_khusus=?, status=?, jumlah_kk=?, no_telp=?, tingkat_keparahan=? WHERE id=?";
        int jumlah = Integer.parseInt(jumlahKK);
        String keparahan = (jumlah <= 5) ? "Ringan 💡" : (jumlah <= 15 ? "Sedang 🔥" : "Berat 🚨");
        try (Connection conn = getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, tipe);
            pst.setString(2, alamat);
            pst.setString(3, kebutuhan);
            pst.setString(4, status);
            pst.setString(5, jumlahKK);
            pst.setString(6, telp);
            pst.setString(7, keparahan);
            pst.setInt(8, id);
            return pst.executeUpdate() > 0;
        }
    }

    public boolean deletePelapor(int id) throws SQLException {
        String sql = "DELETE FROM pelapor_table WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            return pst.executeUpdate() > 0;
        }
    }
}
