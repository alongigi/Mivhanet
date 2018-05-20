package Model;

import java.util.Collections;
import java.util.List;

public class CourseStaff {
    List<Assistant> assistants;
    List<Lecturer> lecturers;
    Manager manager;
    Course course;
    List<Question> questions;
    List<Exam> exams;

    public void addCommentToQuestion(Question q, String comment){

    }

    public void writeQuestion(Question q){

    }

    public void editQuestion(Question q){

    }

    public void deleteQuestionById(int question_id){

    }

    public List<Question> getAllQuestions(){
        return Collections.emptyList();
    }

    public Question searchQuestion(String content){
        return null;
    }
}
