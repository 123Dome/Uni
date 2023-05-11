package Prog2.Übung1;

public class Student extends Person{
    private int matrikelnummer;

    public Student(String pName, String pVorname, int pMatrikelnummer){
        super(pName, pVorname);
        this.matrikelnummer = pMatrikelnummer;
    }

    public int getMatrikel(){
        return this.matrikelnummer;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.matrikelnummer;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student){
            return (((Student) obj).getMatrikel() == this.matrikelnummer && super.equals(obj));
        } else {
            return super.equals(obj);
        }
    }
}
