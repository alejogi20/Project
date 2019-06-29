
package project;

import java.util.Random;

/**
 *
 * @author Goncalves
 */
public class Main {

    public static void main(String[] args) {
        
        String[][]  array = new String[30][30];
        
        
        generateMaze(array, 0, array.length, 0, array[0].length , 5, 0, 0, 8, 0);
        
        
      
        
        for (int i = 0; i < array.length; i++) {
            
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(" " +array[i][j]);
               if(j == array.length - 1) System.out.print(" \n"); 
            }
        }
    }
    
    public static void generateMaze(String[][] maze, int topRow, int bottomRow, int leftCol, int rightCol, int entranceRow, int entranceCol, int exitRow, int exitCol, int wallRotation){ 
        /* 
            La condición de parada, si la diferencia entre las paredes (que son el tope o limites de cada cuadrante)
           es igual a 2, entonces es porque ya no se puede seguir dividiendo ese cuadrante, entonces retorna.
        */
        
        if(bottomRow - topRow == 2  ||  rightCol - leftCol == 2) return; 
        
        Random rand = new Random();
        int cWall;
        int rWall;
        
        /* 
            esto rellena los bordes de la matriz, si la primera celda es null entonces todas las demas son null
           esto quiere decir que no tiene nada, entonces este codigo no solo rellena los bordes sino que pone 
           los caracteres que corresponden a " caminos "
        */
        
        if( maze[0][0] == null ){
            for (int r = 0; r < maze.length; r++) {
                for (int c = 0; c < maze[0].length; c++) {
                    
                    if( (r != 0 && r != maze.length - 1) && (c != 0 && c != maze[0].length - 1)) maze[r][c] = "≡";
                    else if( r == entranceRow && c == entranceCol ) maze[r][c]   = "□";
                    else if(r == exitRow && c == exitCol) maze[r][c] = "∩";
                    else maze[r][c] = "■";
                }
            }
        }
        
        /* 
           Por ahora este if es para saber si se va a poner un pared como columna o como fila, 
           cuando wallRotation es igual a 0 entonces se hará un pared fila o horizontal, si es 1 entonces se
           hará una pared columna o vertical
        */
        
        if(wallRotation == 0){
           
            /*
              BreakCellAtCol es " romper una celda en tal columna " esta es la celda que vamos a romper 
              una vez que tengamos hecha la pared como es horizontal, entonces la variable contendrá una
              posición de una columna random donde se va a romper o hacer un hueco (no confundir con la 
              entrada y la salida del laberinto)
            */
            int breakCellAtCol; 
            
            /* 
                estos do-while asignan las posiciones random, hay muchas condiciones que tiene que cumplir
                un numero random para ser asignado, para que una pared no tape la salida ni la entrada ni 
                los nuevos huecos
           */
            
            //la posicion random de la fila donde se hará la pared
            do{
                rWall = rand.nextInt(bottomRow);
            }while(rWall == entranceRow || rWall == exitRow || ((rWall == entranceRow - 1 && entranceRow == bottomRow) || ( rWall == entranceRow + 1 && entranceRow == topRow ) ) || (rWall == entranceRow - 1 && exitRow == bottomRow) || ( rWall == exitRow + 1 && exitRow == topRow) );
            
            // la posición random en la columna donde se hará el hueco en la pared vertical
            do{
                breakCellAtCol = rand.nextInt(rightCol);
            }while(breakCellAtCol <= leftCol);
            
            //este for hace la pared, y no rellena donde se supone que va el hueco
            for (int c = leftCol + 1; c < rightCol; c++) {
                if(c != breakCellAtCol) maze[rWall][c] = "■";
            }
            
        }    
          
        // este es para hacer paredes pero verticales, como se indicó antes
        if(wallRotation == 1){
            int breakCellAtRow; // hueco en una fila random
            
            // pared vertical en posicion random
            do{
                cWall = rand.nextInt(rightCol) + 1;
            }while( cWall == exitCol || ((cWall == entranceCol - 1 && entranceCol == rightCol) || ( cWall == entranceCol + 1 && entranceCol == leftCol ) ) || (cWall == exitCol - 1 && exitCol == rightCol) || ( cWall == exitCol + 1 && exitCol == leftCol) );
            
            //romper una celda en una fila random de la pared
            do{
                breakCellAtRow = rand.nextInt(bottomRow) + topRow;
            }while(breakCellAtRow == topRow);

            //hacer la pared 
            for (int r = topRow + 1; r < bottomRow ; r++) {
                if(breakCellAtRow != r) maze[r][cWall] = "■";
            }

        }
    }
    
}