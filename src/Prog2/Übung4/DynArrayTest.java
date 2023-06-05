package Prog2.Übung4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynArrayTest {
    DynArray<Integer> array;

    @BeforeEach
    void setUp() {
        array = new DynArray<>();
    }

    @AfterEach
    void tearDown() {
        array = null;
    }

    @Test
    void testIsEmptyGetSizeGetCapacity(){
        assertEquals(0, array.getSize(), "Size muss 0 sein");
        assertEquals(1, array.getCapacity(), "Kapazität muss 1 sein");
        assertTrue(array.isEmpty(), "isEmpty muss true sein");
    }

    @Test
    void testSizehandlerGetSetAddMethodesRemoveMethodes(){
        array.addFirst(1); // 1
        array.addLast(3); // 1,3
        assertEquals(2, array.getCapacity(), "kapazität ist falsch nach sizehandler");
        assertEquals(1, array.get(0), "Get methode ist falsch");
        array.set(0, 5); // 5,3
        assertEquals(5, array.get(0), "Set methode ist falsch");
        assertEquals(3, array.get(1), "Set methode ist falsch");
        array.add(1, 2); // 5, 2, 3
        assertEquals(2, array.get(1), "Set methode ist falsch");
        assertEquals(3, array.get(2), "Set methode ist falsch");


        assertEquals(2, array.remove(1), "Remove(pos) ist falsch");
        assertEquals(5, array.removeFirst(), "RemoveFirst ist falsch");
        assertEquals(3, array.removeLast(), "RemoveLast ist flasch");
        assertEquals(1, array.getCapacity(), "Kapazität muss 1 sein");
    }
}