package Prog2.Übung6;

import Prog2.Übung5.FolgeMitDynArray;

import java.util.NoSuchElementException;

public class IntSuchbaum {
    private KnotenElement startKnoten;

    public IntSuchbaum(){
        this.startKnoten = null;
    }

    class KnotenElement{
        Integer data;
        KnotenElement left;
        KnotenElement right;

        public KnotenElement(Integer v){
            data = v;
            left = null;
            right = null;
        }
    }

    public boolean isEmpty(){
        return this.startKnoten == null;
    }

    public void insert(Integer v){
        if(this.isEmpty()){
            this.startKnoten = new KnotenElement(v);
        } else {
            insertHilfe(v, this.startKnoten);
        }
    }

    private void insertHilfe(Integer v, KnotenElement k){
        if(v == k.data){
            return;
        } else if(v < k.data){
            this.insertLeft(v, k);
        } else {
            this.insertRight(v, k);
        }
    }

    private void insertLeft(Integer v, KnotenElement k){
        if(k.left == null){
            k.left = new KnotenElement(v);
        } else {
            this.insertHilfe(v, k.left);
        }
    }

    private void insertRight(Integer v, KnotenElement k){
        if(k.right == null){
            k.right = new KnotenElement(v);
        } else {
            this.insertHilfe(v, k.right);
        }
    }

    public boolean contains(Integer v){
        return this.containsHilfe(v, this.startKnoten);
    }

    private boolean containsHilfe(Integer v, KnotenElement k){
        if(null == k) return false;
        else if(v == k.data) return true;
        else if(k.data > v) return containsHilfe(v, k.left);
        else return containsHilfe(v, k.right);
    }

    @Override
    public String toString(){
        return this.toStringHilfe(this.startKnoten);
    }

    private String toStringHilfe(KnotenElement k){
        String s = "(";
        if(null != k) {
            s += this.toStringHilfe(k.left);
            s = s + k.data;
            s += this.toStringHilfe(k.right);
        }
        s += ")";
        return s;
    }

    public int hoehe(){
        return this.hoeheHilfe(this.startKnoten);
    }

    private int hoeheHilfe(KnotenElement k) {
        if (k == null) return 0;
        int linkerBaum = this.hoeheHilfe(k.left);
        int rechterBaum = this.hoeheHilfe(k.right);
        return 1 + Math.max(linkerBaum, rechterBaum);
    }

    public int size(){
        return this.size(this.startKnoten);
    }

    private int size(KnotenElement k){
        if (k == null) return 0;
        else{
            return 1 + this.size(k.left) + this.size(k.right);
        }
    }

    public FolgeMitDynArray preorder(){
        if(this.startKnoten == null) return null;
        FolgeMitDynArray<Integer> folge = new FolgeMitDynArray<>();
        preorderHilfe(this.startKnoten, folge);
        return folge;
    }
    private void preorderHilfe(KnotenElement rek,FolgeMitDynArray<Integer> folge){
        if (rek != null) {
            folge.insert(rek.data); // Füge den Inhalt zur Liste hinzu
            preorderHilfe(rek.left, folge);
            preorderHilfe(rek.right, folge);
        }
    }

    public FolgeMitDynArray inorder(){
        if(this.startKnoten == null) return null;
        FolgeMitDynArray<Integer> folge = new FolgeMitDynArray<>();
        inorderHilfe(this.startKnoten, folge);
        return folge;
    }
    private void inorderHilfe(KnotenElement rek,FolgeMitDynArray<Integer> folge){
        if (rek != null) {
            inorderHilfe(rek.left, folge);
            inorderHilfe(rek.right, folge);
            folge.insert(rek.data); // Füge den Inhalt zur Liste hinzu
        }
    }


}
