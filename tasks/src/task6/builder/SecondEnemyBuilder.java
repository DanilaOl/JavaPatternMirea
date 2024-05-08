package task6.builder;

public class SecondEnemyBuilder implements EnemyBuilder{
    SecondEnemy secondEnemy = new SecondEnemy();

    @Override
    public void setHealthPoints() {
        secondEnemy.setHealthPoints(150);
    }

    @Override
    public void setDamage() {
        secondEnemy.setDamage(30);
    }

    @Override
    public void setName() {
        secondEnemy.setName("Second enemy");
    }

    @Override
    public void reset() {
        secondEnemy = new SecondEnemy();
    }

    @Override
    public Enemy getResult() {
        return secondEnemy;
    }
}
