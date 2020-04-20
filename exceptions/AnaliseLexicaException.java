package exceptions;

public class AnaliseLexicaException extends Exception {
    public AnaliseLexicaException(String msg){
        super("Erro léxico: " + msg + "\n");
    }
}
