package DB;

import Model.Course;

import java.io.File;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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

    public Course getCourse(int course_id){
       
        return null;
    }
}
