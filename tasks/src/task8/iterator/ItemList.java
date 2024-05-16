package task8.iterator;

import java.util.ArrayList;
import java.util.List;

public class ItemList implements IterableItem {
	public final List<Item> items = new ArrayList<>();

	public ItemList(int amount) {
		for (int i = 0; i < amount; i++) {
			items.add(new Item(i + 1));
		}
	}

	@Override
	public IteratorForItem createIterator() {
		return new ItemIterator(this);
	}
}
