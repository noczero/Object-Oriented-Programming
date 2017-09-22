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
public class AssessmentPBO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Animal bird = new Bird();
        bird.setSpecies("Burung");

        Animal fish = new Fish();
        fish.setSpecies("Fish");

        Animal mamalia = new Mamalia() {
            @Override
            public void setSpecies(String species) {
                this.species = species + "MAMALIAA";
            }
        };
        mamalia.setSpecies("INI");

        Person satrya = new Person("Satrya");
        satrya.addBinatang(bird);
        satrya.addBinatang(mamalia);
        satrya.addBinatang(fish);

        Person boy = new Person("Boy");
        boy.addBinatang(fish);
        boy.addBinatang(bird);
        boy.addBinatang(mamalia);

        Person hilal = new Person("Hilal");
        hilal.addBinatang(mamalia);
        hilal.addBinatang(bird);
        hilal.addBinatang(mamalia);

        System.out.println(satrya.getName());
        satrya.displayAnimal1();

        System.out.println(boy.getName());
        boy.displayAnimal1();

        System.out.println(hilal.getName());
        hilal.displayAnimal1();
    }

    public void sorting() {

    }
}
