package exceptions;

public class AnaliseSemanticaException extends Exception {
    public AnaliseSemanticaException(String msg){
        super("Erro semantico: " + msg + "\n");
    }
}
