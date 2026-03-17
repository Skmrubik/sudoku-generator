package utilities;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
}
