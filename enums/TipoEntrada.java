package enums;

import utils.Utils;

public enum TipoEntrada {

    ESPACO,
    QUALQUER,
    LETRA,
    FIM,
    DIGITO,
    OPERADOR;

    public static TipoEntrada valueOfByCaracter(char caracter){
        if(caracter == 65535){
            return FIM;
        }

        if(Utils.isEspaco(caracter)){
            return ESPACO;
        }

        if(Utils.isLetra(caracter)){
            return LETRA;
        }

        if(Utils.isDigito(caracter)){
            return DIGITO;
        }

        if(Utils.isOperador(caracter)){
            return OPERADOR;
        }

        return null;
    }
}
