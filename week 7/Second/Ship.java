
public class Ship extends Vehicle implements Floatable {

    public Ship() {
        super(0.0);
    }

    public Ship(double fuel) {
        super(fuel);
    }

    @Override
    public void fl0at() {
        if (fuel >= 50) {
            this.fuel -= 50;
            System.out.println("Ship moves");
        } else {
            System.out.println("Fuel is not enough.");
        }
    }

    @Override
    public void startEngine() {
        if (fuel >= 10) {
            this.fuel -= 10;
            System.out.println("Engine starts");
        } else {
            System.out.println("Fuel is not enough.");
        }
    }

    @Override
    public void stopEngine() {
        System.out.println("Engine stops");
    }

    @Override
    public void honk() {
        System.out.println("Shhhhh");
    }

    public void move() {
        fl0at();
    }

    public void move(int distance) {
        for (int i = 0; i < distance; i++) {
            if (fuel < 50) {
                System.out.println("Fuel is not enough.");
                break;
            }
            fl0at();
        }
    }

}
