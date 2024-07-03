import java.util.ArrayList;

public class Player {
    ArrayList<Card> hand = new ArrayList<Card>();
    public Player(ArrayList<Card> deck){
        hand = deck;
    }

    public String toString(){
        String result = "";
        for(int i = 0; i < hand.size() - 1; i++){
            result += hand.get(i) + " ";
        }
        result += hand.get(hand.size()-1);
        return result;
    }
}
