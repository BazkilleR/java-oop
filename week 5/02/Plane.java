
public class Plane extends Vehicle {

    public void setPlaneInfo(int s, String t) {
        setFuel(s);
        setTopSpeed(t);
    }

    public void fly() {
        int fuel = getFuel();
        if (fuel >= 200) {
            setFuel(fuel - 200);
            System.out.println("Fly.");
        } else {
            System.out.println("Please add fuel.");
        }
    }

    public void showPlaneInfo() {
        int fuel = getFuel();
        String topSpeed = getTopSpeed();
        System.out.println("Plane detail is, Fuel is " + fuel + " litre and Top Speed is " + topSpeed + " m/s.");
    }
}
