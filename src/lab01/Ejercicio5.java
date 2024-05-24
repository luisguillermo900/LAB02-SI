package lab01;

public class Ejercicio5 {
	public static void main(String[] args) {
        Ejercicio5 descifrador = new Ejercicio5();
        
        String textoCifrado = "HERMODD";
        String clave = "CLAVE";

        String textoDescifrado = descifrador.desencriptarTextoCifrado(textoCifrado, clave);

        System.out.println("Texto cifrado: " + textoCifrado);
        
        System.out.println("Texto descifrado: " + textoDescifrado);
    }
    char tablaCesar[] = {
        'A', 'B', 'C', 'D', 'E',
        'F', 'G', 'H', 'I', 'J',
        'K', 'L', 'M', 'N', 'O',
        'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    public char getTextoDescifrado(char parTextoCifrado, char parTextoClave) {
        int indiceCharTextoCifrado = 0;
        int indiceCharTextoClave = 0;

        for (int i = 0; i < tablaCesar.length; i++) {
            if (parTextoCifrado == tablaCesar[i]) {
                indiceCharTextoCifrado = i;
                break;
            }
        }

        for (int j = 0; j < tablaCesar.length; j++) {
            if (parTextoClave == tablaCesar[j]) {
                indiceCharTextoClave = j;
                break;
            }
        }

        if (indiceCharTextoCifrado >= indiceCharTextoClave) {
            return tablaCesar[(indiceCharTextoCifrado - indiceCharTextoClave) % 27];
        } else {
            return tablaCesar[27 - (indiceCharTextoClave - indiceCharTextoCifrado)];
        }
    }

    public String desencriptarTextoCifrado(String textoCifrado, String clave) {
        String claveCompletada = "cielo";
        int indice = 0;

        for (int i = 0; i < textoCifrado.length(); i++) {
            for (int j = 0; j < clave.length(); j++) {
                if (claveCompletada.length() < textoCifrado.length()) {
                    if (textoCifrado.charAt(indice) != ' ') {
                        claveCompletada += clave.charAt(j) + "";
                    } else {
                        claveCompletada += " ";
                        j--;
                    }
                    indice++;
                }
            }
        }

        String textoClaro = "";
        for (int i = 0; i < textoCifrado.length(); i++) {
            char charTextoCifrado = textoCifrado.charAt(i);
            char charClaveCompletada = claveCompletada.charAt(i);

            if (charTextoCifrado != ' ') {
                textoClaro += getTextoDescifrado(charTextoCifrado, charClaveCompletada);
            } else {
                textoClaro += ' ';
            }
        }

        return textoClaro;
    }
}
