public class Customer {

    private int accountId;
    private String customerName;
    private double balance;

    public Customer(int accountId,
                    String customerName,
                    double balance) {

        this.accountId = accountId;
        this.customerName = customerName;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBalance() {
        return balance;
    }
}