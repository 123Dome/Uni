package Prog2.Übung5;

import Prog2.Übung3.Puffer;

import java.util.NoSuchElementException;

public interface Folge<T> extends Puffer<T> {
    public T remove(int pos) throws IndexOutOfBoundsException;
    public void insert(int pos, T o) throws IndexOutOfBoundsException;
    public T get(int pos) throws IndexOutOfBoundsException, NoSuchElementException;
    public T set(int pos, T o) throws IndexOutOfBoundsException, NoSuchElementException;
}
