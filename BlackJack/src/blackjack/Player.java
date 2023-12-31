
package blackjack;

public class Player {
    
    public String name;
    public int score = 0;
    private Card[] hand = new Card[11];
    private int cardCounter = 0;
    
    public void addCard(Card card)
    {
        if (cardCounter < 11)
        {
            hand[cardCounter] = card;
            cardCounter++;
            score += card.getValue();
        }
    }
    
    public Card[] getHand()
    {
        return this.hand;
    }
}
