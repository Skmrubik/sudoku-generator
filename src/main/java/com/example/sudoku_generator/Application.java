package com.example.sudoku_generator;

import com.example.sudoku_generator.utilities.Celda;
import com.example.sudoku_generator.utilities.ProcesamientoSudoku;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        ProcesamientoSudoku proc = new ProcesamientoSudoku();
        proc.rellenar(proc.getSudoku(),0);
        proc.printSudoku();

	}

}
