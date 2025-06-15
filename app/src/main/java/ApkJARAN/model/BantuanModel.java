/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApkJARAN.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Silvio
 */
public class BantuanModel {
    public static Connection getConnection() throws SQLException {
            String url = "jdbc:mysql://localhost:3306/laporan_banjir";
            String user = "root";
            String pass = "";
            return DriverManager.getConnection(url, user, pass);
        }

    public List<Object[]> getAllData() throws SQLException {
        List<Object[]> data = new ArrayList<>();
        String sql = "SELECT * FROM bantuan_table";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                data.add(new Object[]{
                    rs.getString("kategori"),
                    rs.getString("kategori_barang"),
                    rs.getString("nama_barang"),
                    rs.getInt("kuantitas"),
                    rs.getString("keterangan"),
                    rs.getInt("id")
                });
            }
        }
        return data;
    }

    public boolean insertBantuan(String kategori, String kategoriBarang, String namaBarang, int kuantitas, String keterangan) throws SQLException {
        String sql = "INSERT INTO bantuan_table (kategori, kategori_barang, nama_barang, kuantitas, keterangan) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, kategori);
            pst.setString(2, kategoriBarang);
            pst.setString(3, namaBarang);
            pst.setInt(4, kuantitas);
            pst.setString(5, keterangan);
            return pst.executeUpdate() > 0;
        }
    }

    public boolean updateBantuan(int id, String kategori, String kategoriBarang, String namaBarang, int kuantitas, String keterangan) throws SQLException {
        String sql = "UPDATE bantuan_table SET kategori=?, kategori_barang=?, nama_barang=?, kuantitas=?, keterangan=? WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, kategori);
            pst.setString(2, kategoriBarang);
            pst.setString(3, namaBarang);
            pst.setInt(4, kuantitas);
            pst.setString(5, keterangan);
            pst.setInt(6, id);
            return pst.executeUpdate() > 0;
        }
    }

    public boolean deleteBantuan(int id) throws SQLException {
        String sql = "DELETE FROM bantuan_table WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            return pst.executeUpdate() > 0;
        }
    }
}
