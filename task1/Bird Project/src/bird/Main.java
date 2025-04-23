package bird;

public class Main {
    public static void main(String[] args) {
        // Pigeon
        Pigeon pigeon = new Pigeon();
        System.out.println("[Pigeon]");
        pigeon.setName("Pigeon");
        pigeon.setColor("Gray");
        pigeon.setWeight(1);
        System.out.println("- Color: " + pigeon.getColor());
        System.out.println("- Weight: " + pigeon.getWeight() + " kg");
        pigeon.fly();
        pigeon.eat();
        System.out.println();

        // Sparrow
        Sparrow sparrow = new Sparrow();
        System.out.println("[Sparrow]");
        sparrow.setName("Sparrow");
        sparrow.setColor("Brown");
        sparrow.setWeight(1);
        System.out.println("- Color: " + sparrow.getColor());
        System.out.println("- Weight: " + sparrow.getWeight() + " kg");
        sparrow.fly();
        sparrow.eat();
        System.out.println();

        // Crow
        Crow crow = new Crow();
        System.out.println("[Crow]");
        crow.setName("Crow");
        crow.setColor("Black");
        crow.setWeight(2);
        System.out.println("- Color: " + crow.getColor());
        System.out.println("- Weight: " + crow.getWeight() + " kg");
        crow.fly();
        crow.eat();
        crow.saySomething();
        System.out.println();

        // Eagle
        Eagle eagle = new Eagle();
        System.out.println("[Eagle]");
        eagle.setName("Eagle");
        eagle.setColor("Brown");
        eagle.setWeight(5);
        System.out.println("- Color: " + eagle.getColor());
        System.out.println("- Weight: " + eagle.getWeight() + " kg");
        eagle.fly();
        eagle.eat();
        eagle.saySomething();
        System.out.println();

        // Dolphin (Non-bird example)
        Dolphin dolphin = new Dolphin();
        System.out.println("[Dolphin]");
        dolphin.setName("Dolphin");
        dolphin.setColor("Blue");
        dolphin.setWeight(50);
        System.out.println("- Color: " + dolphin.getColor());
        System.out.println("- Weight: " + dolphin.getWeight() + " kg");
        dolphin.eat();
        dolphin.saySomething();
        System.out.println();
    }
}
