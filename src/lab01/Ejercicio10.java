package lab01;

import java.util.*;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Introduce el mensaje a descifrar");
        String cadena = scan.nextLine();
        
        System.out.println("Introduce la clave");
        String clave = scan.nextLine();
        
        System.out.println("Ingrese el módulo (27 o 191)");
        int modulo = scan.nextInt();
        
        System.out.println(Descifrar(cadena, clave, modulo));
    }

    public static String Descifrar(String Mensaje, String clave, int mod) {
        String salida = "";
        String Abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] claveEquals = new char[Mensaje.length()];
        char[] Msg = Mensaje.toUpperCase().toCharArray();
        int cont = 0;
        
        for (int c = 0; c < Mensaje.length(); c++) {
            if (Mensaje.charAt(c) == ' ') {
                claveEquals[c] = ' ';
                continue;
            }
            claveEquals[c] = clave.charAt(cont);
            cont++;
            if (cont == clave.length()) {
                cont = 0;
            }
        }
        
        int x = 0, y = 0, z;
        
        for (int c = 0; c < Mensaje.length(); c++) {
            if (Mensaje.charAt(c) == ' ') {
                salida += " ";
                continue;
            }
            
            for (int f = 0; f < Abecedario.length(); f++) {
                if (Msg[c] == Abecedario.charAt(f)) {
                    x = f;
                }
                if (claveEquals[c] == Abecedario.charAt(f)) {
                    y = f;
                }
            }
            
            z = (x - y) % mod;
            if (z < 0) {
                z += mod;
            }
            salida += Abecedario.charAt(z);
        }
        
        return salida;
    }
}
