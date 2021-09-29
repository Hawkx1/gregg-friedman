import DAO.*;
import Utilities.ConnectionManager;
import Utilities.MyArrayList;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class BankMain {

    public static void main(String[] args){
//        MyArrayList myList = new MyArrayList();
//        myList.add(2);
//        myList.add(4);
//        myList.add(6);
//        System.out.println(myList.get(1));
        MyArrayList test;
        try (Connection kahn = ConnectionManager.getConnection()){
            LoginDAO dao = new LoginDAO(kahn);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        /*MyArrayList<Integer> test = new MyArrayList<>();
        test.add(5);
        test.add(4, 7);
        test.add(9);
        for(int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }
        //LoginDAO.checkLogin();
        String username;
        String password;
        boolean validUser;
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
        System.out.println("===MAIN MENU===\nEnter selection:\n\n1) Register an Account\n2) Login\nQ) Quit");
        String input = sc.nextLine();


            switch (input) {
                case "1":
                    break;
                case "2":
                    System.out.println("Enter your User Name: ");
                    username = sc.nextLine();
                    System.out.println("Enter Your Password: ");
                    password = sc.nextLine();

                    validUser = LoginDAO.checkLogin(username, password);

                    if(validUser == true) {
                        System.out.println("Welcome" + username);
                    }
                    else {
                        System.out.println("User Not Found");
                        break;
                    }
                    System.out.println("==="+ username + "s MENU===\nEnter selection:\n\n1) Create Bank Account\n" +
                            "2) Deposit Funds\n3) Withdrawal Funds\n4) Display All Accounts\nQ) Quit");

                case "Q":
                case "q":
                    running = false;
                    break;
            }
        } */
    }
}
