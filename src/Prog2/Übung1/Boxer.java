package Prog2.Übung1;

public class Boxer extends Person {
    private int gewicht;

    public Boxer(String pName, String pVorname, int pGewicht){
        super(pName, pVorname);
        this.gewicht = pGewicht;
    }

    public int getGewicht() {
        return gewicht;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.gewicht;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Boxer){
            return (((Boxer) obj).getGewicht() == this.gewicht && super.equals(obj));
        } else {
            return super.equals(obj);
        }
    }
}
