package model.enums.mainMenu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum MainMenuCommands {
    logout(""),
    goToProfileMenu(""),
    goToPreGameMenu(""),
    goToPreviousMenu("");
    private final String regex;
    MainMenuCommands(String regex) {
        this.regex = regex;
    }
    public Matcher getMatcher(String input) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input);
    }
}
