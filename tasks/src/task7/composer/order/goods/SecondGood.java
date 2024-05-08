package task7.composer.order.goods;

public class SecondGood implements Priceble{
    private final double price;

    public SecondGood(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
