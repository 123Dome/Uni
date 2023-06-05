package Prog2.Übung7;

import Prog2.Übung5.Folge;
import Prog2.Übung5.FolgeMitDynArray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyClassTest {
    Folge<String> folge;

    @BeforeEach
    void setUp() {
        folge = new FolgeMitDynArray<>();;
    }

    @AfterEach
    void tearDown() {
        folge = null;
    }

    @Test
    void testMaxStringThrowsException() {
        assertThrows(NoSuchElementException.class, () -> {MyClass.maxString(folge);});
    }

    @Test
    void testMaxString(){
        folge.insert("");
        folge.insert("ABA");
        folge.insert("ABC");
        folge.insert("AB");

        assertEquals("ABC", MyClass.maxString(folge));
    }
}