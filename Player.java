import java.util.ArrayList;

public class Player {
    String name;
    ArrayList<Card> hand = new ArrayList<Card>();

    public Player(String name){
        this.name = name;
    }

    public Player(String name, ArrayList<Card> hand){
        this.name = name;
        this.hand = hand;
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
