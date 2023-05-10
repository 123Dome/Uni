package Prog2.Übung3;

import java.util.NoSuchElementException;

public class RDVL<T> {
    private ListenEl entry = null;
    private int size = 0;

    class ListenEl<T>{
        T data;
        ListenEl next;
        ListenEl prev;

        public ListenEl(T d){
            data = d;
            next = null;
            prev = null;
        }
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }

    public void add(T o){
        ListenEl e = new ListenEl(o);

        if(this.isEmpty()){
            this.entry = e;
            entry.next = entry;
            entry.prev = entry;
        } else if (this.size == 1){
            e.next = this.entry;
            entry.prev = e;
            e.prev = this.entry;
            entry.next = e;
        } else {
            ListenEl tmp = entry.prev; // Element vor entry
            entry.prev = e;
            tmp.next = e;
            e.next = this.entry;
            e.prev = tmp;
        }
        this.size++;
    }

    public T remove() throws NoSuchElementException {
        if (this.isEmpty()) throw new NoSuchElementException();
        T data = (T) this.entry.data;

        if(this.size == 1) {
            this.entry.next = null;
            this.entry.prev = null;
            this.entry = null;
        } else{
            this.entry.next.prev = this.entry.prev;
            this.entry.prev.next = this.entry.next;
            this.entry = this.entry.next;
        }
        return data;
    }

    public T element() throws NoSuchElementException{
        if(this.isEmpty()) throw new NoSuchElementException();
        return (T) this.entry.data;
    }

    public void next(int s) throws IllegalStateException{
        if(this.isEmpty()) throw new IllegalStateException();

        for(int i = 0; i < s; i++){
            this.entry = this.entry.next;
        }
    }

    public void prev(int s) throws IllegalStateException{
        if(this.isEmpty()) throw new IllegalStateException();

        for(int i = 0; i < s; i++){
            this.entry = this.entry.prev;
        }
    }

}
