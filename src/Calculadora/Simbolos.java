package Calculadora;

public class Simbolos {

    public static boolean testaOperando(String simbolo) {
        return Character.isDigit(simbolo.charAt(0));
    }

    public static boolean testaOperandoP(String simbolo) {
        //testa o operando e o "."
        if(Character.isDigit(simbolo.charAt(0))){
           return true;
        }
        else if(".".equals(simbolo)){
            return true;
        }
        else{
            return false;
        }
           
    }
    
    public static boolean testaOperador(String simbolo) {
        return "+".equals(simbolo) || "-".equals(simbolo) || "*".equals(simbolo) || "/".equals(simbolo);
    }

    public static boolean verifcaPrioridade(String pri, String n) {
        //vai retornar true se o n tiver prioridade maior ou igual ao pri
        if ("(".equals(pri)){
            return false;
        }
        else if (pri.equals(n)) {
            return true;
        } 
        else if (("*".equals(n)) || ("/".equals(n))) {
            return true;
        } 
        else if ("+".equals(pri) && "-".equals(n)) {
            return true;
        } 
        else if ("-".equals(pri) && "+".equals(n)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static String calcula(String n1, String n2, String op) {
        switch (op) {
            case "+":
                return "" + (Float.parseFloat(n1) + Float.parseFloat(n2));
            case "-":
                return "" + (Float.parseFloat(n1) - Float.parseFloat(n2));
            case "/":
                return "" + (Float.parseFloat(n1) / Float.parseFloat(n2));
            default:
                return "" + (Float.parseFloat(n1) * Float.parseFloat(n2));
        }
    }
}
