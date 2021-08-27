import java.util.*;


public class ticTacToe {
    public static void main(String[] args) {
	
        char[][] board=new char[3][3];
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]='-';
            }
        }
        
        
        
        
        
        Scanner scn=new Scanner(System.in);
        System.out.println("Pick x or 0");
        char p1=scn.next().charAt(0);
        System.out.println("Player 1 picked: "+p1);
        char p2;
        if(p1=='x'){
        p2='0';
        System.out.println("Player 2 is: "+p2);
        }
        else{
          p2='x';
        System.out.println("Player 2 is: "+p2);
        }
    
        
    
        
        String n1="";
        String n2="";
        boolean turn=true;
        int count=0;
        for(int i=0;i<9;i++){
            
            if(turn==true){
           System.out.print("Enter Player 1:" );
            n1=scn.next();
            System.out.print(" "+n1+"\n");
            
            if(isValid(n1,board,p1)){
            for(int x=0;x<board.length;x++){
            for(int j=0;j<board[0].length;j++){
              System.out.print("\t"+board[x][j]+" ");
            }
            System.out.println();
        }
    
            if(isWinner(board,n1)){
                 System.out.println("Player 1 wins");
                break;
            }
            
            turn=false;
            }
            
            else{
            System.out.println("Not Valid");
            i--;
            }
            }
            else{
            System.out.print("Enter Player 2: ");
            n2=scn.next();
            System.out.print(  n2+"\n");
            
            if(isValid(n2,board,p2)){
                  for(int x=0;x<board.length;x++){
            for(int j=0;j<board[0].length;j++){
              System.out.print("\t"+board[x][j]+" ");
            }
            System.out.println();
        }
            if(isWinner(board,n2)){
                System.out.println("Player 2 wins");
                break;
            }
            turn=true;
            }
            else{
            System.out.println("Not Valid");
            i--;
            }
            
            }
            


            count++;
            
        }
        
        
        if(count==9){
            System.out.println("Draw!!!");
        }
        
        
        
        
        
        }
        
        
        public static boolean isValid(String given,char[][] board,char p){
            String[] s=given.split(",");
           int x=Integer.parseInt(s[0]);
           int y=Integer.parseInt(s[1]); 
            
            if(x<3 && y<3){
                if(board[x][y]=='-'){
                    board[x][y]=p;
                    return true;
                }
            }
            
            
            
            
            return false;
            
        }
        
        //check winner
        
        public static boolean isWinner(char[][] board,String given){
           String[] s=given.split(",");
           int x=Integer.parseInt(s[0]);
           int y=Integer.parseInt(s[1]);
            //check rows
            
           
               if( board[x][0]!='-' && board[x][0]==board[x][1] && board[x][1]==board[x][2]){
                    return true;
            }
            else if(board[0][y]!='-'  && board[0][y]==board[1][y] && board[1][y]==board[2][y]){
                    return true;
            }
            else if(x+y==board.length-1 || x==y){
                    if(board[0][0]!='-' && board[0][0]==board[1][1] && board[1][1]==board[2][2]){
                        return true;
                    }
                    if(board[0][2]!='-' && board[0][2]==board[1][1] && board[1][1]==board[2][1]){
                        return true;
                    }
            }

            return false;
            
        }
}

