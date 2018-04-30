import java.io.Console;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public class Bot {
  public Bot() {
    
  }
  
  public int Generate(ArrayList d) {
    int value = new Random().nextInt(d.size());
    return value;
  }
  
  public static void NextMove(String lastPlayer, int play, int playerbot, int player1, Bot bot, Console con, int wager) {
    // set instance variables
    Deck deck_ = new Deck();
    Bet bet_ = new Bet();
    
    if (player1 > 21 || playerbot == 21) {
      System.out.println("You lose against the system, for a total of "+wager);
      System.exit(1);
    }
    if (playerbot > 21 || (player1 > playerbot && playerbot > 17)) {
      System.out.println("You win against the system, for a total of "+wager);
      System.exit(1);
    }
    if (lastPlayer == "player1") {
      play = bot.Generate(deck_.Fill());
      if (playerbot < 17) {
        playerbot += play;
      }
    }
    System.out.println("The system now has a total of "+playerbot);
    bet_.Move(play, player1, playerbot, bot, con, deck_.Fill(), wager);
  }
}