package task6.abstractFactory;

public interface AnimalFactory {
    CatLike makeCat();
    DogLike makeDog();
}
