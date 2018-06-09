package DB;

import Model.*;

import java.sql.*;
import java.util.*;

public class DB {
    private Connection dbConnection;

    public DB(String path) {
        try {
            dbConnection = DriverManager.getConnection("jdbc:sqlite:" + path);
            createCoursesTable();
            createUsersTable();
            System.out.println("db init");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void createUsersTable() throws SQLException {
        execute("CREATE TABLE IF NOT EXISTS Users (\n" +
                "first_name varchar(255) ,\n" +
                "last_name varchar(255) ,\n" +
                "id int ,\n" +
                "phone int ,\n" +
                "email varchar(255) ,\n" +
                "CONSTRAINT Users PRIMARY KEY (id), \n" +
                ";");
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
//  GET data

    public Course getCourse(int course_id){
        return null;
    }

    public List<Exam> getCourseExams(int course_id){
        return null;
    }

    public List<Moed> getCourseMoads(int course_id){
        return Collections.emptyList();
    }

    public List<Course> getSemesterCourses(int semester_id){
        return Collections.emptyList();
    }

    public List<StudentGrade> getExamGrages(int exam_id){
        return Collections.emptyList();
    }

    public Student getStudetById(int student_id){
        return null;
    }

    public User getUserById(int user_id){
        return null;
    }

    public CourseStaff getCourseStaffByCourseId(int course_id){
        return null;
    }

    public List<Question> getCourseQuestions(int course_id){
        return null;
    }

    public List<ExamQuestion> getExamQuestions(int exam_id){
        return Collections.emptyList();
    }

    public List<Answer> getQuestionAnswers(int question_id){
        return Collections.emptyList();
    }

    public List<String> getQuestionComments(int question_id){
        return Collections.emptyList();
    }

    public List<Assistant> getCourseAssistants(int course_id){
        return Collections.emptyList();
    }

    public List<Lecturer> getCourseLecturers(int course_id){
        return Collections.emptyList();
    }

    public Manager getCourseManager(int course_id){
        return null;
    }

//    ADD data

    public void addCourse(Course course){

    }

    public void addQuestion(Question question){

    }

    public void addAnswer(Answer answer){

    }

    public void addComment(Question question, String comment){

    }

    public void addExam(Exam exam){

    }

    public void addUser(User user){

    }

    public void addCourseStaff(CourseStaff courseStaff){

    }

    public void addSemester(Semester semester){

    }

//    DELETE data

    public void deleteQuestion(Question question){

    }

    public void deleteCourse(Course course){

    }
    public void deleteAnswer(Answer answer){

    }

    public void deleteComment(Question question, String comment){

    }

    public void deleteExam(Exam exam){

    }

    public void deleteUser(User user){

    }

    private void execute(String sql) throws SQLException {
        Statement st = dbConnection.createStatement();
        st.execute(sql);
    }
}
