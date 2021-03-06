package DB;

import Model.*;

import java.sql.*;
import java.util.*;

public class DB {
    private Connection dbConnection;

    private static DB db = null;
    private DB(String path) {
        try {
            dbConnection = DriverManager.getConnection("jdbc:sqlite:" + path);
//            createCoursesTable();
            System.out.println("db init");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static DB getInstance(String path) {
        if(db == null) {
            db = new DB(path);
        }
        return db;
    }

//  GET data

    public List<Semester> getAllSemesters() throws SQLException {
        Statement st = dbConnection.createStatement();
        String query = "Select * From Semester ;";
        List<Semester> semesters = new ArrayList<>();
        ResultSet resultSet = st.executeQuery(query);
        while (resultSet.next()) {
            Semester s = new Semester(resultSet.getInt("semester_id"));
            s.setSemesterType(SemesterType.valueOf(resultSet.getString("type")));
            s.setStartDate(resultSet.getString("start_date"));
            s.setEndDate(resultSet.getString("end_date"));
            List<Course> semesterCourses = getSemesterCourses(s.getSemesterId());
            for (Course c : semesterCourses) {
                s.addCourse(c);
            }
            semesters.add(s);
        }
        return semesters;
    }

    public Course getCourse(int course_id) throws SQLException {
        Statement st = dbConnection.createStatement();
        String query = "Select * From Course WHERE course_id = " + course_id + ";";
        ResultSet resultSet = st.executeQuery(query);
        return new Course(resultSet.getString("name"), course_id, resultSet.getString("syllabus"));
    }

    public List<Exam> getCourseExams(int course_id) {
        return null;
    }

    public List<Moed> getCourseMoads(int course_id) {
        return Collections.emptyList();
    }

    public List<Course> getSemesterCourses(int semester_id) throws SQLException {
        Statement st = dbConnection.createStatement();
        String query = "Select * From CourseInSemester WHERE semester_id = " + semester_id + ";";
        List<Course> courses = new ArrayList<Course>();
        ResultSet resultSet = st.executeQuery(query);
        while (resultSet.next()) {
            Course c = getCourse(resultSet.getInt("course_id"));
            courses.add(c);
        }
        return courses;
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

    public void addCourse(Course course) throws SQLException {
            String query = "INSERT INTO Course \n" +
                    "VALUES (" + course.getCourse_id() + ", '" + course.getName() + "', '" + course.getSyllabus() + "');";
            execute(query);
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

//    private void addUser(String firstName, String lastName, String password, String email) {
//        try {
//            String query = "INSERT INTO Users \n" +
//                    "VALUES ('" + firstName + "','" + lastName + "','" + password + "','" + email + "');";
//            execute(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


//    public void addUser(User user) {
//        addUser(user.firstName, user.lastName, user.password, user.email);
//    }

    private void addUser(String userName, String firstName, String lastName, int id, String phoneNumber, String password, String email) {
        try {
            String query = "INSERT INTO User \n" +
                    "VALUES (" + id + " ,'" + userName + "','" + password + "','" + firstName + "','" + lastName
                    + "','" + phoneNumber + "','" + email + "');";
            execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        addUser(user.userName, user.firstName, user.lastName, user.ID, user.phoneNumber, user.password, user.email);
    }

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

    public User loginUser(String userNameInput, String userPasswordInput) {
        try {
            Statement st = dbConnection.createStatement();
            String query = "Select * From User WHERE User.user_name='" + userNameInput + "'" + " AND User.password='" + userPasswordInput + "';";
            ResultSet resultSet = st.executeQuery(query);
            return getUserFromRow(resultSet);

        } catch (SQLException e) {
            return new User("NO USER", "NO USER", 0, "0",
                    "NO USER", "NO USER", "NO USER");
        }
    }

    private User getUserFromRow(ResultSet resultSet) throws SQLException {
        String userFirstName = resultSet.getString("first_name");
        String userLastName = resultSet.getString("last_name");
        String password = resultSet.getString("password");
        String email = resultSet.getString("email");
        String phoneNumber = resultSet.getString("phone");
        String userName = resultSet.getString("user_name");

        Random rand = new Random();

        int ID = rand.nextInt(50000) + 1;

        return new User(userFirstName, userLastName, ID, phoneNumber, email, userName, password);
    }

    public int getNextCourseId() throws SQLException {
        Statement st = dbConnection.createStatement();
        String query = "Select MAX(course_id) as maxId From Course ;";
        ResultSet resultSet = st.executeQuery(query);
        return resultSet.getInt("maxId") + 1;
    }

    public void addCourseInSemester(int course_id, int semesterId) {
        try {
            String query = "INSERT INTO CourseInSemester \n" +
                    "VALUES (" + semesterId + ", " + course_id + ");";
            execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
