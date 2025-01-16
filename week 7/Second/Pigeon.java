
public class Pigeon extends Bird {

    private static int numberOfPigeon;

    public Pigeon() {
        super(0.0, 0.0, 0.0);
        numberOfPigeon += 1;
    }

    public Pigeon(double wingSize, double weight, double height) {
        super(wingSize, weight, height);
        numberOfPigeon += 1;
    }

    public void eat(String food) {
        switch (food) {
            case "worm":
                setWeight(getWeight() + 0.5);
                break;
            case "seed":
                setWeight(getWeight() + 0.2);
                break;
            default:
                System.out.println("Pigeon can eat only worm and seed.");
        }
    }

    @Override
    public void fly() {
        setWeight(getWeight() - 0.25);
        if (getWeight() >= 5) {
            System.out.println("Fly Fly");
        } else {
            System.out.println("I'm hungry.");
        }
    }

    @Override
    public void takeOff() {
        setWeight(getWeight() - 0.5);
        if (getWeight() >= 5) {
            System.out.println("Take Off");
        } else {
            System.out.println("I'm hungry.");
        }
    }

    @Override
    public void landing() {
        setWeight(getWeight() - 0.5);
        if (getWeight() >= 5) {
            System.out.println("Landing");
        } else {
            System.out.println("I'm hungry.");
        }
    }

    @Override
    public String toString() {
        return "Pigeon " + getWeight() + " kg and " + " " + getHeight() + " cm. There are " + numberOfPigeon + " pigeons.";
    }

}
