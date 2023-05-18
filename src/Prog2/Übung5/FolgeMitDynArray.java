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
    public T remove(int pos) throws IndexOutOfBoundsException { // Neu
        if(pos < 0 || pos >= this.array.getSize()) throw new NoSuchElementException();
        T tmp = this.array.get(pos);
        for(int i = pos; i < this.array.getSize(); i++){
            T temp = this.array.get(pos+1);
            this.array.set(pos, temp);
        }
        this.array.removeLast();
        return tmp;
    }

    @Override
    public void insert(T o) {
        this.array.addLast(o);
    }

    @Override
    public T remove() throws NoSuchElementException {
        return this.array.removeFirst();
    }

    @Override
    public void insert(int pos, T o) throws IndexOutOfBoundsException { // Neu
        if(pos < 0 || pos >= this.array.getSize()) throw new NoSuchElementException();
        if(pos == this.array.getSize()-1){
            this.array.addLast(o);
        } else {
            //TODO
        }
    }

    @Override
    public T get(int pos) throws IndexOutOfBoundsException {
        return this.array.get(pos);
    }

    @Override
    public T set(int pos, T o) throws IndexOutOfBoundsException {
        return this.array.set(pos, o);
    }
}
