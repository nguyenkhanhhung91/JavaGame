package javaapplication4;
import java.util.ArrayList;
import java.util.*;

public class Deckofpieces {
    private ArrayList<Piece> allpieces;        
    
    //constructor of Deckofpieces 
    Deckofpieces(){        
       allpieces= new ArrayList<>();
       
      // create a list of face, not including blank
       Face[] face = new Face[] {Face.squ,Face.cir,Face.plu,Face.cro,
           Face.dot,Face.dia,Face.flo};
        
        //i is the first part, j is the second part of a piece       
        for(int i=0;i<7;i++){// first part can be any face from [0] to [6]
            for(int j=i;j<7;j++){// second part can be any face from [0] to [6]                  
            Piece newpiece= new Piece(face[i],face[j]);     
            allpieces.add(newpiece);//add a new piece to allpieces array
            }
        }
    }
    //suffle the deck
   void suffle(){
        Collections.shuffle(allpieces);        
   }
   //get a piece and remove that piece from list
   Piece draw(){
       Piece piece=allpieces.get(0);
       allpieces.remove(0);
       return piece;
   }
}
