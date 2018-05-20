package Model;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CourseStaff {
    List<Assistant> assistants;
    List<Lecturer> lecturers;
    Manager manager;
    Course course;
    List<Question> questions;
    List<Exam> exams;
    List<Moed> moeds;

    public void addCommentToQuestion(Question q, String comment){

    }

    public void writeQuestion(Question q){

    }

    public void editQuestion(Question q){

    }

    public void deleteQuestion(int question_id){

    }

    public List<Question> getAllQuestions(){
        return Collections.emptyList();
    }

    public Question searchQuestion(String content){
        return null;
    }

    public Question getQuestion(int questionId){
        return null;
    }

    public Exam getExam(int examId) {
        return null;
    }

    public void addQuestionToExam(Question question, Exam exam, int score){

    }

    public int searchQuestionIdByContent(String content){
        return 0;
    }

    public void alertError(String msg){

    }

    public void updateQuestionRank(int questionId, int rank){

    }

    public void addComment(int questionId, String comment){

    }

    public Exam createExam(Moed moed){
        return null;
    }

    public Moed getMoed(Date date){
        return null;
    }

}
