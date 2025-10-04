package controller; // Package controller - chứa logic xử lý

import java.text.ParseException; // Exception khi parse date bị lỗi
import java.text.SimpleDateFormat; // Class format date
import java.util.Date; // Class Date
import java.util.Scanner; // Class đọc input từ bàn phím

// Class Validation - xử lý validate và nhập dữ liệu từ user
public class Validation {
    // Biến static Scanner - dùng chung cho toàn class
    // static: thuộc về class, không thuộc về object
    private static Scanner sc = new Scanner(System.in); // Khởi tạo Scanner đọc từ System.in (bàn phím)
    
    // Method nhập số nguyên có giới hạn min-max
    // static: gọi trực tiếp qua tên class, không cần tạo object
    public static int getInt(String msg, int min, int max) {
        while (true) { // Vòng lặp vô hạn cho đến khi nhập đúng
            try { // Bắt đầu khối try-catch để bắt exception
                System.out.print(msg); // In thông báo nhắc nhập
                String input = sc.nextLine().trim(); // Đọc 1 dòng, trim() xóa khoảng trắng 2 đầu
                
                // Kiểm tra input có rỗng không
                if (input.isEmpty()) {
                    throw new NumberFormatException(); // Ném exception nếu rỗng
                }
                
                // Chuyển String thành int
                // Nếu không phải số sẽ tự động ném NumberFormatException
                int result = Integer.parseInt(input);
                
                // Kiểm tra số có nằm trong khoảng min-max không
                if (result < min || result > max) {
                    System.out.println("Please enter a number between " + min + " and " + max);
                    continue; // Quay lại đầu vòng lặp, nhập lại
                }
                
                return result; // Trả về kết quả nếu hợp lệ
            } catch (NumberFormatException e) { // Bắt exception khi parse số bị lỗi
                System.out.println("Invalid input. Please enter a valid integer.");
                // Không return, vòng lặp tiếp tục để nhập lại
            }
        }
    }
    
    // Method nhập chuỗi không được rỗng
    public static String getString(String msg) {
        while (true) { // Vòng lặp cho đến khi nhập đúng
            try {
                System.out.print(msg); // In thông báo
                String input = sc.nextLine().trim(); // Đọc và xóa khoảng trắng
                
                // Kiểm tra chuỗi rỗng
                if (input.isEmpty()) {
                    throw new NullPointerException(); // Ném exception nếu rỗng
                }
                
                return input; // Trả về chuỗi nếu không rỗng
            } catch (NullPointerException e) { // Bắt NullPointerException
                System.out.println("Input cannot be empty. Please try again.");
            }
        }
    }
    
    // Method nhập ngày theo format dd-MM-yyyy
    public static Date getDate(String msg) {
        // Tạo SimpleDateFormat với format dd-MM-yyyy
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        // setLenient(false): chế độ strict - không cho phép ngày không hợp lệ
        // VD: 32-01-2024 sẽ bị lỗi thay vì tự động chuyển sang 01-02-2024
        sdf.setLenient(false);
        
        while (true) { // Vòng lặp nhập đến khi đúng
            try {
                System.out.print(msg); // In thông báo
                String input = sc.nextLine().trim(); // Đọc input
                
                if (input.isEmpty()) { // Kiểm tra rỗng
                    throw new NullPointerException();
                }
                
                // Parse chuỗi thành Date
                // Nếu format sai sẽ tự động ném ParseException
                return sdf.parse(input);
            } catch (ParseException e) { // Bắt exception khi parse date lỗi
                System.out.println("Invalid date format. Please use dd-MM-yyyy format.");
            } catch (NullPointerException e) { // Bắt exception khi input rỗng
                System.out.println("Date cannot be empty. Please try again.");
            }
        }
    }
    
    // Method nhập thời gian (8.0 -> 17.5 với bước 0.5)
    public static double getTime(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                String input = sc.nextLine().trim();
                
                if (input.isEmpty()) {
                    throw new NullPointerException();
                }
                
                // Parse chuỗi thành double
                // Nếu không phải số sẽ ném NumberFormatException
                double time = Double.parseDouble(input);
                
                // Kiểm tra thời gian có trong khoảng 8.0-17.5 không
                if (time < 8.0 || time > 17.5) {
                    System.out.println("Time must be between 8.0 and 17.5");
                    continue; // Nhập lại
                }
                
                // Tách phần thập phân: VD 9.5 -> 0.5
                double decimal = time - Math.floor(time);
                // Math.floor(9.5) = 9.0, nên decimal = 9.5 - 9.0 = 0.5
                
                // Kiểm tra phần thập phân phải là 0.0 hoặc 0.5
                if (decimal != 0.0 && decimal != 0.5) {
                    System.out.println("Time must be in format: 8.0, 8.5, 9.0, 9.5, ... 17.5");
                    continue; // Nhập lại
                }
                
                return time; // Trả về thời gian hợp lệ
            } catch (NumberFormatException e) {
                System.out.println("Invalid time format. Please enter a valid number.");
            } catch (NullPointerException e) {
                System.out.println("Time cannot be empty. Please try again.");
            }
        }
    }
    
    // Method nhập Task Type ID (1-4)
    // Gọi lại method getInt với min=1, max=4
    public static int getTaskTypeID(String msg) {
        return getInt(msg, 1, 4);
    }
}