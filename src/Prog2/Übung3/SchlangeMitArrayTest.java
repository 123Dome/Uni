package Prog2.Übung3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SchlangeMitArrayTest {
    SchlangeMitArray schlange = null;
    static Integer[] testwerte= {1,2,3,4,5};

    @BeforeEach
    void setUp() {
        schlange = new SchlangeMitArray(testwerte.length);
    }

    @AfterEach
    void tearDown() {
        schlange = null;
    }

    @Test
    void testInsertRemoveISEmpty() {
        assertTrue(schlange.isEmpty(), "Schlange muss leer sein");
        for(int i = 0; i < testwerte.length; i++){
            schlange.insert(testwerte[i]);
            assertEquals(testwerte[i], schlange.remove(), "Insert oder remove funktioniert nicht");
        }
    }

    @Test
    void testSizeCapacity(){
        for(int i = 0; i < testwerte.length; i++) {
            schlange.insert(testwerte[i]);
            assertEquals(testwerte.length, schlange.capacity(), "Kapazität stimmt nicht");
            assertEquals(i + 1, schlange.size(), "Größe stimmt nicht"); // i+1 weil größe immer 1 größer ist als i
        }
    }

    @Test
    void testFront(){
        for(int i = 0; i < testwerte.length; i++){
            schlange.insert(testwerte[i]);
            assertEquals(testwerte[0], schlange.front(), "Vorderstes Element ist falsch");
        }
    }

    @Test
    void testIllegalStateException(){
        for(int i = 0; i < testwerte.length; i++){
            schlange.insert(testwerte[i]);
        }
        assertThrows(IllegalStateException.class, () -> schlange.insert(testwerte[0]), "Falsch eingefügt");
    }

    @Test
    void testNoSuchElementException(){
        assertThrows(NoSuchElementException.class, () -> schlange.remove(), "NoSuchElementException nicht geworfen nach entfernen");
        assertThrows(NoSuchElementException.class, () -> schlange.front(), "NoSuchElementException nicht geworfen nach aufrufen des 1. Elements");
    }
}