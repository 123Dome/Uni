package Prog2.Übung4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EulerTest {
    Euler euler = new Euler();
    @Test
    void berechne() {
        assertEquals(2520, euler.berechne(10), "Zahl ist falsch");
    }
}