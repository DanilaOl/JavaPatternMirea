package task3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class MapLock<K, V> implements Map<K, V> {

	private final Map<K, V> map = new HashMap<>();
	private static final ReentrantLock lock = new ReentrantLock();

	@Override
	public int size() {
		lock.lock();
		int size = map.size();
		lock.unlock();

		return size;
	}

	@Override
	public boolean isEmpty() {
		lock.lock();
		boolean isEmpty = map.isEmpty();
		lock.unlock();

		return isEmpty;
	}

	@Override
	public boolean containsKey(Object key) {
		lock.lock();
		boolean containsKey = map.containsKey(key);
		lock.unlock();

		return containsKey;
	}

	@Override
	public boolean containsValue(Object value) {
		lock.lock();
		boolean containsValue = map.containsValue(value);
		lock.unlock();

		return containsValue;
	}

	@Override
	public V get(Object key) {
		lock.lock();
		V value = map.get(key);
		lock.unlock();

		return value;
	}

	@Override
	public V put(K key, V value) {
		lock.lock();
		V oldValue = map.put(key, value);
		lock.unlock();

		return oldValue;
	}

	@Override
	public V remove(Object key) {
		lock.lock();
		V oldValue = map.remove(key);
		lock.unlock();

		return oldValue;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		lock.lock();
		map.putAll(m);
		lock.unlock();
	}

	@Override
	public void clear() {
		lock.lock();
		map.clear();
		lock.unlock();
	}

	@Override
	public Set<K> keySet() {
		lock.lock();
		Set<K> keySet = map.keySet();
		lock.unlock();

		return keySet;
	}

	@Override
	public Collection<V> values() {
		lock.lock();
		Collection<V> values = map.values();
		lock.unlock();

		return values;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		lock.lock();
		Set<Entry<K, V>> entrySet = map.entrySet();
		lock.unlock();

		return entrySet;
	}
}
