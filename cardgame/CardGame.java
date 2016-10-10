// Joseph Allen
package cardgame;

import static java.lang.Math.random;
import java.util.Random;

public class CardGame {

    CircularQueue player1 = new CircularQueue();
    CircularQueue player2 = new CircularQueue();
    ArrayList deck = new ArrayList();

    boolean first = true;   // If first player gets heads true, 2nd player gets heads false

    public static String[] deckOfCards = {
        "Ace of Spades ", "Two of Spades ", "Three of Spades ", "Four of Spades ", "Five of Spades ", "Six of Spades ", "Seven of Spades ", "Eight of Spades ", "Nine of Spades ", "Ten of Spades ", "Jack of Spades ", "Queen of Spades ", "King of Spades ",
        "Ace of Clovers ", "Two of Clovers ", "Three of Clovers ", "Four of Clovers ", "Five of Clovers ", "Six of Clovers ", "Seven of Clovers ", "Eight of Clovers ", "Nine of Clovers ", "Ten of Clovers ", "Jack of Clovers ", "Queen of Clovers ", "King of CLovers ",
        "Ace of Diamonds ", "Two of Diamonds ", "Three of Diamonds ", "Four of Diamonds ", "Five of Diamonds ",
        "Six of Diamonds ", "Seven of Diamonds ", "Eight of Diamonds ", "Nine of Diamonds ", "Ten of Diamonds ",
        "Jack of Diamonds ", "Queen of Diamonds ", "King of Diamonds ",
        "Ace of Hearts ", "Two of Hearts ", "Three of Hearts ", "Four of Hearts ", "Five of Hearts ", "Six of Hearts ", "Seven of Hearts ", "Eight of Hearts ", "Nine of Hearts ", "Ten of Hearts ", "Jack of Hearts ",
        "Queen of Hearts ", "King of Hearts "};

    public static boolean[] cardsUsed = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
    // generate random numbers (Randy)

    public void createHands() {
        int temp = 0;
        Random number = new Random();

        //Start loop
        while (player1.size() < 26 && (player2.size() < 26)) {

            do {
                temp = number.nextInt(52);
            } while (cardsUsed[temp] == true);

            player1.offer(temp);
            cardsUsed[temp] = true;

            do {
                temp = number.nextInt(52);
            } while (cardsUsed[temp] == true);

            player2.offer(temp);
            cardsUsed[temp] = true;

        }

    }

    public void playerStart() { // coin flip to determine who goes first
        System.out.println("Welcome to my Card Game" + "\n");
        System.out.println("Now lets play!!! ");
        Random random = new Random();
        int result = random.nextInt(2);
        if (result == 0) {
            System.out.println("You flipped Heads Player 1 goes first!");
            first = true;
        } else {
            System.out.println("You flipped Tails Player 2 goes first !");
            first = false;
        }

    }

    public void doTurn() {
        // Do turns until round is complete
        cardStack p1 = new cardStack();
        cardStack p2 = new cardStack();
        String matcher = "nothing";

        int Rounds = 1;
        boolean allCards = false;
        boolean leaveGame = false;

        if (first) {
            while (!leaveGame) {
                System.out.println("In round " + Rounds);
                //Simulate person putting card on table
                p1.push(player1.poll().toString());
                System.out.println("Player 1 drew: " + deckOfCards[Integer.parseInt(p1.peek().toString())]);
                if (!deckOfCards[Integer.parseInt(p1.peek().toString())].contains(matcher)) { //if card doesnt match suit, suit is recorded
                    if (deckOfCards[Integer.parseInt(p1.peek().toString())].contains("of Spades")) {
                        matcher = "of Spades";
                    } else if (deckOfCards[Integer.parseInt(p1.peek().toString())].contains("of Hearts")) {
                        matcher = "of Hearts";
                    } else if (deckOfCards[Integer.parseInt(p1.peek().toString())].contains("of Diamonds")) {
                        matcher = "of Diamonds";
                    } else if (deckOfCards[Integer.parseInt(p1.peek().toString())].contains("of Clovers")) {
                        matcher = "of Clovers";
                        //suit is set
                    }
                } else {
                    // Matcher is matched Player 1 wins round
                    System.out.println("Player 1 Collects");
                    while (!p2.isEmpty()) {
                        player1.offer(p2.pop());
                    }
                    while (!p1.isEmpty()) {
                        player1.offer(p1.pop());
                    }

                    matcher = "nothing";
                    if (player1.size() >= 52) {
                        allCards = true;
                    }
                }

                p2.push(player2.poll().toString());
                System.out.println("Player 2 drew: " + deckOfCards[Integer.parseInt(p2.peek().toString())]);
                if (!deckOfCards[Integer.parseInt(p2.peek().toString())].contains(matcher)) { //if p2 suit doesnt match, card gets recorded
                    if (deckOfCards[Integer.parseInt(p2.peek().toString())].contains("of Spades")) {
                        matcher = "of Spades";
                    } else if (deckOfCards[Integer.parseInt(p2.peek().toString())].contains("of Hearts")) {
                        matcher = "of Hearts";
                    } else if (deckOfCards[Integer.parseInt(p2.peek().toString())].contains("of Diamonds")) {
                        matcher = "of Diamonds";
                    } else if (deckOfCards[Integer.parseInt(p2.peek().toString())].contains("of Clovers")) {
                        matcher = "of Clovers";
                    }
                    Rounds++;
                } else {
                    // Matcher is matched Player 2 wins round
                    System.out.println("Player 2 Collects");
                    while (!p1.isEmpty()) {
                        player2.offer(p1.pop());
                    }
                    while (!p2.isEmpty()) {
                        player2.offer(p2.pop());
                    }
                    Rounds++;
                    matcher = "nothing";
                    if (player1.size() >= 52) {
                        allCards = true;
                    }
                }
                if (allCards || (Rounds > 10)) {
                    leaveGame = true;
                }
            }
        } else {
            while (!leaveGame) {

                System.out.println("In round " + Rounds);
                //////// player 2 goes first
                //Simulate person putting card on table
                p2.push(player2.poll().toString());
                System.out.println("Player 2 drew: " + deckOfCards[Integer.parseInt(p2.peek().toString())]);
                if (!deckOfCards[Integer.parseInt(p2.peek().toString())].contains(matcher)) {
                    if (deckOfCards[Integer.parseInt(p2.peek().toString())].contains("of Spades")) {
                        matcher = "of Spades";
                    } else if (deckOfCards[Integer.parseInt(p2.peek().toString())].contains("of Hearts")) {
                        matcher = "of Hearts";
                    } else if (deckOfCards[Integer.parseInt(p2.peek().toString())].contains("of Diamonds")) {
                        matcher = "of Diamonds";
                    } else if (deckOfCards[Integer.parseInt(p2.peek().toString())].contains("of Clovers")) {
                        matcher = "of Clovers";
                    }

                } else {
                    // Matcher is matched Player 2 wins round
                    System.out.println("Player 2 Collects");
                    while (!p1.isEmpty()) {
                        player2.offer(p1.pop());
                    }
                    while (!p2.isEmpty()) {
                        player2.offer(p2.pop());
                    }
                    //Rounds++;
                    matcher = "nothing";
                    if (player2.size() >= 52) {
                        allCards = true;
                    }
                }
                p1.push(player1.poll().toString());
                System.out.println("Player 1 drew: " + deckOfCards[Integer.parseInt(p1.peek().toString())]);
                if (!deckOfCards[Integer.parseInt(p1.peek().toString())].contains(matcher)) {
                    if (deckOfCards[Integer.parseInt(p1.peek().toString())].contains("of Spades")) {
                        matcher = "of Spades";
                    } else if (deckOfCards[Integer.parseInt(p1.peek().toString())].contains("of Hearts")) {
                        matcher = "of Hearts";
                    } else if (deckOfCards[Integer.parseInt(p1.peek().toString())].contains("of Diamonds")) {
                        matcher = "of Diamonds";
                    } else if (deckOfCards[Integer.parseInt(p1.peek().toString())].contains("of Clovers")) {
                        matcher = "of Clovers";
                    }
                    Rounds++;
                } else {
                    // Matcher is matched Player 1 wins round
                    System.out.println("Player 1 Collects");
                    while (!p1.isEmpty()) {
                        player1.offer(p1.pop());
                    }
                    while (!p2.isEmpty()) {
                        player1.offer(p2.pop());
                    }
                    Rounds++;
                    matcher = "nothing";
                    if (player1.size() >= 52) {
                        allCards = true;
                    }
                }
                if (allCards || (Rounds > 10)) {
                    leaveGame = true;
                }
            }

        }

    }

    public void endGame() {
        if (player1.size() > player2.size()) {
            System.out.println("Player 1 wins!");
        } else if (player1.size() == player2.size()) {
            System.out.println("It's a draw");
        } else {
            System.out.println("Player 2 wins!");
        }
    }

    public static void main(String[] args) {
        CardGame cg = new CardGame();
        cg.playerStart();
        cg.createHands();
        cg.doTurn();

        cg.player1.display();
        System.out.println("P1 Cards: " + cg.player1.size());
        cg.player2.display();
        System.out.println("P2 Cards: " + cg.player2.size());
        cg.endGame();

    }
}
