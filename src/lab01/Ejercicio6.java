package lab01;

public class Ejercicio6 {
    public static void main(String[] args) {
        String mensaje = "La perfección se logra no cuando no hay nada más que añadir,"
        		+ "sino cuando no hay nada más que quitar";
        String clave = "MEZCLADOR";
        int mod = 27;

        String mensajeCifrado = Cifrar(mensaje, clave, mod);

        System.out.println("Mensaje original: " + mensaje);
        System.out.println("Clave: " + clave);
        System.out.println("Mensaje cifrado: " + mensajeCifrado);
    }

    public static String Cifrar(String Mensaje, String clavesita, int mod) {
        String salida = "";
        String Abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        char[] claveEquals = new char[Mensaje.length()];
        char[] Msg = Mensaje.toUpperCase().toCharArray();
        int cont = 0;

        for (int c = 0; c < Mensaje.length(); c++) {
            if (Mensaje.charAt(c) == ' ') {
                claveEquals[c] = ' ';
                continue;
            }
            claveEquals[c] = clavesita.charAt(cont);
            cont++;
            if (cont == clavesita.length()) {
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

            z = (x + y) % mod;
            salida += Abecedario.charAt(z);
        }

        return salida;
    }
}

