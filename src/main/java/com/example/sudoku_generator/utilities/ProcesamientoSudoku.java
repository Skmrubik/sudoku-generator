package com.example.sudoku_generator.utilities;

import java.util.*;

public class ProcesamientoSudoku {

    int[][] sudoku;

    public ProcesamientoSudoku() {
        this.sudoku = new int[4][4];
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                sudoku[i][j] = 0;
            }
        }
    }

    public int[][] getSudoku() {
        return sudoku;
    }

    public void setSudoku(int[][] sudoku) {
        this.sudoku = sudoku;
    }


    public void printSudoku(){
        System.out.println("+---+---+---+---+");
        for(int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if(j==0){
                    if (sudoku[i][j]!= 0) {
                        System.out.print("| "+sudoku[i][j]+" |");
                    } else {
                        System.out.print("|   |");
                    }
                } else {
                    if (sudoku[i][j]!=0) {
                        System.out.print(" "+sudoku[i][j]+" |");
                    } else {
                        System.out.print("   |");
                    }
                }
            }
            System.out.println("");
            if ((i+1)%2==0){
                System.out.println("+---+---+---+---+");
            } else {
                System.out.println("+--- ---+--- ---+");
            }

        }
    }

    public void printSudoku(int[][] sudoku){
        System.out.println("+---+---+---+---+");
        for(int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if(j==0){
                    if (sudoku[i][j]!= 0) {
                        System.out.print("| "+sudoku[i][j]+" |");
                    } else {
                        System.out.print("|   |");
                    }
                } else {
                    if (sudoku[i][j]!=0) {
                        System.out.print(" "+sudoku[i][j]+" |");
                    } else {
                        System.out.print("   |");
                    }
                }
            }
            System.out.println("");
            if ((i+1)%2==0){
                System.out.println("+---+---+---+---+");
            } else {
                System.out.println("+--- ---+--- ---+");
            }

        }
    }

    public void copiarSudoku(int sudoku1[][]){
        for(int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                this.sudoku[i][j] = sudoku1[i][j];
            }
        }
    }
    public boolean rellenar (int sudoku1[][], int celda){
        if (celda ==16){
            copiarSudoku(sudoku1);
            return true;
        }
        int fila=celda/4;
        int col = celda %4;
        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            numeros.add(i);
        }
        Collections.shuffle(numeros);
        for (Integer num: numeros){
            if (!noCoincideFila(fila, col, num) && !noCoincideCol(fila, col, num) && !noCoincideCuadrante(fila, col, num)){
                sudoku1[fila][col]=num;
                rellenar(sudoku1, celda+1);
            }
        }
        return false;
    }

    public boolean noCoincideFila (int fila, int col, Integer num){
        for(int i=0; i<col; i++){
            if (sudoku[fila][i]==num){
                return true;
            }
        }
        return false;
    }

    public boolean noCoincideCol (int fila, int col, Integer num){
        for(int i=0; i<fila; i++){
            if (sudoku[i][col]==num){
                return true;
            }
        }
        return false;
    }

    public boolean noCoincideCuadrante (int fila, int col, Integer num){
        int cuadranteFila = fila/2;
        int cuadranteColumna = col/2;
        for(int i=cuadranteFila*2; i<(cuadranteFila*2)+2; i++){
            for(int j=cuadranteColumna*2; j<(cuadranteColumna*2)+2; j++){
                if (sudoku[i][j]==0) {
                    return false;
                }
                if (sudoku[i][j]==num){
                    return true;
                }
            }
        }
        return false;
    }
}
