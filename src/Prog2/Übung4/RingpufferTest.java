package Prog2.Übung4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RingpufferTest {
    Ringpuffer<Integer> ring;

    @BeforeEach
    void setUp() {
        ring = new Ringpuffer<>(4);
    }

    @AfterEach
    void tearDown() {
        ring = null;
    }

    @Test
    void testAddRemove(){
        ring.addLast(1);
        ring.addLast(2);
        assertEquals(1, ring.get(0), "get is wrong");
        assertEquals(2, ring.removeLast(), "Remove ist flasch");
        assertEquals(1, ring.removeLast(), "Remove ist falsch");
    }
}