
public class Player {

    private final String name;
    private final int attackDamage = 2;
    private Houses houses;
    private int hp = 20;
    private int mana = 50;

    public Player() {
        this("", 0);
    }

    public Player(String name) {
        this(name, 20);
    }

    public Player(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return this.name;
    }

    public int getHP() {
        return this.hp;
    }

    public void setHP(int hp) {
        if (hp < 0) {
            this.hp = 0;
            return;
        }

        if (hp > 20) {
            this.hp = 20;
            return;
        }
        this.hp = hp;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getMana() {
        return this.mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            return;
        }

        if (mana > 50) {
            mana = 50;
        }
        this.mana = mana;
    }

    public Houses getHouses() {
        return this.houses;
    }

    public void setHouses(Houses houses) {
        this.houses = houses;
    }

    @Override
    public String toString() {
        return "[Player] : " + name + " HP: " + hp + " Mana: " + mana + " || " + houses.toString();
    }

    public boolean equals(Player player) {
        return (this.name.equals(player.name)) || (this.houses.getName().equals(player.houses.getName()));
    }

    public void attack(Player target, Spell spell) {
        if (this.houses instanceof Gryffindor) {
            ((Gryffindor) houses).attackSpell(this, target, spell);
        } else if (this.houses instanceof Hufflepuff) {
            ((Hufflepuff) houses).attackSpell(this, target, spell);
        }

        if (target.getHP() <= 0) {
            System.out.println("[DEAD]: " + target.getName() + " was killed by " + this.name);
        }
    }

    public void protectFromPlayer(Player target) {
        if (this.houses instanceof Gryffindor) {
            ((Gryffindor) houses).defense(this, target);
        } else if (this.houses instanceof Hufflepuff) {
            ((Hufflepuff) houses).defense(this, target);
        }
    }
}
