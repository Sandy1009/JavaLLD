package AdapterDesignPattern;

public interface BankApi {

    double checkBalance(String upiId, int pin);
    void createBankAccount(String bankAccountNumber, String debitCardDetails, int otp, int pin) throws Exception;
    int makePayment(String fromUpiId, String toUpiId, double amt, int pin);

}
