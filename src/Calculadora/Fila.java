package Calculadora;

public class Fila {

    private Nodo frente;
    private Nodo fim;
    private int num;

    public Fila() {
        fim = null;
        frente = null;
        num = 0;
    }

    public boolean vazia() {
        return this.getNum() == 0;
    }

    public void enfileira(String item) {
        Nodo n = new Nodo();
        n.item = item;
        if (vazia()) {
            frente = n;
            n.prox = null;
        } else {
            fim.prox = n;
            n.prox = null;
        }
        fim = n;
        num++;
    }

    public String desenfileira() {
        if (vazia()) {
            return null;
        } else {
            String item = frente.item;
            frente = frente.prox;
            num--;
            return item;
        }
    }
    
    public String desenfileiraUltimo(){
        if (vazia()) {
            return null;
        }
        else if (num == 1){
            String item = fim.item;
            frente.prox = null;
            fim.prox = null;
            num--;
            return item;
        }
        else{
            String item = fim.item;
            Nodo aux;
            aux = this.frente;
            while (aux.prox.prox != null) {
                aux = aux.prox;
            }
            aux.prox = null;
            fim = aux;
            num--;
            return item;
        }
    }
    
    public String Ultimo(){
        return fim.item;
    }
    
    public String toString() {
        Nodo aux;
        String s = "";
        int n = 1;
        aux = this.frente;
        while (aux != null) {
            s = s + aux.item + "\n";
            aux = aux.prox;
            n++;
        }
        return s;
    }

    public int getNum() {
        return num;
    }

}
