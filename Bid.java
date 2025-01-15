package Auction;
class Bid {
    int bid_id, artwork_id, bidder_id;
    double amount, min_increment;
    String bid_type;
    public Bid() {
        bid_id=0;
        artwork_id=0;
        bidder_id=0;
        amount=0;
        min_increment=0;
        bid_type="Manual";
    }
    public Bid(int bid_id, int artwork_id, int bidder_id, double amount, String bid_type, double min_increment) {
        this.bid_id=bid_id;
        this.artwork_id=artwork_id;
        this.bidder_id=bidder_id;
        this.amount=amount;
        this.bid_type=bid_type;
        this.min_increment=min_increment;
    }
    public boolean isValidBid(double amount, double starting_price) {
        return amount>starting_price;
    }
    public boolean isValidBid(double amount, double starting_price, double min_increment) {
        return (amount>starting_price&&amount-starting_price>=min_increment);
    }
    public void displayBidDetails() {
        System.out.println("Bid ID: "+bid_id+"\nArtwork ID: "+artwork_id+"\nBidder ID: "+bidder_id+"\nBid Amount: "+amount+"\nBid Type: "+bid_type);
        System.out.println("------------------------------");
    }
    public boolean isHigherBid(Bid otherBid) {
        return this.amount>otherBid.amount;
    }
}
