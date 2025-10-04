package model; // Khai báo package model - chứa các class dữ liệu

import java.text.SimpleDateFormat; // Import class để format ngày tháng
import java.util.Date; // Import class Date để xử lý ngày tháng

// Class Task đại diện cho 1 task trong hệ thống
public class Task {
    // Các thuộc tính private - đóng gói dữ liệu
    private int id; // ID của task (tự động tăng)
    private int taskTypeID; // Loại task: 1-Code, 2-Test, 3-Design, 4-Review
    private String requirementName; // Tên yêu cầu của task
    private Date date; // Ngày thực hiện task
    private double planFrom; // Thời gian bắt đầu (8.0 -> 17.5)
    private double planTo; // Thời gian kết thúc (8.0 -> 17.5)
    private String assignee; // Người được giao task
    private String reviewer; // Người review task
    
    // Constructor không tham số - tạo object rỗng
    public Task() {
    }
    
    // Constructor đầy đủ tham số - khởi tạo task với đầy đủ thông tin
    public Task(int id, int taskTypeID, String requirementName, Date date, 
                double planFrom, double planTo, String assignee, String reviewer) {
        this.id = id; // this.id là thuộc tính của class, id là tham số
        this.taskTypeID = taskTypeID; // Gán giá trị tham số cho thuộc tính
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    // Getter cho id - lấy giá trị id
    public int getId() {
        return id; // Trả về giá trị id
    }

    // Setter cho id - gán giá trị cho id
    public void setId(int id) {
        this.id = id; // Gán giá trị mới cho thuộc tính id
    }

    // Getter cho taskTypeID
    public int getTaskTypeID() {
        return taskTypeID;
    }

    // Setter cho taskTypeID
    public void setTaskTypeID(int taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    // Getter cho requirementName
    public String getRequirementName() {
        return requirementName;
    }

    // Setter cho requirementName
    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    // Getter cho date
    public Date getDate() {
        return date;
    }

    // Setter cho date
    public void setDate(Date date) {
        this.date = date;
    }

    // Getter cho planFrom
    public double getPlanFrom() {
        return planFrom;
    }

    // Setter cho planFrom
    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    // Getter cho planTo
    public double getPlanTo() {
        return planTo;
    }

    // Setter cho planTo
    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    // Getter cho assignee
    public String getAssignee() {
        return assignee;
    }

    // Setter cho assignee
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    // Getter cho reviewer
    public String getReviewer() {
        return reviewer;
    }

    // Setter cho reviewer
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
    
    // Method lấy tên task type dựa vào taskTypeID
    public String getTaskTypeName() {
        switch(taskTypeID) { // Kiểm tra giá trị taskTypeID
            case 1: return "Code"; // Nếu = 1, trả về "Code"
            case 2: return "Test"; // Nếu = 2, trả về "Test"
            case 3: return "Design"; // Nếu = 3, trả về "Design"
            case 4: return "Review"; // Nếu = 4, trả về "Review"
            default: return "Unknown"; // Các trường hợp khác trả về "Unknown"
        }
    }
    
    // Method chuyển date thành chuỗi theo format dd-MM-yyyy
    public String getDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // Tạo format dd-MM-yyyy
        return sdf.format(date); // Format date và trả về dạng String
    }
    
    // Override method toString để hiển thị task theo format yêu cầu
    @Override
    public String toString() {
        // String.format: định dạng chuỗi
        // %-6d: số nguyên, căn trái, rộng 6 ký tự
        // %-19s: chuỗi, căn trái, rộng 19 ký tự
        // %.1f: số thực, 1 chữ số thập phân
        return String.format("%-6d %-19s %-13s %-13s %-13.1f %-12s %s", 
                id,                    // ID
                requirementName,       // Tên requirement
                getTaskTypeName(),     // Tên loại task
                getDateString(),       // Ngày dạng string
                planFrom,              // Thời gian bắt đầu
                assignee,              // Người thực hiện
                reviewer);             // Người review
    }
}