package com.example.sudoku_generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utilities.Celda;
import utilities.ProcesamientoSudoku;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        Celda[][] sudoku = new Celda[9][9];
        ProcesamientoSudoku proc = new ProcesamientoSudoku(sudoku);
        proc.rellenarPrimeraFila();
        proc.rellenarSegundaColumna();
        proc.rellenarTerceraColumna();
        proc.printSudoku();

	}

}
