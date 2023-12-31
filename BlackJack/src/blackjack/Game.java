
package blackjack;

import java.util.Random;
import java.util.Scanner;

public class Game {
    
    public Player[] players = new Player[4];
    public Card[] deck = new Card[52];
    public int[] highScores = new int [4];
    
    public void generate()
    {
        int counter = 0;
    for (int i = 0;i < 4;i++)
    {
        for (int j=0;j<13;j++)
        {
            int value = (j >= 10) ? 10 : j+1 ;
            Card card = new Card (i, j, value);
            deck[counter] = card;
            counter++;
        }
    }
    }
    
    public Card drow()
    {
        Random random = new Random();
        Card card = null;
        do{
            int randomNum = random.nextInt(51);
            card = deck[randomNum];
        }while(card == null);
        
        return card;
    }
    
    public void setInfo()
    {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0;i < players.length - 1;i++)
        {
            System.out.print("Enter the name of player" + (i + 1) + ":");
            players[i] = new Player();
            players[i].name = scanner.next();
            players[i].addCard(this.drow());
            players[i].addCard(this.drow());
            
        }
        
            players[3] = new Player();
            players[3].name = scanner.next();
            players[3].addCard(this.drow());
            players[3].addCard(this.drow());
    }
    
    public void updateGameScore()
    {
        for (int i = 0;i < highScores.length;i++)
        {
            highScores[i] = players[i].score <= 21 ? players[i].score : 0 ;
        }
    }
}
