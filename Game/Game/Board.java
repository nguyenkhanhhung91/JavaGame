package javaapplication4;
import java.util.ArrayList;

public class Board {
    private ArrayList<Row> allrows;    
    
    //Constructor-Initialize the board
    Board(){        
        Row row0=new Row(); 
        //create row 0 to row 10       
        row0.blank();row0.blank();row0.blank();row0.blank();row0.blank();
        row0.circle();row0.blank();row0.blank();row0.blank();row0.blank();row0.blank();        
        Row row1=new Row();                  
        row1.blank();row1.blank();row1.blank();row1.blank();row1.flower();
        row1.square();row1.dot();row1.blank();row1.blank();row1.blank();row1.blank();        
        Row row2=new Row();                   
        row2.blank();row2.blank();row2.blank();row2.cross();row2.square();   
        row2.square();row2.square();row2.flower();row2.blank();row2.blank();row2.blank();        
        Row row3=new Row();                   
        row3.blank();row3.blank();row3.plus();row3.circle();row3.circle();
        row3.diamond();row3.dot();row3.dot();row3.cross();row3.blank();row3.blank();        
        Row row4=new Row();         
        row4.blank();row4.diamond();row4.circle();row4.circle();row4.dot();
        row4.blank();row4.plus();row4.dot();row4.dot();row4.circle();row4.blank();        
        Row row5=new Row();         
        row5.diamond();row5.flower();row5.plus();row5.square();row5.blank();
        row5.blank();row5.blank();row5.cross();row5.diamond();row5.diamond();row5.cross();        
        Row row6=new Row();         
        row6.blank();row6.dot();row6.plus();row6.plus();row6.square();
        row6.blank();row6.plus();row6.diamond();row6.diamond();row6.square();row6.blank();        
        Row row7=new Row(); 
        row7.blank();row7.blank();row7.diamond();row7.plus();row7.cross();
        row7.circle();row7.flower();row7.flower();row7.dot();row7.blank();row7.blank();        
        Row row8=new Row();       
        row8.blank();row8.blank();row8.blank();row8.flower();row8.cross();
        row8.cross();row8.flower();row8.circle();row8.blank();row8.blank();row8.blank();        
        Row row9=new Row();         
        row9.blank();row9.blank();row9.blank();row9.blank();row9.plus();
        row9.cross();row9.flower();row9.blank();row9.blank();row9.blank();row9.blank();        
        Row row10=new Row();        
        row10.blank();row10.blank();row10.blank();row10.blank();row10.blank();
        row10.square();row10.blank();row10.blank();row10.blank();row10.blank();row10.blank();
        //add rows to allrows
        allrows=new ArrayList<>();
        allrows.add(row0);allrows.add(row1);allrows.add(row2);allrows.add(row3);
        allrows.add(row4);allrows.add(row5);allrows.add(row6);allrows.add(row7);
        allrows.add(row8);allrows.add(row9);allrows.add(row10);
    }
    
    boolean not_occupied(Position pos1, Position pos2){        
        if(pos1.get_occupied()||pos2.get_occupied())    //check if pos1 and pos2 are occupied
            return false;
        else return true;
    }
    boolean validpiece(int row1, int row2, int col1, int col2){
        if(((Math.abs(row1-row2)+Math.abs(col1-col2))==1)) //row1, row2, col1, col2 must be close and not diagonal
            return true;        
        return false;
    }
    boolean matchpiece(Piece piece, Position pos1, Position pos2){// check if piece matches the positions
        if((piece.gethalf1()==pos1.getface()&&piece.gethalf2()==pos2.getface())
             ||(piece.gethalf2()==pos1.getface()&&piece.gethalf1()==pos2.getface()) ){
             pos1.set_occupied();
             pos2.set_occupied();            
             return true;
        }
        return false;
    }
    // modify the board when put a piece-return true if success
    boolean put(Piece piece, int row1, int row2, int col1, int col2){
        Row rowtoput1=allrows.get(row1);
        Row rowtoput2=allrows.get(row2);
        Position pos1=rowtoput1.get_position_array().get(col1);
        Position pos2=rowtoput2.get_position_array().get(col2);        
        
        boolean canput=not_occupied(pos1, pos2);
        if(!canput)
            return false;
        canput=validpiece(row1, row2, col1, col2);    
        if(!canput)
            return false;
        canput=matchpiece(piece, pos1, pos2);      
        return canput;        
    }
    ArrayList<Row> get_allrows(){
        return allrows;
    }   
    @Override
    public String toString() {
        String print = "";    
        for(int i=0;i<allrows.size();i++){
            print = print.concat(allrows.get(i).toString()+"\n");
        }
        return print;
    }
}
