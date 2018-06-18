package View.AddCourseView;

import Model.Semester;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import Main.ViewModel;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

    @FXML // fx:id="fruitCombo"
    private ComboBox<String> semesterCombo;

    private ViewModel viewModel;

    @FXML // fx:id="selectedFruit"
    private Label selectedFruit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public void setUp() {
        List<Semester> semesterList = viewModel.getAllSemesters();
        List<String> dates = new ArrayList<>();
        for (Semester s : semesterList) {
            dates.add(s.getStartDate());
        }
        semesterCombo.getItems().setAll(dates);

        // bind the selected fruit label to the selected fruit in the combo box.
        selectedFruit.textProperty().bind(semesterCombo.getSelectionModel().selectedItemProperty());

        // listen for changes to the fruit combo box selection and update the displayed fruit image accordingly.
        semesterCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldElement, String newElement) {

                System.out.println(newElement);

//                if (oldFruit != null) {
//                    switch(oldFruit) {
//                        case "Apple": appleImage.setVisible(false); break;
//                        case "Orange": orangeImage.setVisible(false); break;
//                        case "Pear": pearImage.setVisible(false); break;
//                    }
//                }
//                if (newFruit != null) {
//                    switch(newFruit) {
//                        case "Apple": appleImage.setVisible(true); break;
//                        case "Orange": orangeImage.setVisible(true); break;
//                        case "Pear": pearImage.setVisible(true); break;
//                    }
//                }
            }
        });
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void addCourse(MouseEvent mouseEvent) {
        viewModel.addCourse(courseName.getText(), courseNumber.getText(), syllabus.getText(), semester_date.getValue());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("New course add");
        alert.showAndWait();
        courseName.setText("");
        courseNumber.setText("");
        syllabus.setText("");
        semester_date.setValue(null);
    }

    @FXML
    private void exitApp(MouseEvent event) {
        System.exit(0);
    }
}
