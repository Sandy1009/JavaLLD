package AdapterDesignPattern;

import AdapterDesignPattern.thirdParty.AxisBankApi;

public class AxisBankAdapter implements BankApi {

    AxisBankApi axisBankApi;

    public AxisBankAdapter() {
        axisBankApi = new AxisBankApi();
    }

    @Override
    public double checkBalance(String upiId, int pin) {
        return axisBankApi.getBalance(upiId, pin);
    }

    @Override
    public void createBankAccount(String bankAccountNumber, String debitCardDetails, int otp, int pin) throws Exception {
        axisBankApi.addNewAccount(bankAccountNumber, debitCardDetails, otp, pin);
    }

    @Override
    public int makePayment(String fromUpiId, String toUpiId, double amt, int pin) {
        char ch =  axisBankApi.transferPayment(fromUpiId, toUpiId, amt, pin);

        if(ch == 'Y') return 1;
        else if(ch == 'I') return 3;   //Inprogress case
        else return 2;      // failure case - ch == 'F'
    }

}
