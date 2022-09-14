
package blackjack;
import java.util.Scanner;
public class BlackJack {
   static Game g1= new Game();
   public static void main(String[] args) {
   GUI gui = new GUI();
   g1.deck();
   
   g1.setInfo();
     
   gui.runGUI( g1.deckOfCard, g1.player[0].getCardHand(), g1.player[1].getCardHand(), g1.player[2].getCardHand(), g1.player[3].getCardHand() );
   
   pTurn(gui);
    
   g1.newHighsc();
   
   dTurn(gui);
   
   g1.newHighsc();
 
   winner();
    }
   public static void pTurn(GUI gui){
   for (int i=0;i<3;i++){
         Scanner scan=new Scanner(System.in);
       int inp=0;
       while(inp!=2 && g1.player[i].score<21){
       System.out.println("Player "+(i+1)+" Wanna (1:Hit / 2:Stand)");
       inp= scan.nextInt();
      if(inp==1)
      {
        addPCArd(i,gui);
      }
             
   }     
   }
    }
   public static void addPCArd(int i ,GUI gui){
        Card card= g1.Draw();
          g1.player[i].addCard(card);
         gui.updatePlayerHand(card, i);
   }
   public static void dTurn(GUI gui){
       boolean de=true;
       int highSc=0;
       for (int i=0 ;i<3;i++){
           if (g1.highScore[i]>= g1.player[3].score){
               de=false;
           }
       if(g1.highScore[i]>highSc){
           highSc=g1.highScore[i];
       }
       }
       if (!de){
           deCard(gui,highSc);
       }
       else {
           return;
       }
   }
   public static void deCard(GUI gui ,int highScore){
       while(g1.player[3].score<highScore){
           Card card= g1.Draw();
          g1.player[3].addCard(card);
         gui.updateDealerHand(card, g1.deckOfCard);
       }
   }
   public static void winner(){
       int highs=0; int n=-1;
       for (int i=0; i<4 ;i++){
           if (g1.highScore[i]>highs){
               highs=g1.highScore[i];
              n=i;
           if ( g1.player[i].score==g1.player[i+1].score &&highs>g1.player[3].score){
           System.out.println("PUSH");
       }
           else if (g1.player[3].score<21 || g1.player[3].score>21|| highs>g1.player[3].score){
           System.out.println( g1.player[n].name +" Win"+"\nwith Score is :" + highs);
       }
       else if (highs<g1.player[3].score && g1.player[3].score<=21|| g1.player[3].score==21 ){
               System.out.println("Dealer won");
               break;
           }
           }
   
       }
   }
}
