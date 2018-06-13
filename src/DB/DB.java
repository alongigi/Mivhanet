package DB;

import Model.*;

import java.sql.*;
import java.util.*;

public class DB {
    private Connection dbConnection;

    public DB(String path) {
        try {
            dbConnection = DriverManager.getConnection("jdbc:sqlite:" + path);
//            createCoursesTable();
            createUsersTable();
            System.out.println("db init");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void createUsersTable() throws SQLException {
        execute("CREATE TABLE IF NOT EXISTS Users (\n" +
                "first_name varchar(255),\n" +
                "last_name varchar(255),\n" +
                "password varchar(255),\n" +
                "email varchar(255) PRIMARY KEY \n" +
                ");");
    }

    private void createCoursesTable() throws SQLException {
        execute("CREATE TABLE IF NOT EXISTS Courses (\n" +
                "name_course varchar(255) ,\n" +
                "number_course int ,\n" +
                "syllabus varchar(255),\n" +
                "semester varchar(255),\n" +
                "CONSTRAINT Courses PRIMARY KEY (name_course,number_course,semester), \n" +
                ";");
    }

    private void createExamTable() throws SQLException {
        execute("CREATE TABLE IF NOT EXISTS Exams (\n" +
                "exam_id int ,\n" +
                "course_id int ,\n" +
                "duration int ,\n" +
                "moed_id int ,\n" +
                "factor int ,\n" +
                ";");
    }

//  GET data

    public Course getCourse(int course_id) {
        return null;
    }

    public List<Exam> getCourseExams(int course_id) {
        return null;
    }

    public List<Moed> getCourseMoads(int course_id) {
        return Collections.emptyList();
    }

    public List<Course> getSemesterCourses(int semester_id) {
        return Collections.emptyList();
    }

    public List<StudentGrade> getExamGrages(int exam_id) {
        return Collections.emptyList();
    }

    public Student getStudetById(int student_id) {
        return null;
    }

    public User getUserById(int user_id) {
        return null;
    }

    public CourseStaff getCourseStaffByCourseId(int course_id) {
        return null;
    }

    public List<Question> getCourseQuestions(int course_id) {
        return null;
    }

    public List<ExamQuestion> getExamQuestions(int exam_id) {
        return Collections.emptyList();
    }

    public List<Answer> getQuestionAnswers(int question_id) {
        return Collections.emptyList();
    }

    public List<String> getQuestionComments(int question_id) {
        return Collections.emptyList();
    }

    public List<Assistant> getCourseAssistants(int course_id) {
        return Collections.emptyList();
    }

    public List<Lecturer> getCourseLecturers(int course_id) {
        return Collections.emptyList();
    }

    public Manager getCourseManager(int course_id) {
        return null;
    }

//    ADD data

    public void addCourse(Course course) {

    }

    public void addQuestion(Question question) {

    }

    public void addAnswer(Answer answer) {

    }

    public void addComment(Question question, String comment) {

    }

    public void addExam(Exam exam) {
        int exam_id = exam.ID;
        int course_id = exam.course.getCourse_id();
        int duration = exam.duration;
        int moed_id = exam.moed.ID;
        int factor = exam.factor;

        try {
            String query = "INSERT INTO Exams \n" +
                    "VALUES ('" + exam_id + "','" + course_id + "','" + duration + "','" + moed_id
                    + "','" + factor + "');";
            execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addUser(String firstName, String lastName, String password, String email) {
        try {
            String query = "INSERT INTO Users \n" +
                    "VALUES ('" + firstName + "','" + lastName + "','" + password + "','" + email + "');";
            execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addUser(User user) {
        addUser(user.firstName, user.lastName, user.password, user.email);
    }

//    private void addUser(String firstName, String lastName, int id, int phoneNumber, String password, String email) {
//        try {
//            String query = "INSERT INTO Users \n" +
//                    "VALUES ('" + firstName + "','" + lastName + "','" + password + "','" + id
//                    + "','" + phoneNumber + "','" + password + "','" + email + "');";
//            execute(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void addUser(User user) {
//        addUser(user.firstName, user.lastName, user.ID, user.phoneNumber, user.password, user.email);
//    }

    public void addCourseStaff(CourseStaff courseStaff) {

    }

    public void addSemester(Semester semester) {

    }

//    DELETE data

    public void deleteQuestion(Question question) {

    }

    public void deleteCourse(Course course) {

    }

    public void deleteAnswer(Answer answer) {

    }

    public void deleteComment(Question question, String comment) {

    }

    public void deleteExam(Exam exam) {

    }

    public void deleteUser(User user) {

    }

    private void execute(String sql) throws SQLException {
        Statement st = dbConnection.createStatement();
        st.execute(sql);
    }

    public User loginUser(String emailInput, String userPasswordInput) {
        try {
            Statement st = dbConnection.createStatement();
            String query = "Select * From Users WHERE Users.email='" + emailInput + "'" + " AND Users.password='" + userPasswordInput + "';";
            ResultSet resultSet = st.executeQuery(query);
            return getUserFromRow(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();


            return new User("NO USER", "NO USER", 0, 0,
                    "NO USER", "NO USER", "NO USER");
        }
    }

    private User getUserFromRow(ResultSet resultSet) throws SQLException {
        String userFirstName = resultSet.getString("first_name");
        String userLastName = resultSet.getString("last_name");
        String password = resultSet.getString("password");
        String email = resultSet.getString("email");

        Random rand = new Random();

        int ID = rand.nextInt(50000) + 1;

        return new User(userFirstName, userLastName, ID, 0, email, "userName", password);
    }


//    private User getUserFromRow(ResultSet resultSet) throws SQLException {
//        String userName = resultSet.getString("user_name");
//        String userFirstName = resultSet.getString("first_name");
//        String userLastName = resultSet.getString("last_name");
//        String password = resultSet.getString("password");
//        String email = resultSet.getString("email");
//        int ID = Integer.parseInt(resultSet.getString("id"));
//        int phoneNumber = Integer.parseInt(resultSet.getString("id"));
//
//        return new User(userFirstName, userLastName, ID, phoneNumber, email, userName, password);
//    }
}
