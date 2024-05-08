package task6;

import task6.abstractFactory.AnimalFactoryDriver;
import task6.abstractFactory.FirstAnimalFactory;
import task6.abstractFactory.SecondAnimalFactory;
import task6.builder.*;
import task6.factory.Cat1Factory;
import task6.factory.Cat2Factory;
import task6.factory.CatFactory;
import task6.prototype.First;
import task6.prototype.Second;

public class Main {
    public static void main(String[] args) {
        System.out.println("---Factory---");

        CatFactory cat1Factory = new Cat1Factory();
        CatFactory cat2Factory = new Cat2Factory();

        cat1Factory.goMeow();
        cat2Factory.goMeow();

        System.out.println("\n---Abstract Factory---");

        new AnimalFactoryDriver(new FirstAnimalFactory());
        new AnimalFactoryDriver(new SecondAnimalFactory());

        System.out.println("\n---Builder---");

        EnemyBuilder firstEnemyBuilder = new FirstEnemyBuilder();
        EnemyBuilder secondEnemyBuilder = new SecondEnemyBuilder();

        EnemyDirector firstEnemyDirector = new EnemyDirector(firstEnemyBuilder);
        EnemyDirector secondEnemyDirector = new EnemyDirector(secondEnemyBuilder);

        firstEnemyDirector.buildEnemy();
        secondEnemyDirector.buildEnemy();

        Enemy firstEnemy = firstEnemyBuilder.getResult();
        Enemy secondEnemy = secondEnemyBuilder.getResult();

        firstEnemy.ultimateAbility();
        secondEnemy.ultimateAbility();

        System.out.println("\n---Prototype---");

        First first = new First();
        Second second = new Second();

        System.out.println(first.getMessage());
        System.out.println(second.getText());

        First firstCopy = (First) first.copy();
        Second secondCopy = (Second) second.copy();

        System.out.println(firstCopy.getMessage());
        System.out.println(secondCopy.getText());

        System.out.println();

        if (first == firstCopy || second == secondCopy) {
            System.out.println("Wrong");
        }
        else {
            System.out.println("OK");
        }
    }
}
