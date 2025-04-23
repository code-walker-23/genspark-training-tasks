package bird;

public class Dolphin extends Bird implements Eat, SaySomething {
    @Override
    public void eat() {
        System.out.println("Dolphin eating");
    }

    @Override
    public void saySomething() {
        System.out.println("Click Click");
    }
}