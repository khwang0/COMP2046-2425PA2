import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the ModernArt game and control the main logic of the game
 * 
 * You are not allowed to add any new field to this class
 * You are not allowed to add any new public method to this class
 */
public class ModernArt {

    /**
     * PRE_DEAL contains the number of paintings that should be dealt to each player before each round
     * 
     * So for example, PRE_DEAL[3] means for 3 players, the number of painting to be dealt to each player
     * before round 1 is 10, round 2 is 6, and round 3 is 6, and round 4 is 0
     */
    public static final int[][] PRE_DEAL = {null, null, null,  //game can't be played for 0, 1, 2 players
                                         {10,6,6,0}, {9,4,4,0}, {8,3,3,0}};
    /**
     * The game has 4 rounds in total, they are
     * 
     * Round 0, Round 1, Round 2, Round 3
     */
    public static final int ROUND = 4;
    /**
     * The initial money each player has is 100
     */
    public static final int INITIAL_MONEY = 100;
    /**
     * The number of paintings for each artist is fixed
     * "0. Manuel Carvalho" = 12 , 
     * "1. Sigrid Thaler" = 15, 
     * "2. Daniel Melim" = 15, 
     * "3. Ramon Martins" = 15, 
     * "4. Rafael Silveira" = 20
     */
    public static final int[] INITIAL_COUNT = {12,15,15,15,20};                             
    /**
     * The price of the most sold paintings is 30, 
     * the second most sold is 20, 
     * and the third most sold is 10
     * 
     * Tie-breaker: if two artists have the same number of painting sold
     * the one with the lower id will be the winner, i.e.,
     * 
     * If 0. Manuel Carvalho and 1. Sigrid Thaler have the same number of paintings sold
     * then 0. Manuel Carvalho will be considered have more paintings sold than 1. Sigrid Thaler
     * 
     */
    private static final int SCORES[] = {30, 20, 10};
    /**
     * Each round a painting can only be played for 5 times.
     * The 5th time the painting is played, it will not be placed in auction
     * and that round ends immediately
     */
    private static final int MAX_PAINTINGS = 5;
    /**
     * The number of players in the game, it should be between 3-5
     */
    private int noOfPlayers;
    /**
     * The array of players in the game
     */
    private Player[] players;
    /**
     * The deck of paintings
     */
    private List<Painting> deck = new ArrayList<>();
    /**
     * The score board of the game
     */
    private int[][] scoreboard = new int[ROUND][Painting.ARTIST_NAMES.length];

    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                int noOfPlayers = Integer.parseInt(args[0]);
                if (noOfPlayers < 3 || noOfPlayers > 5) {
                    throw new Exception();
                }
                new ModernArt(noOfPlayers).startgame();
            } catch (Exception e) {
                System.out.println("Invalid argument. Please enter a valid integer between 3-5.");
            }
        } else
            new ModernArt().startgame();
    }
    public ModernArt(int noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
        this.players = new Player[noOfPlayers];
        for (int i = 0; i < noOfPlayers; i++) {
            players[i] = new Player(INITIAL_MONEY);
        }
        prepareDeck();
    }

    /**
     * Default constructor, the game will be played with 3 players by default
     */
    public ModernArt() {
        //TODO
    }
    /**
     * Prepare the deck of paintings
     */
    public void prepareDeck() {
        //TODO
        
        shuffle(deck);
    }
    /**
     * Deal the paintings to the players. After this method,
     * each player should receive some number of new paintings in their hand
     * as specified in the PRE_DEAL array
     * 
     * The parameter round indicate which round the game is currently in
     */
    public void dealPainting(int round) {
        //TODO
    }

    /**
     * This method will update the score board after each round.
     * The score board updating rules please refer to the game description
     * 
     * The method also returns the price for each artist's painting in this round
     * 
     * The parameter round indicate which round the game is currently in
     * The parameter paintingCount indicates how many paintings each artist has sold in this round
     */
    public int[] updateScoreboard(int round, int[] paintingCount) {
        //TODO
    }
    /**
     * This is the main logic of the game and has been completed for you
     * You are not supposed to change this method
     */
    public void startgame() {
        int currentPlayer = 0;
        
        for (int round = 0; round < ROUND; round++) {
            //deal the paintings
            dealPainting(round);
            //start auction
            int[] paintingCount = new int[Painting.ARTIST_NAMES.length];
            while (true) {
                Player player = players[currentPlayer];
                Painting p = player.playPainting();
                if (++paintingCount[p.getArtistId()] == MAX_PAINTINGS)
                    break; //this round end immediately and the painting is not putting up for auction

                if (p != null) {
                    p.auction(players);
                }
                currentPlayer = (currentPlayer + 1) % noOfPlayers;
                System.out.println("The number of painting sold: ");
                for (int i = 0; i < Painting.ARTIST_NAMES.length; i++) {
                    System.out.println(Painting.ARTIST_NAMES[i] + " " + paintingCount[i]);
                }
            }
            System.out.println("Complete auction - sell paintings");
            //update score board
            int[] scoreForThisRound = updateScoreboard(round, paintingCount);
            System.out.println("Print the score board after auction");
            System.out.print("\t\t");
            for (int j = 0; j < Painting.ARTIST_NAMES.length; j++) {
                System.out.print( "\t" + j);
            }
            for (int i = 0; i < round + 1; i++) {
                System.out.print("\nRound " + i + ":\t\t");
                
                for (int j = 0; j < Painting.ARTIST_NAMES.length; j++) {
                    System.out.print(scoreboard[i][j] + "\t");
                }
            }
            
            System.out.println("\n\nPrint the price for each artist's painting");
            for (int i = 0; i < Painting.ARTIST_NAMES.length; i++) {
                System.out.println(Painting.ARTIST_NAMES[i] + " " + scoreForThisRound[i]);
            }



            //Sell the paintings
            for (Player p : players) {
                p.sellPainting(scoreForThisRound);
            }
        }
        System.out.println("Game over, score of each player");
        for (int i = 0; i < noOfPlayers; i++) {
            System.out.println(players[i]);
        }
    }
    /**
     * Shuffle the deck of paintings
     * 
     * This method is completed for you.
     */
    public void shuffle(List<Painting> deck) {
        for (int i = 0; i < deck.size(); i++) {
            int index = ThreadLocalRandom.current().nextInt(deck.size());
            Painting temp = deck.get(i);
            deck.set(i, deck.get(index));
            deck.set(index, temp);
        }
    }
    
    /**
     * This method is completed for you. We use this for grading purpose
     */
    public int[][] getScoreboard() {
        return scoreboard;
    }
}
