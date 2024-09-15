package AdapterDesignPattern;

public class Client {

    public static void main(String[] args) {
        AxisBankAdapter axisBankAdapter = new AxisBankAdapter();
        YesBankAdapter yesBankAdapter = new YesBankAdapter();

        PhonePe p1 = new PhonePe(axisBankAdapter);
        PhonePe p2 = new PhonePe(yesBankAdapter);
    }

}
