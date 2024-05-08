package task7.composer.order;

import task7.composer.order.goods.Priceble;

import java.util.ArrayList;
import java.util.List;

public class Box implements Priceble {
    List<Priceble> goods = new ArrayList<>();

    public Box() {}

    public Box(List<Priceble> goods) {
        this.goods = goods;
    }

    public Box addItem(Priceble item) {
        goods.add(item);
        return this;
    }

    @Override
    public double getPrice() {
        double price = 0;

        for (var i : goods) {
            price += i.getPrice();
        }

        return price;
    }
}
