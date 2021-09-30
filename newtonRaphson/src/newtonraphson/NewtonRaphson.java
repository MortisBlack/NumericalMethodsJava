
package newtonraphson;

import java.util.Scanner;

public class NewtonRaphson {

    public static void newtonRaphson(double xi, double eamax, double xr) {
        double xrv = xr;
        double fxi = f(xi);
        double fxii = fi(xi);
        xr = xi - (fxi / fxii);
        double ea = (double) (xr - xrv) / xr;

        if (xrv == 12345f) {
            System.out.printf("%13s%16s%15s%15s\n", "xi", "f(xi)", "f'(xi)", "ea");
            System.out.printf("%15.6f%15.6f%15.6f%15s\n", xi, fxi, fxii,"");
        } else {
            System.out.printf("%15.6f%15.6f%15.6f%15.6f\n", xi, fxi, fxii, ea);
        }
        
        if(Math.abs(ea) > eamax) {
            xi = xr;
            newtonRaphson(xi, eamax, xr);
        } else {
            System.out.println("");
            System.out.printf("La raíz del valor dado es (%.6f, 0) aproximadamente.\n", xi);
        }
    }

    public static double f(double x) {
        return (double) -2.1 + (6.21 * x) + (-3.9 * (Math.pow(x, 2))) + (0.667 * (Math.pow(x, 3)));
    }

    public static double fi(double x) {
        return (double) 6.21 + (-7.8 * x) + (2.001 * (Math.pow(x, 2)));
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double xi;
        double eamax;
        double xr = 12345f;
        
        System.out.println("Ingrese el valor de xi: ");
        System.out.print("> ");
        xi = scn.nextDouble();

        System.out.println("");

        System.out.println("Ingrese el error: ");
        System.out.print("> ");
        eamax = scn.nextDouble();

        System.out.println("");

        newtonRaphson(xi, eamax, xr);
    }

}
