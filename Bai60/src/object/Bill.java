package object;

public class Bill {

    private int[] bills;

    public Bill(int[] bills) {
        this.bills = bills;
    }

    // tính tổng tiền hóa đơn
    public int calcTotal() {
        int sum = 0;
        for (int b : bills) {
            sum += b;
        }
        return sum;
    }

    public int[] getBills() {
        return bills;
    }

}
