package blackjack;
import java.util.Random;
import java.util.Scanner;
public class Game {
   Player []player=new Player[4];
   Card []deckOfCard=new Card[52];
   public int []highScore = new int [4];
   public int win=-1; boolean Busterd= false;
   int[] values = {
            1,2,3,4,5,6,7,8,9,10,10,10,10
        };
public void deck(){
        int ni=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Card dcard= new Card(i,j,values[j]);
                deckOfCard[ni]=dcard;
                ni++;
            }
}
}
public Card Draw(){
   Random rand =new Random();
   while (true){ 
       int ind= rand.nextInt(51);
       if(deckOfCard[ind]!=null){
  Card drawenCard= deckOfCard[ind];
deckOfCard[ind]=null;
  return drawenCard;
       }
   }    
}   
public void setInfo(){
Scanner scan = new Scanner(System.in);
for (int i=0; i<3 ;i++){
    System.out.println("Hello Player "+(i+1)+"\nPlease Enter Your Name : ");
    player[i]=new Player();
    player[i].name=scan.next();
    player[i].addCard(Draw());
    player[i].addCard(Draw());
}
 player[3]=new Player();
 player[3].name="Dealer";
 player[3].addCard(Draw());
 player[3].addCard(Draw());
}
public void newHighsc(){
   
  for (int i=0 ;i<3;i++){
    if(player[i].score<=21)
  { 
      highScore[i]=player[i].score ;
     
  }
    if (player[i].score>21)
    {
     Busterd=true;
    }
   
}
}
}
        

