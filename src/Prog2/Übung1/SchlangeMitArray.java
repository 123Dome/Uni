package Prog2.Übung1;

import java.util.NoSuchElementException;

public class SchlangeMitArray implements Schlange{
    private int[] schlange;
    private int size = 0;
    private int firstElement = 0;

    public SchlangeMitArray(int maxGroesse){
        this.schlange = new int[maxGroesse];
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
    public void insert(int o) throws IllegalStateException {
        if(this.size == this.capacity()) {
            throw new IllegalStateException();
        }

        if(this.size + this.firstElement < this.capacity()){
            this.schlange[this.firstElement + this.size] = o;
        } else {
            this.schlange[(this.firstElement + this.size) % this.capacity()] = o;
        }
        this.size++;
    }

    @Override
    public int remove() throws NoSuchElementException {
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
    public int front() throws NoSuchElementException {
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        return this.schlange[firstElement];
    }
}
