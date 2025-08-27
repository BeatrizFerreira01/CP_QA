// Beatriz Ferreira Cruz - RM 555698 - Turma 2TDSPZ

package org.example;

public class Main {
    public static void main(String[] args) {
        Apdex apdex = new Apdex();

        long total = 555_698;   // meu RM como total de amostras
        long satisfeitos = Math.round(total * 0.90);
        long toleraveis = Math.round(total * 0.00);

        double score = apdex.calcular(satisfeitos, toleraveis, total);
        String faixa = apdex.classificar(score);

        System.out.println("APDEX = " + String.format("%.3f", score) + " -> " + faixa);
    }
}
