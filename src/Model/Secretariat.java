package Model;

import DB.DB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Secretariat {
    List<Semester> semesters;
    List<User> userList;
    DB db;

    public Secretariat() {
        this.db = DB.getInstance("myDB.db");
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

    public void addCourseToSemester(Course course, Semester semester) {

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

    public void sendUsernameAndPassword(User u) {

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

    public User loginUser(String userNameInput, String userPasswordInput) {
        return db.loginUser(userNameInput, userPasswordInput);
    }

    public void addUser(User user) {
        db.addUser(user);
    }


    public List<Semester> getAllSemesters() {
        try {
            semesters = db.getAllSemesters();

        } catch (SQLException e) {
            System.out.println("error");
            semesters = new ArrayList<Semester>();
        }
        return semesters;
    }

    public void addCourse(String nameCourse, String syllabus, Semester semester, int courseId) throws SQLException {
        Course c = new Course(nameCourse, courseId, syllabus);
        for (Semester s : semesters) {
            if (s.semesterId == semester.semesterId) {
                s.addCourse(c);
            }
        }
        db.addCourse(c);
        db.addCourseInSemester(c.getCourse_id(), semester.semesterId);
    }
}
