package Prog2.Übung5;

import Prog2.Übung4.DynArray;

import java.util.NoSuchElementException;

public class FolgeMitDynArray<T> implements Folge<T>{
    private DynArray<T> array;

    public FolgeMitDynArray(){
        array = new DynArray<>();
    }
    // Interface Puffer
    @Override
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    @Override
    public int size() {
        return this.array.getSize();
    }

    @Override
    public int capacity() {
        return this.array.getCapacity();
    }

    @Override
    public void insert(T o) {
        this.array.addLast(o);
    }

    @Override
    public T remove() throws NoSuchElementException {
        return this.array.removeLast();
    }

    // Interface Folge
    @Override
    public T remove(int pos) throws IndexOutOfBoundsException { // Neu
        return this.array.remove(pos);
    }

    @Override
    public void insert(int pos, T o) throws IndexOutOfBoundsException { // Neu
        this.array.add(pos, o);
    }

    @Override
    public T get(int pos) throws IndexOutOfBoundsException{
        return this.array.get(pos);
    }

    @Override
    public T set(int pos, T o) throws IndexOutOfBoundsException{
        return this.array.set(pos, o);
    }
}
