package payment;
import java.util.Random;
public abstract class AbstractPayment implements Payment {
    public double amount;
    public AbstractPayment(double amount) {
        this.amount = amount;
    }
    public final boolean verifyPayment() {
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
    
    private boolean isVerified() {
        Random rand = new Random();
        return rand.nextInt(100) < 70;
    }
}
