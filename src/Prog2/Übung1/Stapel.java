package Prog2.Übung1;

import java.util.NoSuchElementException;

public interface Stapel extends Puffer{
    public int top() throws NoSuchElementException;
}
