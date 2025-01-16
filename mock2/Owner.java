
public class Owner {

    protected final String name;
    protected Animal animal;

    public Owner() {
        this("", null);
    }

    public Owner(String name) {
        this(name, null);
    }

    public Owner(Animal animal) {
        this("", animal);
    }

    public Owner(String name, Animal animal) {
        this.name = name;
        this.animal = animal;
    }

    public String getName() {
        return this.name;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Animal getAnimal() {
        return this.animal;
    }

    public void feedFood(Food f) {
        animal.setPower(animal.getPower() + f.getPower());
    }

    @Override
    public String toString() {
        return "Owner : name = " + name + ", Animal : name = " + animal.getName() + ", power = " + animal.getPower() + ", age = " + animal.getAge();
    }

    public void protectOwnerFrom(Animal a) {
        if (this.animal instanceof Pigeous) {
            ((Pigeous) this.animal).wingAttack(a);
        } else if (this.animal instanceof Dog) {
            ((Dog) this.animal).kick(a);
        }
    }
}
