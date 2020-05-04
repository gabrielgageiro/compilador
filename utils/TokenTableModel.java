package utils;

import automato.Token;

import javax.swing.table.AbstractTableModel;
import java.util.Stack;

public class TokenTableModel extends AbstractTableModel {

    private static final int CODIGO = 0;
    private String[] colunas = new String[]{"Código", "Palavra"};

    private Stack<Token> linhas = new Stack<>();

    public TokenTableModel(Stack<Token> linhas) {
        if(linhas != null && !linhas.isEmpty()){
            Stack<Token> pilha = (Stack<Token>) linhas.clone(); //nao altera a pilha original

            while(!pilha.isEmpty()){
                this.linhas.push(pilha.pop());
            }
        }
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 0){
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Token token = linhas.get(row);

        if(column == CODIGO){
            return token.getCodigo().getCodigo();
        }
        return token.getPalavra();
    }

    public void addToken(Token token) {
        linhas.add(token);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
}
