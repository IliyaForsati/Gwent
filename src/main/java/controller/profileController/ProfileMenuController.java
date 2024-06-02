package controller.profileController;

import controller.loginController.LoginMenuController;

import java.util.Scanner;

//extending from LoginMenuController because of some methods
public class ProfileMenuController extends LoginMenuController {

    //change user username
    public static void changeUserName(String newUserName){}

    //change nickname
    public static void changeNickName(String newNickname) {}

    //change email
    public static void changeEmail(String newEmail) {}

    //change Password
    public static void changePassword(String newPassword , String oldPassword) {}

    //check if 2 strings are the same
    public boolean isStringsEqual(String str1 , String str2){return false;}

    //go to user info menu and show user's information
    public static void goToUserInfoMenu(Scanner scanner){}



}
