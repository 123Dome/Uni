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
        return this.capacity;
    }

    private void sizehandler(){
        if(this.isEmpty()){
            this.capacity = 1;
            this.array = (T[]) new Object[this.capacity];
        }
        if(4 * this.size <= this.capacity && !this.isEmpty()){
            capacity /= 2;
            T[] newArray = (T[]) new Object[capacity];
            for(int i = 0; i < this.size; i++){
                newArray[i] = this.array[i];
            }
            this.array = newArray;
        }
        if(this.size == this.capacity){
            this.capacity *= 2;
            T[] newArray = (T[]) new Object[capacity];
            for(int i = 0; i < this.size; i++){
                newArray[i] = this.array[i];
            }
            this.array = newArray;
        }
    }

    public T get(int pos) throws IndexOutOfBoundsException {
        if(this.isEmpty() || pos < 0 || pos > this.size) throw new NoSuchElementException();
        return array[pos];
    }

    public T set(int pos, T o) throws IndexOutOfBoundsException {
        if (this.isEmpty() || pos < 0 || pos > this.size) throw new NoSuchElementException();
        T tmp = this.array[pos];
        this.array[pos] = o;
        return tmp;
    }

    public void addFirst(T o){ // Vor ersten Element hinzufügen
        this.sizehandler();
        for(int i = this.size; i > 0; i--){
            this.array[i] = this.array[i - 1];
        }
        this.array[0] = o;
        this.size++;
    }

    public void addLast(T o){ // Hinter letzten Element hinzufügen
        this.sizehandler();
        this.array[this.size++] = o;
    }

    public void add(int pos, T o) throws IndexOutOfBoundsException{ // Objekt in der Mitte hinzufügen (Ü5)
        if(pos < 0 || pos >= this.size) throw new IndexOutOfBoundsException();

        if(pos == this.size){
            this.addLast(o);
        } else if (pos == 0){
            this.addFirst(o);
        } else {
            this.sizehandler();
            for(int i = this.size++; i > pos; i--){
                this.array[i] = this.array[i - 1];
            }
            this.array[pos] = o;
        }
    }

    public T removeFirst() throws NoSuchElementException{ // Erstes Element entfernen
        if(this.isEmpty()) throw new NoSuchElementException();

        T tmp = this.array[0];
        for(int i = 0; i < this.size - 1; i++){
            this.array[i] = this.array[i+1];
        }
        this.size--;
        this.sizehandler();
        return tmp;
    }

    public T removeLast(){ // Letztes Element entfernen
        T tmp = this.array[--this.size];
        this.sizehandler();
        return tmp;
    }

    public T remove(int pos) throws IndexOutOfBoundsException{ // Im Array Element entfernen (Ü5)
        if(pos < 0 || pos >= this.size) throw new IndexOutOfBoundsException();
        T tmp = this.array[pos];
        for(int i = pos; i < this.size - 1; i++){ // Array verschieben
            this.array[i] = this.array[i+1];
        }
        this.removeLast();
        return tmp;
    }
}
