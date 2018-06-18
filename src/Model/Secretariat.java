package Model;

import DB.DB;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Secretariat {
    List<Semester> semesters;
    List<User> userList;
    DB db;

    public Secretariat() {
        this.db = SingletonDB.getInstance("myDB.db");
        semesters = new ArrayList<Semester>();
        userList = new ArrayList<User>();
    }

    public void initSystem() {
        //initSystem

    }

    public void watch(Exam e) {
        //watch
    }

    public Course createCourse(String courseName, int courseId, String syllabus) {
        //createCourse
        return null;
    }

    public Semester getSemesterByDate(Date startDate) {
        return null;
    }

    public void addCourseToSemester(Course course, Semester semester){

    }

    public void insertToSystem(User u) {
        //insertToSystem
    }

    public Moed createMoad() {
        //createMoad
        return null;
    }

    public void creatNewUser(String firstName, String lastName, int id, String phone, String email) {

    }

    public void sendUsernameAndPassword(User u){

    }

    public boolean logIn(String user_name, String password) {
        return false;
    }

    public User getUser(String user_name, String password) {
        return null;
    }

    public void connectUser(User u) {

    }

    public void alertUserNotExsits() {

    }

    public User loginUser(String emailInput, String userPasswordInput) {
        return db.loginUser(emailInput, userPasswordInput);
    }

    public void addUser(User user) {
        db.addUser(user);
    }


}
