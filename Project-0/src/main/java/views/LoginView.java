package views;

import DAO.LoginDAO;
import Utilities.ConnectionManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginView extends View{

    public LoginView(Scanner scanner) {
        super("LoginView", scanner);
    }

    @Override
    public void renderView(){
        String username;
        String password;
        boolean validUser = false;
        LoginDAO ldao;
        Connection kahn;
        Scanner sc = new Scanner(System.in);
        kahn = ConnectionManager.getConnection();
        ldao = new LoginDAO(kahn);
        while(validUser == false) {
            System.out.println("Enter your User Name: ");
            username = sc.nextLine();
            System.out.println("Enter Your Password: ");
            password = sc.nextLine();
            try {
                validUser = LoginDAO.checkLogin(username, password);
                if (validUser == true) {
                    viewManager.navigate("Registered View");
                    viewManager.goToNextView();
                } else {
                    System.out.println("Username/Password Combination Not Valid");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
