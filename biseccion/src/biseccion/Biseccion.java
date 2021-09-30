
package biseccion;

import java.util.Scanner;

public class Biseccion {
    
    public static void biseccion(double xi, double xf, double eamax, double xr){
        double xrv = xr;
        xr = (double) (xi + xf) / 2f;
        double fxi = f(xi);
        double fxr = f(xr);
        double fxifxr = (double) fxi * fxr;
        double ea = (double) (xr - xrv) / xr ;
        
        if(xrv == 12345){
            System.out.printf("%13s%15s%15s%15s%18s%10s\n","xi","xf","xr","f(xi)","f(xi)*f(xr)","ea");
            System.out.printf("%15.6f%15.6f%15.6f%15.6f%15.6f%15s\n",xi,xf,xr,fxi,((double)fxi*fxr),"");
        } else {
            System.out.printf("%15.6f%15.6f%15.6f%15.6f%15.6f%15.6f\n",xi,xf,xr,fxi,((double)fxi*fxr),ea);
        }
        
        if(Math.abs(ea) > eamax) {
            if(fxifxr > 0){
                xi = xr;
            } else {
                xf = xr;
            }
            biseccion(xi, xf, eamax, xr);
        } else {
            System.out.println("");
            System.out.printf("La raíz de los datos dados es (%.6f, 0) aproximadamente.\n", xr);
        }
    }
    
    public static double f(double x){
        return (-2.1) + 6.21*x + (-3.9*(Math.pow(x, 2))) + (0.667*Math.pow(x, 3));
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        double xi;
        double xf;
        double eamax;
        double xr = 12345;
        

            System.out.println("Ingrese el valor de xi: ");
            System.out.print("> ");
            xi = scn.nextDouble();
            
            System.out.println("");
            
            System.out.println("Ingrese el valor de xf: ");
            System.out.print("> ");
            xf = scn.nextDouble();
        
        System.out.println("Ingrese el error: ");
            System.out.print("> ");
            eamax = scn.nextDouble();
            
            System.out.println("");
            
        biseccion(xi, xf, eamax, xr);
    }
    
}
