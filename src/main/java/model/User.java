package model;

import model.enums.loginMenu.ConfirmQuestions;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String answer;
    private ConfirmQuestions confirmQuestions;
    private static User loggedInUser;
    private double highestScore;
    private int wonGames;
    private int lostGames;
    private int drawGames;
    private int totalPlayedGames;
    private UserPreGameInfo userPreGameInfo;
    private static ArrayList<User> allUsers = new ArrayList<>();
    private ArrayList<GameHistory> allPlayedGamesHistory; // for command "GameHistory history -n <n>"

    public User(ConfirmQuestions confirmQuestions, String... input) {
        username = input[0];
        password = input[1];
        nickname = input[2];
        email = input[3];
        answer = input[4];

        this.confirmQuestions = confirmQuestions;
        this.highestScore = 0;
        this.wonGames = 0;
        this.lostGames = 0;
        this.drawGames = 0;
        this.totalPlayedGames = 0;
        this.userPreGameInfo = new UserPreGameInfo();
        this.allPlayedGamesHistory = new ArrayList<>();

        allUsers.add(this);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private static User getUserByUsername(String username) {
        return null;
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        User.loggedInUser = loggedInUser;
    }

    //get user rank
    public int getRank(){return 0;}
}
