package task6.factory;

public class Cat2Factory implements CatFactory{
    @Override
    public CatLike makeCat() {
        return new Cat2();
    }
}
