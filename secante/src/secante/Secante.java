package secante;

import java.util.Scanner;

public class Secante {

    public static void secante(double x1, double x2, double eamax, double xr) {
        double xrv = xr;
        double fx1 = f(x1);
        double fx2 = f(x2);
        xr = x2 - (((x1 - x2) / (fx1 - fx2)) * fx2);
        double ea = (float) (xr - xrv) / xr;

        if (xrv == 12345f) {
            System.out.printf("%13s%15s%16s%14s%13s%15s\n", "x1", "x2", "f(x1)", "f(x2)", "xr", "ea");
            System.out.printf("%15.6f%15.6f%15.6f%15.6f%15.6f%15s\n", x1, x2, fx1, fx2, xr, "");
        } else {
            System.out.printf("%15.6f%15.6f%15.6f%15.6f%15.6f%15.6f\n", x1, x2, fx1, fx2, xr, ea);
        }

        if (Math.abs(ea) > eamax) {
            x1 = x2;
            x2 = xr;

            secante(x1, x2, eamax, xr);
        } else {
            System.out.println("");
            System.out.printf("La raíz del intervalo dado es (%.6f, 0) aproximadamente.\n", xr);
        }
    }

    public static double f(double x) {
        return (double) (1 + (-0.6 * x)) / x;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double x1;
        double x2;
        double eamax;
        double xr = 12345f;

        System.out.println("Ingrese el valor de x1: ");
        System.out.print("> ");
        x1 = scn.nextDouble();

        System.out.println("Ingrese el valor de x2: ");
        System.out.print("> ");
        x2 = scn.nextDouble();

        System.out.println("");

        System.out.println("Ingrese el error: ");
        System.out.print("> ");
        eamax = scn.nextFloat();

        System.out.println("");

        secante(x1, x2, eamax, xr);
    }

}
