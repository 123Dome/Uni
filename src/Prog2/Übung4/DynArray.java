package Prog2.Übung4;

import java.util.NoSuchElementException;

public class DynArray<T> {
    private T[] array;
    private int startgröße = 1;
    private int size = 0;

    public DynArray(){
        array = (T[]) new Object[this.startgröße];
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity(){
        return this.array.length;
    }

    public T get(int pos) throws NoSuchElementException {
        if(this.isEmpty()) throw new NoSuchElementException();


    }
}
