package ArtAuction;
import java.util.*;
class Bidder {
    String name;
    int maxBid;
    int minIncrement;
    int currentBid;

    public Bidder(String name, int maxBid, int minIncrement) {
        this.name = name;
        this.maxBid = maxBid;
        this.minIncrement = minIncrement;
        this.currentBid = 0;
    }
}
public class Auction implements IAuction {
    private List<Bidder> bidders;
    private int startingAmount;
    private int currentBid;
    private Bidder lastBidder;
    private StringBuilder auctionLog;
    public Auction(int startingAmount) {
        this.startingAmount = startingAmount;
        this.currentBid = startingAmount;
        this.bidders = new ArrayList<>();
        this.lastBidder = null;
        this.auctionLog = new StringBuilder("Auction started at " + startingAmount + "\n");
    }
    public void addBidder(String name, int maxBid, int minIncrement) {
    if (maxBid < startingAmount) {
        System.out.println("Error: Maximum bid must be at least the starting amount (" + startingAmount + ").");
        return;
    }
    bidders.add(new Bidder(name, maxBid, minIncrement));
}

    public void startAuction() {
        if (bidders.isEmpty()) {
            auctionLog.append("No bidders available. Auction cannot start.\n");
            return;
        }
        bidders.removeIf(b -> b.maxBid < currentBid);
        if (bidders.isEmpty()) {
            auctionLog.append("No valid bidders. Auction cannot start.\n");
            return;
        }
        boolean biddingActive = true;
        while (biddingActive) {
            biddingActive = false;
            Iterator<Bidder> iterator = bidders.iterator();
            while (iterator.hasNext()) {
                Bidder bidder = iterator.next();
                if (bidder.currentBid + bidder.minIncrement > bidder.maxBid) {
                    auctionLog.append(bidder.name).append(" exits the auction.\n");
                    iterator.remove();
                }
            }
            if (bidders.size() == 1) {
                lastBidder = bidders.get(0);
                auctionLog.append("Winner: ").append(lastBidder.name).append(" at ").append(lastBidder.currentBid).append("\n");
                return;
            }
            for (Bidder bidder : bidders) {
                int newBid = currentBid + bidder.minIncrement;

                if (lastBidder != null && bidder.name.equals(lastBidder.name)) {
                    continue;
                }
                if (newBid <= bidder.maxBid) {
                    bidder.currentBid = newBid;
                    currentBid = newBid;
                    lastBidder = bidder;
                    auctionLog.append(bidder.name).append(" bids ").append(currentBid).append("\n");
                    biddingActive = true;
                }
            }
        }
        if (lastBidder != null) {
            auctionLog.append("Winner: ").append(lastBidder.name).append(" at ").append(lastBidder.currentBid).append("\n");
        }
    }
    public void showAuctionLog() {
        System.out.println(auctionLog.toString());
    }
}
