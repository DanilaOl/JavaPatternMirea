package task6.builder;

public class FirstEnemyBuilder implements EnemyBuilder{
    FirstEnemy firstEnemy = new FirstEnemy();

    @Override
    public void setHealthPoints() {
        firstEnemy.setHealthPoints(100);
    }

    @Override
    public void setDamage() {
        firstEnemy.setDamage(20);
    }

    @Override
    public void setName() {
        firstEnemy.setName("First enemy");
    }

    @Override
    public void reset() {
        firstEnemy = new FirstEnemy();
    }

    @Override
    public Enemy getResult() {
        return firstEnemy;
    }
}
