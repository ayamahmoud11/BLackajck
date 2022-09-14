package blackjack;

public class Player {
    public String name;
    public int score=0;
   private Card []cardHand=new Card[11];

    public Card[] getCardHand() {
        return cardHand;
    }
  int co=0;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
    public void addCard(Card handCard)
    {
        if (co<11)
        {
            cardHand[co]=handCard;
            co++;
            score+=handCard.getValue();
        } 
    }
}
