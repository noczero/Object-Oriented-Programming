package ispdemo;

public class Bird implements AnimalAction {

    @Override
    public void fly() {
        System.out.println("Burung bisa terbang");
    }

    // this method violate ISP
    @Override
    public void swim() {
        // Do nothing, bird cannot swim;
    }
    
}
