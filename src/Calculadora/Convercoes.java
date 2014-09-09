package Calculadora;

import javax.swing.JOptionPane;

public class Convercoes {

    public static Fila convStrFila(String str) {
        //converte para fila com espaços entre string
        String[] array = str.split(" ");
        int i;
        Fila f = new Fila();
        for (i = 0; i < array.length; i++) {
            f.enfileira(array[i]);
        }
        return f;
    }
    
   public static Fila convStrFilaS(String str) {
        //resolve sem espaco entre strings
        Fila f = new Fila();
        int i;
        for(i = 0; i < str.length(); i++){
            if (i == 0){
                f.enfileira("" + str.charAt(i));
            }
            else if(Simbolos.testaOperador("" + str.charAt(i)) || "(".equals("" + str.charAt(i)) || ")".equals("" + str.charAt(i))) {
                f.enfileira("" + str.charAt(i));
            }
            else if (Simbolos.testaOperandoP("" + str.charAt(i))){
                if(Simbolos.testaOperandoP(f.Ultimo())){
                    f.enfileira(f.desenfileiraUltimo() + "" + str.charAt(i));
                }
                else{
                    f.enfileira("" + str.charAt(i));
                }     
            }
        }
        return f;
    }

    public static Fila convPosfixa(Fila filaInfixa) {
        Pilha pilhaConv = new Pilha();
        Fila filaPosfixa = new Fila();
        String simboloFila;
        while (filaInfixa.vazia() == false) {
            simboloFila = filaInfixa.desenfileira();
            if (Simbolos.testaOperando(simboloFila)) {
                filaPosfixa.enfileira(simboloFila);
            } else if ("(".equals(simboloFila)) {
                pilhaConv.empilha(simboloFila);
            } else if (Simbolos.testaOperador(simboloFila)) {
                while ((pilhaConv.vazia() == false) && (Simbolos.verifcaPrioridade(pilhaConv.topo(), simboloFila) == true)) {
                    filaPosfixa.enfileira(pilhaConv.desempilha());
                }
                pilhaConv.empilha(simboloFila);
            } else if (")".equals(simboloFila)) {
                while (!"(".equals(pilhaConv.topo())) {
                    filaPosfixa.enfileira(pilhaConv.desempilha());
                }
            }
        }
        while (pilhaConv.vazia() == false) {
            filaPosfixa.enfileira(pilhaConv.desempilha());
        }
        return filaPosfixa;
    }

    public static String calculaFinal(Fila filaEntrada) {
        String simb;
        Pilha pilhaCalc = new Pilha();
        while (filaEntrada.vazia() == false) {
            simb = filaEntrada.desenfileira();
            if (Simbolos.testaOperando(simb)) {
                pilhaCalc.empilha(simb);
            } else if (Simbolos.testaOperador(simb)) {
                pilhaCalc.empilha(Simbolos.calcula(pilhaCalc.desempilha(), pilhaCalc.desempilha(), simb));
            }
        }
        return (pilhaCalc.topo());
    }
    
    public static String calcula(String str){
        return (calculaFinal(convPosfixa(convStrFilaS(str))));
    }
}
