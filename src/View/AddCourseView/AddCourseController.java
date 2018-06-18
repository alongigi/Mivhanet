package View.AddCourseView;

import Model.Semester;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import Main.ViewModel;

//import javax.jnlp.IntegrationService;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

public class AddCourseController implements Initializable {
    @FXML
    public TextField courseName;
    @FXML
    public TextField courseNumber;
    @FXML
    public TextField syllabus;

    @FXML // fx:id="fruitCombo"
    private ComboBox<String> semesterCombo;

    private ViewModel viewModel;

    @FXML // fx:id="selectedFruit"
    private Label selectedFruit;

    private Semester pickedSemester;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public void setUp() {
        List<Semester> semesterList = viewModel.getAllSemesters();
        List<String> dates = new ArrayList<>();
        Map<String, Semester> startDateToSemester = new HashMap<>();
        for (Semester s : semesterList) {
            dates.add(s.getStartDate());
            startDateToSemester.put(s.getStartDate(), s);
        }
        semesterCombo.getItems().setAll(dates);
        pickedSemester = startDateToSemester.get(dates.get(0));
        // bind the selected fruit label to the selected fruit in the combo box.
        selectedFruit.textProperty().bind(semesterCombo.getSelectionModel().selectedItemProperty());

        // listen for changes to the fruit combo box selection and update the displayed fruit image accordingly.
        semesterCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldElement, String newElement) {
                pickedSemester = startDateToSemester.get(newElement);
                System.out.println(newElement);
            }
        });
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void addCourse(MouseEvent mouseEvent) {
        if (!courseName.getText().equals("") && !syllabus.getText().equals("") && !pickedSemester.equals("")) {
            try {
                int courseId = Integer.parseInt(courseNumber.getText());
                viewModel.addCourse(courseId, courseName.getText(), syllabus.getText(), pickedSemester);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("New course add");
                alert.showAndWait();
                courseName.setText("");
                courseNumber.setText("");
                syllabus.setText("");
            } catch (SQLException e) {
                System.out.println("Bad course values");
                popAlert("CourseId is taken");
            } catch (Exception e) {
                popAlert("CourseId must be Integer");
            }
        }
        else {
            popAlert("Some values are missing");
        }
    }

    @FXML
    private void exitApp(MouseEvent event) {
        System.exit(0);
    }

    private void popAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(text);
        alert.showAndWait();
    }
}
