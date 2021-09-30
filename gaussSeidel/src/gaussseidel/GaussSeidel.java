package gaussseidel;

import java.util.Scanner;

public class GaussSeidel {
    
    public static void GaussSeidel(float[][] matrix){        
        float[] datos = new float[6];

        datos[0] = 0f;

        datos[1] = 0f;

        datos[2] = 0f;
        

        datos[3] = 12345f;

        datos[4] = 12345f;

        datos[5] = 12345f;
        
        float eamax = 0.001f;
        
        System.out.println("Matriz inicial:");

        System.out.printf("| %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[0][0], matrix[0][1], matrix[0][2], matrix[0][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[1][0], matrix[1][1], matrix[1][2], matrix[1][3]);
        System.out.printf("| %8.4f  %8.4f %8.4f | = | %8.4f |\n", matrix[2][0], matrix[2][1], matrix[2][2], matrix[2][3]);
        System.out.println("");
        

        System.out.printf("%5s%11s%11s%11s%9s%9s\n","X1","X2","X3","eaX1","eaX2","eaX3");

        System.out.printf("%8.4f   %8.4f   %8.4f\n", datos[0], datos[1], datos[2]);
        while(Math.abs(datos[3]) > eamax && Math.abs(datos[4]) > eamax && Math.abs(datos[5]) > eamax){
            operacion(matrix, datos);

            System.out.printf("%8.4f   %8.4f   %8.4f  %8.4f  %8.4f  %8.4f\n", datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);
        }
        

        operacion(matrix, datos);
        System.out.printf("%8.4f   %8.4f   %8.4f  %8.4f  %8.4f  %8.4f\n", datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);
        
        despliegaSolucion(datos);
    }

    public static void operacion(float[][] matrix, float[] datos){
        float x1v = datos[0];
        float x2v = datos[1];
        float x3v = datos[2];
        

        datos[0] = (matrix[0][3] - (matrix[0][1] * datos[1]) - (matrix[0][2] * datos[2])) / matrix[0][0];

        datos[3] = (x1v - datos[0]) / datos[0];
        

        datos[1] = (matrix[1][3] - (matrix[1][0] * datos[0]) - (matrix[1][2] * datos[2])) / matrix[1][1];

        datos[4] = (x2v - datos[1]) / datos[1];
        

        datos[2] = (matrix[2][3] - (matrix[2][0] * datos[0]) - (matrix[2][1] * datos[1])) / matrix[2][2];

        datos[5] = (x3v - datos[2]) / datos[2];
    }
    

    public static void despliegaSolucion(float[] datos) {
        System.out.println("-----------------------------");
        System.out.println("");
        System.out.printf("Las respuestas del sistema de ecuaciones dado son (aproximadamente dado el error del 0.1%1c):\n"
                + "x1 = %8.4f\nx2 = %8.4f\nx3 = %8.4f\n", '%', datos[0], datos[1], datos[2]);
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
                 
        GaussSeidel(matrix);
    }
    
}
