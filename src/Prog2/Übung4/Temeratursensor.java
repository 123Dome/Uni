package Prog2.Übung4;

public class Temeratursensor {
    private Ringpuffer<Float> messungen = new Ringpuffer<>(24);

    public void neueMessung(Float wert){
        try {
            messungen.addLast(wert);
        } catch (Exception e) {
            System.out.println("Puffer voll, also wird älteste Messung gelöscht");
            messungen.removeFirst();
            messungen.addLast(wert);
        }
    }

    public Float aktuelleTemperatur(){
        try {
            return this.messungen.get(messungen.getSize());
        } catch (Exception e) {
            return Float.NaN;
        }
    }

    public Float durchschnittsTemperatur(){
        try {
            Float res = this.messungen.get(messungen.getSize());
            return res /= this.messungen.getSize();
        } catch (Exception E) {
            return Float.NaN;
        }
    }

    public void reset(){
        for(int i = 0; i < this.messungen.getCapacity(); i++){
            this.messungen.removeLast();
        }
    }
}
