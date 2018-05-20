package Model;

import java.util.List;

public class Question {
    int creator_id;
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

    public int getCommentSize(){
        return 0;
    }



}
