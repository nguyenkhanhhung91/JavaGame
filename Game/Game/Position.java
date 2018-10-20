
package javaapplication4;

public class Position {    
    private Face face;
    private boolean occupied;
    
    //Constructor
    Position(Face _face){
        face=_face;
        occupied=false;
    }          
    Face getface(){
        return face;
    }
    void set_occupied(){
        occupied=true;
    }
    boolean get_occupied(){
        return occupied;
    }
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    @Override
    public String toString() {
        if(face==Face.blank)//if blank just print space
            return "     ";
        if(occupied==true){
        return String.format(ANSI_BLUE+face.name()+ ANSI_RESET);
        }
        else return String.format(face.name());
    }
}