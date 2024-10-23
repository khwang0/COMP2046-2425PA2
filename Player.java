import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class represents a player in the ModernArt game
 * 
 * You are not allowed to add any new field to this class
 * You are not allowed to add any new public method to this class
 */
public class Player {
    /**
     * The name of the player
     * 
     * The first player should have the name "Player 0"
     * The second player should have the name "Player 1"
     * The third player should have the name "Player 2"
     * ...
     */
    private final String name;
    /**
     * The money the player has
     */
    private int money;
    /**
     * The total number of players in the game
     */
    private static int totalPlayers = 0;
    /**
     * The paintings the player has in hand
     */
    private List<Painting> handPaintings = new ArrayList<>();
    /**
     * The paintings the player has bought
     */
    private List<Painting> boughtPaintings = new ArrayList<>();
    /**
     * Constructor of the Player class
     */
    public Player(int money) {
        //TODO
    }
    /**
     * To deal a painting to the player
     */
    public void dealPaintings(Painting painting) {
        //TODO
    }
    /**
     * Get the name of the player
     */
    public String getName() {
        //TODO
    }
    /**
     * To let the player to put up a painting for auction
     * After this method, the painting should be removed from handPaintings
     * 
     * Validation of user's input should be done in this method,
     * such as checking if the index is valid. If it is invalid,
     * the player will need to enter the index again.
     */
    public Painting playPainting() {
        //TODO
    }
    /**
     * Get the money the player has
     */
    public int getMoney() {
        return money;
    }
    /**
     * To let the player to bid. 
     * 
     * In some auctions, e.g. open auction, the player knows the current bid.
     * In this case the currentBid will be passed to the method.
     * 
     * In some auctions, e.g. blind auction, the player does not know the current bid.
     * In this case, the currentBid passed to the method will be 0.
     * 
     * A human player should be asked to input the bid amount.
     * The bid amount should be less than or equal to the money the player has.
     * If the bid amount is too high, the player should be asked to input again.
     * 
     * If the bid amount is too small (less than the current bid or less than 1),
     * the bid amount will also be returned, which may means to pass the bid.
     * 
     * You should not assume there is only open auction when writing this method
     */
    public int bid(int currentBid) {
        //TODO
    }
    /**
     * To let the player to pay
     */
    public void pay(int amount) {
        //TODO
    }
    /**
     * To let the player to earn
     */
    public void earn(int amount) {
        //TODO
    }
    /**
     * toString method that you need to override
     */
    public String toString() {
        //TODO
    }
    /**
     * To finalize a bid and purchase a painting
     * 
     * This method has been finished for you
     */
    public void buyPainting(Painting Painting) {
        boughtPaintings.add(Painting);
    }
    /**
     * To sell all the paintings the player has bought to the bank 
     * after each round
     */    
    public void sellPainting(int[] scores) {
        //TODO
    }
}
