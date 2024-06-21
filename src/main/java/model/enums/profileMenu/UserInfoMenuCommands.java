package model.enums.profileMenu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum UserInfoMenuCommands {
    gameHistory(""),
    goToPreviousMenu("");
    private final String regex;
    UserInfoMenuCommands(String regex) {
        this.regex = regex;
    }
    public Matcher getMatcher(String input) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input);
    }}
