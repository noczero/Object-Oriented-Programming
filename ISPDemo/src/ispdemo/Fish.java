
package ispdemo;

public class Fish implements AnimalAction {

    // this method violate ISP
    @Override
    public void fly() {
        // Do nothing, fish cannot fly
    }

    @Override
    public void swim() {
        System.out.println("Ikan bisa berenang");
    }
    
}
