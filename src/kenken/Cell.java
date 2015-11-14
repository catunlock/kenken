package kenken;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author busvar
 */
public class Cell implements Serializable{

    final private int posX;
    final private int posY;
    private int solutionValue;
    private int userValue;
    final private boolean original;
    private Set<Integer> setPossibleValues;
    
    /* ATRIBUTO NO OFICIAL DE LA ESPECIFICACION*/
    private int region = 0;

    /*METODO NO OFICIAL DE LA ESPECIFICACION*/
    public int getRegion() {
        return region;
    }

    /*METODO NO OFICIAL DE LA REGION*/
    public void setRegion(int region) {
        this.region = region;
    }
    

    /*  Pre: x i y han de respectar la mesura del Board i solution ha de ser un valor entre 1 i n
** Post: retornarà una instancia nova de Cell amb els parametres rebuts, notes
    i possibleValues amb ArrayLists buides i userValue amb valor -1
     */
    public Cell(int posX, int posY, boolean original, int solution) {
        this.posX = posX;
        this.posY = posY;
        this.original = original;
        this.solutionValue = solution;
        this.userValue = -1;
        //    this.possibleValues = new ArrayList <>();
        this.setPossibleValues = new HashSet<>();
    }

    /*  Pre: x i y han de respectar la mesura del Board i solution ha de ser un valor entre 1 i n
    ** Post: retornarà una instancia nova de Cell amb els parametres rebuts, notes
    i possibleValues amb ArrayLists buides i userValue amb valor -1
     */
    public Cell(int x, int y, boolean original) {
        this.posX = x;
        this.posY = y;
        this.original = original;
        this.solutionValue = -1;
        this.userValue = -1;
        //    this.possibleValues = new ArrayList<>();
        this.setPossibleValues = new HashSet<>();
    }

    /*  Pre: cert
    ** Post: retorna la posició de la fila on esta situada la cel·la.
     */
    public int getPosX() {
        return posX;
    }

    /*  Pre: cert
    ** Post: retorna el valor correcte de la cel·la.
     */
    public int getPosY() {
        return posY;
    }

    public int getSolutionValue() {
        return solutionValue;
    }

    /*  Pre: cert
    ** Post: retorna el valor que ha introduït l’usuari.
     */
    public int getUserValue() {
        return userValue;
    }

    /*  Pre: cert
    ** Post: Ens retorna si la Cel·la es original.
     */
    public boolean isOriginal() {
        return original;
    }

    /*  Pre: cert
    ** Post: retorna el ArrayList possibleValues
     */
 /* public ArrayList<Integer> getPossibleValues() {
        return possibleValues;
    }
     */
    public Set<Integer> getPossibleValues() {
        return new HashSet<> (setPossibleValues);
    }

    public int getSizePossibleValues() {
        return setPossibleValues.size();
    }

    /*  Pre: cert
    ** Post: retorna cert si userValue és igual a solutionValue, és a dir, si la cel.la es correcta
     */
    public boolean isCorrect() {
        return userValue == solutionValue;
    }

    /*  Pre: cert
    ** Post: se li assigna a la cel.la el valor que ha triat l’usuari.
     */
    public void setUserValue(int userValue) {
        this.userValue = userValue;
    }

    /* pre: cert
    **Post: afegeix un nou possible valor a la casella
     */
    public void addPossibleValue(int newVal) {
        boolean ok = setPossibleValues.add(newVal);
        //if(ok) possibleValues.add(newVal);
    }

    /* pre: oldValue es un valor possible
    **Post: borra un nou possible valor a la casella
     */
    public void removePossibleValue(int oldVal) {
        boolean ok = setPossibleValues.remove(oldVal);
        //if(ok) possibleValues.remove((Integer)oldVal);
    }

    public void setSolutionValue(int newVal) {
        if (this.solutionValue == -1) {
            this.solutionValue = newVal;
        }
    }
}
