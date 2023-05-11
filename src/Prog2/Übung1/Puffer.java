package Prog2.Übung1;

import java.util.NoSuchElementException;

public interface Puffer {
    public boolean isEmpty();
    public int size();
    public int capacity();
    public void insert(int o) throws IllegalStateException;
    public int remove() throws NoSuchElementException;
}
