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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController implements Initializable {

    @FXML
    public TextField email;

    @FXML
    public PasswordField password;
    private ViewModel viewModel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    protected void loginIn(ActionEvent event) {
        String emailInput = email.getText();
        String userPasswordInput = password.getText();

        viewModel.loginUser(emailInput, userPasswordInput);
    }

    private void clearInput() {
        email.clear();
        password.clear();
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @FXML
    private void exitApp(MouseEvent event) {
        System.exit(0);
    }

    public void moveToSignUp(ActionEvent actionEvent) {
        viewModel.goToSignUp();
    }
}
