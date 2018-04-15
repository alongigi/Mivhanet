package Model;

import java.util.List;

public class Question {
    User creator;
    String Body;
    int Time;
    QuestionDifficulty questionDifficulty;
    List<Answer> answers;
    List<Comment> comments;

}
