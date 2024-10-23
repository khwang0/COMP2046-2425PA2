import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


/**
* This file is used for testing your code. You can ignore the entire file during your development
* You can click the button next to TestClass to test your code.
*
* This is also how we are going to grade your work! Of course, there will be more test cases
*/

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestClass {
   private ByteArrayOutputStream out;
   private ByteArrayInputStream in;


   @BeforeEach
   public void setup() {
       out = new ByteArrayOutputStream();
       System.setOut(new PrintStream(out));
       Field f = null;
       try {
           f = Player.class.getDeclaredField("totalPlayers");
           f.setAccessible(true);
           f.set(null, 0);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }

   }

   @Order(1)
   @Test
   void testPlayer() {

        Player p1 = new Player(100);
        Player p2 = new Player(200);
        assertEquals("Player 0", p1.getName());
        assertEquals("Player 1", p2.getName());
   }

   @Order(2)
   @Test
   void testPlayer2() {
        Player p1 = new Player(100);
        Player p2 = new Player(200);
        assertEquals(100, p1.getMoney());
        assertEquals(200, p2.getMoney());
        p1.pay(50);
        p2.earn(40);
        assertEquals(50, p1.getMoney());
        assertEquals(240, p2.getMoney());
   }

   @Order(3)
   @Test
   void testPainting1() {
        Painting p = new Painting(0);
        assertEquals("0. Manuel Carvalho", p.getArtistName());
        assertEquals(0, p.getArtistId());
        assertEquals("0. Manuel Carvalho [Open Auction] owner: null", p.toString());
   }

   @Order(4)
   @Test
   void testPainting2() {
        Painting p = new Painting(0);
        Player p1 = new Player(100);
        p.setOwner(p1);
        assertEquals("0. Manuel Carvalho", p.getArtistName());
        assertEquals(0, p.getArtistId());
        assertEquals("0. Manuel Carvalho [Open Auction] owner: Player 0", p.toString());
   }

   @Order(5)
   @Test
   void testModernArt1() {
        ModernArt ma = new ModernArt(3);
        int[] soldpaintings = {2, 0, 1, 0, 5};
        int[] scores = ma.updateScoreboard(0, soldpaintings);
        assertTrue(Arrays.equals(new int[]{20, 0, 10, 0, 30}, scores));
   }

   @Order(6)
   @Test
   void testModernArt2() {
        ModernArt ma = new ModernArt(3);
        int[] soldpaintings = {2, 0, 2, 0, 5};
        int[] scores = ma.updateScoreboard(0, soldpaintings);
        assertTrue(Arrays.equals(new int[]{20, 0, 10, 0, 30}, scores));
   }




}


