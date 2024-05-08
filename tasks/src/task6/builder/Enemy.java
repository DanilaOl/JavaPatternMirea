package task6.builder;

public abstract class Enemy {
    private int healthPoints = 0;
    private int damage = 0;
    private String name = "enemy";

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    @SuppressWarnings("unused")
    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    abstract public void ultimateAbility();

    @Override

    public String toString() {
        return "I am a " + name +
                ", my HP: " + healthPoints +
                ", my Damage: " + damage;
    }
}