package Prog2.Übung1;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StapelMitArrayTest {
    StapelMitArray stapel = null;
    static int[] testwerte = {1,2,3,4,5};

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        stapel = new StapelMitArray(testwerte.length);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        stapel = null;
    }

    @Test
    void testInsertRemoveISEmpty() {
        assertTrue(stapel.isEmpty(), "Stapel muss leer sein");
        for(int i = 0; i < testwerte.length; i++){
            stapel.insert(testwerte[i]);
            assertEquals(testwerte[i], stapel.remove(), "Insert oder Remove funktioniert nicht");
        }
    }

    @Test
    void testSizeCapacity(){
        for(int i = 0; i < testwerte.length; i++) {
            stapel.insert(testwerte[i]);
            assertEquals(testwerte.length, stapel.capacity(), "Kapazität stimmt nicht");
            assertEquals(i + 1, stapel.size(), "Größe stimmt nicht"); // i+1 weil größe immer 1 größer ist als i
        }
    }

    @Test
    void testTop(){
        for(int i = 0; i < testwerte.length; i++){
            stapel.insert(testwerte[i]);
            assertEquals(testwerte[i], stapel.top(), "Oberstes Element ist falsch");
        }
    }

    @Test
    void testIllegalStateException(){
        for(int i = 0; i < testwerte.length; i++){
            stapel.insert(testwerte[i]);
        }
        assertThrows(IllegalStateException.class, () -> stapel.insert(testwerte[0]), "Falsch eingefügt");
    }

    @Test
    void testNoSuchElementException(){
        assertThrows(NoSuchElementException.class, () -> stapel.remove(), "NoSuchElementException nicht geworfen nach entfernen");
        assertThrows(NoSuchElementException.class, () -> stapel.top(), "NoSuchElementException nicht geworfen nach aufrufen des 1. Elements");
    }

    @Test
    void testApplyToAll(){
        for(int i = 0; i < testwerte.length; i++){
            stapel.insert(testwerte[i]);
        }
        stapel.applyToAll(wert -> wert * 2);
        assertEquals(10, stapel.remove());
        assertEquals(8, stapel.remove());
        assertEquals(6, stapel.remove());
        assertEquals(4, stapel.remove());
        assertEquals(2, stapel.remove());

        for(int i = 0; i < testwerte.length; i++){
            stapel.insert(testwerte[i]);
        }
        stapel.applyToAll(wert -> wert * wert);
        assertEquals(25, stapel.remove());
        assertEquals(16, stapel.remove());
        assertEquals(9, stapel.remove());
        assertEquals(4, stapel.remove());
        assertEquals(1, stapel.remove());
    }
}