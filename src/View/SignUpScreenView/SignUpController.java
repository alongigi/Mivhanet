package View.SignUpScreenView;/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.util.ResourceBundle;

import Model.User;
import Main.ViewModel;
//import com.jfoenix.controls.JFXButton;
//import com.jfoenix.controls.JFXPasswordField;
//import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * @author proxc
 */
public class SignUpController implements Initializable {

    @FXML
    private Label btn_exit;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField email;
    @FXML
    private TextField userName;
    @FXML
    private TextField password;

    private ViewModel viewModel;

    @FXML
    private void exitApp(MouseEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void handleAddUser(MouseEvent mouseEvent) {
        String firstNameInput = firstName.getText();
        String lastNameInput = lastName.getText();
        String phoneNumberInput = phoneNumber.getText();
        String emailInput = email.getText();
        String userNameInput = userName.getText();
        String passwordInput = password.getText();
        int ID = viewModel.getRandomNumber();

        if (!isFormCorrect(firstNameInput, lastNameInput, phoneNumberInput, emailInput,
                userNameInput, passwordInput)) {
            popAlert("Please put correct data");

            return;
        }

        User user = new User(firstNameInput, lastNameInput, ID, phoneNumberInput, emailInput, userNameInput,
                passwordInput);

        try {
            viewModel.createUser(user);

        } catch (Exception e) {
            popAlert("Invalid Input");
        }
        goToLogIn();
    }

    private boolean isFormCorrect(String firstNameInput, String lastNameInput, String phoneNumberInput, String emailInput,
                                  String userNameInput, String passwordInput) {
        try {
            Integer.parseInt(phoneNumberInput);
            return firstNameInput != "" && lastNameInput != "" && phoneNumberInput != "" && firstNameInput != "" &&
                    emailInput != "" && userNameInput != "" && passwordInput != "";
        } catch (Exception e) {
            return false;
        }
    }

    private void popAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(text);
        alert.showAndWait();
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void resetFields() {
        firstName.clear();
        lastName.clear();
        phoneNumber.clear();
        email.clear();
        userName.clear();
        password.clear();
    }

    public void goToLogIn() {
        viewModel.goToLogin();
    }
}
