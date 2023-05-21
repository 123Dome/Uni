package Prog2.Übung6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntSuchbaumTest {
    IntSuchbaum suchbaum = null;

    @BeforeEach
    void setUp() {
        suchbaum = new IntSuchbaum();
    }

    @AfterEach
    void tearDown() {
        suchbaum = null;
    }

    @Test
    void testIsEmptyInsert() {
        assertTrue(suchbaum.isEmpty(), "Baum muss leer sein");
        suchbaum.insert(1);
        assertFalse(suchbaum.isEmpty(), "Baum darf nicht leer sein");
    }

    @Test
    void testContainsToString() {
        suchbaum.insert(1);
        suchbaum.insert(2);
        assertTrue(suchbaum.contains(1), "Muss das Element 1 enthalten");
        assertTrue(suchbaum.contains(2), "Muss das Element 2 enthalten");
        assertFalse(suchbaum.contains(3), "Darf nicht das Element 3 enthalten");
        assertEquals(suchbaum.toString(), "(()1(()2()))", "String muss gleich sein");
    }


    @Test
    void testHoeheSize() {
        assertEquals(0, suchbaum.hoehe(), "Baum soll keine Hoehe haben");
        assertEquals(0, suchbaum.size(), "Baum soll kein Element erhalten");

        suchbaum.insert(1);
        suchbaum.insert(2);

        assertEquals(2, suchbaum.hoehe(), "Baum soll 2 Hoehe haben");
        assertEquals(2, suchbaum.size(), "Baum soll 2 Elemente erhalten");

        suchbaum.insert(3);
        assertEquals(3, suchbaum.hoehe(), "Baum soll 3 Hoehe haben");
    }

}