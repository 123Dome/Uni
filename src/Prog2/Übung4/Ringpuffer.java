package Prog2.Übung4;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.NoSuchElementException;

public class Ringpuffer<T> {
    private T[] array;
    private int capacity;
    private int size;
    private int vorne, hinten;

    public Ringpuffer(int capacity){
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
        this.size = 0;
        this.vorne = -1;
        this.hinten = -1;
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public T get(int pos) throws NoSuchElementException {
        if(this.isEmpty() || pos >= this.capacity || pos < 0) throw new NoSuchElementException();
        return this.array[(this.vorne + pos) % this.size];
    }

    public T set(int pos, T o) throws IndexOutOfBoundsException{
        if(pos < 0 || pos >= this.capacity || pos < 0) throw new IndexOutOfBoundsException();
        T tmp = this.array[(this.vorne + pos) % this.size];
        this.array[(this.vorne + pos) % this.size] = o;
        return tmp;
    }

    public void addFirst(T o) throws IndexOutOfBoundsException{
        if(this.size == this.capacity) throw new IndexOutOfBoundsException();

        if(this.vorne == -1) this.array[++this.vorne] = o; // Für das erste Element in der Liste

        if(this.vorne == 0){
            this.array[this.capacity - 1] = o;
            this.vorne = this.capacity - 1;
        } else {
            this.array[--this.vorne] = o;
        }

        this.size++;
    }

    public void addLast(T o) throws IndexOutOfBoundsException{
        if(this.size == this.capacity) throw new IndexOutOfBoundsException();

        if(this.hinten == this.capacity){
            this.array[0] = o;
            this.hinten = 0;
        } else {
            this.array[++this.hinten] = o;
        }

        this.size++;
    }

    public T removeFirst() throws NoSuchElementException{
        if(this.isEmpty()) throw new NoSuchElementException();
        this.size--;
        return this.array[this.vorne++];
    }

    public T removeLast() throws NoSuchElementException{
        if(this.isEmpty()) throw new NoSuchElementException();
        this.size--;
        return this.array[this.hinten--];
    }
}
