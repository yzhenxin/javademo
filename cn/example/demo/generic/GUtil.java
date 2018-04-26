package cn.example.demo.generic;

public class GUtil {
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
	}

	public static <T extends Comparable<T>> int countGraterThan(T[] arr, T item) {
		int count = 0;
		for (T i : arr) {
			if (i.compareTo(item) > 0) {
				count++;
			}
			/*
			 * if(i > item) // compiler error count++;
			 */
		}
		return count;
	}

	public static void main(String[] args) {
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "apple");
		Pair<Integer, String> p2 = new Pair<Integer, String>(2, "bananar");

		System.out.println(GUtil.<Integer, String>compare(p1, p2));
		System.out.println(GUtil.compare(p1, p2));
	}
}

class Pair<K, V> {
	private K key;
	private V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}
