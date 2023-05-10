package Prog2.Übung3;

public class Josephus {
    public int loese(int n, int k){
        RDVL<Integer> rdvl = new RDVL<>();

        for(int i = n; i > 0; i--){
            rdvl.add(i);
            rdvl.prev(1);
        }

        while(rdvl.size() > 1){
            rdvl.next(k);
            rdvl.remove();
        }
        return rdvl.element();
    }
}
