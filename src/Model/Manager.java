package Model;

public class Manager extends Lecturer {
    public Manager(String firstMame, String lastName, int ID, int phoneNumber, String email, String userName, String password) {
        super(firstMame, lastName, ID, phoneNumber, email, userName, password);
    }

    public void deleteQuestion(Question q){
        //deleteQuestion
    }

    public void approveExam(Exam exam){
        //approveExam
    }


    public void changeGrade(int factor){
        //changeGrade
    }
}
