package model.enums.loginMenu;

public enum ConfirmQuestions {
    q1(""),
    q2(""),
    q3(""),
    q4(""),
    q5("");

    private final String Question;

    ConfirmQuestions(String Question) {
        this.Question = Question;
    }

    public String getQuestion() {
        return Question;
    }
}
