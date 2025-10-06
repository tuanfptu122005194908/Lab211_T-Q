package manager;

import gui.Menu;

public class run {

    Management m = new Management();
    Menu menu = new Menu();
    public void run() {
        while (true) {
            menu.menu();
            int choice = Validation.getInt("Your choice: ", 1, 6);
            Management.handelChoice(choice, m);
        }

    }
}
