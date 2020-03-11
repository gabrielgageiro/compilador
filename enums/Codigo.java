package enums;

public enum Codigo {

    /*
    TERMINAIS
     */
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

    //Simbolos especiais
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
    OP_CIFRAO(51, "$"),


    /*
    NAO TERMINAIS
     */
    PROGRAMA(52),
    BLOCO(53),
    DCLROT(54),
    LID(55),
    REPIDENT(56),
    DCLCONST(57),
    LDCONST(58),
    DCLVAR(59),
    LDVAR(60),
    TIPO(61),
    DCLPROC(62),
    DEFPAR(63),
    CORPO(64),
    REPCOMANDO(65),
    COMANDO(66),
    RCOMID(67),
    RVAR(68),
    PARAMETROS(69),
    REPPAR(70),
    ELSEPARTE(71),
    VARIAVEL(72),
    VARIAVEL1(73),
    REPVARIAVEL(74),
    ITEMSAIDA(75),
    REPITEM(76),
    EXPRESSAO(77),
    REPEXPSIMP(78),
    EXPSIMP(79),
    REPEXP(80),
    TERMO(81),
    REPTERMO(82),
    FATOR(83),
    CONDCASE(84),
    CONTCASE(85),
    RPINTEIRO(86),
    SEMEFEITO(87);

    private int codigo;
    private String op;

    Codigo(int codigo){
        this.codigo = codigo;
    }

    Codigo(int codigo, String op){
        this.codigo = codigo;
        this.op = op;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getOp() {
        return op != null ? op : "";
    }
}
