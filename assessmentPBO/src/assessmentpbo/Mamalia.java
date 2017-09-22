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
public class Mamalia extends Animal {

    @Override
    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public boolean moveable() {
        return true;
    }

    @Override
    public String toString(){
        return super.species + "," + moveable();
    }
}
