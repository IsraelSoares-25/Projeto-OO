package utils;

public class CalculadoraDistancia {
    public static double calcular(String origem,String destino){
        System.out.printf("Origem: %s\nDestino: %s\n", origem, destino);
        int fator = origem.length() + destino.length();
        return (fator* 0.5)+7.0;
    }
}
