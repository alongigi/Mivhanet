package Model;

import java.util.Date;
import java.util.List;

public class Semester {
    int semesterId;
    SemesterType semesterType;
    String startDate;
    String endDate;
    List<Course> courses;

    public Semester(int semesterId) {
        this.semesterId = semesterId;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void addCourse(Course course){

    }

    public SemesterType getSemesterType() {
        return semesterType;
    }

    public void setSemesterType(SemesterType semesterType) {
        this.semesterType = semesterType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
