package Prog2.Übung3;

import java.util.NoSuchElementException;

public class SchlangeMitArray <T> implements Schlange <T>{
    private T[] schlange;
    private int size = 0;
    private int firstElement = 0;

    public SchlangeMitArray(int maxGroesse){
        this.schlange = (T[]) new Object[maxGroesse];
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.schlange.length;
    }

    @Override
    public void insert(T obj) throws IllegalStateException {
        if(this.size == this.capacity()) {
            throw new IllegalStateException();
        }

        if(this.size + this.firstElement < this.capacity()){
            this.schlange[this.firstElement + this.size] = obj;
        } else {
            this.schlange[(this.firstElement + this.size) % this.capacity()] = obj;
        }
        this.size++;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if(this.isEmpty()) {
            throw new NoSuchElementException();
        }
        // Für den Fall, dass das erste Element am Ende ist
        this.size--;
        if (this.firstElement == this.capacity() - 1){
            this.firstElement = 0;
            return this.schlange[this.capacity() - 1];
        } else {
            return this.schlange[this.firstElement++];
        }
    }

    @Override
    public T front() throws NoSuchElementException {
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        return this.schlange[firstElement];
    }
}