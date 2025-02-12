import java.util.Scanner;
import payment.*;
public class PaymentSystem {
    private static Payment[] approvedPayments = new Payment[5];
    private static int paymentCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    static void makePayment() {
        if (paymentCount == 0) {
            System.out.println("No payment methods linked. Please add a payment method first.");
            return;
        }
        System.out.print("\nEnter the amount to pay: ₹");
        double amountToPay = scanner.nextDouble();  
        System.out.println("\nSelect Payment Method to Use for Payment:");
        for (int i = 0; i < paymentCount; i++) {
            System.out.println((i + 1) + ". " + (approvedPayments[i] instanceof CreditCard ? "Credit Card" : "Bank Account"));
        }
        System.out.print("Enter your choice: ");
        int selectedOption = scanner.nextInt();
        if (selectedOption > 0 && selectedOption <= paymentCount) {
            Payment selectedPayment = approvedPayments[selectedOption - 1];
            selectedPayment.setAmount(amountToPay);  
            selectedPayment.processPayment();
            boolean verified = selectedPayment.verifyPayment(); 
            if (verified) {
                selectedPayment.displayPaymentDetails();  
            }
        } else {
            System.out.println("Invalid choice! Payment canceled.");
        }
    }

    static void addPaymentOption() {
        boolean paymentMethodLinked = false;
        System.out.println("Link a Payment Method (₹2 for verification)");
        while (!paymentMethodLinked) {
            System.out.println("\nSelect Payment Method to Link:");
            System.out.println("1. Credit Card");
            System.out.println("2. Bank Transfer");
            System.out.print("Enter your choice (1-2): ");
            int choice = scanner.nextInt();
            Payment payment = null;
            switch (choice) {
                case 1:
                    System.out.print("Enter your credit card number: ");
                    String cardNumber = scanner.next();
                    payment = new CreditCard(cardNumber);
                    break;
                case 2:
                    System.out.print("Enter your bank account number: ");
                    String bankAccount = scanner.next();
                    payment = new BankTransfer(bankAccount);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    continue;
            }
            payment.setAmount(2);
            payment.processPayment();
            payment.verifyPayment();
            System.out.print("\nDid the ₹2 payment go through? (yes/no): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("yes")) {
                if (paymentCount < approvedPayments.length) {
                    approvedPayments[paymentCount++] = payment;
                    System.out.println("Payment method linked successfully.");
                    paymentMethodLinked = true;
                } else {
                    System.out.println("Cannot link more payment methods. Storage full.");
                }
            } else {
                System.out.println("Payment verification failed. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("-----------Art Auctioning Management System------------");
        System.out.println("Payment Gateway");
        boolean loop = true;
        while (loop) {
            System.out.println("\n1. Make Payment");
            System.out.println("2. Add a New Payment Method");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    makePayment();
                    break;
                case 2:
                    addPaymentOption();
                    break;
                case 3:
                    loop = false;
                    System.out.println("Exiting Payment System.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
        scanner.close();
    }
}
