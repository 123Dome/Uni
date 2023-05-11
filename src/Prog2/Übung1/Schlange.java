package Prog2.Übung1;

import java.util.NoSuchElementException;

public interface Schlange extends Puffer{
    public int front() throws NoSuchElementException;
}
