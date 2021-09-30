/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaussjordan;

/**
 *
 * @author Mortis
 */
public class Jordan {
    
    public double[] gaussJordan3(double[][] matrix) {
        
        System.out.println("Matriz inicial:\n");
        impresion3(matrix);
        
        divicion(matrix, 0, 0);
        System.out.println("División de la fila " + 1);
        System.out.println("");
        impresion3(matrix);
        
        operacion(matrix, 1, 0);
        impresion3(matrix);
        
        operacion(matrix, 2, 0);
        impresion3(matrix);
        
        divicion(matrix, 1, 1);
        System.out.println("División de la fila " + 2);
        System.out.println("");
        impresion3(matrix);
        
        operacion(matrix, 2, 1);
        impresion3(matrix);
        
        divicion(matrix, 2, 2);
        System.out.println("División de la fila " + 3);
        System.out.println("");
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
    
    public double[] gaussJordan4(double[][] matrix) {
        System.out.println("Matriz inicial:\n");
        impresion4(matrix);
        
        divicion(matrix, 0, 0);
        System.out.println("División de la fila 1");
        System.out.println("");
        impresion4(matrix);
        
        operacion(matrix, 1, 0);
        impresion4(matrix);
        
        operacion(matrix, 2, 0);
        impresion4(matrix);
        
        operacion(matrix, 3, 0);
        impresion4(matrix);
        
        divicion(matrix, 1, 1);
        System.out.println("División de la fila 2");
        System.out.println("");
        impresion4(matrix);
        
        operacion(matrix, 2, 1);
        impresion4(matrix);
        
        operacion(matrix, 3, 1);
        impresion4(matrix);
        
        divicion(matrix, 2, 2);
        System.out.println("División de la fila 3");
        System.out.println("");
        impresion4(matrix);
        
        operacion(matrix, 3, 2);
        impresion4(matrix);
        
        divicion(matrix, 3, 3);
        System.out.println("División de la fila 4");
        System.out.println("");
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
    
    public void impresion3(double[][] matrix){
        System.out.printf("| %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[0][0], matrix[0][1], matrix[0][2], matrix[0][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[1][0], matrix[1][1], matrix[1][2], matrix[1][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[2][0], matrix[2][1], matrix[2][2], matrix[2][3]);
        System.out.println("");
    }
    
    public void impresion4(double[][] matrix){
        System.out.printf("| %12.4f  %12.4f %12.4f %12.4f | = | %12.4f |\n", matrix[0][0], matrix[0][1], matrix[0][2], matrix[0][3], matrix[0][4]);
        System.out.printf("| %12.4f  %12.4f %12.4f %12.4f | = | %12.4f |\n", matrix[1][0], matrix[1][1], matrix[1][2], matrix[1][3], matrix[1][4]);
        System.out.printf("| %12.4f  %12.4f %12.4f %12.4f | = | %12.4f |\n", matrix[2][0], matrix[2][1], matrix[2][2], matrix[2][3], matrix[2][4]);
        System.out.printf("| %12.4f  %12.4f %12.4f %12.4f | = | %12.4f |\n", matrix[3][0], matrix[3][1], matrix[3][2], matrix[3][3], matrix[3][4]);
        System.out.println("");
    }
    
    /**
     * Método que se encarga de volver 1 el valor de un numero dentro de la matriz según la teoria de Gauss-Jordan
     * @param matrix arreglo bidimensional con los datos de la matriz
     * @param fila fila que se va a dividir
     * @param pos posición dentro de la matriz que se va a volver 1
     */
    public void divicion(double[][] matrix, int fila, int pos) {
        double div = 1f / matrix[fila][pos];
        for (int i = 0; i < matrix.length + 1; i++) {
            matrix[fila][i] = matrix[fila][i] * div;
        }
    }

    /**
     * Método que se encarga de realizar las operaciones necesarias para calcular los nuevos valores de la matriz
     * @param matrix arreglo bidimensional con los datos de la matriz
     * @param fila la fila que se va a calcular
     * @param posi posición dentro de la matriz que se va a volver 0
     */
    public void operacion(double[][] matrix, int fila, int posi) {
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
    
    /**
     * Método que despliega la solución del sistema de ecuaciones dado
     * @param matrix arreglo bidimensional que contiene los datos de la respuesta
     */
    public void despliegaSolucion3(double[][] matrix){
        System.out.println("-----------------------------");
        System.out.println("");
        System.out.printf("Las respuestas del sistema de ecuaciones dado son:\n\n"
                + "a0 = %8.4f\na1 = %8.4f\na2 = %8.4f\n", matrix[0][3], matrix[1][3], matrix[2][3]);
    }
    
    public void despliegaSolucion4(double[][] matrix){
        System.out.println("-----------------------------");
        System.out.println("");
        System.out.printf("Las respuestas del sistema de ecuaciones dado son:\n\n"
                + "a0 = %12.4f\na1 = %12.4f\na2 = %12.4f\na3 = %12.4f\n", matrix[0][4], matrix[1][4], matrix[2][4], matrix[3][4]);
    }
}
