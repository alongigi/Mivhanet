/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.LoginView;

import java.net.URL;
import java.util.ResourceBundle;

import Main.ViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController implements Initializable {

    @FXML
    public TextField userName;

    @FXML
    public PasswordField password;
    private ViewModel viewModel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @FXML
    private void exitApp(MouseEvent event) {
        System.exit(0);
    }

}
