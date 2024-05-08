package task6.abstractFactory;

public class AnimalFactoryDriver {
    public final AnimalFactory animalFactory;

    public AnimalFactoryDriver(AnimalFactory animalFactory) {
        this.animalFactory = animalFactory;

        animalFactory.makeCat().meow();
        animalFactory.makeDog().bark();
    }
}
