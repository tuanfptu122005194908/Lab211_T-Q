package controller;

import model.Task; // Import class Task từ package model
import java.text.SimpleDateFormat; // Import để format date
import java.util.ArrayList; // Import ArrayList - danh sách động
import java.util.Collections; // Import để sort collection
import java.util.Comparator; // Import để tạo bộ so sánh
import java.util.Date; // Import Date

// Class Management - quản lý danh sách task
public class Management {
    // ArrayList chứa danh sách các task
    // ArrayList: danh sách động, có thể thêm/xóa phần tử
    private ArrayList<Task> taskList;
    
    // Biến lưu ID của task cuối cùng
    private int lastID;
    
    // Constructor khởi tạo Management
    public Management() {
        taskList = new ArrayList<>(); // Khởi tạo ArrayList rỗng
        lastID = 0; // ID bắt đầu từ 0
    }
    
    // Method thêm task mới
    // throws Exception: method này có thể ném exception
    public int addTask(String requirementName, String assignee, String reviewer, 
                      String taskTypeID, String date, String planFrom, String planTo) throws Exception {
        try { // Bắt đầu try-catch
            // Chuyển String thành int
            int typeID = Integer.parseInt(taskTypeID);
            
            // Validate taskTypeID phải từ 1-4
            if (typeID < 1 || typeID > 4) {
                // Ném exception với message tùy chỉnh
                throw new Exception("Task Type ID must be between 1 and 4");
            }
            
            // Tạo SimpleDateFormat để parse date
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false); // Chế độ strict
            Date taskDate = sdf.parse(date); // Parse String thành Date
            
            // Chuyển planFrom và planTo từ String sang double
            double from = Double.parseDouble(planFrom);
            double to = Double.parseDouble(planTo);
            
            // Validate thời gian phải trong khoảng 8.0-17.5
            if (from < 8.0 || from > 17.5 || to < 8.0 || to > 17.5) {
                throw new Exception("Plan time must be between 8.0 and 17.5");
            }
            
            // Kiểm tra phần thập phân của from
            double fromDecimal = from - Math.floor(from);
            // Kiểm tra phần thập phân của to
            double toDecimal = to - Math.floor(to);
            
            // Phần thập phân phải là 0.0 hoặc 0.5
            if ((fromDecimal != 0.0 && fromDecimal != 0.5) || 
                (toDecimal != 0.0 && toDecimal != 0.5)) {
                throw new Exception("Plan time must be in format: 8.0, 8.5, 9.0, ..., 17.5");
            }
            
            // Validate from phải nhỏ hơn to
            if (from >= to) {
                throw new Exception("Plan From must be less than Plan To");
            }
            
            // Tăng lastID lên 1 để tạo ID mới
            lastID++;
            
            // Tạo object Task mới với các thông tin đã validate
            Task task = new Task(lastID, typeID, requirementName, taskDate, 
                               from, to, assignee, reviewer);
            
            // Thêm task vào ArrayList
            taskList.add(task);
            
            // Trả về ID của task vừa thêm
            return lastID;
            
        } catch (NumberFormatException e) { // Bắt lỗi parse number
            // Ném exception mới với message chi tiết hơn
            throw new Exception("Invalid number format: " + e.getMessage());
        } catch (NullPointerException e) { // Bắt lỗi null
            throw new Exception("Input cannot be null: " + e.getMessage());
        }
    }
    
    // Method xóa task theo ID
    public void deleteTask(String id) throws Exception {
        try {
            // Chuyển String ID thành int
            int taskID = Integer.parseInt(id);
            
            // Biến lưu task cần xóa
            Task taskToDelete = null;
            
            // Duyệt qua từng task trong taskList
            for (Task task : taskList) { // Enhanced for loop
                // Kiểm tra ID có khớp không
                if (task.getId() == taskID) {
                    taskToDelete = task; // Lưu task cần xóa
                    break; // Thoát vòng lặp vì đã tìm thấy
                }
            }
            
            // Nếu không tìm thấy task
            if (taskToDelete == null) {
                throw new Exception("Task ID does not exist");
            }
            
            // Xóa task khỏi ArrayList
            taskList.remove(taskToDelete);
            
        } catch (NumberFormatException e) { // Bắt lỗi parse ID
            throw new Exception("Invalid ID format");
        } catch (NullPointerException e) { // Bắt lỗi null
            throw new Exception("ID cannot be null");
        }
    }
    
    // Method lấy danh sách task đã sắp xếp
    public ArrayList<Task> getDataTasks() {
        // Sort taskList theo ID tăng dần
        Collections.sort(taskList, new Comparator<Task>() {
            // Override method compare để định nghĩa cách so sánh
            @Override
            public int compare(Task t1, Task t2) {
                // So sánh ID của 2 task
                // Trả về: âm nếu t1 < t2, 0 nếu bằng, dương nếu t1 > t2
                return Integer.compare(t1.getId(), t2.getId());
            }
        });
        
        // Trả về danh sách đã sort
        return taskList;
    }
    
    // Method kiểm tra taskList có rỗng không
    public boolean isEmpty() {
        return taskList.isEmpty(); // Trả về true nếu rỗng, false nếu có task
    }
}