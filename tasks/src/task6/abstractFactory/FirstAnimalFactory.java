package task6.abstractFactory;

public class FirstAnimalFactory implements AnimalFactory{
    @Override
    public CatLike makeCat() {
        return new FirstCat();
    }

    @Override
    public DogLike makeDog() {
        return new FirstDog();
    }
}
