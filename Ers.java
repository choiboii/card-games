import java.lang.Math;
import java.util.*;

public class Ers{
    public static int random(int min, int max){
        int range = max - min;
        return (int)(Math.random() * range) + min;
    }

    public static void createDeck(Card[] deck){
        for(int i = 0; i < 52; i++){
            String suit = "";
            if(i/13 == 0){
                suit = "Heart";
            }
            else if(i/13 == 1){
                suit = "Diamond";
            }
            else if(i/13 == 2){
                suit = "Spade";
            }
            else if(i/13 == 3){
                suit = "Club";
            }
            deck[i] = new Card(suit, (i % 13) + 1);
        }
    }

    public static void shuffle(Card[] deck){
        //implements efficient version of Fisher-Yates shuffle algorithm
        //O(n) runtime, O(1) space
        for(int i = 0; i < deck.length - 1; i++){
            int j = random(i, deck.length-1);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    public static void main(String args[]){
        Card[] deck = new Card[52];
        createDeck(deck);

        shuffle(deck);

        //for(int i = 0; i < deck.length; i++){
        //     if(i != 0 && i % 13 == 0){
        //         System.out.println();
        //     }
        //     System.out.print(deck[i].toString() + " ");
        // }
        // System.out.println();

        Scanner scan = new Scanner(System.in);
        //System.out.print("How many players? (1-2)");
        //int numPlayers = scan.nextInt();

        //System.out.print("Which game would you like to play? (War/Blackjack/ERS): ");
        //String game = scan.next().toLowerCase(); //use for later; for now, implement war

        // System.out.print("Name for player 1: ");
        // String name = scan.next();
        Player player1 = new Player("Andrew");

        // System.out.print("Name for player 2: ");
        // name = scan.next();
        Player player2 = new Player("Rachel");

        for(int i = 0; i < deck.length; i++){
            if(i % 2 == 0){
                player1.hand.add(deck[i]);
            }
            else{
                player2.hand.add(deck[i]);
            }
        }

        //quick check of decks
        //System.out.println(player1.toString());
        //System.out.println(player2.toString());

        //System.out.print("Start game? (Y/N)");
        // String confirm = scan.next().toLowerCase();

        // if(confirm.equals("n")){
        //     System.exit(1);
        // }

        scan.close();
        //begin the games

        /*
         * War: 
         * Two players place down their top card, and whose card has a larger value wins the pile
         * In the case of a tie, both players will burn one card (if possible) and place their next 
         * card, and whoever wins this duel wins the pile. In the case of another tie, this continues 
         * until one player eventually wins. If a player does not have enuogh cards to play the tie
         * (number of cards is less than three in the case of a tie), the player with more cards
         * automatically wins the game. Whoever wins the entire deck wins the game.
         */
        while(player1.hand.size() > 0 && player2.hand.size() > 0){
            ArrayList<Card> pile = new ArrayList<Card>();
            Card card1 = player1.hand.remove(0); //pop() method
            Card card2 = player2.hand.remove(0);
            pile.add(card1);
            pile.add(card2);

            System.out.println(card1 + " VS " + card2);
            int winner = 0;
            //while winner of this bout is not yet decided:
            while(winner == 0){
                if(card1.value > card2.value){
                    winner = 1;
                }
                else if(card2.value > card1.value){
                    winner = 2;
                }
                else{ //in case of a tie
                    if(player1.hand.size() < 3){
                        winner = 2;
                        for(Card card : player1.hand){
                            pile.add(card);
                            player1.hand.remove(0);
                        }
                    }
                    else if(player2.hand.size() < 3){
                        winner = 1;
                        for(Card card : player2.hand){
                            pile.add(card);
                            player2.hand.remove(0);
                        }
                    }
                    else{
                        Card burn11 = player1.hand.remove(0);
                        Card burn12 = player1.hand.remove(0);
                        card1 = player1.hand.remove(0);
                        Card burn21 = player2.hand.remove(0);
                        Card burn22 = player2.hand.remove(0);
                        card2 = player2.hand.remove(0);
                        System.out.println("Tie! New duel: " + card1 + " VS " + card2);
                    } 
                }
            }
            if(winner == 1){
                for(Card card : pile){
                    player1.hand.add(card);
                }
            }
            else{
                for(Card card : pile){
                    player2.hand.add(card);
                }
            }
        }

        if(player1.hand.size() == 0){
            System.out.println(player2.name + " wins!");
            System.exit(0);
        }
        else{
            System.out.println(player1.name + " wins!");
            System.exit(0);
        }
    }


}