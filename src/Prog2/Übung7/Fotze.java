package Prog2.Übung7;

import Prog2.Übung5.Folge;

import java.util.NoSuchElementException;

public class Fotze implements Comparable<Fotze>{
     private int bar;

    @Override
    public int compareTo(Fotze other) {
        return 0;
    }

    public String maxString(Folge<String> input) throws NoSuchElementException {
        if(input.isEmpty()) throw new NoSuchElementException();
        String maxString = input.get(0);
        for(int i = 1; i < input.size(); i++){
            if(input.get(i).compareTo(maxString) > 1) maxString = input.get(i);
        }
        return  maxString;
    }
}
