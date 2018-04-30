import java.io.Console;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    int player1 = 0;
    int playerbot = 0;
    int play = 0;
    int wager = 100;
    
    Console con = System.console();
    Bot bot = new Bot();
    Bet bet = new Bet();
    Deck d = new Deck();
    ArrayList deck = d.Fill();
    
    if (con == null) {
      System.exit(1);
    }
    
    bet.FirstHand(play, player1, playerbot, bot, con, deck, wager);
    
  }
}