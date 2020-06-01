package automato;

import enums.Codigo;

public class Token {

    private String palavra;
    private Codigo codigo;

    public Token(String palavra) {
        this.codigo = Codigo.valueOfByPalavra(palavra);
        this.palavra = palavra;
    }

    public Token(Codigo codigo){
        this.codigo = codigo;
        this.palavra = codigo.getOp();
    }

    public Token(String palavra, Codigo codigo) {
        this.palavra = palavra;
        this.codigo = codigo;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public Codigo getCodigo() {
        return codigo;
    }

    public void setCodigo(Codigo codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return codigo.toString() + " " + palavra;
    }

    public static Token tokenIgnorado(){
        return new Token(null, null);
    }

    public boolean isIgnorado(){
        return palavra == null && codigo == null;
    }

}
