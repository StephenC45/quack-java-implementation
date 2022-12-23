package test;

import org.junit.jupiter.api.Test;

import src.Quack;

import static org.junit.jupiter.api.Assertions.*;


public class QuackTest {

    @Test
    public void testCreateQuack() {
        Quack<Integer> q = new Quack<>();
        assertEquals(0, q.getItemCount());
        assertTrue(q.isEmpty());
    }

    
    @Test
    public void testPushQuackUnit() {
        Quack<Integer> q = new Quack<>();

        for (int i = 1; i <= 4; ++i) {
            q.push(i);
            assertEquals(i, q.getItemCount());
        }
    }


    @Test
    public void testPushQuackIntegration() {
        Quack<Integer> q = new Quack<>();

        for (int i = 1; i <= 4; ++i) {
            q.push(i);
            assertEquals(1, q.qpeek());
            assertEquals(i, q.speek());
        }
    }


    @Test
    public void testQueuePop() {
        Quack<Integer> q = new Quack<>();

        for (int i = 1; i <= 10; ++i) {
            q.push(i);
        }

        assertEquals(10, q.getItemCount());

        for (int i = 1; i <= 10; ++i) {
            assertEquals(i, q.qpeek());
            assertEquals(i, q.qpop());
        }

        assertTrue(q.isEmpty());
    }


    @Test
    public void testStackPop() {
        Quack<Integer> q = new Quack<>();

        for (int i = 1; i <= 10; ++i) {
            q.push(i);
        }

        assertEquals(10, q.getItemCount());

        for (int i = 10; i >= 1; --i) {
            assertEquals(i, q.speek());
            assertEquals(i, q.spop());
        }

        assertTrue(q.isEmpty());
    }


    @Test
    public void testQuackPopIntegration() {
        Quack<Integer> q = new Quack<>();

        for (int i = 1; i <= 10; ++i) {
            q.push(i);
        }

        assertEquals(10, q.getItemCount());

        assertEquals(1, q.qpeek());
        assertEquals(10, q.speek());
        assertEquals(1, q.qpop());
        assertEquals(10, q.speek());

        assertEquals(10, q.spop());
        assertEquals(9, q.speek());
        assertEquals(2, q.qpeek());

        assertEquals(9, q.spop());
        assertEquals(8, q.speek());
        assertEquals(2, q.qpeek());

        assertEquals(2, q.qpop());
        assertEquals(3, q.qpeek());
        assertEquals(8, q.speek());
    }


    @Test
    public void testQuackEquality() {
        Quack<Integer> q = new Quack<>();
        Quack<Integer> r = new Quack<>();
        Quack<String> s = new Quack<>();

        assertTrue(q.equals(r));
        assertTrue(r.equals(s)); // Both are empty despite being different type.

        s.push("Hello");
        assertFalse(r.equals(s));
        assertTrue(r.equals(q));

        r.push(1);
        assertFalse(r.equals(q));

        q.push(1);
        assertTrue(r.equals(q));

        q = new Quack<>();
        r = new Quack<>();

        q.push(1);
        r.push(2);
        assertFalse(q.equals(r));

        q.qpop();
        r.qpop();
        assertTrue(q.equals(r));

        q.push(3);
        r.push(3);
        assertTrue(q.equals(r));

        for (int i = 4; i <= 13; ++i) {
            q.push(i);
            r.push(i);
            assertTrue(q.equals(r));
        }

        q = new Quack<>();
        r = new Quack<>();

        for (int i = 1; i <= 5; ++i) {
            q.push(i);
            r.push(i);
            assertTrue(q.equals(r));
        }

        q.push(-1);
        r.push(-2);
        assertFalse(q.equals(r));

        for (int i = 6; i <= 10; ++i) {
            q.push(i);
            r.push(i);
            assertFalse(q.equals(r));
        }

        for (int i = 0; i < 5; ++i) {
            q.spop();
            r.spop();
            assertFalse(q.equals(r));
        }

        q.spop();
        r.spop();
        assertTrue(q.equals(r));
    }

}
