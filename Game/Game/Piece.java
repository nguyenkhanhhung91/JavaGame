
package javaapplication4;

public class Piece {
    //Piece has 2 parts- half 1 and half 2
    private final Face half1;
    private final Face half2;
    
    //Constructor
    Piece(Face _half1,Face _half2){
        half1=_half1;
        half2=_half2;
    }
    Face gethalf1(){
        return half1;        
    }
    Face gethalf2(){
        return half2;        
    }
     @Override
    public String toString() {
        return String.format("["+half1.name()+"|"+half2.name()+"]");
    }
}
