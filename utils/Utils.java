package utils;

public class Utils {
    public static boolean isLetra(char caracter){ // letras
        return  (caracter > 64 && caracter < 91) || (caracter > 96 && caracter < 123);
    }

    public static boolean isDigito(char caracter){ // numeros
        return caracter > 47 && caracter < 58;
    }

    public static boolean isOperador(char caracter){ // operadores
        return caracter == 36 || (caracter > 42 && caracter < 45) || caracter == 47 || caracter == 59 || caracter == 91 || caracter == 93;
    }

    public static boolean isEspaco(char caracter){
        return caracter == 32 || caracter == 9 || caracter == 10;
    }
}
