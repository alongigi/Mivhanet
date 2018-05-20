package Model;

import java.util.Date;
import java.util.List;

public class Secretariat {
    List<Semester> semesters;
    List<User> userList;

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
}
