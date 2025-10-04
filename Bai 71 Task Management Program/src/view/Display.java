package view;

import model.Task;
import java.util.ArrayList;

public class Display {
    
    public void showMenu() {
        System.out.println("========= Task program =========");
        System.out.println("1. Add Task");
        System.out.println("2. Delete task");
        System.out.println("3. Display Task");
        System.out.println("4. exit");
    }
    
    public void showAddTaskHeader() {
        System.out.println("------------Add Task---------------");
    }
    
    public void showDeleteTaskHeader() {
        System.out.println("---------Del Task------");
    }
    
    public void showTaskList(ArrayList<Task> tasks) {
        System.out.println("----------------------------------------- Task ---------------------------------------");
        System.out.printf("%-6s %-19s %-13s %-13s %-13s %-12s %s\n", 
                         "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        
        for (Task task : tasks) {
            System.out.println(task.toString());
        }
    }
    
    public void showMessage(String message) {
        System.out.println(message);
    }
}