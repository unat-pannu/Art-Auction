import ArtAuction.Auction;
import java.util.Scanner;
public class AuctionMain {
    public static void main(String[] args) {
        System.out.println("\n-------------------Art Auctioneering Management System----------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter starting amount for auction: ");
        int amount=scanner.nextInt();
        Auction auction = new Auction(amount);
        boolean exit = false;
        boolean auctionStarted = false;
        while (!exit) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Bidder");
            System.out.println("2. Start Auction");
            System.out.println("3. Show Auction Log");
            System.out.println("4. Reset Auction");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();  
            switch (choice) {
                case 1:
                    System.out.print("Enter bidder name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter maximum bid: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Maximum bid must be an integer.");
                        scanner.next(); 
                        break;
                    }
                    int maxBid = scanner.nextInt();
                    System.out.print("Enter minimum increment: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Minimum increment must be an integer.");
                        scanner.next();  
                        break;
                    }
                    int minIncrement = scanner.nextInt();
                    scanner.nextLine();  
                    if (maxBid < 5000) {
                        System.out.println("Error: Maximum bid must be at least the starting amount (5000). Please try again.");
                        break;
                    }
                    if (minIncrement <= 0) {
                        System.out.println("Error: Minimum increment must be greater than zero. Please try again.");
                        break;
                    }
                    auction.addBidder(name, maxBid, minIncrement);
                    System.out.println(name + " has been added as a bidder.");
                    break;
                    case 2:
                    if (auctionStarted) {
                        System.out.println("Auction has already been started. Reset it to start again.");
                    } else {
                        auction.startAuction();
                        System.out.println("Auction completed.");
                        auctionStarted = true;
                    }
                    break;
                case 3:
                    auction.showAuctionLog();
                    break;
                case 4:
                    auction = new Auction(5000);
                    auctionStarted = false;
                    System.out.println("Auction has been reset. You can now add new bidders.");
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
