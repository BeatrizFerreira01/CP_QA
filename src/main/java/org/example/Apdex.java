// Beatriz Ferreira Cruz - RM 555698 - Turma 2TDSPZ

package org.example;

/**
 * Cálculo do índice APDEX.
 * Fórmula: (satisfeitos + 0.5 * toleráveis) / total
 * Faixas:
 *   >= 0.94         -> EXCELLENT
 *   0.85 até 0.93   -> GOOD
 *   0.70 até 0.84   -> FAIR
 *   0.50 até 0.69   -> POOR
 *   < 0.50          -> UNACCEPTABLE
 */
public class Apdex {

    public double calcular(double satisfeitos, double toleraveis, double total) {
        if (total <= 0) {
            throw new IllegalArgumentException("Total deve ser maior que zero.");
        }
        return (satisfeitos + 0.5 * toleraveis) / total;
    }

    public String classificar(double score) {
        if (score >= 0.94) return "EXCELLENT";
        if (score >= 0.85) return "GOOD";
        if (score >= 0.70) return "FAIR";
        if (score >= 0.50) return "POOR";
        return "UNACCEPTABLE";
    }

    public static void executar() {
        Apdex apdex = new Apdex();

        long total = 555_698;   // meu RM como total de amostras
        long satisfeitos = Math.round(total * 0.90);
        long toleraveis = Math.round(total * 0.00);

        double score = apdex.calcular(satisfeitos, toleraveis, total);
        String faixa = apdex.classificar(score);

        System.out.println("APDEX = " + String.format("%.3f", score) + " -> " + faixa);
    }
}