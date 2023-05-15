package Prog2.Übung5;

import Prog2.Übung4.DynArray;

import java.util.NoSuchElementException;

public class FolgeMitDynArray<T> implements Folge<T>{
    private DynArray<T> array;

    public FolgeMitDynArray(){
        array = new DynArray<>();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int capacity() {
        return 0;
    }

    @Override
    public T remove(int pos) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public void insert(T o) {

    }

    @Override
    public T remove() throws NoSuchElementException {
        return null;
    }

    @Override
    public void insert(int pos, T o) throws IndexOutOfBoundsException {

    }

    @Override
    public T get(int pos) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public T set(int pos, T o) throws IndexOutOfBoundsException {
        return null;
    }
}
