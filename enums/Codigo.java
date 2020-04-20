package enums;

import derivacao.DerivacaoBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Codigo {

    // Terminais
    PROGRAM(1),
    LABEL(2),
    CONST(3),
    VAR(4),
    PROCEDURE(5),
    BEGIN(6),
    END(7),
    INTEGER(8),
    ARRAY(9),
    OF(10),
    CALL(11),
    GOTO(12),
    IF(13),
    THEN(14),
    ELSE(15),
    WHILE(16),
    DO(17),
    REPEAT(18),
    UNTIL(19),
    READLN(20),
    WRITELN(21),
    OR(22),
    AND(23),
    NOT(24),
    IDENTIFICADOR(25),
    INTEIRO(26),
    FOR(27),
    TO(28),
    CASE(29),
    LITERAL(48),

    // Operadores
    OP_SOMA(30, "+"),
    OP_SUB(31, "-"),
    OP_MULT(32, "*"),
    OP_DIV(33, "/"),
    OP_COLCHETE_ABRE(34, "["),
    OP_COLCHETE_FECHA(35, "]"),
    OP_PARENTESE_ABRE(36, "("),
    OP_PARENTESE_FECHA(37, ")"),
    OP_RECEBE(38, ":="),
    OP_TIPAGEM(39, ":"),
    OP_IGUAL(40, "="),
    OP_MAIOR(41, ">"),
    OP_MAIOR_OU_IGUAL(42, ">="),
    OP_MENOR(43, "<"),
    OP_MENOR_OU_IGUAL(44, "<="),
    OP_DIFERENTE(45, "<>"),
    OP_VIRGULA(46, ","),
    OP_PONTO_VIRGULA(47, ";"),
    OP_PONTO(49, "."),
    OP_PONTO_PONTO(50, ".."),
    OP_CIFRAO(51, "$");

    private int codigo;
    private String op;

    // Mapa estatico para melhor performance para encontrar delimitadores
    private static final Map<String, Codigo> delimitadores;
    static {
        HashMap<String, Codigo> tmp = new HashMap<>();
        tmp.put(OP_SOMA.op, OP_SOMA);
        tmp.put(OP_SUB.op, OP_SUB);
        tmp.put(OP_MULT.op, OP_MULT);
        tmp.put(OP_DIV.op, OP_DIV);
        tmp.put(OP_COLCHETE_ABRE.op, OP_COLCHETE_ABRE);
        tmp.put(OP_COLCHETE_FECHA.op, OP_COLCHETE_FECHA);
        tmp.put(OP_PARENTESE_ABRE.op, OP_PARENTESE_ABRE);
        tmp.put(OP_PARENTESE_FECHA.op, OP_PARENTESE_FECHA);
        tmp.put(OP_RECEBE.op, OP_RECEBE);
        tmp.put(OP_TIPAGEM.op, OP_TIPAGEM);
        tmp.put(OP_IGUAL.op, OP_IGUAL);
        tmp.put(OP_MAIOR.op, OP_MAIOR);
        tmp.put(OP_MAIOR_OU_IGUAL.op, OP_MAIOR_OU_IGUAL);
        tmp.put(OP_MENOR.op, OP_MENOR);
        tmp.put(OP_MENOR_OU_IGUAL.op, OP_MENOR_OU_IGUAL);
        tmp.put(OP_DIFERENTE.op, OP_DIFERENTE);
        tmp.put(OP_VIRGULA.op, OP_VIRGULA);
        tmp.put(OP_PONTO_VIRGULA.op, OP_PONTO_VIRGULA);
        tmp.put(OP_PONTO.op, OP_PONTO);
        tmp.put(OP_PONTO_PONTO.op, OP_PONTO_PONTO);
        tmp.put(OP_CIFRAO.op, OP_CIFRAO);

        delimitadores = Collections.unmodifiableMap(tmp);
    }

    Codigo(int codigo, String op){
        this.codigo = codigo;
        this.op = op;
    }

    Codigo(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static Codigo valueOfByPalavra(String token) {
        String tokenUpper = token.toUpperCase();

        Codigo codigo = getByOperador(tokenUpper);

        if(codigo != null){
            return codigo;
        }

        //Procura por palavras reservadas
        try {
            codigo = valueOf(tokenUpper);
            if(!codigo.isTerminal()){
                codigo = null;
            }

        }catch (IllegalArgumentException e){
            //não precisa fazer nada
        }

        if(codigo == null){
            return IDENTIFICADOR;
        }

        return codigo;
    }

    public String getOp() {
        if(op == null){
            return this.toString();
        }
        return op;
    }

    public static Codigo getByOperador(String palavra){
        return delimitadores.get(palavra);
    }

    public boolean isTerminal  (){
        return getCodigo() < 52;
    }
}
