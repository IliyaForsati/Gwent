package model.enums.loginMenu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum LoginMenuCommands {
    enterMainMenu(""),
    exitMenu(""),
    showCurrentMenu(""),
    register(""),
    pickQuestion(""),
    login(""),
    forgetPassword(""),
    answerQ(""),
    setPassword("");
    private final String regex;
    LoginMenuCommands(String regex) {
        this.regex = regex;
    }
    public Matcher getMatcher(String input) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input);
    }}