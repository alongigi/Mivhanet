package Model;

import java.util.List;

public class Question {
    User creator;
    String Body;
    int duration;
    QuestionDifficulty questionDifficulty;
    List<Answer> answers;
    List<String> comments;

}
