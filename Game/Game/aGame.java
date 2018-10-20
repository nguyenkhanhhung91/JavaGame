
package javaapplication4;

public class Game {
    private Board board;
    private Deckofpieces Deck;
    private Player Player1,Player2;
    private Console console;
    
    Game(){        
        board= new Board();    
        Deck= new Deckofpieces();   
        Player1=new Player();
        Player2=new Player();  
        console=new Console();
    }    
    //setup the game, ask name, shuffle the desk
    void setup(){        
        Player1.addname(console.askname(1));
        Player2.addname(console.askname(2));   
        Deck.suffle();        
        for(int i=0;i<14;i++){
            Player1.draw(Deck.draw());
            Player2.draw(Deck.draw());
        }
        Player1.switchturn();   //player1 default turn is true
    }
    void currentstate(){
        //Print the board currrent state    
        console.printboard(board);            
        console.printpiece(Player1);
        console.printpiece(Player2);
    }
    //get player who has turn
    Player getcurrentturn(){
        if(Player1.getturn())
            return Player1;
            else return Player2;
    }
    //switch turn 
    void switchturn(){             
        Player1.switchturn();
        Player2.switchturn();     
    }      
    //check if game is over or not
    boolean gameover(){
        Player current=getcurrentturn();
        if(current.get_wrongmove()>=3)
            return true;
        else             
            return false;            
    }    
     //return 1 if player1 wins, 2 if player2 wins, 0 if nobody wins yet
    int checkwinner(){
        if(Player1.get_wrongmove()>=3){
          return 2;  
        }
        else 
            return 1;          
    }
    //Ask and make a move for a player- return true if success
    boolean move(Player player){             
        int pieceindex=console.askpiece(player);                
        int col=console.askcol(player, 1);
        int row=console.askrow(player, 1);
        int col2=console.askcol(player, 2); 
        int row2=console.askrow(player, 2);           
        boolean movemade=board.put(player.getpiece(pieceindex), row, row2, col, col2);
        if(!movemade){
           player.wrongmove();
           console.wrongmove(player);                
           return false;
        }               
        else {
            player.removepiece(pieceindex);
            player.reset_wrongmove();
            console.movemade();
            return true;
        }
    }        
    void play(){
        setup();
        currentstate();
        while(!gameover()){
            boolean movedone=move(getcurrentturn());
            if (movedone){
                    switchturn();
                    currentstate();
            }
        }        
        if(checkwinner()==1)
            console.displaywinner(Player1);
        else console.displaywinner(Player2);
    }
}
