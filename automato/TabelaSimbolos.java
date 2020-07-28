package automato;

import enums.Categoria;
import enums.Codigo;

import java.util.Objects;

public class TabelaSimbolos {
    private String nome;
    private Categoria categoria;
    private Codigo tipo;

    public TabelaSimbolos(String nome, Categoria categoria, Codigo tipo) {
        this.nome = nome;
        this.categoria = categoria;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Codigo getTipo() {
        return tipo;
    }

    public void setTipo(Codigo tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof TabelaSimbolos)) {
            return false;
        }
        TabelaSimbolos tabelaSimbolo = (TabelaSimbolos) obj;
        return  Objects.equals(nome, tabelaSimbolo.nome);
    }
}
