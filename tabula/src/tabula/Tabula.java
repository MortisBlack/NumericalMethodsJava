package tabula;

import java.util.Scanner;

public class Tabula {
    
    public static void tabula(float limInferior, float limSuperior, float incremento) {
        
        System.out.printf("%7s%4s%25s\n", "f(x)","|","-12x^5 - 6.4x^3 + 12");
        
        for (float i = limInferior; i <= (float)limSuperior; i = i + incremento) {
            System.out.printf("%9.2f%2s%29.2f\n", i, "|",f(i));
        }
    }
    
    public static float f(float x) {
        return -12f * (float) Math.pow(x, 5) - (6.4f * (float) Math.pow(x, 3)) + 12f;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        boolean esMayor = false;
        
        float limInferior;
        float limSuperior;
        float incremento;
        
        do{
            esMayor = false;
            System.out.println("Ingrese el valor del limite inferior: ");
            System.out.print("> ");
            limInferior = scn.nextFloat();
            
            System.out.println("");
            
            System.out.println("Ingrese el valor del limite superior: ");
            System.out.print("> ");
            limSuperior = scn.nextFloat();
            
            System.out.println("");
            
            System.out.println("Ingrese el incremento: ");
            System.out.print("> ");
            incremento = scn.nextFloat();
            
            // Condición que confirma que el limite inferior no sea mayor que el limite superior
            if(limSuperior < limInferior){
                System.out.println("");
                System.out.println("ERROR: El limite superior no puede ser menor al limite inferior."
                        + "\n Por favor, vuelva a introducir los valores.");
                System.out.println("");
                esMayor = true;
            }
            
        }while(esMayor);
        
        System.out.println("");
        tabula(limInferior, limSuperior, incremento);
    }

}
