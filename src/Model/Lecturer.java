package Model;

public class Lecturer extends User {
    public Lecturer(String firstMame, String lastName, int ID, int phoneNumber, String email, String userName, String password) {
        super(firstMame, lastName, ID, phoneNumber, email, userName, password);
    }

    public void editAnswer(Question question, Answer answer){

    }

    public void addAnswer(Question question,Answer answer){

    }

    public void CreateExam(Question q){
        //createExam
    }
}
