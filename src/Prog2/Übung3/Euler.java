package Prog2.Übung3;

public class Euler {
    public static int quadrate(int range){
        int res = 0;
        int tmp1 = 0;
        for(int i = 1; i <= range; i++){
            tmp1 += i*i;
        }
        int tmp2 = 0;
        for (int i = 0; i <= range; i++){
            tmp2 += i;
        }
        tmp2 = tmp2 * tmp2;
        res = tmp2 - tmp1;
        return res;
    }
}
