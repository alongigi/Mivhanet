package Model;

import java.util.List;

public class Course {
    private String name;
    private int id;
    private String syllabus;



    public Course(String name, int id, String syllabus) {

        this.name = name;
        this.id = id;
        this.syllabus = syllabus;
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

}
