import java.util.*;


public class ticTacToe {
    public static void main(String[] args) {
	
        char[][] board=new char[3][3];
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
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
        for(int i=0;i<board.length*board[0].length;i++){
            
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
    
            if(isWinner(board,n1,p1)){
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
            if(isWinner(board,n2,p2)){
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
        
        
        if(count==board.length*board[0].length){
            System.out.println("Draw!!!");
        }
        
        
        
        
        
        }
        
        
        public static boolean isValid(String given,char[][] board,char p){
            String[] s=given.split(",");
           int x=Integer.parseInt(s[0]);
           int y=Integer.parseInt(s[1]); 
            
            if(x<=board.length-1 && y<=board[0].length-1){
                if(board[x][y]=='-'){
                    board[x][y]=p;
                    return true;
                }
            }
            
            
            
            
            return false;
            
        }
        
        //check winner
        
        public static boolean isWinner(char[][] board,String given,char alpha){
           String[] s=given.split(",");
           int x=Integer.parseInt(s[0]);
           int y=Integer.parseInt(s[1]);
            //check rows
            char checkRow=board[0][y];
            boolean rowFlag=true;
            
            for(int i=1;i<board.length;i++){
                if(checkRow!='-'){
                if(board[i][y]!='-'){
                    if(board[i][y]!=checkRow){
                        rowFlag=false;
                    }
                  
                }
                if(board[i][y]=='-'){
                    rowFlag=false;
                }
                   checkRow=board[i][y];
                }
                
                if(checkRow=='-'){
                    rowFlag=false;
                }        
                
                
            }
            
    
            
            
            //check colums
    
            char checkCol=board[x][0];
            
          
            boolean colFlag=true;
           
            for(int j=1;j<board[0].length;j++){
                if(checkCol!='-'){
                if(board[x][j]!='-'){
                      if(board[x][j]!=checkCol){
                         colFlag=false;
                         
                    }
                   
                         checkCol=board[x][j];
                }
                if(board[x][j]=='-'){
                    colFlag=false;
                }
                    
                }
                if(checkCol=='-'){
                    colFlag=false; 
                }
            }
            
            if(colFlag==true || rowFlag==true){
                return true;
            }
            
            //check diag
            
          if(x==y){
            char diag1=board[0][0];
            boolean checkDiag1=true;
   
            
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                  
                    if(i==j){
                //check if board[i][j] and checkdiag!=-
                //if not check values
                if(board[i][j]=='-' || diag1=='-'){
                    checkDiag1=false;
                }
                else if(board[i][j]!='-' && diag1!='-'){
                        if(board[i][j]!=diag1){
                            checkDiag1=false;
                            diag1=board[i][j];
                        }
                }
                    }
                    
                
         
    
            }

            }

            if(checkDiag1==true){
               return true;
           }

            
          }
            
          if(x+y==board.length-1){
            char diag2=board[0][2];
            boolean checkDiag2=true;
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                  
                   if(i+j==board.length-1){
                      if(i+j==board.length-1){
                 
            if(board[i][j]=='-' || diag2=='-'){
                checkDiag2=false;
            }
            else if(board[i][j]!='-' && diag2!='-'){
                    if(board[i][j]!=diag2){
                        checkDiag2=false;
                        diag2=board[i][j];
                    }
            }

    }
                   }
                
         
    
            }

            }

            
            if(checkDiag2==true){
                return true;
            }
 
    
          }
            
    




            return false;
            
        }
}

