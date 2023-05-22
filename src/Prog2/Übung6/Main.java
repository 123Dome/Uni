package Prog2.Übung6;

public class Main {
    public static void main(String[] args){
        IntSuchbaum baum1 = new IntSuchbaum();
        IntSuchbaum baum2 = new IntSuchbaum();

        baum1.insert(33);
        baum1.insert(7);
        baum1.insert(43);
        baum1.insert(1);
        baum1.insert(20);
        baum1.insert(31);
        baum1.insert(67);

        baum2.insert(1);
        baum2.insert(7);
        baum2.insert(20);
        baum2.insert(31);
        baum2.insert(33);
        baum2.insert(43);
        baum2.insert(167);

        float ende = 0;
        float start = System.currentTimeMillis();
        baum1.contains(67);
        ende = System.currentTimeMillis();
        System.out.println(ende-start);

        ende = 0;
        start = System.currentTimeMillis();
        baum2.contains(67);
        ende = System.currentTimeMillis();
        System.out.println(ende-start);
    }
}
