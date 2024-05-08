package task6.factory;

public interface CatFactory {
    CatLike makeCat();

    default void goMeow() {
        CatLike cat = makeCat();
        cat.meow();
    }
}
