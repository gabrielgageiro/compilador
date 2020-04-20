package derivacao;


import enums.Codigo;

import java.util.*;

public final class ListDerivacaoBuilder {

    private DerivacaoBuilder derivacaoBuilder;
    private Codigo codigo;

    private ListDerivacaoBuilder(){}

    //Contrutor visivel apenas no pacote
    ListDerivacaoBuilder(DerivacaoBuilder derivacaoBuilder, Codigo codigo) {
        this.derivacaoBuilder = derivacaoBuilder;
        this.codigo = codigo;
    }

    public DerivacaoBuilder derivarEm(Codigo... derivacoes){
        List<Codigo> listDerivacoes = Arrays.asList(derivacoes);
        Collections.reverse(listDerivacoes);
        derivacaoBuilder.getDerivacoes().put(codigo , listDerivacoes);

        return derivacaoBuilder;
    }

    public DerivacaoBuilder derivarEm(){
        derivacaoBuilder.getDerivacoes().put(codigo , Collections.emptyList());

        return derivacaoBuilder;
    }
}
