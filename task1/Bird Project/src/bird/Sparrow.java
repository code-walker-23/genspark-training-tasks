package bird;

public class Sparrow extends Bird implements Fly, Eat {
    FlyingBehaviour flyingBehaviour;

    public Sparrow() {
        flyingBehaviour = new PigeonSparrowFlyingBehaviour();
    }

    @Override
    public void eat() {
        System.out.println("Sparrow eating");
    }

    @Override
    public void fly() {
        flyingBehaviour.flyingBehaviour();
    }

}