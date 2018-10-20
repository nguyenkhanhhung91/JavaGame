package javaapplication4;
import java.util.Scanner;

public class Console {
    Scanner sc = new Scanner(System.in);
    
    String askname(int i){
        System.out.print("Name of Player "+i+": ");
        String name = sc.nextLine();
        return name;    
    }    
    //check if piece is in list range
    boolean validpiece(int piece, int numofpiece ){        
        return !(piece<0||piece>=numofpiece);
    }    
    
    int askpiece(Player player){
        int numofpiece=player.get_numofpiece();
        int piece=-1;
        while (!validpiece(piece,numofpiece)){
        System.out.print(player.getname()+", enter piece number to move: ");
        piece= sc.nextInt();       
            if (!validpiece(piece,numofpiece)){
                System.out.println("Invalid piece number!");
            }        
        }    
        System.out.println(player.getname()+", you picked "+ player.get_piecearray().get(piece).toString());
        return piece;
    }
    
    //check if player enter valid input rows and collums
    boolean validinput(int piece){        
        return !(piece<0||piece>=11);
    }
    
    int askrow(Player player, int rownumber){
        int piece=-1;
        while (!validinput(piece)){
        System.out.print(player.getname()+", enter row"+ rownumber+": ");
        piece= sc.nextInt();
            if (!validinput(piece)){
                System.out.println("Invalid row number!");
            }
        }
        return piece;
    }
    
    int askcol(Player player, int collumnumber){
        int piece=-1;
        while (!validinput(piece)){
        System.out.print(player.getname()+", enter collum"+ collumnumber+": ");
        piece= sc.nextInt();
            if (!validinput(piece)){
                System.out.println("Invalid collum number!");
            }
        }
        return piece;
    }   
    void movemade(){
        System.out.println("Move is made");
    }
    void wrongmove(Player player){
        System.out.println("Can not put the piece there!");
        System.out.println(player.getname()+", you made "+player.get_wrongmove()+" wrong move");
    }
    void printpiece(Player player){//print all pices player currently has
        System.out.print(player.toString()+"\n");       
    }
    void printboard(Board board){
        System.out.println(board.toString());
    }
    void displaywinner(Player player){
        System.out.println("Congratulation "+player.getname()+ "! You WIN");
    }
}
