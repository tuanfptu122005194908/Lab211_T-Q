package object;

public class Wallet {

    private int amount;

    public Wallet(int amount) {
        this.amount = amount;
    }

    // kiểm tra có đủ tiền không
    public boolean payMoney(int total) {
        return amount >= total;
    }

    public int getAmount() {
        return amount;
    }
}
