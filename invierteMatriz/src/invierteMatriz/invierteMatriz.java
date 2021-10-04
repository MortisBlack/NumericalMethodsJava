package invierteMatriz;

import java.util.Scanner;

public class invierteMatriz {

    public static double[][] leeMatriz() {
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

    public static void invertirMatriz(double[][] matriz) {

        System.out.println("Matriz inicial:");
        impresionSimple(matriz);
        System.out.println("");
        
        System.out.println("Se amplia la amtriz incial:");
        double[][] matrizAmp = ampliaMatriz(matriz);
        impresionAmpliada(matrizAmp);
        System.out.println("");
        
        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Pivoteo columna " + (i + 1) + ":");
            pivotea(matrizAmp, i);
            impresionAmpliada(matrizAmp);
            System.out.println("");

            eliminacionAbajo(matrizAmp, i);
        }
        int aux = matriz[0].length - 2;
        
        for (int i = matriz.length - 2; i > -1; i--) {
            eliminacionArriba(matrizAmp, i, aux);
            aux--;
        }
        
        despliegaMatriz(matrizAmp);
        
        despliegaSolucion(matrizAmp);
    }

    public static void pivotea(double[][] matriz, int columna) {
        double[][] aux = new double[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                aux[i][j] = matriz[i][j];
            }
        }

        for (int i = columna; i < matriz.length - 1; i++) {
            if (matriz[i][columna] < matriz[i + 1][columna]) {
                for (int j = 0; j < matriz[i].length; j++) {
                    matriz[i][j] = aux[i + 1][j];
                    matriz[i + 1][j] = aux[i][j];
                }
                pivotea(matriz, columna);
            }
        }
    }
    
    public static double[][] ampliaMatriz(double[][] matriz){
        double[][] matrizAmp = new double[matriz.length][(matriz.length * 2) + 1];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length - 1; j++) {
                matrizAmp[i][j] = matriz[i][j];
            }
        }
        
        for (int i = 0; i < matrizAmp.length; i++) {
            for (int j = matriz[i].length; j < matrizAmp[i].length; j++) {
                matrizAmp[i][j-1] = (i) == (j - matriz[i].length) ? 1 : 0 ;
            }
            matrizAmp[i][matrizAmp[i].length - 1] = matriz[i][matriz[i].length - 1];
        }
        
        return matrizAmp;
    }

    public static void impresionSimple(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matriz[i].length - 2; j++) {
                System.out.printf("(%10.4f) + ", matriz[i][j]);
            }
            System.out.printf(" (%10.4f) | = | (%10.4f) |\n", matriz[i][matriz[i].length - 2], matriz[i][matriz[i].length - 1]);
        }
    }

    public static void impresionAmpliada(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("| ");
            
            for (int j = 0; j < (matriz[i].length / 2 - 1); j++) {
                System.out.printf("(%10.4f) + ", matriz[i][j]);
            }
            
            System.out.printf("(%10.4f) | ", matriz[i][(matriz[i].length / 2) - 1]);
            
            for (int j = (matriz[i].length / 2); j < matriz[i].length - 2; j++) {
                System.out.printf("(%10.4f) + ", matriz[i][j]);
            }
            
            System.out.printf(" (%10.4f) | = | (%10.4f) |\n", matriz[i][matriz[i].length - 2], matriz[i][matriz[i].length - 1]);
        }
    }
    
    public static void eliminacionAbajo(double[][] matriz, int fila) {
        double div01 = 0;
        double div02 = 0;

        for (int i = fila; i < matriz.length; i++) {
            if (i == fila) {
                div01 = 1 / matriz[fila][fila];
                for (int j = 0; j < matriz[i].length; j++) {
                    matriz[i][j] = matriz[i][j] * div01;
                }
            } else {
                div02 = matriz[i][fila];
                for (int j = 0; j < matriz[i].length; j++) {
                    matriz[i][j] = matriz[i][j] - (div02 * matriz[fila][j]);
                }
            }
            impresionAmpliada(matriz);
            System.out.println("");
        }
    }

    public static void eliminacionArriba(double[][] matriz, int fila, int aux) {
        double div = 0;
        
        
        for (int i = fila; i > -1; i--) {
            div = matriz[i][aux];
           
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = matriz[i][j] - (div * matriz[fila+1][j]);
            }
            
            impresionAmpliada(matriz);
            System.out.println("");
        }
        
    }

    public static void despliegaMatriz(double[][] matriz) {
        System.out.println("La matriz invertida del sistema de ecuaciones dado es:");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("| ");
            for (int j = (matriz[i].length / 2); j < matriz[i].length - 2; j++) {
                System.out.printf("(%10.4f) + ", matriz[i][j]);
            }
            
            System.out.printf(" (%10.4f) |\n", matriz[i][matriz[i].length - 2]);
        }
    }
    
    public static void despliegaSolucion(double[][] matriz) {
        System.out.println("Las respuestas del sistema de ecuaciones dado son:");
        for (int i = 0; i < matriz.length - 1; i++) {
            System.out.printf("x%s:  (%10.4f)\n", i+1 ,matriz[i][matriz[i].length - 1]);
        }
        System.out.printf("x%s:  (%10.4f)\n",matriz.length, matriz[matriz.length-1][matriz[0].length - 1]);
    }

    public static void main(String[] args) {
        double[][] matriz = new double[3][4];
        invertirMatriz(matriz);
    }

}
