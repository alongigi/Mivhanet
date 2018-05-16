package Model;

import java.util.List;

public class Question {
    User creator;
    String Body;
    int duration;
    QuestionDifficulty questionDifficulty;
    List<Answer> answers;
    List<String> comments;

    public int getCommentsSize()
    {
        return 0;
    }

    public void addComment(String comment){

    }



}
