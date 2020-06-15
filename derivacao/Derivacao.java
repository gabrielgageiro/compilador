package derivacao;

import enums.Codigo;

import java.util.*;

public final class Derivacao {

    public Map<Codigo, List<Codigo>> derivacoes;

    public Derivacao() {
        this.derivacoes = new HashMap<>();
    }

    public ListDerivacao quando(Codigo codigo){
        return new ListDerivacao(this, codigo);
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
}
