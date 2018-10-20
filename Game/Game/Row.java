package javaapplication4;
import java.util.ArrayList;

public class Row {
    private ArrayList<Position> position_array;
    
    //constructor
    Row(){
        position_array= new ArrayList<>();        
    }            
     @Override
    public String toString() {
        String print="";        
        for(int i=0;i<11;i++){//11 positions in a row
            Position pos=position_array.get(i);
            if(pos.getface()==Face.blank)// if blank then no need for bracket
                print=print.concat(pos.toString());
            else print=print.concat("["+pos.toString()+"]");
        }
        return print;
    }    
    ArrayList<Position> get_position_array(){
        return position_array;
    }
   //list of methods to add new position to row 
   void square(){
        Position newpos=new Position(Face.squ);
       position_array.add( newpos);
    }
   void circle(){
        Position newpos=new Position(Face.cir);
       position_array.add( newpos);
    }
   void diamond(){
        Position newpos=new Position(Face.dia);
       position_array.add( newpos);
    }
   void plus(){
        Position newpos=new Position(Face.plu);
       position_array.add( newpos);
    }
   void cross(){
        Position newpos=new Position(Face.cro);
       position_array.add( newpos);
    }
    void flower(){
        Position newpos=new Position(Face.flo);
       position_array.add( newpos);
    }
    void blank(){
        Position newpos=new Position(Face.blank);
       position_array.add( newpos);
    }
    void dot(){
        Position newpos=new Position(Face.dot);
       position_array.add( newpos);
    }
}
