import java.util.Queue;
import java.util.LinkedList;
public class Board{
    private Card [][] boardArr;
    private Queue<Card> waste;
    public Board(){
        this.boardArr = new Card[7][12];
        this.waste = new LinkedList<Card>();
    }

    public void deal(){
        Card [] unshuffledDeck = new Card[52];
        for(int i = 0; i < 52; i++){
            int val = (i % 13) + 2;
            if(val == 14){
             val = 15;
            }
            boolean vis;
            unshuffledDeck[i] = new Card(i % 4, val, false);

            // System.out.println(cardRead(unshuffledDeck[i]));

        }
        Card [] deck = Solitaire.shuffle(unshuffledDeck);
        // for(Card card : deck){
        //     System.out.println(cardRead(card));
        // }
        int deckInd = 0;
        for(int i = 0; i < 7; i++){
            for(int j = 0; j <= i; j++){
                boardArr[i][j] = deck[deckInd];
                if(j == i){
                    boardArr[i][j].visible = true;
                }
                deckInd++;
            }
        }
        for(int i = deckInd; i < deck.length; i++){
            waste.add(deck[deckInd]);
        }
        print();
    }
    public void print(){
        for(int i = 0; i < 7; i++){
            System.out.println("Stack #" + Integer.toString(i+1));
            for(int j = 0; j <= i; j++){
                System.out.println(Solitaire.cardRead(boardArr[i][j]));
            }
        }
        System.out.println("Waste Pile has size: " + waste.size());
    }
}