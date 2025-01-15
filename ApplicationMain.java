import Auction.artwork;
import Auction.Bid;

public class ApplicationMain {
    public static void main(String[] args) {
        artwork art1 = new artwork(1, 101, 1500.0, "The Persistence of Memory", "Oil on Canvas", "Salvador Dalí");
        artwork art2 = new artwork(2, 102, 3000.0, "The Scream", "Tempera on Cardboard", "Edvard Munch");
        System.out.println("Available Artworks:");
        art1.displayDetails();
        art2.displayDetails();
        Bid bid1 = new Bid(1, 1, 201, 2000.0, "Manual", 500.0);
        Bid bid2 = new Bid(2, 2, 202, 3500.0, "Auto", 300.0);
        System.out.println("Validating Bids:");
        if (bid1.isValidBid(bid1.amount, art1.starting_price)) {
            System.out.println("Bid 1 is valid for Artwork 1.");
        } else {
            System.out.println("Bid 1 is not valid for Artwork 1.");
        }

        if (bid2.isValidBid(bid2.amount, art2.starting_price, bid2.min_increment)) {
            System.out.println("Bid 2 is valid for Artwork 2.");
        } else {
            System.out.println("Bid 2 is not valid for Artwork 2.");
        }
        System.out.println("Bid Details:");
        bid1.displayBidDetails();
        bid2.displayBidDetails();
        System.out.println("Comparing Bids:");
        if (bid1.isHigherBid(bid2)) {
            System.out.println("Bid 1 is higher than Bid 2.");
        } else {
            System.out.println("Bid 2 is higher than Bid 1.");
        }
    }
}
