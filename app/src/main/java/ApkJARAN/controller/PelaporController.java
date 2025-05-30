/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApkJARAN.controller;

import ApkJARAN.model.PelaporModel;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Silvio
 */
public class PelaporController {
    private PelaporModel model;

    public PelaporController() throws Exception {
        model = new PelaporModel();
    }

    public void kirimPelapor(String tipe, String alamat, String kebutuhan, int jumlahKK, String telp, String username) throws Exception {
        String tingkat;
        if (jumlahKK <= 5) tingkat = "Ringan 💡";
        else if (jumlahKK <= 15) tingkat = "Sedang 🔥";
        else tingkat = "Berat 🚨";

        Date tanggalSekarang = Date.valueOf(LocalDate.now());
        model.tambahPelapor(tipe, alamat, kebutuhan, jumlahKK, telp, tingkat, "Pilih...", username, tanggalSekarang);
    }

    public ArrayList<String[]> getDataPelapor(String username) throws Exception {
        return model.ambilDataPelapor(username);
    }
}
