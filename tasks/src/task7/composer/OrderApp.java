package task7.composer;

import task7.composer.order.Box;
import task7.composer.order.goods.FirstGood;
import task7.composer.order.goods.SecondGood;

public class OrderApp {
    public OrderApp() {
        Box box1 = new Box();
        box1.addItem(new FirstGood(100)).addItem(new SecondGood(120));

        Box box2 = new Box().addItem(box1);
        box2.addItem(new FirstGood(130));
        System.out.println(box2.getPrice());
    }
}
