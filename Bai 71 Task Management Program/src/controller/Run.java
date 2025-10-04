package controller;

import view.Display; // Import class Display

// Class Run - Điều khiển luồng chương trình chính
public class Run {
    // Thuộc tính handler - xử lý các chức năng
    private Handler handler;
    // Thuộc tính display - hiển thị giao diện
    private Display display;
    
    // Constructor khởi tạo Run
    public Run() {
        handler = new Handler(); // Tạo object Handler
        display = new Display(); // Tạo object Display
    }
    
    // Method bắt đầu chạy chương trình
    public void start() {
        // Vòng lặp vô hạn - chương trình chạy liên tục cho đến khi user chọn exit
        while (true) {
            // Hiển thị menu
            display.showMenu();
            
            // Nhập lựa chọn từ user (1-4)
            int choice = Validation.getInt("Your choice: ", 1, 4);
            
            // Xử lý lựa chọn bằng handler
            handler.handleChoice(choice);
            
            // Nếu không phải chọn exit (4) thì xuống dòng cho đẹp
            if (choice != 4) {
                System.out.println(); // In dòng trống
            }
            // Nếu choice = 4, chương trình sẽ exit ở trong handleChoice
            // nên không chạy đến đây
        }
    }
}