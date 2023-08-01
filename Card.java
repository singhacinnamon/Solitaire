public class Card{
    int suit;   //Spade=0, Heart=1, Club=2, Diamond=3
    int value;  //J=11, Q=12, K=13 INVALID=14 A=15
    boolean visible;

    public Card(int suit, int value, boolean visible){
        if(value < 2 || value == 14 || value > 15){
            System.out.println("invalid Card value in constructor");
        }
        if(suit < 0 || suit > 3){
            System.out.print("invalid suit in constructor");
        }
        this.suit = suit;
        this.value = value;
        this.visible = visible;
    }
}