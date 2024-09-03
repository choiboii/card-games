public class Card {
    String suit;
    int value;
    public Card(String s, int v){
        this.suit = s;
        this.value = v;
    }

    public String toString(){
        return this.suit + " " + this.value;
    }
}
