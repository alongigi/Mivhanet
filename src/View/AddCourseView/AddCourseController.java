package View.AddCourseView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import Main.ViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class AddCourseController implements Initializable {
    @FXML
    public TextField courseName;
    @FXML
    public TextField courseNumber;
    @FXML
    public TextField syllabus;
    @FXML
    private DatePicker semester_date;

    private ViewModel viewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        categories.set
    }

    public void setViewModel(ViewModel viewModel) {this.viewModel = viewModel;}

    public void addCurse(MouseEvent mouseEvent) {
        viewModel.addCurse(courseName.getText(), courseNumber.getText(), syllabus.getText(), semester_date.getValue());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("New course add");
        alert.showAndWait();
        courseName.setText("");
        courseNumber.setText("");
        syllabus.setText("");
        semester_date.setValue(null);
    }

    public void quitOption(ActionEvent actionEvent) {
        System.exit(0);
    }
}
