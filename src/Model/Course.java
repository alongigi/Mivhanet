package Model;

import java.util.List;

public class Course {
    private String name;
    private int id;
    private String syllabus;
    private CourseStaff courseStaff;
    private List<Question> questions;

    public Course(String name, int id, String syllabus) {

        this.name = name;
        this.id = id;
        this.syllabus = syllabus;
    }

    public void setCourseStaff(CourseStaff courseStaff) {
        this.courseStaff = courseStaff;
    }

    public String getName() {

        return name;
    }

    public int getId() {
        return id;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public CourseStaff getCourseStaff() {
        return courseStaff;
    }

}
