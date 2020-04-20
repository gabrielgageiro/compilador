package automato;

import enums.TipoEntrada;
import enums.TipoRetorno;

import java.util.HashMap;
import java.util.Map;

public class Estado {
    private Map<Object, Estado> transicoes = new HashMap<>();
    private Estado excecao;
    private TipoRetorno retornoEspecifico;

    public Estado() {}

    //Utilizado em estados finais com retorno predefinido
    public Estado(TipoRetorno retornoEspecifico) {
        this.retornoEspecifico = retornoEspecifico;
    }

    public void addTransicao(Object entrada, Estado estado){
        transicoes.put(entrada, estado);
    }

    public Estado getEstado(Object entrada){

        Estado estado = transicoes.get(TipoEntrada.QUALQUER);

        if(estado != null){
            return estado;
        }

        estado = transicoes.get(entrada);

        if(estado == null && excecao != null){
            return excecao;
        }

        return estado;
    }

    public TipoRetorno getRetornoEspecifico() {
        return retornoEspecifico;
    }

    public void setExcecao(Estado excecao) {
        this.excecao = excecao;
    }
}