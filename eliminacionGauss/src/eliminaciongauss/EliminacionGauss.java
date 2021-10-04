
package eliminaciongauss;

import java.util.Scanner;

public class EliminacionGauss {

    public static double[][] leeEcuaciones() {
        Scanner scr = new Scanner(System.in);
        double[][] matriz;
        boolean flag = true;
        int ecuaciones = 0;

        System.out.println("¿Cuantas ecuaciones tiene el ejercicio? (máximo 10):");
        do {
            ecuaciones = scr.nextInt();
            if (ecuaciones <= 0 && ecuaciones >= 10) {
                System.out.println("Numero incorrecto, ingrese otro numero.");
            }
        } while (ecuaciones <= 0 && ecuaciones >= 10);

        matriz = new double[ecuaciones][ecuaciones + 1];

        System.out.println("");

        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Valores de la fila " + (i + 1) + ":");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("Ingrese el valor de la posición A[" + (i + 1) + "][" + (j + 1) + "]:");
                matriz[i][j] = scr.nextDouble();
            }
            System.out.println("");
        }
        return matriz;
    }

    public static void eliminacionGauss(double[][] matriz) {

        System.out.println("Matriz inicial:");
        impresion(matriz);
        System.out.println("");

        for (int i = 0; i < matriz.length - 1; i++) {
            System.out.println("Pivoteo columna "+ (i+1) +":");
            
            pivotea(matriz, i);
            impresion(matriz);
            System.out.println("");
            
            eliminacionAdelante(matriz, i);
        }
        
        sustitucionAtras(matriz);
    }

    public static void pivotea(double[][] matriz, int columna) {
        double[][] aux = new double[matriz.length][matriz[0].length];
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                aux[i][j] = matriz[i][j];
            }
        }
        
        for (int i = columna; i < matriz.length - 1; i++) {
            if(matriz[i][columna] < matriz[i + 1][columna]){
                for (int j = 0; j < matriz[i].length; j++) {
                    matriz[i][j] = aux[i + 1][j];
                    matriz[i+1][j] = aux[i][j];
                }
                pivotea(matriz, columna);
            }
        }
    }

    public static void impresion(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matriz[i].length - 1; j++) {
                System.out.printf("(%10.4f) + ", matriz[i][j]);
            }
            System.out.printf("| = | (%10.4f) |\n", matriz[i][matriz[i].length - 1]);
        }
    }

    public static void eliminacionAdelante(double[][] matriz, int fila) {
        System.out.println("Inicia eliminacion de la columna "+(fila+1)+":");
        for (int i = fila; i < matriz.length - 1; i++) {
            double div = matriz[i+1][fila] / matriz [fila][fila];
            for (int j = 0; j < matriz[i].length; j++) {                
                matriz[i+1][j] = matriz[i+1][j] - (div * matriz[fila][j]);
            }
            impresion(matriz);
            System.out.println("");
        }
        System.out.println("Finaliza eliminacion de la columna "+(fila+1));
        System.out.println("");
    }

    public static void sustitucionAtras(double[][] matriz) {
        double[] resultados = new double[matriz.length];
        double auxSuma = 0;
        double auxDiv = 0;
        
        for (int i = matriz.length - 1; i > -1; i--) {
            auxSuma = 0;
            auxDiv = 0;
            for (int j = 0; j < matriz[i].length - 1; j++) {
                if (resultados[j] != 0 && matriz[i][j] != 0) {
                    auxSuma += resultados[j] * matriz[i][j];
                } else if (resultados[j] == 0 && matriz[i][j] != 0){
                    auxDiv = matriz[i][j];
                }
            }
            resultados[i] = (matriz[i][matriz.length] + (-1 * auxSuma)) / auxDiv;
        }
        despliegaSolucion(resultados);
    }
    
    public static void despliegaSolucion(double[] resultados) {
        System.out.println("Las respuestas del sistema de ecuaciones dado son:");
        for (int i = 0; i < resultados.length; i++) {
            System.out.printf("El resultado de x"+(i+1)+" es: %10.4f\n", resultados[i]);
        }
    }

    public static void main(String[] args) {
        double[][] matriz = leeEcuaciones();
        eliminacionGauss(matriz);
    }
}
