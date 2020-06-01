package derivacao;

import enums.Codigo;

import java.util.*;

public final class Derivacao {
    private Map<Codigo, List<Codigo>> derivacoes;
    private Codigo codigo;

    public Derivacao() {
        this.derivacoes = new HashMap<>();
    }

    public Map<Codigo, List<Codigo>> toMap(){
        return derivacoes;
    }

    public Map<Codigo, List<Codigo>> getDerivacoes() {
        return derivacoes;
    }

    void setDerivacoes(Map<Codigo, List<Codigo>> derivacoes) {
        this.derivacoes = derivacoes;
    }

    public Derivacao quando(Codigo codigo){ //poderia ser usado o metodo derivarEm, mas assim fica mais legivel
        return derivarEm(codigo);
    }

    public Derivacao derivarEm(Codigo... derivacoes){
        List<Codigo> listDerivacoes = Arrays.asList(derivacoes);
        Collections.reverse(listDerivacoes);
        getDerivacoes().put(codigo , listDerivacoes);

        return this;
    }

    public Derivacao derivarEm(){
        getDerivacoes().put(codigo , Collections.emptyList());
        return this;
    }
}
