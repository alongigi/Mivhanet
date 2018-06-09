package Model;
import DB.DB;


public class SingletonDB {
    private static DB db = null;
    private SingletonDB() {

    }
    public static DB getInstance(String path) {
        if(db == null) {
            db = new DB(path);
        }
        return db;
    }
}
