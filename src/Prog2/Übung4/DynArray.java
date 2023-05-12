package Prog2.Übung4;

import java.util.NoSuchElementException;

public class DynArray<T> {
    private T[] array;
    private int size = 0;
    private int capacity = 1;

    public DynArray(){
        array = (T[]) new Object[this.capacity];
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

    private void increase(){
        this.capacity *= 2;
        T[] newArray = (T[]) new Object[capacity];
        this.size = 0;
        for(int i = 0; i < this.array.length; i++){
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    private void decrease(){
        capacity /= 2;
        T[] newArray = (T[]) new Object[capacity];
        this.size = 0;
        for(int i = 0; i < newArray.length; i++){
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    public T get(int pos) throws NoSuchElementException {
        if(this.isEmpty() || pos < 0 || pos > this.size) throw new NoSuchElementException();
        return array[pos];
    }

    public T set(int pos, T o) throws NoSuchElementException {
        if (this.isEmpty() || pos < 0 || pos > this.size) throw new NoSuchElementException();
        T tmp = this.array[pos];
        this.array[pos] = o;
        return tmp;
    }

    public void addFirst(T o){
        if(this.size == this.capacity) this.increase();
        this.size++;
        for(int i = 1; i < this.size; i++){
            this.array[i] = this.array[i - 1];
        }
        this.array[0] = o;
    }

    public void addLast(T o){
        if(this.size == this.capacity) this.increase();
        this.array[this.size++] = o;
    }

    public T removeFirst() throws NoSuchElementException{
        if(this.isEmpty()) throw new NoSuchElementException();
        T tmp = this.array[0];
        for(int i = 0; i < this.size; i++){
            this.array[i] = this.array[i+1];
        }
        if(4 * --this.size <= this.capacity) this.decrease();
        return tmp;
    }

    public T removeLast(){
        T tmp = this.array[--this.size];
        if(4 * this.size <= this.capacity)
            this.decrease();
        return tmp;

    }


}
