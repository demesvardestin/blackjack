import java.io.Console;
import java.util.Arrays;
import java.util.ArrayList;

public class Deck {
  public Deck() {
    ArrayList<Element> arrayList = new ArrayList<Element>(Arrays.asList([1,2,3,4,5,6,7,8,9,10]));
  }
  
  public ArrayList Fill() {
    ArrayList<Integer> deck = new ArrayList<Integer>();
    int i = 1;
    do {
      deck.add(i);
      i += 1;
    } while(i < 11);
    return deck;
  }
}
