/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApkJARAN.controller;

import ApkJARAN.model.Login;
import ApkJARAN.model.LoginModel;

/**
 *
 * @author Silvio
 */
public class LoginController {
    private LoginModel userModel;

    public LoginController() throws Exception {
        userModel = new LoginModel();
    }

    public Login handleLogin(String username, String password) throws Exception {
        return userModel.login(username, password);
    }
}
