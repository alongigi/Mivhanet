package Model;

import DB.DB;
import java.util.Random;

public class Model {
    DB db;

    public Model() {
        this.db = SingletonDB.getInstance("myDB.db");
    }

    public User loginUser(String emailInput, String userPasswordInput) {
        return db.loginUser(emailInput, userPasswordInput);
    }

    public int getRandomNumber() {
        Random rand = new Random();

        return rand.nextInt(50000) + 1;
    }

    public void createUser(User user) {
        db.addUser(user);
    }
}
