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
            throw new IllegalArgumentException("Total deve ser maior que zero");
        }
        return (satisfeitos + (toleraveis / 2.0)) / total;
    }

    public String classificar(double score) {
        if (score >= 0.94) return "EXCELLENT";
        if (score >= 0.85) return "GOOD";
        if (score >= 0.70) return "FAIR";
        if (score >= 0.50) return "POOR";
        return "UNACCEPTABLE";
    }
}
