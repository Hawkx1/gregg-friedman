package views;

import DAO.AccountsDAO;
import DAO.LoginDAO;
import Utilities.ConnectionManager;
import Utilities.ViewManager;

import java.io.IOException;
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
        //try {
            kahn = ConnectionManager.getConnection();
            ldao = new LoginDAO(kahn);
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println("Enter your User Name: ");
        username = sc.nextLine();
        System.out.println("Enter Your Password: ");
        password = sc.nextLine();
        try {
            validUser = LoginDAO.checkLogin(username, password);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        if(validUser == true) {
            System.out.println("Welcome" + username);
        }
        else {
            System.out.println("User Not Found");
        }
    }
}
