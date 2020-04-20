package leitor;

public class Fita {

    private char[] arquivo;
    private char caracterAtual;
    private char proximoCaracter;
    private int posicaoLeitura = 0;
    private int linha = 1;
    private int coluna = 1;
    private int colunaLeitura = 0;

    public Fita(char[] arquivo){
        this.arquivo = arquivo;
        this.caracterAtual = arquivo[posicaoLeitura];
        countCaracter();
        moveFita();
        this.proximoCaracter = arquivo[posicaoLeitura];
    }

    public void lerProximoCaracter(){
        moveFita();
        caracterAtual = proximoCaracter;

        countCaracter();

        if(posicaoLeitura < arquivo.length){
            proximoCaracter = arquivo[posicaoLeitura];
        }else{ //Fim do arquivo
            proximoCaracter = (char)-1;
        }
    }

    public char getCaracterAtual() {
        return caracterAtual;
    }

    public boolean hasNext(){
        return posicaoLeitura < getLenght();
    }

    private void moveFita(){
        if(hasNext()){
            posicaoLeitura ++;
        }
    }

    public int getLenght(){
        return arquivo.length + 1;
    }

    public void countCaracter(){
        if(caracterAtual == 10){ // quebra de linha
            linha ++;
            colunaLeitura = 0;
        }else{
            colunaLeitura++;
            if(caracterAtual == 32 || caracterAtual == 9){ //espaço
                coluna = colunaLeitura +1;
            }
        }
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }
}