package exceptions;

public class AnaliseSintaticaException extends Exception{
    public AnaliseSintaticaException(String msg){
        super(msg + "\n");
    }
}
