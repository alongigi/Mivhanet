package Model;

import java.util.Date;

public class Moed {
    public MoadType moadType;
    public Date date;
    public Course course;
    public int ID;

    public Moed(MoadType moadType, Date date, Course course, int ID) {
        this.moadType = moadType;
        this.date = date;
        this.course = course;
        this.ID = ID;
    }
}
