package task8.iterator;

public class ItemIterator implements IteratorForItem{
	private final ItemList collection;
	private int iteration;

	public ItemIterator(ItemList collection) {
		this.collection = collection;
		this.iteration = 0;
	}


	@Override
	public Item getNext() {
		if (!hasMore()) {
			return null;
		}

		Item item = collection.items.get(iteration);
		iteration += 1;
		return item;
	}

	@Override
	public boolean hasMore() {
		return (iteration < collection.items.size());
	}

	@Override
	public void reset() {
		this.iteration = 0;
	}
}

