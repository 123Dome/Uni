package Prog2.Übung1;

import java.util.NoSuchElementException;

public class StapelMitArray implements Stapel{
    private int[] stapel;
    private int size = 0;
    public StapelMitArray(int maxGroesse){
        this.stapel = new int[maxGroesse];
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return this.stapel.length;
    }

    @Override
    public void insert(int o) throws IllegalStateException {
        if(this.size == this.capacity()) {
            throw new IllegalStateException();
        }
        this.stapel[this.size++] = o;
    }

    @Override
    public int remove() throws NoSuchElementException {
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        return this.stapel[--this.size];
    }

    @Override
    public int top() throws NoSuchElementException {
        if(this.isEmpty()) throw new NoSuchElementException();
        return this.stapel[this.size-1];
    }

    public void applyToAll(Funktion obj){
        for(int i = 0; i < this.capacity(); i++){
            this.stapel[i] = obj.auswerten(this.stapel[i]);
        }
    }
}
