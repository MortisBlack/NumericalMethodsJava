
package gaussjordan;

import java.util.Scanner;

public class GaussJordan {
    
    public static double[] gaussJordan3(double[][] matrix) {
        System.out.println("Matriz inicial:\n");
        impresion3(matrix);
        
        divicion(matrix, 0, 0);
        System.out.println("División de la fila " + 1);
        impresion3(matrix);
        
        operacion(matrix, 1, 0);
        impresion3(matrix);
        
        operacion(matrix, 2, 0);
        impresion3(matrix);
        
        divicion(matrix, 1, 1);
        System.out.println("División de la fila " + 2);
        impresion3(matrix);
        
        operacion(matrix, 2, 1);
        impresion3(matrix);
        
        divicion(matrix, 2, 2);
        System.out.println("División de la fila " + 3);
        impresion3(matrix);
        
        operacion(matrix, 1, 2);
        impresion3(matrix);
        
        operacion(matrix, 0, 2);
        impresion3(matrix);
        
        operacion(matrix, 0, 1);
        impresion3(matrix);

        despliegaSolucion3(matrix);
        
        double[] soluciones = new double [3];
        soluciones[0] = matrix[0][3];
        soluciones[1] = matrix[1][3];
        soluciones[2] = matrix[2][3];
        
        return soluciones;
    }
    
    public static double[] gaussJordan4(double[][] matrix) {
        System.out.println("Matriz inicial:\n");
        impresion4(matrix);
        
        divicion(matrix, 0, 0);
        System.out.println("División de la fila 1");
        impresion4(matrix);
        
        operacion(matrix, 1, 0);
        impresion4(matrix);
        
        operacion(matrix, 2, 0);
        impresion4(matrix);
        
        operacion(matrix, 3, 0);
        impresion4(matrix);
        
        divicion(matrix, 1, 1);
        System.out.println("División de la fila 2");
        impresion4(matrix);
        
        operacion(matrix, 2, 1);
        impresion4(matrix);
        
        operacion(matrix, 3, 1);
        impresion4(matrix);
        
        divicion(matrix, 2, 2);
        System.out.println("División de la fila 3");
        impresion4(matrix);
        
        operacion(matrix, 3, 2);
        impresion4(matrix);
        
        divicion(matrix, 3, 3);
        System.out.println("División de la fila 4");
        impresion4(matrix);
        
        operacion(matrix, 3, 3);
        impresion4(matrix);
        
        operacion(matrix, 2, 3);
        impresion4(matrix);
        
        operacion(matrix, 1, 3);
        impresion4(matrix);
        
        operacion(matrix, 0, 3);
        impresion4(matrix);

        operacion(matrix, 1, 2);
        impresion4(matrix);
        
        operacion(matrix, 0, 2);
        impresion4(matrix);
        
        operacion(matrix, 0, 1);
        impresion4(matrix);
        
        despliegaSolucion4(matrix);
        
        double[] soluciones = new double [4];
        soluciones[0] = matrix[0][4];
        soluciones[1] = matrix[1][4];
        soluciones[2] = matrix[2][4];
        soluciones[3] = matrix[3][4];
        
        return soluciones;
    }
    
    public static void impresion3(double[][] matrix){
        System.out.printf("| %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[0][0], matrix[0][1], matrix[0][2], matrix[0][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[1][0], matrix[1][1], matrix[1][2], matrix[1][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[2][0], matrix[2][1], matrix[2][2], matrix[2][3]);
        System.out.println("");
    }
    
    public static void impresion4(double[][] matrix){
        System.out.printf("| %12.4f  %12.4f %12.4f %12.4f | = | %12.4f |\n", matrix[0][0], matrix[0][1], matrix[0][2], matrix[0][3], matrix[0][4]);
        System.out.printf("| %12.4f  %12.4f %12.4f %12.4f | = | %12.4f |\n", matrix[1][0], matrix[1][1], matrix[1][2], matrix[1][3], matrix[1][4]);
        System.out.printf("| %12.4f  %12.4f %12.4f %12.4f | = | %12.4f |\n", matrix[2][0], matrix[2][1], matrix[2][2], matrix[2][3], matrix[2][4]);
        System.out.printf("| %12.4f  %12.4f %12.4f %12.4f | = | %12.4f |\n", matrix[3][0], matrix[3][1], matrix[3][2], matrix[3][3], matrix[3][4]);
        System.out.println("");
    }
    
    public static void divicion(double[][] matrix, int fila, int pos) {
        double div = 1f / matrix[fila][pos];
        for (int i = 0; i < matrix.length + 1; i++) {
            matrix[fila][i] = matrix[fila][i] * div;
        }
    }

    public static void operacion(double[][] matrix, int fila, int posi) {
        if (fila == 1 && posi == 0) {
            double mul = matrix[fila][posi];
            for (int i = 0; i < matrix.length + 1; i++) {
                matrix[fila][i] = matrix[fila][i] - (mul * matrix[fila - 1][i]);
            }
        }
        if (fila == 2 && posi == 0) {
            double mul = matrix[fila][posi];
            for (int i = 0; i < matrix.length + 1; i++) {
                matrix[fila][i] = matrix[fila][i] - (mul * matrix[fila - 2][i]);
            }
        }
        if (fila == 3 && posi == 0) {
            double mul = matrix[fila][posi];
            for (int i = 0; i < matrix.length + 1; i++) {
                matrix[fila][i] = matrix[fila][i] - (mul * matrix[fila - 3][i]);
            }
        }
        if (fila == 2 && posi == 1) {
            double mul = matrix[fila][posi];
            for (int i = 0; i < matrix.length + 1; i++) {
                matrix[fila][i] = matrix[fila][i] - (mul * matrix[fila - 1][i]);
            }
        }
        if (fila == 3 && posi == 1) {
            double mul = matrix[fila][posi];
            for (int i = 0; i < matrix.length + 1; i++) {
                matrix[fila][i] = matrix[fila][i] - (mul * matrix[fila - 2][i]);
            }
        }
        if (fila == 3 && posi == 2) {
            double mul = matrix[fila][posi];
            
            for (int i = 0; i < matrix.length + 1; i++) {
                matrix[fila][i] = matrix[fila][i] - (mul * matrix[fila - 1][i]);
            }
        }         
        if (fila == 1 && posi == 2) {
            double mul = matrix[fila][posi];
            for (int i = 0; i < matrix.length + 1; i++) {
                matrix[fila][i] = matrix[fila][i] - (mul * matrix[fila + 1][i]);
            }
        }
        
        if (fila == 0 && posi == 2) {
            double mul = matrix[fila][posi];
            System.out.println(mul);
            for (int i = 0; i < matrix.length + 1; i++) {
                matrix[fila][i] = matrix[fila][i] - (mul * matrix[fila + 2][i]);
            }
        }        
        if (fila == 0 && posi == 1) {
            double mul = matrix[fila][posi];
            for (int i = 0; i < matrix.length + 1; i++) {
                matrix[fila][i] = matrix[fila][i] - (mul * matrix[fila + 1][i]);
            }
        }        
        if (fila == 0 && posi == 3) {
            double mul = matrix[fila][posi];
            for (int i = 0; i < matrix.length + 1; i++) {
                matrix[fila][i] = matrix[fila][i] - (mul * matrix[fila + 3][i]);
            }
        }
        if (fila == 1 && posi == 3) {
            double mul = matrix[fila][posi];
            for (int i = 0; i < matrix.length + 1; i++) {
                matrix[fila][i] = matrix[fila][i] - (mul * matrix[fila + 2][i]);
            }
        }
        if (fila == 2 && posi == 3) {
            double mul = matrix[fila][posi];
            for (int i = 0; i < matrix.length + 1; i++) {
                matrix[fila][i] = matrix[fila][i] - (mul * matrix[fila + 1][i]);
            }
        }
    }
    

    public static void despliegaSolucion3(double[][] matrix){
        System.out.println("-----------------------------");
        System.out.println("");
        System.out.printf("Las respuestas del sistema de ecuaciones dado son:\n\n"
                + "x1 = %8.4f\nx2 = %8.4f\nx3 = %8.4f\n", matrix[0][3], matrix[1][3], matrix[2][3]);
    }
    
    public static void despliegaSolucion4(double[][] matrix){
        System.out.println("-----------------------------");
        System.out.println("");
        System.out.printf("Las respuestas del sistema de ecuaciones dado son:\n\n"
                + "x1 = %12.4f\nx2 = %12.4f\nx3 = %12.4f\nn4 = %12.4f\n", matrix[0][4], matrix[1][4], matrix[2][4], matrix[3][4]);
    }
    
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        double[][] matrix = new double[3][4];
        double[][] matrix2 = new double[4][5];
        /*
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

        System.out.println("");

        gaussJordan3(matrix);
        */
        
        /*
        matrix[0][0] = 2f;
        matrix[0][1] = 1f;
        matrix[0][2] = -1f;
        matrix[0][3] = 1f;
        
        matrix[1][0] = 5f;
        matrix[1][1] = 2f;
        matrix[1][2] = 2f;
        matrix[1][3] = -4f;
        
        matrix[2][0] = 3f;
        matrix[2][1] = 1f;
        matrix[2][2] = 1f;
        matrix[2][3] = 5f;
        
        
        
        matrix2[0][0] = 8f;
        matrix2[0][1] = 59f;
        matrix2[0][2] = 509f;
        matrix2[0][3] = 4859f;
        matrix2[0][4] = 26.4f;
        
        matrix2[1][0] = 59f;
        matrix2[1][1] = 509f;
        matrix2[1][2] = 4859f;
        matrix2[1][3] = 49397f;
        matrix2[1][4] = 204.8f;
        
        matrix2[2][0] = 509f;
        matrix2[2][1] = 4859f;
        matrix2[2][2] = 49397f;
        matrix2[2][3] = 522899f;
        matrix2[2][4] = 1838.4f;
        
        matrix2[3][0] = 4859f;
        matrix2[3][1] = 49397f;
        matrix2[3][2] = 522899f;
        matrix2[3][3] = 5689229f;
        matrix2[3][4] = 18164f;
        
        gaussJordan4(matrix2);
        
        gaussJordan3(matrix);
        */
    }
}
