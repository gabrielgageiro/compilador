package analises;

import automato.Token;
import enums.Codigo;
import exceptions.AnaliseSemanticaException;
import exceptions.AnaliseSintaticaException;

import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

import static analises.AnaliseSemantica.*;

public class AnaliseSintatica {

    public static Stack<Token> getPilhaParsingInicial() {
        Stack<Token> parsing = new Stack<>();
        parsing.add(new Token(Codigo.PROGRAMA));
        return parsing;
    }

    public static void analisar(Stack<Token> derivacoes, Stack<Token> parsing) throws AnaliseSintaticaException, AnaliseSemanticaException {

        if(!derivacoes.isEmpty() && parsing.isEmpty()){
            throw new AnaliseSintaticaException("Código fora do escopo");
        }

        Codigo x = parsing.peek().getCodigo();

        if(derivacoes.isEmpty() && !parsing.isEmpty()){
            throw new AnaliseSintaticaException("Final prematuro -> Esperado: " + x.getOp());
        }

        Token i = derivacoes.peek();
        Codigo a = i.getCodigo();

        classificarIdentificador(x, i);

        if(x.isTerminal()){
            if(x.equals(a)){
                derivacoes.pop();
                parsing.pop();

                return;
            }
        }else{
            Map<Codigo, List<Codigo>> y = Codigo.tabelaParsing.get(x);
            if(y != null){
                List<Codigo> yk = y.get(a);
                if(yk != null){
                    parsing.pop();
                    parsing.addAll(yk.stream().map( c -> new Token(c)).collect(Collectors.toList()));
                    return;
                }
            }
        }

        throw new AnaliseSintaticaException("Erro sintatico. Esperado: " + x.getOp() + " Encontrado: " + a.getOp());
//        throw new AnaliseSintaticaException("Erro sintatico" + i.getLinha() + " | " + i.getColuna() + " -> Esperado: " + x.getCaracter() + " Encontrado: " + a.getCaracter());
    }

}