package AdapterDesignPattern;

import AdapterDesignPattern.thirdParty.YesBankApi;

public class YesBankAdapter implements BankApi {

    private YesBankApi yesBankApi;

    public YesBankAdapter() {
        this.yesBankApi = new YesBankApi();
    }

    @Override
    public double checkBalance(String upiId, int pin) {
        String balance = yesBankApi.checkBalance(upiId, String.valueOf(pin));
        return Double.parseDouble(balance);
    }

    @Override
    public void createBankAccount(String bankAccountNumber, String debitCardDetails, int otp, int pin) throws Exception {
        int status = yesBankApi.addBankAccount(String.valueOf(pin), otp, bankAccountNumber);

        if(status == 2) {
            throw new Exception("failed while adding the bank account");
        }
    }

    @Override
    public int makePayment(String fromUpiId, String toUpiId, double amt, int pin) {
        return yesBankApi.makeTransfer(amt, pin, fromUpiId, toUpiId);
    }
}
