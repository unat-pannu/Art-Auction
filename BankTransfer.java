package payment;
import java.util.Random;
public class BankTransfer implements Payment {
    private double amount;
    private String bankAccount;

    public BankTransfer(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing bank transfer payment of ₹" + amount);
        System.out.println("Bank Account: " + bankAccount);
    }

    @Override
    public void displayPaymentDetails() {
        System.out.println("Paid via Bank Transfer: " + bankAccount);
    }

    @Override
    public boolean verifyPayment() {
        int retryCount = 0;
        while (retryCount < 3) {
            if (isVerified()) {
                System.out.println("Payment of ₹" + amount + " has been successfully verified.");
                return true;
            } else {
                retryCount++;
                System.out.println("Payment verification failed. Attempt " + retryCount + " of 3. \nRetrying Payment: ");
            }
        }
        System.out.println("Payment verification failed after 3 attempts. Please try again later.");
        return false;
    }

    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }

    private boolean isVerified() {
        Random rand = new Random();
        return rand.nextInt(100) < 70;
    }
}

