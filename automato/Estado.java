package automato;

import enums.TipoEntrada;
import enums.TipoRetorno;

import java.util.HashMap;
import java.util.Map;

public class Estado {
    private Map<Object, Estado> transicoes = new HashMap<>();
    private Estado excecao;
    private TipoRetorno tipoRetorno;

    public Estado() {}

    public Estado(TipoRetorno tipoRetorno) {
        this.tipoRetorno = tipoRetorno;
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

    public TipoRetorno getTipoRetorno() {
        return tipoRetorno;
    }

    public void setExcecao(Estado excecao) {
        this.excecao = excecao;
    }
}