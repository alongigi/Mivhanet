package Model;

public class User {
    public String firstName;
    public String lastName;
    public int ID;
    public String phoneNumber;
    public String email;
    public String userName;
    public String password;

    public User(String firstName, String lastName, int ID, String phoneNumber, String email, String userName,
                String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    CourseStaff courseStaff;

    public void sendMail() {
        //sendMail
    }

    public void login() {
        //login
    }

    public void changPassword(String newPassword) {
        //changePassword
    }
}
