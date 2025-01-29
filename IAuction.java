package ArtAuction;

public interface IAuction {
    void addBidder(String name, int maxBid, int minIncrement);
    void startAuction();
    void showAuctionLog();
}
