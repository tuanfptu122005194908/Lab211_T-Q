package manager;

import java.util.ArrayList;
import java.util.List;
import object.SalaryHistory;
import object.Worker;

public class Management {

    private List<Worker> workers;
    private List<SalaryHistory> histories;

    public Management() {
        workers = new ArrayList<>();
        histories = new ArrayList<>();
    }

    // 1. Add a worker
    public void addWorker() {
        String id = Validation.getCode("Enter Code: ", workers);
        String name = Validation.getString("Enter Name: ");
        int age = Validation.getInt("Enter Age: ", 18, 50);
        double salary = Validation.getDouble("Enter Salary: ", 0, Double.MAX_VALUE);
        String location = Validation.getString("Enter work location: ");

        Worker w = new Worker(id, name, age, salary, location);
        workers.add(w);
        System.out.println("Worker added success!");

    }

    // 2 update salary (up/down)
    public void changeSalary(String type) {
        if (workers.isEmpty()) {
            System.err.println("No workers!");
            return;
        }
        String id = Validation.getString("Enter Code: ");
        Worker w = null;

        for (Worker worker : workers) {
            if (worker.getId().equalsIgnoreCase(id)) {
                w = worker;
                break;
            }
        }
        if (w == null) {
            System.err.println("Worker not found!");
            return;
        }

        double amount = Validation.getDouble("Enter salary: ", 0, Double.MAX_VALUE);

        if (type.equals("UP")) {
            w.setSalary(w.getSalary() + amount);
        } else if (type.equals("DOWN")) {
            // neu ma cai luong goc - amount < 0
            if (w.getSalary() - amount <= 0) {
                System.err.println("Salary can not negative!");
                return;
            }
            w.setSalary(w.getSalary() - amount);
        }
       
        // save history salary
        histories.add(new SalaryHistory(w, w.getSalary(), type));
        System.out.println("Salary updae success!");

    }

    public void increaseSalary() {
        changeSalary("UP");
    }

    public void decreaseSalary() {
        changeSalary("DOWN");
    }

   
    // print salary history
    public void printHistory() {
        if (histories.isEmpty()) {
            System.out.println("No history available!");
            return;
        }
        System.out.println("---------------- Display Infomation salary ----------------");
        System.out.printf("%-10s %-15s %-5s %-10s %-10s %-12s", "Code", "Name", "Age", "Salary", "Status", "Date");
        System.out.println();
        for (SalaryHistory h : histories) {
            System.out.println(h);
        }
    }
}
