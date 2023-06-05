package Prog2.Übung7;

import Prog2.Übung5.Folge;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class MyClass {
    public static String maxString(Folge<String> input) throws NoSuchElementException {
        if(input.isEmpty()) throw new NoSuchElementException();

        String maxString = input.get(0);
        for(int i = 1; i < input.size(); i++){
            String element = input.get(i);
            if(maxString.compareTo(element) < 0) maxString = element;
        }
        return maxString;
    }

    public static String maxString(Folge<String> input, Comparator<String> comp){
        return null;
    }
}
