package Prog2.Übung3;

import java.util.NoSuchElementException;

public interface Puffer <T> {
    public boolean isEmpty();
    public int size();
    public int capacity();
    public void insert(T obj) throws IllegalStateException;
    public T remove() throws NoSuchElementException;
}