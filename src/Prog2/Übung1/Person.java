package Prog2.Übung1;

public abstract class Person {
    private String name;
    private String vorname;

    public Person(String pVorname, String pName){
        this.name = pName;
        this.vorname = pVorname;
    }

    public String getName(){
        return this.name;
    }

    public String getVorname(){
        return this.vorname;
    }
    @Override
    public String toString(){
        return this.name + ", " + this.vorname;
    }

    @Override
    public boolean equals(Object obj) {
        return this.equals(obj);
    }
}
