package object;

public class Person {

    private Wallet wallet;
    private Bill bill;

    public Person(Wallet wallet, Bill bill) {
        this.wallet = wallet;
        this.bill = bill;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public Bill getBill() {
        return bill;
    }
}
