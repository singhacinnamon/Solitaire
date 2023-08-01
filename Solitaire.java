import java.util.Random;
import java.util.ArrayList;
public class Solitaire{
    private static Random rand;
    private Board board;

    public Solitaire(){
        rand = new Random();
        board = new Board();
    }

    public static Card [] shuffle(Card [] toShuffle){   //returns a shuffled version of the input array
        ArrayList<Card> temp = new ArrayList<Card>();
        for(int i = 0; i < toShuffle.length; i++){
            int rInd;
            if(temp.size() == 0){   //nextInt requires a positivebound so zero case is separate
                rInd = 0;
            } else {
                rInd = rand.nextInt(temp.size());
            }
            temp.add(rInd, toShuffle[i]); //take advantage of arraylist dynamic size to randomize order. could be more efficient?
        }
        Card [] retArr = new Card[toShuffle.length];
        for(int i = 0; i < toShuffle.length; i++){
            retArr[i] = temp.get(i);
        }
        System.out.println("length of shuffled array return: " + retArr.length);
        return retArr;
    }



    public static String cardRead(Card c){ //Turn a card object into its string representation
        if(!c.visible){
            return "XXXXXXXXX";
        }
        String outVal;
        String outSuit;
        switch(c.value){
            case 11:
                outVal = "J";
                break;
            case 12:
                outVal = "Q";
                break;
            case 13:
                outVal = "K";
                break;
            case 15:
                outVal = "A";
                break;
            default:
                outVal = Integer.toString(c.value);
        }

        switch(c.suit){
            case 0:
                outSuit = "Spades";
                break;
            case 1:
                outSuit = "Hearts";
                break;
            case 2:
                outSuit = "Clubs";
                break;
            default:
                outSuit = "Diamonds";
        }
        return outVal + " of " + outSuit;
    }

    public void test(){
        board.deal();
    }
    public static void main(String args[]){
        Solitaire soli = new Solitaire();
        soli.test();
    }
}