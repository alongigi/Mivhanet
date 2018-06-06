/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Model.Model;
import View.AddCourseView.AddCourseController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDate;

public class ViewModel extends Application {

    private Model model;
    private Stage stage;
    private AddCourseController addCourseController;
    private Scene addCourseScene;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader addCourseLoader = new FXMLLoader(getClass().getResource("../View/AddCourseView/AddCourse.fxml"));
        Parent addCourseRoot = addCourseLoader.load();


        this.stage = stage;
        this.stage.initStyle(StageStyle.UNDECORATED);

        addCourseScene = new Scene(addCourseRoot);

        Model model = new Model();
        setModel(model);
        AddCourseController controller = addCourseLoader.getController();
        controller.setViewModel(this);

        stage.setScene(addCourseScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void addCurse(String nameCourse, String numberCourse, String syllabus, LocalDate semester) {
    }
}

