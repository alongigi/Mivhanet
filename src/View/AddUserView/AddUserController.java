package View.AddUserView;

import java.net.URL;
import java.util.ResourceBundle;

import Model.User;
import Main.ViewModel;
//import com.jfoenix.controls.JFXButton;
//import com.jfoenix.controls.JFXPasswordField;
//import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author proxc
 */
public class AddUserController implements Initializable {

    @FXML
    private Label btn_exit;
    public TextField first_name;
    public TextField phone;
    public TextField last_name;
    public TextField email;
    public TextField id;
    public Button btn_add_user;

    private ViewModel viewModel;

    @FXML
    private void exitApp(MouseEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void handleAddUser(MouseEvent mouseEvent) {
        User u = new User(first_name.getText(),last_name.getText(), Integer.parseInt(id.getText()) ,Integer.parseInt(phone.getText()), email.getText());

//        if(!viewModel.isUserExists(u)) {
//            try {
//                viewModel.sendEmail(email.getText());
//                viewModel.addUser(u);
//                resetFields(mouseEvent);
//                viewModel.goToSignIn();
//            }
//            catch (Exception e){
//                popAlert("Email is not well formed");
//            }
//        }
//        else {
//            popAlert("User exists");
//        }
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

    public void resetFields(MouseEvent mouseEvent) {
        first_name.setText("");
        phone.setText("");
        last_name.setText("");
        email.setText("");
        id.setText("");
    }

}