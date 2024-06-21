package view.OtherMenu;

import controller.mainController.MainMenuController;
import view.HeadViewController;

import java.util.Scanner;

public class MainMenu {
    public static void run(Scanner scanner){

    }

    public void goToProfileMenu() {
        // TODO:
    }

    public void goToPreGameMenu() {
        // TODO:
    }

    public void signOut() {
        MainMenuController.userLogout();

        HeadViewController.changeScene("login page");
    }

    public void mute() {
        HeadViewController.player.setMute(HeadViewController.isMute = !HeadViewController.isMute);
    }
}