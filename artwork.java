package Auction;
class artwork {
    public String title, medium, artist_name;
    protected int artwork_id, artist_id;
    double starting_price;
    boolean availability=true;
    artwork(int artwork_id, int artist_id, double starting_price, String title, String medium, String artist_name) {
        this.artist_id=artist_id;
        this.artist_name=artist_name;
        this.artwork_id=artwork_id;
        this.starting_price=starting_price;
        this.title=title;
        this.medium=medium;
    }
    void displayDetails() {
        System.out.println("Artwork ID: "+artwork_id);
        System.out.println("Title: "+title+"\nMedium: "+medium+"\nArtist: "+artist_name+"\nStarting Price: "+starting_price);
        System.out.println("-------------------------------");
    }
}