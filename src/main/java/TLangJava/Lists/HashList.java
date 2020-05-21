package TLangJava.Lists;

public class HashList<T extends Object, H extends Object> {
	private TArray<T> keys = new TArray<>();
	private TArray<H> objs = new TArray<>();
	
	public HashList() {
	}
	
	public T put(T key, H object) {
		if (!this.containsKey(key)) {
			keys.add(key);
			objs.add(object);
		}
		return key;
	}
	
	public H get(T key) {
		if (this.containsKey(key)) {
			return objs.get(keys.indexOf(key));
		}
		throw new RuntimeException(new NullPointerException("Could not find key:" + key));
	}
	
	public H getObject(int index) {
		return objs.get(index);
	}
	
	public T getKey(int index) {
		return keys.get(index);
	}
	
	public boolean containsKey(T key) {
		return keys.contains(key);
	}
	
	public boolean containsObject(H object) {
		return objs.contains(object);
	}
	
	public int size() {
		return keys.size();
	}
	
	public TArray<T> keySet() {
		return keys;
	}
	
	public TArray<H> objects() {
		return objs;
	}
}
