package Model;

public class Course {
    private String name;
    private int course_id;
    private String syllabus;

    public Course(String name, int course_id, String syllabus) {

        this.name = name;
        this.course_id = course_id;
        this.syllabus = syllabus;
    }

    public String getName() {
        return name;
    }

    public int getCourse_id() {
        return course_id;
    }

    public String getSyllabus() {
        return syllabus;
    }

}
