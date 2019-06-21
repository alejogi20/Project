
package project;

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
    
        
        
        generateMaze(array);
        
        for (int i = 0; i < 10; i++) {
            
            for (int j = 0; j < 10; j++) {
                System.out.print("  " + array[i][j]);
               if(j == 9) System.out.print(" \n"); 
            }
        }
    }
    
    static public void generateMaze(int[][] array){
        
        
    }
}
