package DB;

import Model.*;

import java.sql.*;
import java.util.*;

public class DB {
    private Connection dbConnection;

    public DB(String path) {
        try {
            dbConnection = DriverManager.getConnection("jdbc:sqlite:" + path);
            System.out.println("db init");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
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

    public List<Comment> getQuestionComments(int question_id){
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

    public void addComment(Comment comment){

    }

    public void addExam(Exam exam){

    }

    public void addUser(User user){

    }

    public void addCourseStaff(CourseStaff courseStaff){

    }

    public void addSemester(Semester semester){

    }

}
