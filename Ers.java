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

        for(int i = 0; i < deck.length; i++){
            if(i != 0 && i % 13 == 0){
                System.out.println();
            }
            System.out.print(deck[i].toString() + " ");
        }
        System.out.println();

        Scanner scan = new Scanner(System.in);
        System.out.print("How many players? ");
        int numPlayers = scan.nextInt();

        System.out.print("Which game would you like to play? (War/Blackjack/ERS): ");
        String game = scan.nextLine(); //use for later; for now, implement war

        

        for(int i = 0; i < deck.length; i++){

        }

    }


}