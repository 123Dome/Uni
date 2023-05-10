package Prog2.Übung3;

import java.util.NoSuchElementException;

public class EVL <T>{
    private ListenEl first = null;
    private ListenEl last = null;
    private int size = 0;

    class ListenEl<T>{
        T data;
        ListenEl next;

        public ListenEl(T d){
            data = d;
            next = null;
        }
    }

    public boolean isÉmpty(){
        return this.first == null;
    }

    // Gibt die Daten vom ersten Element
    public T getFirst() throws NoSuchElementException{
        if(this.isÉmpty()) throw new NoSuchElementException();
        return (T) this.first.data;
    }

    // Gibt die Daten vom letzten Element
    public T getLast() throws NoSuchElementException{
        if(this.isÉmpty()) throw new NoSuchElementException();
        return (T) this.last.data;
    }

    public void addFirst(T d){
        ListenEl e = new ListenEl(d);
        if(this.isÉmpty()) {
            this.first = e;
            this.last = e;
        }
        e.next = this.first;
        this.first = e;
        this.size++;
    }

    public void addLast(T d){
        ListenEl e = new ListenEl(d);
        if(this.isÉmpty()) {
            this.first = e;
            this.last = e;
        }
        this.last.next = e;
        this.last = e;
        this.size++;
    }

    public T removeFirst() throws NoSuchElementException{
        if(this.isÉmpty()) throw new NoSuchElementException();
        T tmp = (T) this.first.data;
        this.first = this.first.next;
        this.size--;
        return tmp;
    }

    public T removeLast() throws NoSuchElementException{
        if(this.isÉmpty()) throw new NoSuchElementException();
        T tmp = (T) this.last.data;
        ListenEl temp;
        for(temp = this.first; temp.next != this.last; temp = temp.next);
        temp.next = null;
        this.last = temp;
        this.size--;
        return tmp;
    }

    public boolean contains(T o) throws NoSuchElementException{
        if(this.isÉmpty()) throw new NoSuchElementException();
        for(ListenEl tmp = this.first; tmp.next != null; tmp = tmp.next){
            if(tmp.data.equals(o)) return true;
        }
        return false;
    }

    public int size(){
        return this.size;
    }

    @Override
    public String toString() {
        if(this.isÉmpty()) return "";
        return toString1(this.first);
    }

    public String toString1(ListenEl e){
        if(e.next == null){
            return "" + e.data;
        } else {
            return e.data + "-" + this.toString1(e.next);
        }
    }

    public void zip(EVL<T> other) {
        if (isÉmpty()) {
            return;
        }

        ListenEl currentThis = first;
        ListenEl currentOther = other.first;
        ListenEl currentOther2 = null;

        while (currentThis != null && currentOther != null) {
            ListenEl nextThis = currentThis.next;
            ListenEl nextOther = currentOther.next;

            currentThis.next = currentOther;
            currentOther.next = nextThis;

            currentOther2 = currentOther;
            currentThis = nextThis;
            currentOther = nextOther;
        }

        if (currentThis == null && currentOther2 != null) {
            currentOther2.next = currentOther;
        }

        size += other.size();
        other.first = null;
        other.size = 0;
    }
}
