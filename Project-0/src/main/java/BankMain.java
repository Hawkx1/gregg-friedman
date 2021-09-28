import DAO.LoginDAO;

import java.sql.SQLException;

public class BankMain {



//        System.out.println("Please enter your username: ");
//        username = user.nextLine();
//        System.out.println("Please enter your password: ");
//        password = pass.nextLine();

    public static void main(String[] args) throws SQLException {
//        MyArrayList myList = new MyArrayList();
//        myList.add(2);
//        myList.add(4);
//        myList.add(6);
//        System.out.println(myList.get(1));
        LoginDAO.checkLogin();
        /*String username;
        String password;
        Scanner input = new Scanner(System.in);

        System.out.println("===MAIN MENU===\nEnter selection:\n\n1) Register an Account\n2) Login\nQ) Quit");
        String input = sc.nextLine();

        boolean running = true;
        while (running) {
            switch (input) {
                case "1":
                    System.out.println("Enter your User Name: ");
                    username = user.nextLine();
                    System.out.println("Enter Your Password: ");
                    password = pass.nextLine();

                    break;
                case "2":

                    break;
                case "Q":
                case "q":
                    running = false;
                    break;
            }
        } */
    }
}
