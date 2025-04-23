package bird;

public class Pigeon extends Bird implements Fly, Eat {
    FlyingBehaviour flyingBehaviour;

    public Pigeon() {
        flyingBehaviour = new PigeonSparrowFlyingBehaviour();
    }

    @Override
    public void eat() {
        System.out.println("Pigeon eating");
    }

    @Override
    public void fly() {
        flyingBehaviour.flyingBehaviour();
    }
}
