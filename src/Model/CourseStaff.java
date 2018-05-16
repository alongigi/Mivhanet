package Model;

import java.util.List;

public class CourseStaff {
    List<Assistant> assistants;
    List<Lecturer> lecturers;
    Manager manager;
    List<Question> questions;
    Course course;

    public void writeComment(Question q, String comment){

    }

    public void writeQuestion(Question q){

    }

    public void editQuestion(Question q){

    }

    public void deleteQuestionById(int question_id){

    }

    public List<Question> getAllQuestions(){
        return questions;
    }

    public Question searchQuestion(String content){
        return null;
    }
}
