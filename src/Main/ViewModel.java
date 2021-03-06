/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Model.Model;
import View.AddCourseView.AddCourseController;
import View.AddUserView.AddUserController;
import View.LoginView.LoginController;
import View.SignUpScreenView.SignUpController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Model.User;
import Model.Semester;

import java.sql.SQLException;
import java.util.List;

public class ViewModel extends Application {

    private Model model;
    private Stage stage;
    private AddCourseController addCourseController;
    private AddCourseController addUserController;
    private Scene addCourseScene;
    private Scene addUserScene;
    private Scene loginScene;
    private Scene signUpScene;

    private User user;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader addCourseLoader = new FXMLLoader(getClass().getResource("../View/AddCourseView/AddCourse.fxml"));
        Parent addCourseRoot = addCourseLoader.load();

        FXMLLoader addUserLoader = new FXMLLoader(getClass().getResource("../View/AddUserView/AddUser.fxml"));
        Parent addUserRoot = addUserLoader.load();

        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("../View/LoginView/Login.fxml"));
        Parent loginRoot = loginLoader.load();

        FXMLLoader signUpLoader = new FXMLLoader(getClass().getResource("../View/SignUpScreenView/SignUpScreen.fxml"));
        Parent signUpRoot = signUpLoader.load();

        this.stage = stage;
        this.stage.initStyle(StageStyle.UNDECORATED);

        addCourseScene = new Scene(addCourseRoot);
        addUserScene = new Scene(addUserRoot);
        loginScene = new Scene(loginRoot);
        signUpScene = new Scene(signUpRoot);

        Model model = new Model();
        setModel(model);
        AddCourseController addCourseController = addCourseLoader.getController();
        AddUserController addUserController = addUserLoader.getController();
        LoginController loginController = loginLoader.getController();
        SignUpController signUpController = signUpLoader.getController();


        addCourseController.setViewModel(this);
        addUserController.setViewModel(this);
        loginController.setViewModel(this);
        signUpController.setViewModel(this);
        addCourseController.setUp();
//        stage.setScene(addCourseScene);
        //stage.setScene(addUserScene);
        stage.setScene(loginScene);
//        stage.setScene(signUpScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void addCourse(int courseId, String nameCourse, String syllabus, Semester semester) throws SQLException {
        model.addCourse(nameCourse, syllabus, semester, courseId);
    }

    public boolean loginUser(String userNameInput, String userPasswordInput) {
        user = model.loginUser(userNameInput, userPasswordInput);
        if(user.userName.equals("NO USER")) {
            System.out.println("Invalid username or password");
            return false;
        }
        return true;
    }

    public void goToSignUp() {
        user = null;
        stage.setScene(signUpScene);
    }

    public void goToLogin() {
        stage.setScene(loginScene);
    }
    public void goToAddCourse() {
        stage.setScene(addCourseScene);
    }

    public int getRandomNumber() {
        return model.getRandomNumber();
    }

    public void createUser(User user) {
        model.createUser(user);
    }


    public List<Semester> getAllSemesters() {

        return  model.getAllSemesters();
    }
}
