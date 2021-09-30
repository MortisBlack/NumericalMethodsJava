package interpolacionlagrange;

import java.util.Scanner;

public class InterpolacionLagrange {


    public static double[][] leePuntos() {
        Scanner scn = new Scanner(System.in);

        double[][] puntos = new double[4][2];

        for (int i = 0; i < puntos.length; i++) {
            System.out.println("Ingrese el valor de X del punto numero " + (i + 1));
            System.out.print("> ");
            puntos[i][0] = scn.nextDouble();
            System.out.println("");

            System.out.println("Ingrese el valor de Y del punto numero " + (i + 1));
            System.out.print("> ");
            puntos[i][1] = scn.nextDouble();
            System.out.println("");
        }
        
        return puntos;
    }
    
    public static double[] interpolacionlagrange(double[][] puntos) {
        Scanner scn = new Scanner(System.in);
        
        System.out.println("Ingrese el valor de X que desea interpolar:");
        System.out.print("> ");
        double x  = scn.nextDouble();
        System.out.println("");

        double aux;
        double arriba = 1;
        double abajo = 1;
        double total = 0;

        for (int i = 0; i < puntos.length; i++) {
            aux = puntos[i][0];

            arriba = 1;
            abajo = 1;
            for (int j = 0; j < puntos.length; j++) {
                if (puntos[j][0] != aux) {
                    // Linea de arriba en la división
                    arriba = arriba * (x - puntos[j][0]);
                    
                    // Linea de abajo en la división
                    abajo = abajo * (aux - puntos[j][0]);
                }
            }            
            total = puntos[i][1] * (arriba / abajo) + total;
        }
        
        double[] datos = new double[2];
        
        // La ordenada del punto a interpolar
        datos[0] = total;
        
        // El punto a interpolar
        datos[1] = x;
        return datos;
    }
    
    public static void despliegaSolucion(double[] solucion){
        System.out.printf("La abscisa para el punto X = %.6f según los datos ingresados es:\n", solucion[1]);
        System.out.printf("%1c(%.6f) = %.6f\n",'\u0192',  solucion[1], solucion[0]);
    }
    
    public static void main(String[] args) {
        
        double puntos[][] = leePuntos();
        double[] datos = interpolacionlagrange(puntos);
        despliegaSolucion(datos);
    }

}
