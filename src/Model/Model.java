package Model;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class Model {
    Secretariat secretariat;

    public Model() {

//        this.db = SingletonDB.getInstance("myDB.db");
        secretariat = new Secretariat();
    }

    public User loginUser(String emailInput, String userPasswordInput) {

        return secretariat.loginUser(emailInput, userPasswordInput);
//        return db.loginUser(emailInput, userPasswordInput);
    }

    public int getRandomNumber() {
        Random rand = new Random();

        return rand.nextInt(50000) + 1;
    }

    public void createUser(User user) {
        secretariat.addUser(user);
    }


    public List<Semester> getAllSemesters() {
        return secretariat.getAllSemesters();
    }

    public void addCourse(String nameCourse, String syllabus, Semester semester) throws SQLException {
        secretariat.addCourse(nameCourse, syllabus, semester);
    }
}
