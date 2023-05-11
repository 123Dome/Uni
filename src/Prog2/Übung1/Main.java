package Prog2.Übung1;

public class Main {
    public static void main(String[] args){
        int a[] = {1,2,3,4,5};
        StapelMitArray stapel = new StapelMitArray(a.length);

        for(int i = 0; i < a.length; i++){
            stapel.insert(a[i]);
        }

        System.out.println("Stapel: ");
        for(int i = 0; i < a.length; i++){
            System.out.println(stapel.remove());
        }
    }
}
