/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assessmentpbo;

/**
 *
 * @author Zero-Inside
 */
public abstract class Animal {
    String species;
    
    public abstract void setSpecies(String species);
    public abstract boolean moveable();
}
