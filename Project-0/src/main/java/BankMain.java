import java.util.Scanner;

public class BankMain {



//        System.out.println("Please enter your username: ");
//        username = user.nextLine();
//        System.out.println("Please enter your password: ");
//        password = pass.nextLine();

    public static void main(String[] args) {
        String username;
        String password;
        Scanner user = new Scanner(System.in);
        Scanner pass = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        System.out.println("===MAIN MENU===\nEnter selection:\n\n1) Register an Account\n2) Login\nQ) Quit");
        String input = sc.nextLine();

        boolean running = true;
        while (running) {
            switch (input) {
                case "1":

                    break;
                case "2":

                    break;
                case "Q":
                case "q":
                    running = false;
                    break;
            }
        }
    }
}
