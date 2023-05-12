package Prog2.Übung4;

public class Euler {
    public static int berechne(int range) {
        int res = 0;
        for (int i = range; true; i += range) {
            for(int j = 1; i <= range; i++){
                if(j % i != 0) break;
            }
            return res = i;
        }
    }
}
