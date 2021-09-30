
package reglafalsa;

import java.util.Scanner;

public class ReglaFalsa {
    
    public static void reglaFalsa(double xi, double xf, double eamax, double xr){
        double xrv = xr;
        double fxi = f(xi);
        double fxf = f(xf);
        xr = (double) xi -(((xf-xi)/(fxf-fxi))*fxi);
        double fxr = f(xr);
        double fxifxr = (double) fxi * fxr;
        double ea = (double) (xr - xrv) / xr ;

        if(xrv == 12345f){
            System.out.printf("%13s%15s%15s%15s%15s%15s%18s%10s\n","xi","xf","f(xi)","f(xf)","xr","f(xi)","f(xi)*f(xr)","ea");
            System.out.printf("%15.6f%15.6f%15.6f%15.6f%15.6f%15.6f%15.6f%15s\n",xi,xf,fxi,fxf,xr,fxi,((double)fxi*fxr),"");
        } else {
            System.out.printf("%15.6f%15.6f%15.6f%15.6f%15.6f%15.6f%15.6f%15.6f\n",xi,xf,fxi,fxf,xr,fxi,((double)fxi*fxr),ea);
        }
        
        if(Math.abs(ea) > eamax) {
            if(fxifxr > 0){
                xi = xr;
            } else {
                xf = xr;
            }
            reglaFalsa(xi, xf, eamax, xr);
        } else {
            System.out.println("");
            System.out.printf("La raíz de los valores dados es (%.6f, 0) aproximadamente.\n", xr);
        }
    }
    
    public static double f(double x){
        return (1 - 0.6 * x) / x;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double xi;
        double xf;
        double eamax;
        double xr = 12345f;

            System.out.println("Ingrese el valor de xi: ");
            System.out.print("> ");
            xi = scn.nextDouble();
            
            System.out.println("");
            
            System.out.println("Ingrese el valor de xf: ");
            System.out.print("> ");
            xf = scn.nextDouble();
            
            System.out.println("");
        
        System.out.println("Ingrese el error: ");
            System.out.print("> ");
            eamax = scn.nextDouble();
            
            System.out.println("");
            
        reglaFalsa(xi, xf, eamax, xr);
    }
    
}
