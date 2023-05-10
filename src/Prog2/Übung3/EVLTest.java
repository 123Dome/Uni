package Prog2.Übung3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EVLTest {
    EVL<String> evlS= null;
    EVL<Integer> evlI = null;

    @BeforeEach
    void setUp() {
        evlS = (EVL<String>) new EVL();
        evlI = (EVL<Integer>) new EVL();
    }

    @AfterEach
    void tearDown() {
        evlS = null;
        evlI = null;
    }

    @Test
    void testIsEmpty(){
        assertTrue(evlS.isÉmpty(), "EVL mit Strings muss leer sein");
        assertTrue(evlI.isÉmpty(), "EVL mit Integerns muss leer sein");

        evlS.addFirst("a");
        evlI.addFirst(1);
        assertFalse(evlS.isÉmpty(), "EVL mit Strings darf nicht leer sein");
        assertFalse(evlI.isÉmpty(), "EVL mit Integern darf nicht leer sein");
    }

    @Test
    void TestAddFirstGetFirstAddLastGetLast(){
        evlS.addFirst("a");
        evlI.addFirst(1);

        assertEquals("a", evlS.getFirst(), "Erstes Element bei Strings ist falsch");
        assertEquals(1, evlI.getFirst(), "Erstes Element bei Integern ist falsch");
    }

    @Test
    void testRemoveFirstRemoveLast(){
        evlS.addFirst("b");
        evlS.addFirst("a");
        evlS.addLast("c");
        evlS.addLast("d");
        evlI.addFirst(2);
        evlI.addFirst(1);
        evlI.addLast(3);
        evlI.addLast(4);

        assertEquals("a", evlS.removeFirst(), "Remove First bei Strings ist falsch");
        assertEquals("d", evlS.removeLast(), "Remove Last ist bei Strings falsch");
        assertEquals(1 , evlI.removeFirst(), "Remove First bei Integern ist falsch");
        assertEquals(4 , evlI.removeLast(), "Remove Last bei Integern ist falsch");
    }

    @Test
    void testContainsToString(){
        evlS.addLast("a");
        evlS.addLast("b");
        evlI.addLast(1);
        evlI.addLast(2);

        assertTrue(evlS.contains("a"), "String wurde nicht gefunden mit contains()");
        assertTrue(evlI.contains(1), "Integer wurde nicht gefunden mit contains()");

        assertEquals("a-b", evlS.toString(), "ToString ist falsch");
        assertEquals("1-2", evlI.toString(), "ToString ist falsch");
    }

    @Test
    void testZip(){
        // TODO: Test Methode schreiben
    }
}