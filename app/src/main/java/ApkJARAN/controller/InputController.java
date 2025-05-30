/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApkJARAN.controller;

import ApkJARAN.model.InputModel;
import java.util.List;

/**
 *
 * @author Silvio
 */
public class InputController {
    private final InputModel model;

    public InputController() {
        this.model = new InputModel();
    }

    public List<Object[]> ambilSemuaData() {
        try {
            return model.getAllData();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean simpanData(String tipe, String alamat, String kebutuhan, String status, String jumlahKK, String telp, String username) {
        try {
            int jumlah = Integer.parseInt(jumlahKK);
            String keparahan = (jumlah <= 5) ? "Ringan 💡" : (jumlah <= 15 ? "Sedang 🔥" : "Berat 🚨");
            return model.insertPelapor(tipe, alamat, kebutuhan, status, jumlahKK, telp, keparahan, username);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateData(int id, String tipe, String alamat, String kebutuhan, String status, String jumlahKK, String telp) {
        try {
            return model.updatePelapor(id, tipe, alamat, kebutuhan, status, jumlahKK, telp);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean hapusData(int id) {
        try {
            return model.deletePelapor(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
