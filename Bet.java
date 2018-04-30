import java.io.Console;
import java.util.Arrays;
import java.util.ArrayList;

public class Bet {
  public Bet() {
  }
  
  public static void FirstHand(int play, int player1, int playerbot, Bot bot, Console con, ArrayList d, int wager) {
    Bet _bet = new Bet();
    
    System.out.println("Welcome to blackjack! Starting the game...");
    
    // Dealing first hand
    play = bot.Generate(d);
    player1 += play;
    System.out.println("You now have a total of "+player1);
    play = bot.Generate(d);
    playerbot += play;
    System.out.println("The system now has a total of "+playerbot);
    _bet.Move(play, player1, playerbot, bot, con, d, wager);  
  }
  
  public static void Move(int play, int player1, int playerbot, Bot bot, Console con, ArrayList d, int wager) {
    
    // Waiting for first player move
    String move = con.readLine("Chose b/w [Hit, Stand, Surrender] \n");
    
    // Making sure something was correctly inputted
    if (move.length() == 0) {
      System.out.println("No input provided. Exiting the game...");
      System.exit(1);
    }
    
    // Analyzing the move
    switch(move.toLowerCase()) {
      case "stand":
        System.out.println("You chose to stand with your total of "+player1);
        bot.NextMove("player1", play, playerbot, player1, bot, con, wager);
        break;
      case "hit":
        wager += 10;
        System.out.println("You chose 'hit me'. Your total wager is now "+wager);
        play = bot.Generate(d);
        player1 += play;
        System.out.println("You now have a total of "+player1);
        bot.NextMove("player1", play, playerbot, player1, bot, con, wager);
        break;
      case "surrender":
        System.out.println("You chose to surrender, you lose.");
        System.exit(1);
      // I'm not entirely familiar with the following two moves, so I left them out, to be implemented later
      // case "double down":
      //   System.out.println("You chose to double down. You now have two wagers of $100.");
      //   break;
      // case "split":
      //   System.out.println("You chose to split");
      //   break;
    }
  }
}