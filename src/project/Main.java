
package project;

import java.util.Random;

/**
 *
 * @author Goncalves
 */
public class Main {

    public static void main(String[] args) {
        
        int[][]  array = new int[10][10];
        
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                array[x][y] = 0;
            }
        }
        
        
        for (int i = 0; i < 10; i++) {
            
            for (int j = 0; j < 10; j++) {
                
                if(i == 0 || i == 9){
                    array[i][j] = 1;
                }else if(i == 1 ){
                    array[i][9] = 1;
                    break;
                }else if( i == 8){
                    array[i][0] = 1;
                    break;
                } else if(j == 0 || j == 9) array[i][j] = 1;
                
            }
        }
    
        
        
        generateMaze(array, 9, 2, 9, 8);
        
        for (int i = 0; i < 10; i++) {
            
            for (int j = 0; j < 10; j++) {
                System.out.print("  " + array[i][j]);
               if(j == 9) System.out.print(" \n"); 
            }
        }
    }
    
    public static void generateMaze(int[][] array, int rowBound, int rowEntrance, int colBound, int rowExit){
        
        Random rand = new Random();
        int colWall;
        int rowWall;
        
        do{
            colWall = rand.nextInt(colBound - 1);
        }while(colWall < 2);
        
        do{
            rowWall  = rand.nextInt(rowBound -1) ;
        }while(rowWall < 2);
            
        for(int i = 1; i < rowBound; i++){
                array[i][colWall] = 1;
        }
        
        for (int j = 0; j < colBound; j++) {
            array[rowWall][j] = 1;
        }
        
        int flag = rand.nextInt(2);
        
        if(flag == 0){
            int breakWall1, breakWall2, breakWall3;
            
        do{
            breakWall1  = rand.nextInt(colBound) ;
        }while(breakWall1 < 1 || breakWall1 >= colWall);    
            
        do{
            breakWall2  = rand.nextInt(colBound) ;
        }while(breakWall2 < 1 || breakWall2 <= colWall );    

        do{
            breakWall3  = rand.nextInt(rowBound) ;
        }while(breakWall3 < 1 || breakWall3 == rowWall);    
  
        array[rowWall][breakWall1] = 0;
        array[rowWall][breakWall2] = 0;
        array[breakWall3][colWall] = 0;
        
        }else{
           
             int breakWall1, breakWall2, breakWall3;
            
        do{
            breakWall1  = rand.nextInt(rowBound) ;
        }while(breakWall1 < 1 || breakWall1 >= rowWall);    
            
        do{
            breakWall2  = rand.nextInt(rowBound) ;
        }while(breakWall2 < 1 || breakWall2 <= rowWall );    

        do{
            breakWall3  = rand.nextInt(colBound) ;
        }while(breakWall3 < 1 || breakWall3 == colWall);    
  
        array[breakWall1][colWall] = 0;
        array[breakWall2][colWall] = 0;
        array[rowWall][breakWall3] = 0;
        
            
        }
        
    }
}
