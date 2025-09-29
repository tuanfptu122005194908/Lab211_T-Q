package manager;

import object.Person;
import object.Wallet;
import object.Bill;

public class Management {

    public void printResult(int total, boolean canPay) {
        // in kết quả
        System.out.println("this is total bill: " + total);
        if (canPay) {
            System.out.println("You can buy it.");
        } else {
            System.out.println("You can't buy it.");
        }
    }

    // tinh tong
    public int calc(Person p) {
        return p.getBill().calcTotal();
    }

    // kiem tra thanh toan
    public boolean check(Person p, int total) {
        return p.getWallet().payMoney(total);
    }

    // chạy chương trình
    public Person inputData() {
        int n = Validation.checkInput("input number of bill: ");

        int[] billValues = new int[n];
        for (int i = 0; i < n; i++) {
            billValues[i] = Validation.checkInput("input value of bill " + (i + 1) + ": ");
        }

        int w = Validation.checkInput("input value of wallet: ");

        // tạo đối tượng
        Bill bill = new Bill(billValues);
        Wallet wallet = new Wallet(w);
        return new Person(wallet, bill);

    }

    public void run() {
        System.out.println("======= Shopping program =======");

        Person p = inputData();

        int total = calc(p);
        
        boolean canPay = check(p, total);
        
        printResult(total, canPay);
    }
}
