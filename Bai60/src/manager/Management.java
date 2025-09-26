package manager;

import object.Person;
import object.Wallet;
import object.Bill;

public class Management {

    // chạy chương trình
    public void run() {
        System.out.println("======= Shopping program =======");
        int n = Validation.checkInput("input number of bill: ");

        int[] billValues = new int[n];
        for (int i = 0; i < n; i++) {
            billValues[i] = Validation.checkInput("input value of bill " + (i + 1) + ": ");
        }

        int w = Validation.checkInput("input value of wallet: ");

        // tạo đối tượng
        Bill bill = new Bill(billValues);
        Wallet wallet = new Wallet(w);
        Person p = new Person(wallet, bill);

        // tính tổng và kiểm tra
        int total = p.getBill().calcTotal();
        boolean canPay = p.getWallet().payMoney(total);

        // in kết quả
        System.out.println("this is total bill: " + total);
        if (canPay) {
            System.out.println("You can buy it.");
        } else {
            System.out.println("You can't buy it.");
        }
    }
}
