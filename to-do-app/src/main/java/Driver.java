import models.ToDoItem;
import utils.PrintView;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        //view command line arguments passed to app
        for (String arg : args) {
            System.out.println(arg);
        }

        Scanner sc = new Scanner(System.in);

        List<ToDoItem> toDoList = new LinkedList<ToDoItem>();

        ToDoItem newItem1 = new ToDoItem("Build a to do list");
        toDoList.add(newItem1);
        ToDoItem newItem2 = new ToDoItem("Debug the new to do list");
        toDoList.add(newItem2);
        ToDoItem newItem3 = new ToDoItem("Enjoy your new to do list");
        toDoList.add(newItem3);




        //Main app loop
        boolean running = true;
        while(running) {
            System.out.println("===MAIN MENU===\n1) Show ToDo Items\n2) Mark item complete\n3) Quit");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.println("==========To Do List: ==========");
                    for (int i = 0; i < toDoList.size(); i++) {
                        PrintView.printMyView(i, toDoList.get(i));
                    }
                    System.out.println("================================");
                    break;
                case 2:
                    System.out.println("==========To Do List: ==========");
                    for (int i = 0; i < toDoList.size(); i++) {
                        PrintView.printMyView(i, toDoList.get(i));
                    }
                    System.out.print("\nEnter item number to complete: ");
                    int choice = sc.nextInt();
                    toDoList.get(choice).setComplete(true);
                    System.out.println("\n Item #" + choice + " is complete!");
                    break;
                case 3:
                    running = false;
                    break;
            }
        }

    }
}
