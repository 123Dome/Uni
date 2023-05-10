package Prog2.Übung3;

import java.util.NoSuchElementException;

public class SchlangeMitEVL <T> implements Schlange <T>{
    private EVL<T> evl;

    public SchlangeMitEVL(){
        evl = new EVL<>();
    }


    @Override
    public boolean isEmpty() {
        return evl.isÉmpty();
    }

    @Override
    public int size() {
        return evl.size();
    }

    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void insert(T obj) throws IllegalStateException {
        evl.addLast(obj);
    }

    @Override
    public T remove() throws NoSuchElementException {
        return evl.removeFirst();
    }

    @Override
    public T front() throws NoSuchElementException {
        return evl.getFirst();
    }
}
