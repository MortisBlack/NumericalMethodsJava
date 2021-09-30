
package invirtematriz;

import java.util.Scanner;

public class InvirteMatriz {
        
        public static void gaussJordan(float[][] matrix) {

        System.out.println("Matriz inicial:");

        System.out.printf("| %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[0][0], matrix[0][1], matrix[0][2], matrix[0][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[1][0], matrix[1][1], matrix[1][2], matrix[1][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[2][0], matrix[2][1], matrix[2][2], matrix[2][3]);
        System.out.println("");
        
        System.out.println("Se amplia la amtriz incial:");
        
        ampliarMatriz(matrix);
        
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[0][0], matrix[0][1], matrix[0][2], matrix[0][4], matrix[0][5], matrix[0][6], matrix[0][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[1][0], matrix[1][1], matrix[1][2], matrix[1][4], matrix[1][5], matrix[1][6], matrix[1][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[2][0], matrix[2][1], matrix[2][2], matrix[2][4], matrix[2][5], matrix[2][6], matrix[2][3]);
        System.out.println("");

        divicion(matrix, 0, 0);
        System.out.println("División de la fila " + 1);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[0][0], matrix[0][1], matrix[0][2], matrix[0][4], matrix[0][5], matrix[0][6], matrix[0][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[1][0], matrix[1][1], matrix[1][2], matrix[1][4], matrix[1][5], matrix[1][6], matrix[1][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[2][0], matrix[2][1], matrix[2][2], matrix[2][4], matrix[2][5], matrix[2][6], matrix[2][3]);
        System.out.println("");

        operacion(matrix, 1, 0);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[0][0], matrix[0][1], matrix[0][2], matrix[0][4], matrix[0][5], matrix[0][6], matrix[0][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[1][0], matrix[1][1], matrix[1][2], matrix[1][4], matrix[1][5], matrix[1][6], matrix[1][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[2][0], matrix[2][1], matrix[2][2], matrix[2][4], matrix[2][5], matrix[2][6], matrix[2][3]);
        System.out.println("");

        operacion(matrix, 2, 0);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[0][0], matrix[0][1], matrix[0][2], matrix[0][4], matrix[0][5], matrix[0][6], matrix[0][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[1][0], matrix[1][1], matrix[1][2], matrix[1][4], matrix[1][5], matrix[1][6], matrix[1][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[2][0], matrix[2][1], matrix[2][2], matrix[2][4], matrix[2][5], matrix[2][6], matrix[2][3]);
        System.out.println("");
        
        divicion(matrix, 1, 1);
        System.out.println("División de la fila " + 2);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[0][0], matrix[0][1], matrix[0][2], matrix[0][4], matrix[0][5], matrix[0][6], matrix[0][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[1][0], matrix[1][1], matrix[1][2], matrix[1][4], matrix[1][5], matrix[1][6], matrix[1][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[2][0], matrix[2][1], matrix[2][2], matrix[2][4], matrix[2][5], matrix[2][6], matrix[2][3]);
        System.out.println("");
        
        operacion(matrix, 2, 1);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[0][0], matrix[0][1], matrix[0][2], matrix[0][4], matrix[0][5], matrix[0][6], matrix[0][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[1][0], matrix[1][1], matrix[1][2], matrix[1][4], matrix[1][5], matrix[1][6], matrix[1][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[2][0], matrix[2][1], matrix[2][2], matrix[2][4], matrix[2][5], matrix[2][6], matrix[2][3]);
        System.out.println("");
        
        divicion(matrix, 2, 2);
        System.out.println("División de la fila " + 3);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[0][0], matrix[0][1], matrix[0][2], matrix[0][4], matrix[0][5], matrix[0][6], matrix[0][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[1][0], matrix[1][1], matrix[1][2], matrix[1][4], matrix[1][5], matrix[1][6], matrix[1][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[2][0], matrix[2][1], matrix[2][2], matrix[2][4], matrix[2][5], matrix[2][6], matrix[2][3]);
        System.out.println("");
        
        operacion(matrix, 1, 2);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[0][0], matrix[0][1], matrix[0][2], matrix[0][4], matrix[0][5], matrix[0][6], matrix[0][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[1][0], matrix[1][1], matrix[1][2], matrix[1][4], matrix[1][5], matrix[1][6], matrix[1][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[2][0], matrix[2][1], matrix[2][2], matrix[2][4], matrix[2][5], matrix[2][6], matrix[2][3]);
        System.out.println("");
        
        operacion(matrix, 0, 2);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[0][0], matrix[0][1], matrix[0][2], matrix[0][4], matrix[0][5], matrix[0][6], matrix[0][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[1][0], matrix[1][1], matrix[1][2], matrix[1][4], matrix[1][5], matrix[1][6], matrix[1][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[2][0], matrix[2][1], matrix[2][2], matrix[2][4], matrix[2][5], matrix[2][6], matrix[2][3]);
        System.out.println("");
        
        operacion(matrix, 0, 1);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[0][0], matrix[0][1], matrix[0][2], matrix[0][4], matrix[0][5], matrix[0][6], matrix[0][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[1][0], matrix[1][1], matrix[1][2], matrix[1][4], matrix[1][5], matrix[1][6], matrix[1][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[2][0], matrix[2][1], matrix[2][2], matrix[2][4], matrix[2][5], matrix[2][6], matrix[2][3]);
        System.out.println("");
        
        despliegaMatriz(matrix);
        
        despliegaSolucion(matrix);
    }
        
    public static void divicion(float[][] matrix, int fila, int pos) {
        float div = 1f / matrix[fila][pos];
        for (int i = 0; i < matrix.length + 4; i++) {
            matrix[fila][i] = matrix[fila][i] * div;
        }
    }
    
    public static void operacion(float[][] matrix, int fila, int posi) {
        if (fila == 1 && posi == 0) {
            float mul = matrix[fila][posi];
            for (int i = 0; i < matrix.length + 4; i++) {
                matrix[fila][i] = matrix[fila][i] - (mul * matrix[fila - 1][i]);
            }
        }
        if (fila == 2 && posi == 0) {
            float mul = matrix[fila][posi];
            for (int i = 0; i < matrix.length + 4; i++) {
                matrix[fila][i] = matrix[fila][i] - (mul * matrix[fila - 2][i]);
            }
        }
        if (fila == 2 && posi == 1) {
            float mul = matrix[fila][posi];
            for (int i = 0; i < matrix.length + 4; i++) {
                matrix[fila][i] = matrix[fila][i] - (mul * matrix[fila - 1][i]);
            }
        }
        
        if (fila == 1 && posi == 2) {
            float mul = matrix[fila][posi];
            for (int i = 0; i < matrix.length + 4; i++) {
                matrix[fila][i] = matrix[fila][i] - (mul * matrix[fila + 1][i]);
            }
        }
        
        if (fila == 0 && posi == 2) {
            float mul = matrix[fila][posi];
            for (int i = 0; i < matrix.length + 4; i++) {
                matrix[fila][i] = matrix[fila][i] - (mul * matrix[fila + 2][i]);
            }
        }
        
        if (fila == 0 && posi == 1) {
            float mul = matrix[fila][posi];
            for (int i = 0; i < matrix.length + 4; i++) {
                matrix[fila][i] = matrix[fila][i] - (mul * matrix[fila + 1][i]);
            }
        }               
    }
    
    public static void despliegaMatriz(float[][] matrix){
        System.out.println("-----------------------------");
        System.out.println("");
        
        System.out.println("La matriz invertida del sistema de ecuaciones dado es:");
        System.out.printf("| %8.4f  %8.4f %8.4f |\n", matrix[0][4], matrix[0][5], matrix[0][6]);
        System.out.printf("| %8.4f  %8.4f %8.4f |\n", matrix[1][4], matrix[1][5], matrix[1][6]);
        System.out.printf("| %8.4f  %8.4f %8.4f |\n", matrix[2][4], matrix[2][5], matrix[2][6]);
        System.out.println("");
    }
    
    public static void despliegaSolucion(float[][] matrix){
        System.out.println("-----------------------------");
        System.out.println("");
        System.out.printf("Las respuestas del sistema de ecuaciones dado son:\n"
                + "x1 = %8.4f\nx2 = %8.4f\nx3 = %8.4f\n", matrix[0][3], matrix[1][3], matrix[2][3]);
    }
    
    public static void ampliarMatriz( float[][] matrix){
        matrix[0][4] = 1f;
        matrix[0][5] = 0f;
        matrix[0][6] = 0f;
        
        matrix[1][4] = 0f;
        matrix[1][5] = 1f;
        matrix[1][6] = 0f;
        
        matrix[2][4] = 0f;
        matrix[2][5] = 0f;
        matrix[2][6] = 1f;
    }
    
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        float[][] matrix = new float[3][7];
        
        System.out.println("");
        System.out.println("Ingrese los valores de la primer ecuación");
        System.out.print("X1 -> "); matrix[0][0] = scr.nextFloat();
        System.out.print("X2 -> "); matrix[0][1] = scr.nextFloat();
        System.out.print("X3 -> "); matrix[0][2] = scr.nextFloat();
        System.out.print("=  -> "); matrix[0][3] = scr.nextFloat();

        System.out.println("");
        System.out.println("Ingrese los valores de la segunda ecuación");
        System.out.print("X1 -> "); matrix[1][0] = scr.nextFloat();
        System.out.print("X2 -> "); matrix[1][1] = scr.nextFloat();
        System.out.print("X3 -> "); matrix[1][2] = scr.nextFloat();
        System.out.print("=  -> "); matrix[1][3] = scr.nextFloat();

        System.out.println("");
        System.out.println("Ingrese los valores de la tercera ecuación");
        System.out.print("X1 -> "); matrix[2][0] = scr.nextFloat();
        System.out.print("X2 -> "); matrix[2][1] = scr.nextFloat();
        System.out.print("X3 -> "); matrix[2][2] = scr.nextFloat();
        System.out.print("=  -> "); matrix[2][3] = scr.nextFloat();
                       
        gaussJordan(matrix);
    }
    
}
