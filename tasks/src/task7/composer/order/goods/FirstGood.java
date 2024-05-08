package task7.composer.order.goods;

public class FirstGood implements Priceble {
    private final double price;

    public FirstGood(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
