/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Model.Model;
import View.AddCourseView.AddCourseController;
import View.AddUserView.AddUserController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDate;

public class ViewModel extends Application {

    private Model model;
    private Stage stage;
    private AddCourseController addCourseController;
    private AddCourseController addUserController;
    private Scene addCourseScene;
    private Scene addUserScene;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader addCourseLoader = new FXMLLoader(getClass().getResource("../View/AddCourseView/AddCourse.fxml"));
        Parent addCourseRoot = addCourseLoader.load();
        FXMLLoader addUserLoader = new FXMLLoader(getClass().getResource("../View/AddUserView/AddUser.fxml"));
        Parent addUserRoot = addUserLoader.load();

        this.stage = stage;
        this.stage.initStyle(StageStyle.UNDECORATED);

        addCourseScene = new Scene(addCourseRoot);
        addUserScene = new Scene(addUserRoot);

        Model model = new Model();
        setModel(model);
        AddCourseController addCourseController = addCourseLoader.getController();
        AddUserController addUserController = addUserLoader.getController();

        addCourseController.setViewModel(this);
        //addUserController.setViewModel(this);

        stage.setScene(addCourseScene);
        //stage.setScene(addUserScene);
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
