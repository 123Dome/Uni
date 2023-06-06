package Prog2.Übung4;

import java.util.NoSuchElementException;

public class Ringpuffer<T> { //TODO
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

    public T get(int pos) throws IndexOutOfBoundsException, NoSuchElementException {
        if(this.isEmpty()) throw new NoSuchElementException();
        if(pos >= this.capacity || pos < 0) throw new IndexOutOfBoundsException();
        return this.array[(this.vorne + pos) % this.capacity];
    }

    public T set(int pos, T o) throws IndexOutOfBoundsException, NoSuchElementException{
        if(this.isEmpty()) throw new NoSuchElementException();
        if(pos < 0 || pos >= this.capacity || pos < 0) throw new IndexOutOfBoundsException();
        T tmp = this.array[(this.vorne + pos) % this.capacity];
        this.array[(this.vorne + pos) % this.capacity] = o;
        return tmp;
    }

    public void addFirst(T o) throws IndexOutOfBoundsException{
        if(this.size == this.capacity) throw new IndexOutOfBoundsException();
        this.array[(this.vorne--) % this.capacity] = o;
        this.size++;
    }

    public void addLast(T o) throws IndexOutOfBoundsException{
        if(this.size == this.capacity) throw new IndexOutOfBoundsException();
        this.array[(this.hinten++) % this.capacity] = o;
        this.size++;
    }

    public T removeFirst() throws NoSuchElementException{
        if(this.isEmpty()) throw new NoSuchElementException();
        this.size--;
        return this.array[(++this.vorne) % this.capacity];
    }

    public T removeLast() throws NoSuchElementException{
        if(this.isEmpty()) throw new NoSuchElementException();
        this.size--;
        return this.array[(--this.hinten) % this.capacity];
    }

}
