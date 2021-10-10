package gaussseidel;

import java.util.Scanner;

public class GaussSeidel {

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
            for (int j = 0; j < matriz[i].length - 1; j++) {
                System.out.printf("Ingrese el valor del coeficiente X%2s:\n", i + 1);
                matriz[i][j] = scr.nextDouble();
            }
            System.out.println("Ingrese el valor del término independiente:");
            matriz[i][matriz[i].length - 1] = scr.nextDouble();
            System.out.println("");
        }
        return matriz;
    }

    public static void GaussSeidel(double[][] matriz) {

        System.out.println("Sistema de ecuaciones lineales simultáneas indicado inicial:");
        impresionInicial(matriz);
        System.out.println("");

        double[] soluciones = new double[matriz.length];
        double suma;
        double[] div = new double[matriz.length];
        double[] ea = new double[matriz.length];
        double eaAux = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length - 1; j++) {
                if (i == j) {
                    div[i] = matriz[i][j];
                }
            }
        }

        boolean flag = false;

        impresionCabecera(soluciones);

        while (!flag) {
            for (int i = 0; i < matriz.length; i++) {
                suma = 0;
                eaAux = soluciones[i];
                for (int j = 0; j < matriz[i].length - 1; j++) {
                    if (i != j) {
                        suma += (matriz[i][j] * -1) * soluciones[j];
                    }
                }
                soluciones[i] = (matriz[i][matriz[i].length - 1] + suma) / div[i];
                ea[i] = (soluciones[i] - eaAux) / soluciones[i];
            }

            impresionLineas(soluciones, ea);

            for (int i = 0; i < ea.length + 1; i++) {
                if ((i) == ea.length) {
                    flag = true;
                } else if (Math.abs(ea[i]) > Math.abs(0.0001)) {
                    break;
                }
            }
        }
        System.out.println("");

        despliegaSolucion(soluciones);
    }

    public static void impresionInicial(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matriz[i].length - 2; j++) {
                System.out.printf("(%10.4f) X%2s + ", matriz[i][j], (j + 1));
            }
            System.out.printf("(%10.4f) X%2s ", matriz[i][matriz[i].length - 2], matriz[i].length - 1);
            System.out.printf("| = | (%10.4f) |\n", matriz[i][matriz[i].length - 1]);
        }
    }

    public static void impresionCabecera(double[] soluciones) {
        System.out.printf("%6sX%2s", " ", (1));
        for (int i = 1; i < soluciones.length; i++) {
            System.out.printf("%10sX%2s", " ", (i + 1));
        }
        for (int i = 0; i < soluciones.length - 1; i++) {
            System.out.printf("%9sEa%2s", " ", (i + 1));
        }
        System.out.printf("%9sEa%2s\n", " ", (soluciones.length));

        for (int i = 0; i < soluciones.length - 1; i++) {
            System.out.printf("%10.4f   ", soluciones[i]);
        }
        System.out.printf("%10.4f\n", soluciones[soluciones.length - 1]);
    }

    public static void impresionLineas(double[] soluciones, double[] ea) {
        for (int i = 0; i < soluciones.length; i++) {
            System.out.printf("%10.4f   ", soluciones[i]);
        }
        for (int i = 0; i < ea.length - 1; i++) {
            System.out.printf("%10.4f   ", ea[i]);
        }
        System.out.printf("%10.4f\n", ea[ea.length - 1]);
    }

    public static void despliegaSolucion(double[] soluciones) {
        System.out.println("Las soluciones del sistema de ecuaciones simultáneas es: ");
        for (int i = 0; i < soluciones.length; i++) {
            System.out.printf("X%2s = %10.4f |\n", (i + 1), soluciones[i]);
        }
    }

    public static void main(String[] args) {
        double[][] matriz = leeEcuaciones();
        GaussSeidel(matriz);
    }

}
