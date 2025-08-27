// Beatriz Ferreira Cruz - RM 555698 - Turma 2TDSPZ


import org.example.Apdex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * usando TOTAL = RM (555698) e @BeforeEach
 */

public class ApdexTest {

    private long TOTAL;
    private Apdex apdex;

    @BeforeEach
    void setup() {
        TOTAL = 555_698L;
        apdex = new Apdex();
    }

    @Test
    void deveClassificarComoExcellent() {
        // ~1.00: 100% satisfeitos
        long S = TOTAL;
        long T = 0;
        double score = apdex.calcular(S, T, TOTAL);
        assertEquals(1.00, score, 0.01);
        assertEquals("EXCELLENT", apdex.classificar(score));
    }

    @Test
    void deveClassificarComoGood() {
        // ~0.90: 90% satisfeitos
        long S = Math.round(TOTAL * 0.90);
        long T = 0;
        double score = apdex.calcular(S, T, TOTAL);
        assertEquals("GOOD", apdex.classificar(score));
    }

    @Test
    void deveClassificarComoFair() {
        // ~0.75: 70% satisfeitos + 10% toleráveis -> 0.70 + 0.5*0.10 = 0.75
        long S = Math.round(TOTAL * 0.70);
        long T = Math.round(TOTAL * 0.10);
        double score = apdex.calcular(S, T, TOTAL);
        assertEquals("FAIR", apdex.classificar(score));
    }

    @Test
    void deveClassificarComoPoor() {
        // ~0.60: 50% satisfeitos + 20% toleráveis -> 0.50 + 0.5*0.20 = 0.60
        long S = Math.round(TOTAL * 0.50);
        long T = Math.round(TOTAL * 0.20);
        double score = apdex.calcular(S, T, TOTAL);
        assertEquals("POOR", apdex.classificar(score));
    }

    @Test
    void deveClassificarComoUnacceptable() {
        // ~0.40: 40% satisfeitos
        long S = Math.round(TOTAL * 0.40);
        long T = 0;
        double score = apdex.calcular(S, T, TOTAL);
        assertEquals("UNACCEPTABLE", apdex.classificar(score));
    }
}
