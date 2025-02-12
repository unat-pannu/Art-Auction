package payment;
public interface Payment {
    void processPayment();
    void displayPaymentDetails();
    boolean verifyPayment(); 
    void setAmount(double amount);
}
