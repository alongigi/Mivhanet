package Model;

public class Manager extends Lecturer {
    public Manager(String firstMame, String lastName, int ID, int phoneNumber, String email) {
        super(firstMame, lastName, ID, phoneNumber, email);
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
