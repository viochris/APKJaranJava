/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApkJARAN.model;

/**
 *
 * @author Silvio
 */
public class Login {
        private String username;
    private String posisi;

    public Login(String username, String posisi) {
        this.username = username;
        this.posisi = posisi;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    @Override
    public String toString() {
        return "User{" + "username='" + username + "', posisi='" + posisi + "'}";
    }
}
