/**
 * The Painting class represents a painting in the game.
 * A painting has an artist, an owner, a current bidder and a current bid.
 * 
 * Each painting has a type of auction. In this assignment, all paintings
 * have the same type of auction, which is "Open Auction".
 * 
 * You are not allowed to add any new field to this class
 * You are not allowed to add any new public method to this class
 */
public class Painting {
    /**
     * The artist ID of the painting, should be between 0 and 4.
     */
    private final int artist_id;
    /**
     * The type of auction of the painting
     */
    private final String TYPE = "Open Auction";
    /**
     * The owner of the painting.
     * 
     * When the painting is dealt to a player, the owner is set to that player.
     * When the painting is sold in the auction, the owner is set to the player 
     * that won the auction.
     * After the painting is sold to the bank after each round, the owner 
     * information is irrelevant and can be set as any value.
     * 
     */
    private Player owner;
    /**
     * The current bidder of the painting.
     */
    private Player currentBidder;
    /**
     * The current bid of the painting.
     */
    private int currentBid;
    /**
     * The names of the artists
     */
    public static final String[] ARTIST_NAMES = {"0. Manuel Carvalho", "1. Sigrid Thaler", "2. Daniel Melim", "3. Ramon Martins", "4. Rafael Silveira"};        

    /**
     * Constructor of the Painting class
     */
    public Painting(int artist_id) {
        //TODO
    }
    /**
     * Get the artist ID of the painting
     */
    public int getArtistId() {
        //TODO
    }
    /**
     * Setter of owner
     */
    public void setOwner(Player p) {
        //TODO
    }
    /**
     * Getter of owner
     */
    public Player getOwner() {
        //TODO
    }
    /**
     * Get the name of the artist
     */
    public String getArtistName() {
        //TODO
    }
    /**
     * Sold the painting to the current bidder
     * This method has been completed for you.
     * You should not modify this method.
     */
    public void sold() {
        System.out.print("Sold! - ");
        if (currentBidder == null || owner == currentBidder) {
            System.out.println(this.toString() + " is sold to " + owner.getName() + " for " + currentBid);
            //owner get the painting automatically
            owner.buyPainting(this);
            owner.pay(currentBid); //owner pay to the bank
        } else {
            System.out.println(this.toString() + " is sold to " + currentBidder.getName() + " for " + currentBid);
            //currentBidder get the painting
            currentBidder.buyPainting(this);
            currentBidder.pay(currentBid);
            //owner get the money
            owner.earn(currentBid);
            owner = currentBidder;
        }
        
    }
    /**
     * toString method to be modified
     */
    public String toString() {
        //TODO
    }
    /**
     * The auction method - open auction
     * 
     * In open auction, each player has a chance to bid for the painting.
     * If a player bids higher than the current bid, he becomes the current bidder.
     * We always start the auction with the first player in the players array.
     * When all other players have passed (either bidding 0 or bidding lower 
     * than the current bid), the painting is sold to the current bidder.
     * 
     * p.s. we model the auction in round-robin fashion although open auction 
     * allows player to bid at any time.
     * 
     */
    public void auction(Player[] players) {
        //TODO
    }
}
