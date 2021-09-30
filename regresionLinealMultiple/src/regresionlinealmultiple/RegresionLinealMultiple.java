package regresionlinealmultiple;

import java.util.Scanner;
import gaussjordan.Jordan;
import java.util.ArrayList;

public class RegresionLinealMultiple {
    
    public static double[][] leePuntos(){
        Scanner scn = new Scanner(System.in);
        int num;
        
        boolean flag;
        
        do{
            flag = false;
            System.out.println("Indique la cantidad de puntos a usar (máximo 100): ");
            System.out.print("> "); num = scn.nextInt();
            System.out.println("");
            if(num > 100){
                System.out.println("Error: El número de puntos a usar no puede ser mayor que 100\n"
                        +          "       ingrese un nuevo valor.");
                System.out.println("");
                flag = true;
            }
            
            if(num <= 0){
                System.out.println("Error: El número de puntos a usar no puede ser menor que 1\n"
                        +          "       ingrese un nuevo valor.");
                System.out.println("");
                flag = true;
            }
        }while(flag);
        
        double[][] puntos = new double[3][num];
        
        for (int i = 0; i < num; i++) {
            System.out.println("Ingrese el valor de X1 del punto numero " + (i+1));
            System.out.print("> "); puntos[0][i] = scn.nextDouble();
            System.out.println("");
            
            System.out.println("Ingrese el valor de X2 del punto numero " + (i+1));
            System.out.print("> "); puntos[1][i] = scn.nextDouble();
            System.out.println("");
            
            System.out.println("Ingrese el valor de Y del punto numero " + (i+1));
            System.out.print("> "); puntos[2][i] = scn.nextDouble();
            System.out.println("");
        }
        
 
        return puntos;
    }
     
    public static ArrayList<Object> regresionLinealMultiple(double[][] puntos){
        ArrayList<Object> datos = new ArrayList();
        
        double[][] sumatorias = creaSumatorias(puntos);
        datos.add(sumatorias);
        
        imprimirSumatorias(sumatorias);
        
        
        double[][] matrix = creaMatrizSumatorias(sumatorias);
        datos.add(matrix);
        
        return datos;
    }
    
    public static double[][] creaSumatorias(double[][] puntos) {
        double[][] sumatorias = new double[8][(puntos[0].length) + 1];
        
        for (int i = 0; i < puntos[0].length; i++) {
            // X1
            sumatorias[0][i] = puntos[0][i];
            // X2
            sumatorias[1][i] = puntos[1][i];
            // Y
            sumatorias[2][i] = puntos[2][i];
            // X1 ^ 2
            sumatorias[3][i] = Math.pow(puntos[0][i], 2);
            // X2 ^ 2
            sumatorias[4][i] = Math.pow(puntos[1][i], 2);
            // X1 * X2
            sumatorias[5][i] = puntos[0][i] * puntos[1][i];
            // X1 * Y
            sumatorias[6][i] = puntos[0][i] * puntos[2][i];
            // X2 * Y
            sumatorias[7][i] = puntos[1][i] * puntos[2][i];
        }
        
        double aux;
        for (int i = 0; i < 8 ; i++) {
            aux = 0;
            for (int j = 0; j < puntos[0].length; j++) {
                aux = aux + sumatorias[i][j];
            }
            sumatorias[i][puntos[0].length] = aux;
        }
        
        return sumatorias;
    }
    
    public static void imprimirSumatorias(double[][] sumatorias) {
        System.out.println("Tabla con las sumatorias:");
        System.out.println("");
        System.out.printf("%18s %12s %11s %15s %12s %13s %11s %12s\n",
                "X1",
                "X2",
                "Y",
                "X1^2",
                "X2^2",
                "X1 * X2",
                "X1 * Y",
                "X2 * Y");
        
        for (int i = 0; i < (sumatorias[0].length) - 1; i++) {
            System.out.printf("%22.4f %12.4f %12.4f %12.4f %12.4f %12.4f %12.4f %12.4f\n", 
                    sumatorias[0][i],
                    sumatorias[1][i],
                    sumatorias[2][i],
                    sumatorias[3][i],
                    sumatorias[4][i],
                    sumatorias[5][i],
                    sumatorias[6][i],
                    sumatorias[7][i]);
        }
        System.out.printf("%7c = %12.4f %12.4f %12.4f %12.4f %12.4f %12.4f %12.4f %12.4f\n",
                    '\u03A3',
                    sumatorias[0][sumatorias[0].length - 1],
                    sumatorias[1][sumatorias[0].length - 1],
                    sumatorias[2][sumatorias[0].length - 1],
                    sumatorias[3][sumatorias[0].length - 1],
                    sumatorias[4][sumatorias[0].length - 1],
                    sumatorias[5][sumatorias[0].length - 1],
                    sumatorias[6][sumatorias[0].length - 1],
                    sumatorias[7][sumatorias[0].length - 1]);
        System.out.println("");
    }
    
    public static double[][] creaMatrizSumatorias(double[][] sumatorias){
        double[][] matrix = new double[3][4];
        
        // a11
        matrix[0][0] = sumatorias[0].length - 1;
        
        // a12
        matrix[0][1] = sumatorias[0][sumatorias[0].length - 1];

        // a13
        matrix[0][2] = sumatorias[1][sumatorias[0].length - 1];
        
        // a0
        matrix[0][3] = sumatorias[2][sumatorias[0].length - 1];
        
        
        // a21
        matrix[1][0] = sumatorias[0][sumatorias[0].length - 1];
        
        // a22
        matrix[1][1] = sumatorias[3][sumatorias[0].length - 1];

        // a23
        matrix[1][2] = sumatorias[5][sumatorias[0].length - 1];
        
        // a1
        matrix[1][3] = sumatorias[6][sumatorias[0].length - 1];
        
        
        // a31
        matrix[2][0] = sumatorias[1][sumatorias[0].length - 1];
        
        // a32
        matrix[2][1] = sumatorias[5][sumatorias[0].length - 1];

        // a33
        matrix[2][2] = sumatorias[4][sumatorias[0].length - 1];
        
        // a2
        matrix[2][3] = sumatorias[7][sumatorias[0].length - 1];
        
        
        return matrix;
    }
    
    public static double[] gaussJordan(double[][] matrix){
        Jordan jordan = new Jordan();
        return jordan.gaussJordan3(matrix);
    }
    
    public static void despliegaSolucion(double[][] sumatorias, double[] soluciones){
        double[][] puntos = new double[3][(sumatorias[0].length) - 1];
        
        System.out.println("");
        System.out.println("La formula para hayar los nuevos puntos es:");
        System.out.println("");
        System.out.printf("%12.4f + (%12.4f)x1 + (%12.4f)x2\n", soluciones[0], soluciones[1], soluciones[2]);
        System.out.println("");
        System.out.println("Teniendo en cuenta esto, los nuevos valores de los puntos en Y serian:");
        System.out.println("");
        
        for (int i = 0; i < (sumatorias[0].length) - 1; i++) {
            puntos[0][i] = sumatorias[0][i];
            puntos[1][i] = sumatorias[0][i];
            puntos[2][i] = soluciones[0] + ( soluciones[1] * sumatorias[0][i]) + ( soluciones[2] * sumatorias[1][i]);
        }
        
        System.out.printf("%12s %12s %12s\n", "X1", "X2", "Y");
        for (int i = 0; i < puntos[0].length ; i++) {
            System.out.printf("%12.4f %12.4f  %12.4f\n", puntos[0][i], puntos[1][i], puntos[2][i]);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(""
                + "Programa que realiza una \"Regresión Lineal Multiple\"\n"
                + "\n"
                + "Programa creado por:\n"
                + "- Jesús Antonio Urrego Gutiérrez\n"
                + "- ID: 00000216768\n"
                + "- 04/06/2021\n");

        System.out.println("");
        double[][] puntos = leePuntos();
        ArrayList<Object> datos = regresionLinealMultiple(puntos);
        double[] soluciones = gaussJordan((double[][])datos.get(1));
        despliegaSolucion((double[][])datos.get(0), soluciones);
    }
    
}
