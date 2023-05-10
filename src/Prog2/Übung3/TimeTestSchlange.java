package Prog2.Übung3;

public class TimeTestSchlange {
    public static void main(String[] args){
        int testgröße = 100000000;
        SchlangeMitArray<Integer> array = new SchlangeMitArray<>(testgröße);
        SchlangeMitEVL<Integer> evl = new SchlangeMitEVL<>();

        long start, finish, elapsed;

        start = System.currentTimeMillis();
        for(int i = 0; i < array.capacity(); i++){
            array.insert(i);
        }
        while(!array.isEmpty()){
            array.remove();
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println(elapsed);

        start = System.currentTimeMillis();
        for(int i = 0; i < testgröße; i++){
            evl.insert(i);
        }
        while(!evl.isEmpty()){
            evl.remove();
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println(elapsed);

    }
}
