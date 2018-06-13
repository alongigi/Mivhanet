package Model;

import java.util.List;

public class Exam {
    public int duration;
    public int ID;
    public Course course;
    public Moed moed;
    public int factor;
    public List<ExamQuestion> questions;
    public List<StudentGrade> grades;

    public Exam(int ID, Course course, int duration, Moed moed, int factor) {
        this.ID = ID;
        this.course = course;
        this.duration = duration;
        this.moed = moed;
        this.factor = factor;
    }


    public void printToFile(String filePath) {
        //printToFile
    }

    public void approve() {

    }
}
