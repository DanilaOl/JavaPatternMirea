package task6.abstractFactory;

public class SecondAnimalFactory implements AnimalFactory{
    @Override
    public CatLike makeCat() {
        return new SecondCat();
    }

    @Override
    public DogLike makeDog() {
        return new SecondDog();
    }
}
