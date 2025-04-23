package bird;

public class Crow extends Bird implements Fly, Eat, SaySomething {
    FlyingBehaviour flyingBehaviour;

    public Crow() {
        flyingBehaviour = new CrowEagleFlyingBehaviour();
    }

    @Override
    public void eat() {
        System.out.println("Crow eating");
    }

    @Override
    public void fly() {
        flyingBehaviour.flyingBehaviour();
    }

    @Override
    public void saySomething() {
        System.out.println("Caw Caw");
    }
}