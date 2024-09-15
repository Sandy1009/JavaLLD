package AdapterDesignPattern;

public class PhonePe {

    BankApi bankApi;

    public PhonePe(BankApi b) {
        this.bankApi = b;
    }

    public void checkBalance() {
        double amount = bankApi.checkBalance("UPI Id", 1323);
        System.out.println("Your balance is "+amount);
    }

}
