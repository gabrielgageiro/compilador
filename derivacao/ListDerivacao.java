package derivacao;

import enums.Codigo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListDerivacao {

    private Derivacao derivacoes;
    private Codigo codigo;

    private ListDerivacao(){}

    //Contrutor visivel apenas no pacote
    ListDerivacao(Derivacao derivacaoBuilder, Codigo codigo) {
        this.derivacoes = derivacaoBuilder;
        this.codigo = codigo;
    }

    public Derivacao derivarEm(Codigo... derivacoes){
        List<Codigo> listDerivacoes = Arrays.asList(derivacoes);
        Collections.reverse(listDerivacoes);
        this.derivacoes.getDerivacoes().put(codigo , listDerivacoes);

        return this.derivacoes;
    }

    public Derivacao derivarEm(){
        derivacoes.getDerivacoes().put(codigo , Collections.emptyList());

        return derivacoes;
    }
}
