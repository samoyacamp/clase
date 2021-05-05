/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblio;

import com.mycompany.biblio.DAO.LibroDAO;
import com.mycompany.biblio.modelos.Libros;
import com.mycompany.biblio.DAO.UsuarioDAO;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.mycompany.biblio.modelos.Usuario;
import java.sql.SQLException;

/**
 *
 * @author sergi
 */
public class LoginController {

    @FXML
    private TextField user;
    @FXML
    private TextField email;
    @FXML
    private TextField pwd;

    @FXML
    private void login() {
        String usuario = user.getText();
        Usuario u = new Usuario(-1, user.getText(), email.getText(), pwd.getText());
        boolean ok = u.checkBDUsuario(usuario);

        if (ok) {
            AlertsUtil.mostrarInformacion("correcto");
            App.setUsuario(u);
            try {
                App.loadRutasWindow();
            } catch (IOException e) {
                AlertsUtil.mostrarError(e.getMessage());
            }
        } else {
            AlertsUtil.mostrarError("incorrecto");
        }

    }
    
    @FXML
    private void register() {
        AlertsUtil.mostrarError("Aun no esta");

    }

}
