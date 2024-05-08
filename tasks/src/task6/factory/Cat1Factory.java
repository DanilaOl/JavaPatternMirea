package task6.factory;

public class Cat1Factory implements CatFactory {
    @Override
    public CatLike makeCat() {
        return new Cat1();
    }
}
