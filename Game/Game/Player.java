package javaapplication4;
import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Piece> piece_array;    
    private boolean turn;
    private int wrongmove;
    
    //Constructor
    Player(){
        name=null;
        piece_array= new ArrayList<>();
        turn=false;
        int wrongmove=0;
    }
    //switch turn
    void switchturn(){
        turn=!turn;
    }
    boolean getturn(){return turn;}
    //draw piece
    void draw(Piece piece){
        piece_array.add(piece);
    }
    int get_numofpiece(){return piece_array.size();}
    void wrongmove(){wrongmove++;}
    int get_wrongmove(){return wrongmove;}
    void reset_wrongmove(){wrongmove=0;}//reset after success move
    void addname(String _name){
        name=_name;
    }
    String getname(){
        return name;
    }
    ArrayList<Piece> get_piecearray(){return piece_array;}    
    Piece getpiece(int pieceindex){    
       Piece piece=piece_array.get( pieceindex);   
       return piece; 
    }   
    void removepiece(int pieceindex){piece_array.remove( pieceindex);}
    @Override
    public String toString() {
        String print = "";    
        print=print.concat(name+": ");
        for(int i=0;i<piece_array.size();i++){
            print=print.concat(i+piece_array.get(i).toString()+" ");
        }
        return print;
    }
}
