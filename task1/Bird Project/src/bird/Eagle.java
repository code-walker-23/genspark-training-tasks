package bird;

public class Eagle extends Bird implements Fly, Eat, SaySomething {
    FlyingBehaviour flyingBehaviour;

    public Eagle() {
        flyingBehaviour = new CrowEagleFlyingBehaviour();
    }

    @Override
    public void eat() {
        System.out.println("Eagle eating");
    }

    @Override
    public void fly() {
        flyingBehaviour.flyingBehaviour();
    }

    @Override
    public void saySomething() {
        System.out.println("Screech");
    }
}