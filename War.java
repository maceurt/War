
import java.util.Random;
import java.util.ArrayList;

class War {

  private ArrayList<Integer> deck_player1 = new ArrayList<Integer>();
  private ArrayList<Integer> deck_player2 = new ArrayList<Integer>();

  private Card ref_deck = new Card();

  public War() {
    this.restart_decks();
  }

  //!-------------------------------------------------------------------------------------------------!
  //!-----------------------------------------PRIVATE METHODS-----------------------------------------!
  //!-------------------------------------------------------------------------------------------------!

  private int get_random_from(ArrayList<Integer> arr) {
    Random rn_gen = new Random();
    return arr.remove(rn_gen.nextInt(arr.size()));
  }

  private void add_into(ArrayList<Integer> g, int deck_num) {
    for (int i = 0; i < g.size(); i++) {
      if (deck_num == 1) { this.deck_player1.add(g.get(i)); }
      else               { this.deck_player2.add(g.get(i)); }
    }
  }

  private void restart_decks() {


    ArrayList<Integer> clean_deck = new ArrayList<Integer>();

    for (int i = 1; i < 53; i++) { clean_deck.add(i); }

    for (int i = 0; i < 52; i++) {
      int ctt = this.get_random_from(clean_deck);

      if (i % 2 == 0) { this.deck_player1.add(ctt); }
      else            { this.deck_player2.add(ctt); }

    }
  }


  //!-------------------------------------------------------------------------------------------------!
  //!-----------------------------------------Public Methods------------------------------------------!
  //!-------------------------------------------------------------------------------------------------!

  public int play_next_move() {
    ArrayList<Integer> card_pool = new ArrayList<Integer>();
    int val_1 = 0; int val_2 = 0;

    //checks for equals.
    while ( this.deck_player1.size() > 0 && this.deck_player2.size() > 0 &&
            (ref_deck.vc(val_1 = this.get_random_from(this.deck_player1)) ==
            ref_deck.vc(val_2 = this.get_random_from(this.deck_player2)))
          ) {
      card_pool.add(val_1); card_pool.add(val_2);
      System.out.println(ref_deck.nc(val_1) + " [.VS.] " + ref_deck.nc(val_2));
      System.out.printf("   TIEBREAKER -> ");
    }
    System.out.println(ref_deck.nc(val_1) + " [.VS.] " + ref_deck.nc(val_2));
    card_pool.add(val_1); card_pool.add(val_2);

    if (this.deck_player1.size() == 0 || val_2 > val_1)      {  this.add_into(card_pool, 2); return 2;  }
    else                                                     {  this.add_into(card_pool, 1); return 1;  }
  }

  public ArrayList<Integer> get_deck(int deck_num) {
    if (deck_num == 1) { return deck_player1; }
    else                 { return deck_player2; }
  }

  public void print_deck_sizes(String name_1, String name_2) {
    System.out.println(name_1 + " you have " + String.valueOf(this.deck_player1.size()) + " cards in your deck.");
    System.out.println(name_2 + " you have " + String.valueOf(this.deck_player2.size()) + " cards in your deck.");
  }

  public void print_deck(String name_1, String name_2) {
    System.out.println();
    System.out.println(name_1 + "'s Hand");
    for (int i = 0; i < this.deck_player1.size(); i++) {
      System.out.print(" ");
      System.out.print(this.ref_deck.nc(this.deck_player1.get(i)));
    }

    System.out.println("\n");

    System.out.println(name_2 + "'s Hand");
    for (int i = 0; i < this.deck_player2.size(); i++) {
      System.out.print(" ");
      System.out.print(this.ref_deck.nc(this.deck_player2.get(i)));
    }
    System.out.println();
  }
}
