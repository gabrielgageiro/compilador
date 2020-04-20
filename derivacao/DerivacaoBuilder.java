package derivacao;


import enums.Codigo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DerivacaoBuilder {

    Map<Codigo, List<Codigo>> derivacoes;

    public DerivacaoBuilder() {
        this.derivacoes = new HashMap<>();
    }

    public ListDerivacaoBuilder quando(Codigo codigo){
        return new ListDerivacaoBuilder(this, codigo);
    }

    public Map<Codigo, List<Codigo>> toMap(){
        return derivacoes;
    }

    //Visivel apenas no pacote
    Map<Codigo, List<Codigo>> getDerivacoes() {
        return derivacoes;
    }

    void setDerivacoes(Map<Codigo, List<Codigo>> derivacoes) {
        this.derivacoes = derivacoes;
    }
}
