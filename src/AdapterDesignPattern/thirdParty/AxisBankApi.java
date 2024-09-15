package AdapterDesignPattern.thirdParty;

public class AxisBankApi {

    public double getBalance(String upiId, int pin){
        return 0;
    }

    public void addNewAccount(String bankAccountNumber, String debitCard, int otp, int pin){
            //if it fails, it will throw an exception
            //if it is success, it return nothing
    }

    public char transferPayment(String fromUpiId, String toUpiId, double amount, int pin){
        return 'Y';
    }

}
