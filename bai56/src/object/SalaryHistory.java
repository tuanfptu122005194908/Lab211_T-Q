
package object;

import java.text.SimpleDateFormat;
import java.util.Date;


public class SalaryHistory {

    private String workerId;
    private String workerName;
    private int workerAge;
    private double salary;
    private String status;  // UP or  Down
    private String date;

    public SalaryHistory(Worker w, double salary, String status) {
        this.workerId = w.getId();
        this.workerName = w.getName();
        this.workerAge = w.getAge();
        this.salary = salary;
        this.status = status;
        this.date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());

    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public int getWorkerAge() {
        return workerAge;
    }

    public void setWorkerAge(int workerAge) {
        this.workerAge = workerAge;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-5d %-10.2f %-10s %-12s", workerId, workerName, workerAge, salary, status, date);

    }

}
