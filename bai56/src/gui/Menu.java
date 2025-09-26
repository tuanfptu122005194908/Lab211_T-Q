package gui;

import manager.*;

public class Menu {

    public void menu() {
        Management menu = new Management();
        while (true) {
            System.out.println("======== Worker Management ========");
            System.out.println("1. Add Worker");
            System.out.println("2. Up salary");
            System.out.println("3. Down salary");
            System.out.println("4. Display Infomation salary");
            System.out.println("5. Exit");

            int choice = Validation.getInt("Your choice: ", 1, 5);

            switch (choice) {
                case 1:
                    System.out.println("-------- Add Worker --------");
                    menu.addWorker();
                    break;
                case 2:
                    System.out.println("-------- UP/DOWN Salary --------");
                    menu.increaseSalary();
                    break;
                case 3:
                    System.out.println("-------- UP/DOWN Salary --------");
                    menu.decreaseSalary();
                    break;
                case 4:
                    menu.printHistory();
                    break;
                case 5:
                    System.out.println("Exit!");
                    return;
                default:
                    System.out.println("Invalid!");
            }
        }
    }
}
