package Model;

public class User {
    String firstMame;
    String lastName;
    int ID;
    int phoneNumber;
    String email;
    String userName;
    String password;

    public User(String firstMame, String lastName, int ID, int phoneNumber, String email) {
        this.firstMame = firstMame;
        this.lastName = lastName;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    CourseStaff courseStaff;

    public void sendMail(){
        //sendMail
    }

    public void login(){
        //login
    }

    public void changPassword(String newPassword){
        //changePassword
    }
}
