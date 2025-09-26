
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menuSinglyLinkedList menu1 = new menuSinglyLinkedList();
        menuDoublyLinkedList menu2 = new menuDoublyLinkedList();
        while (true) {
            int choice;
            System.out.println("=====MENU=====");
            System.out.println("1. Singly Linked List");
            System.out.println("2. Doubly Linked List");
            System.out.println("3. Exit menu");

            System.out.println("Your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    menu1.showMenuSinglyLinkedList();
                    break;
                case 2:
                    menu2.showMenuDoublyLinkedList();
                    break;
                case 3:
                    System.out.println("Exit menu");
                    return;
                default:
                    System.out.println("Invalid selection, please try again!");
            }
        }
    }

}
