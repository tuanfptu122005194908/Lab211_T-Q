package controller;

import view.Display; // Import class Display từ package view
import java.util.Date; // Import Date

// Class Handler - xử lý logic cho từng chức năng menu
public class Handler {
    // Thuộc tính management - quản lý danh sách task
    private Management management;
    // Thuộc tính display - hiển thị giao diện
    private Display display;
    
    // Constructor khởi tạo Handler
    public Handler() {
        management = new Management(); // Tạo object Management
        display = new Display(); // Tạo object Display
    }
    
    // Method xử lý lựa chọn từ menu
    public void handleChoice(int choice) {
        // Switch-case để xử lý từng lựa chọn
        switch (choice) {
            case 1: // Nếu chọn 1
                addTask(); // Gọi method addTask
                break; // Thoát switch
            case 2: // Nếu chọn 2
                deleteTask(); // Gọi method deleteTask
                break;
            case 3: // Nếu chọn 3
                displayTasks(); // Gọi method displayTasks
                break;
            case 4: // Nếu chọn 4
                display.showMessage("Exiting program. Goodbye!"); // Hiển thị thông báo
                System.exit(0); // Thoát chương trình với code 0 (thành công)
                break;
            default: // Các trường hợp khác
                display.showMessage("Invalid choice!"); // Thông báo lỗi
        }
    }
    
    // Method xử lý thêm task
    private void addTask() {
        display.showAddTaskHeader(); // Hiển thị header "Add Task"
        
        try { // Bắt đầu try-catch để bắt exception
            // Nhập requirement name từ user
            String requirementName = Validation.getString("Requirement Name: ");
            
            // Nhập task type ID (1-4)
            int taskTypeID = Validation.getTaskTypeID("Task Type: ");
            
            // Nhập date
            Date date = Validation.getDate("Date: ");
            
            // Nhập thời gian bắt đầu
            double planFrom = Validation.getTime("From: ");
            
            // Nhập thời gian kết thúc
            double planTo = Validation.getTime("To: ");
            
            // Kiểm tra lại planFrom phải < planTo
            if (planFrom >= planTo) {
                display.showMessage("Error: Plan From must be less than Plan To");
                return; // Thoát method, không thêm task
            }
            
            // Nhập người thực hiện
            String assignee = Validation.getString("Assignee: ");
            
            // Nhập người review
            String reviewer = Validation.getString("Reviewer: ");
            
            // Tạo SimpleDateFormat để format date
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
            
            // Gọi method addTask của management để thêm task
            int id = management.addTask(
                requirementName,              // Tên requirement
                assignee,                     // Người thực hiện
                reviewer,                     // Người review
                String.valueOf(taskTypeID),   // Chuyển int thành String
                sdf.format(date),             // Format Date thành String
                String.valueOf(planFrom),     // Chuyển double thành String
                String.valueOf(planTo)        // Chuyển double thành String
            );
            
            // Hiển thị thông báo thành công với ID của task
            display.showMessage("Task added successfully with ID: " + id);
            
        } catch (Exception e) { // Bắt mọi exception
            // Hiển thị thông báo lỗi với message từ exception
            display.showMessage("Error: " + e.getMessage());
        }
    }
    
    // Method xử lý xóa task
    private void deleteTask() {
        display.showDeleteTaskHeader(); // Hiển thị header "Del Task"
        
        // Kiểm tra danh sách task có rỗng không
        if (management.isEmpty()) {
            display.showMessage("No tasks available to delete.");
            return; // Thoát method nếu không có task
        }
        
        try {
            // Nhập ID task cần xóa
            String id = Validation.getString("ID: ");
            
            // Gọi method deleteTask của management
            management.deleteTask(id);
            
            // Hiển thị thông báo thành công
            display.showMessage("Task deleted successfully!");
            
        } catch (Exception e) { // Bắt exception
            // Hiển thị thông báo lỗi
            display.showMessage("Error: " + e.getMessage());
        }
    }
    
    // Method xử lý hiển thị danh sách task
    private void displayTasks() {
        // Kiểm tra danh sách có rỗng không
        if (management.isEmpty()) {
            display.showMessage("No tasks available.");
            return; // Thoát nếu không có task
        }
        
        // Gọi method showTaskList của display
        // Truyền vào danh sách task từ management.getDataTasks()
        display.showTaskList(management.getDataTasks());
    }
}