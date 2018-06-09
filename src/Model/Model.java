package Model;

import DB.DB;

public class Model {
    public Model() {
        DB db = SingletonDB.getInstance("myDB.db");
    }
}
