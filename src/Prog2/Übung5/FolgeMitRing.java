package Prog2.Übung5;

import Prog2.Übung4.Ringpuffer;

import java.util.NoSuchElementException;

public class FolgeMitRing<T> implements Folge<T>{
    private Ringpuffer<T> ring;

    public FolgeMitRing(int capacity){
        this.ring = new Ringpuffer<>(capacity);
    }

    @Override
    public boolean isEmpty() {
        return this.ring.isEmpty();
    }

    @Override
    public int size() {
        return this.ring.getSize();
    }

    @Override
    public int capacity() {
        return this.ring.getCapacity();
    }

    @Override
    public T remove(int pos) throws IndexOutOfBoundsException { // Neu, entfernt Element und die dannach rücken nach
        if(pos < 0 || pos >= this.ring.getSize()) throw new NoSuchElementException();
        T tmp = this.ring.get(pos);
        for(int i = pos; i < this.ring.getSize(); i++){
            T temp = this.ring.get(pos+1);
            this.ring.set(pos, temp);
        }
        this.ring.removeLast();
        return tmp;
    }

    @Override
    public void insert(T o) {
        this.ring.addLast(o);
    }

    @Override
    public T remove() throws NoSuchElementException {
        return this.ring.removeFirst();
    }

    @Override
    public void insert(int pos, T o) throws IndexOutOfBoundsException { // Neu
        if(pos < 0 || pos >= this.ring.getSize()) throw new NoSuchElementException();

        if(pos == this.ring.getSize()-1){
            this.ring.addLast(o);
        } else {
            //TODO
        }
    }

    @Override
    public T get(int pos) throws IndexOutOfBoundsException {
        if(pos < 0 || pos >= this.ring.getSize()) throw new NoSuchElementException();
        return this.ring.get(pos);
    }

    @Override
    public T set(int pos, T o) throws IndexOutOfBoundsException {
        if(pos < 0 || pos >= this.ring.getSize()) throw new NoSuchElementException();
        return this.ring.set(pos, o);
    }
}
