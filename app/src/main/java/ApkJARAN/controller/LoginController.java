/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApkJARAN.controller;

import ApkJARAN.model.User;
import ApkJARAN.model.UserModel;

/**
 *
 * @author Silvio
 */
public class LoginController {
    private UserModel userModel;

    public LoginController() throws Exception {
        userModel = new UserModel();
    }

    public User handleLogin(String username, String password) throws Exception {
        return userModel.login(username, password);
    }
}
