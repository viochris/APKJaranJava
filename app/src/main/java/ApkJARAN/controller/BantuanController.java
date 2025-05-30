/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApkJARAN.controller;

import ApkJARAN.model.BantuanModel;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *
 * @author Silvio
 */
public class BantuanController {
    private final BantuanModel model;

    public BantuanController() {
        this.model = new BantuanModel();
    }

    public DefaultTableModel loadTable() {
        String[] kolom = {"Kategori", "Kategori Barang", "Nama Barang", "Kuantitas", "Keterangan", "ID"};
        DefaultTableModel modelTabel = new DefaultTableModel(kolom, 0);
        try {
            List<Object[]> data = model.getAllData();
            for (Object[] row : data) {
                modelTabel.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelTabel;
    }

    public boolean insert(String kategori, String kategoriBarang, String namaBarang, int kuantitas, String keterangan) {
        try {
            return model.insertBantuan(kategori, kategoriBarang, namaBarang, kuantitas, keterangan);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(int id, String kategori, String kategoriBarang, String namaBarang, int kuantitas, String keterangan) {
        try {
            return model.updateBantuan(id, kategori, kategoriBarang, namaBarang, kuantitas, keterangan);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            return model.deleteBantuan(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
