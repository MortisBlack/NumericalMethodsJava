package interpolacionlagrange;

import java.util.Scanner;

public class InterpolacionLagrange {


    public static void leePuntos() {
        Scanner scn = new Scanner(System.in);
        
        double[][] puntos;
        double abscisa;
        int grado;
        boolean flag;
        
        System.out.println("Ingrese el valor de la abscisa:");
        System.out.print("> "); 
        abscisa = scn.nextDouble();
        System.out.println("");
        
        do {
            flag = true;
            System.out.println("Ingrese el grado del polinomio (Máximo 10):");
            System.out.print("> "); 
            grado = scn.nextInt();
            System.out.println("");
            
            if (grado >10) {
                System.out.println("Grado incorrecto (Máximo 10).");
                flag = false;
            }
        } while (!flag);
        
        puntos = new double[grado][2];
        
        for (int i = 0; i < puntos.length; i++) {
            System.out.println("Ingrese el valor de X del punto numero " + (i + 1));
            System.out.print("> ");
            puntos[i][0] = scn.nextDouble();
            System.out.println("Ingrese el valor de Y del punto numero " + (i + 1));
            System.out.print("> ");
            puntos[i][1] = scn.nextDouble();
            System.out.println("");
        }
        
        interpolacionlagrange(puntos, abscisa);
    }
    
    public static void interpolacionlagrange(double[][] puntos, double abscisa) {        
        double grado = 0;
        
        double arriba;
        double abajo;
        
        for (int i = 0; i < puntos.length; i++) {
            
            arriba = 1;
            abajo = 1;
            
            // linea de arriba
            for (int j = 0; j < puntos.length; j++) {
                if(i != j) {
                    arriba *= abscisa - puntos[j][0];
                }
            }
            
            // linea de abajo
            for (int j = 0; j < puntos.length; j++) {
                if(i != j) {
                    abajo *= puntos[i][0] - puntos[j][0];
                }
            }
            
            grado += ((arriba / abajo) * puntos[i][1]); 
        }
        
        despliegaSolucion(grado, abscisa);
    }
    
    public static void despliegaSolucion(double grado, double abscisa){
        System.out.printf("La solución para el punto X = %.6f según los datos ingresados es:\n", abscisa);
        System.out.printf("%1c(%.6f) = %.6f\n",'\u0192',  abscisa, grado);
    }
    
    public static void main(String[] args) {     
        leePuntos();
    }
}
