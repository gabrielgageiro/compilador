package automato;

import enums.*;
import exceptions.AnaliseLexicaException;
import fita.Fita;

import java.util.HashSet;
import java.util.Set;

public class Automato {

    private Estado estadoInicial;
    private Set<Estado> estadoFinais = new HashSet<>();

    public Automato(Estado estadoInicial, Estado... estadoFinais) {
        this.estadoInicial = estadoInicial;

        for (int i=0; i<estadoFinais.length; i++){
            this.estadoFinais.add(estadoFinais[i]);
        }
    }

    public Token executar(Fita fita) throws AnaliseLexicaException{
        Estado estadoAtual = estadoInicial;

        StringBuilder palavra = new StringBuilder();
        int cont = 0;
        while (true) {
            char caracterAtual = fita.getCaracterAtual();

            Object entrada = TipoEntrada.valueOfByCaracter(caracterAtual);

            if(entrada == null){
                entrada = Character.toString(caracterAtual);
            }

            Estado estado = estadoAtual.getEstado(entrada);

            if(estado != null){
                estadoAtual = estado;

                if(estadoFinais.contains(estadoAtual)){
                    break;
                }

                palavra.append(caracterAtual);
            }

            fita.lerProximoCaracter();

            //Caso tenha entrado em loop
            if(cont > fita.getLenght()){
                break;
            }

            cont ++;
        }

        if(!estadoFinais.contains(estadoAtual)){
            throw new AnaliseLexicaException("Um bloco não foi fechado!");
        }

        return retorno(estadoAtual, palavra.toString(), fita);
    }

    private Token retorno(Estado estadoFinal, String palavra, Fita fita) throws AnaliseLexicaException{
        TipoRetorno tipo = estadoFinal.getTipoRetorno();

        if(tipo != null){
            if(tipo == TipoRetorno.IGNORAR){
                return Token.tokenIgnorado();
            }

            if(tipo == TipoRetorno.IDENTIFICADOR){
                return new Token(palavra, Codigo.IDENTIFICADOR);
            }

            if(tipo == TipoRetorno.OPERADOR){
                return new Token(palavra, Codigo.getByOperador(palavra));
            }

            if(tipo == TipoRetorno.INTEIRO){
                return new Token(palavra, Codigo.INTEIRO);
            }

            if(tipo == TipoRetorno.LITERAL){
                return new Token(palavra, Codigo.LITERAL);
            }

            if(tipo == TipoRetorno.ERRO){
                throw new AnaliseLexicaException("Numero invalido na posicao na linha " + fita.getLinha() + " coluna " + fita.getColuna());
            }
        }

        return new Token(palavra);
    }
}