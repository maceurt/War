

import java.util.Scanner;
import java.lang.Thread;

public class Main {


  public static void real_sleep(long time) {
    try {
      Thread.sleep(time);
    } catch(InterruptedException e) {
      System.out.println("Interrupted");
    }
  }
  public static void main(String[] args) {
    War war_game = new War();
    boolean fast_roll = false;
    Scanner sc = new Scanner(System.in);
    String name_player = "";

    System.out.println("What is your name?");
    System.out.print("> ");

    while ((name_player = sc.nextLine()).length() <= 2) {
      System.out.println("Your name must be longer than 2 characters.");
      System.out.print("> ");
    }

    System.out.println("Auto fast roll? (Y/N)");
    System.out.print("> ");
    String ii = sc.nextLine();
    if (ii.contains("y") || ii.contains("Y")) {
      fast_roll = true;
    }

    while (war_game.get_deck(1).size() > 0 && war_game.get_deck(2).size() > 1) {

      war_game.print_deck_sizes(name_player, "Computer");

      if (!fast_roll) {
        real_sleep(2000);
        System.out.print("Press enter to play round...");
        sc.nextLine();
        System.out.println();
        real_sleep(1000);
      }

      if (war_game.play_next_move() == 1) {
        System.out.println("You won that round.");
      }
      
      else {
        System.out.println("You lost that round.");
      }

      if (!fast_roll) { real_sleep(2000); }
    }

    if (war_game.get_deck(1).size() < 0) {
      System.out.println("YOU LOST. Better luck next time.");
    }
    else {
      System.out.println("YOU WON. I guess the luck was on your side this time.");
    }
  }
}
