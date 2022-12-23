package test;

import org.junit.jupiter.api.Test;

import src.Quack;

import static org.junit.jupiter.api.Assertions.*;


public class QuackPerformanceTest {

    @Test
    public void testQueuePopPerformance() {
        Quack<Integer> q = new Quack<>();

        for (int i = 1; i <= 50000000; ++i) {
            q.push(i);
        }

        for (int i = 1; i <= 50000000; ++i) {
            assertEquals(i, q.qpop());
        }
    }

    
    @Test
    public void testStackPopPerformance() {
        Quack<Integer> q = new Quack<>();

        for (int i = 1; i <= 50000000; ++i) {
            q.push(i);
        }

        for (int i = 50000000; i >= 1; --i) {
            assertEquals(i, q.spop());
        }
    }
}
