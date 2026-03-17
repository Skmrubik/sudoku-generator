package utilities;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ProcesamientoSudoku {

    Celda[][] sudoku;

    public ProcesamientoSudoku(Celda[][] sudoku) {
        this.sudoku = sudoku;
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                Celda celda = new Celda();
                sudoku[i][j] = celda;
            }
        }
    }

    public void rellenarPrimeraFila(){
        List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(lista);
        for (int i=0; i<9; i++) {
            sudoku[0][i].setNumero(lista.get(i));
            sudoku[0][i].setNumeroPuesto(true);
            eliminarPosibles(0, i, lista.get(i));
        }
    }

    public void printSudoku(){
        System.out.println("+---+---+---+---+---+---+---+---+---+");
        for(int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if(j==0){
                    if (sudoku[i][j].getNumeroPuesto()) {
                        System.out.print("| "+sudoku[i][j].getNumero()+" |");
                    } else {
                        System.out.print("|   |");
                    }
                } else {
                    if (sudoku[i][j].getNumeroPuesto()) {
                        System.out.print(" "+sudoku[i][j].getNumero()+" |");
                    } else {
                        System.out.print("   |");
                    }
                }
            }
            System.out.println("");
            if ((i+1)%3==0){
                System.out.println("+---+---+---+---+---+---+---+---+---+");
            } else {
                System.out.println("+--- --- ---+--- --- ---+--- --- ---+");
            }

        }
    }

    public void eliminarPosibleFila(int fila, int posible){
        for (int i=0; i< 9; i++){
            if (!sudoku[fila][i].getNumeroPuesto())
                sudoku[fila][i].getPosibles()[posible-1]=false;
        }
    }

    public void eliminarPosibleColumna(int col, int posible){
        for (int i=0; i< 9; i++){
            if (!sudoku[i][col].getNumeroPuesto())
                sudoku[i][col].getPosibles()[posible-1]=false;
        }
    }
    //el primer cuadrante es 0
    public void eliminarPosibleCuadrante(int cuadrante, int posible){
        int posCuadranteFila = cuadrante/(int) 3;
        int posCuadranteColumna = cuadrante%3;
        int inicioFila = posCuadranteFila*3;
        int inicioCol = posCuadranteColumna*3;
        for (int i=inicioFila; i<(inicioFila)+3; i++){
            for (int j=inicioCol; j<(inicioCol)+3; j++){
                if (!sudoku[i][j].getNumeroPuesto())
                    sudoku[i][j].getPosibles()[posible-1]=false;
            }
        }
    }

    public void eliminarPosibles(int fila, int col, int posible){
        eliminarPosibleFila(fila, posible);
        eliminarPosibleColumna(col, posible);
        int posCuadranteFila = fila/(int) 3;
        int posCuadranteCol = col/(int) 3;
        int cuadrante = (3*posCuadranteFila)+posCuadranteCol;
        eliminarPosibleCuadrante(cuadrante, posible);
    }

    public void rellenarSegundaColumna(){
        boolean todos = false;
        while (!todos){
            for(int i=0; i<9; i++) {
                boolean[] posibles = sudoku[1][i].getPosibles();
                boolean algunPosible= false;
                for (int j=0; j<9 && !algunPosible; j++){
                    if(posibles[j]){
                        algunPosible=true;
                    }
                }
                if (!algunPosible){
                    break;
                }
                boolean randomPosible= false;
                int numero = -1;
                while (!randomPosible){
                    Random rand = new Random();
                    numero = rand.nextInt(9);
                    if (sudoku[1][i].getPosibles()[numero]){
                        randomPosible= true;
                    }
                }
                sudoku[1][i].setNumero(numero+1);
                sudoku[1][i].setNumeroPuesto(true);
                eliminarPosibles(1, i, numero+1);
                if (i==8){
                    todos=true;
                }
            }
        }
    }

    public void rellenarTerceraColumna(){
        boolean todos = false;
        while (!todos){
            for(int i=0; i<9; i++) {
                boolean[] posibles = sudoku[2][i].getPosibles();
                boolean algunPosible= false;
                for (int j=0; j<9 && !algunPosible; j++){
                    if(posibles[j]){
                        algunPosible=true;
                    }
                }
                if (!algunPosible){
                    break;
                }
                boolean randomPosible= false;
                int numero = -1;
                while (!randomPosible){
                    Random rand = new Random();
                    numero = rand.nextInt(9);
                    if (sudoku[2][i].getPosibles()[numero]){
                        randomPosible= true;
                    }
                }
                sudoku[2][i].setNumero(numero+1);
                sudoku[2][i].setNumeroPuesto(true);
                eliminarPosibles(2, i, numero+1);
                if (i==8){
                    todos=true;
                }
            }
        }
    }
}
