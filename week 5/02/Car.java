
public class Car extends Vehicle {

    private String typeEngine;

    public void setTypeEngine(String t) {
        this.typeEngine = t;
    }

    public String getTypeEngine() {
        return this.typeEngine;
    }

    public void showCarInfo() {
        int fuel = getFuel();
        String topSpeed = getTopSpeed();
        System.out.println("Car engine is " + this.typeEngine + ".");
        System.out.println("Fuel is " + fuel + " litre and Top Speed is " + topSpeed + " m/s.");
    }

    public void setCarInfo(int s, String t, String y) {
        setFuel(s);
        setTopSpeed(t);
        setTypeEngine(y);
    }

    public void move() {
        int fuel = getFuel();
        if (fuel >= 50) {
            setFuel(fuel - 50);
            System.out.println("Move.");
        } else {
            System.out.println("Please add fuel.");
        }

    }
}
