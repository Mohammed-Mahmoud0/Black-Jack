package blackjack;

import java.util.Scanner;

public class BlackJack {

    static Game game = new Game();
    public static void main(String[] args) {
        
        GUI gui = new GUI();
        
        game.generate();
        game.setInfo();
        
        
        
        gui.runGUI( game.deck, game.players[0].getHand(), game.players[1].getHand(), game.players[2].getHand(), game.players[3].getHand() );
        
        playersTurn(gui);
        
        game.updateGameScore();
        
        dealersTurn(gui);
        
        game.updateGameScore();
        
        checkGame();
    }
    
    public static void playersTurn(GUI gui)
    {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        
        for (int i = 0;i < game.players.length - 1;i++)
        {
            while(!input.toLowerCase().equals("stand"))
            {
                System.out.println("player nomber" + (i + 1) + " { Hit or Stand } ");
                input = scanner.next();
                if (input.toLowerCase().equals("hit"))
                {
                    addCardToPlayer(i, gui);
                }
            }
        }
    }
    
    public static void addCardToPlayer(int index, GUI gui)
    {
        Card card = game.drow();
        game.players[index].addCard(card);
        gui.updatePlayerHand(card, index);
    }
    
    public static void dealersTurn(GUI gui)
    {
        boolean dealerWins = true;
        int highscore = 0;
        for (int i = 0;i < game.players.length - 1;i++)
        {
            if (game.highScores[i] >= game.players[3].score)
                dealerWins = false;
            
            if (game.highScores[i] > highscore)
                highscore = game.highScores[i];
        }
        
        if (!dealerWins)
        {
            addCardToDealer(gui, highscore);
        }
        else
            return;
    }
    
    public static void addCardToDealer(GUI gui, int highscore)
    {
        while (game.players[3].score < highscore)
        {
            Card card = game.drow();
            game.players[3].addCard(card);
            gui.updateDealerHand(card, game.deck);
        }
    }
    
    public static void checkGame()
    {
        int highscore = 0;
        int winner = -1;
        for (int i = 0;i < game.players.length;i++)
        {
            if (game.highScores[i] > highscore)
            {
                highscore = game.highScores[i];
                winner = i;
            }
        }
        if (winner >= 0)
        {
            System.out.println("\n###################################");
            System.out.println("the winner is " + game.players[winner].name + " with score : " + highscore);
            System.out.println("\n###################################");
            
        }
    }
    
}
