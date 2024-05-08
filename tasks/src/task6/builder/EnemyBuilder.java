package task6.builder;

public interface EnemyBuilder {
    void setHealthPoints();
    void setDamage();
    void setName();
    void reset();
    Enemy getResult();
}
