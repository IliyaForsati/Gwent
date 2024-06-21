package controller.GameControllers;

import model.User;
import model.UserPreGameInfo;
import model.enums.card.Card;
import model.enums.gameMenu.Factions;
import model.toolClasses.Pair;
import model.toolClasses.Result;

import java.util.ArrayList;

public class PreGameMenuController {
    public static User currentUser = User.getLoggedInUser();
    // create a game
    public static Result createGame(String player2Username) {
        //check if player2Username is valid or not
        User secondUser = User.getLoggedInUser();
        if (secondUser == null)
            return new Result(false, "Second player username is invalid!");

        //check if current user wants to play with himself or not
        if (secondUser.getUsername().equals(currentUser.getUsername()))
            return new Result(false, "You can't play with yourself!");

        //run the game menu in view

        return new Result(true, "Game started");
    }
    private static boolean isUsernameValid(String username) {
        return true;
    }

    // show factions
    // it returns the faction that the user selected before
    public static Factions showFactions() {
        User user = User.getLoggedInUser();
        return user.getUserPreGameInfo().getFaction();
    }

    // select faction
    public static Result selectFaction(String factionName) {
        Factions factions = Factions.getFaction(factionName);
        if (factions == null)
            return new Result(false, "No faction found with this name!");


        //changing the faction
        User user = User.getLoggedInUser();
        UserPreGameInfo userPreGameInfo = user.getUserPreGameInfo();
        userPreGameInfo.setFaction(factions);
        user.setUserPreGameInfo(userPreGameInfo);
        User.setLoggedInUser(user);

        return new Result(true, "Faction changed successfully!");
    }

    // show Cards
    public static Result showCards() {
        User user = User.getLoggedInUser();

        Factions factions = user.getUserPreGameInfo().getFaction();
        ArrayList<Pair<Card,Integer>> factionCards = factions.getDeepCopyOfArraylist();
        // printing all cards
        for (int i = 0; i < factionCards.size(); i++) {
            Pair<Card, Integer> cardIntegerPair = factionCards.get(i);
            Card card = cardIntegerPair.getFirst();
            int numberOfCard = cardIntegerPair.getSecond();
        }
        return null; // todo
    }



    // show information current user
    public static Result showInfoCurrentUser() {
        return null;
    }

    // save deck
    public static Result saveDeckWithName(String address) {
        return null;
    }
    public static Result saveDeckWithAddress(String address) {
        return null;
    }
    private static boolean isAddressAlreadyUsed(String address) {
        return true;
    }
    private static boolean isSavedSuccessfully(String address) {
        return true;
    }

    // load deck
    public static Result loadDeckWithAddress(String address) {
        return null;
    }
    public static Result loadDeckWithName(String address) {
        return null;
    }
    private static boolean isAddressValid(String address) {
        return true;
    }
    private static boolean checkValidationOfFileContext(String fileAddress){
        return true;
    }

    // leader commands
    public static Result showLeaders(){
        return null;
    }
    public static Result selectLeader(int leaderNumber){
        return null;
    }
    private static boolean isLeaderNumValid(int leaderNumber) {
        return true;
    }

    // add to deck
    public static Result addToDeck(String cardName, int count){
        return null;
    }
    private static boolean isCountValid(int count) {
        return true;
    }
    private static boolean isCardNameValid(String cardName) {
        return true;
    }
    private static boolean checkNumberOfCardInDeck() {
        return true;
    } // TODO: ???
    private static boolean checkSpecialCardInDeck() {
        return true;
    }

    // delete card from deck
    public static Result deleteFromDeck(String cardName, int count){
        return null;
    }

    // change turn
    public static Result changeTurn(){
        return null;
    }
    private static boolean checkDeckIsOk() {
        return true;
    }


    // start game
    public static Result startGame(){
        return null;
    }

}
