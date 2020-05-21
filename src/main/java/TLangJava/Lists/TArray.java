package TLangJava.Lists;

public class TArray<T extends Object> {
	private T[] list = (T[]) new Object[0];
	
	public TArray() {
	}
	
	public T add(T obj) {
		list = resize(this.list, this.size() + 2);
		list[list.length - 1] = obj;
		return obj;
	}
	
	public T[] resize(T[] list, int length) {
		T[] newList = (T[]) new Object[length];
		for (int i = 0; i < length; i++) {
			try {
				newList[i] = list[i];
			} catch (Exception err) {
				try {
					newList[i] = (T) list[0].getClass().newInstance();
				} catch (Exception err2) {
					newList[i] = null;
				}
			}
		}
		return newList;
	}
	
	public T get(int index) {
		return list[index];
	}
	
	public int indexOf(T obj) {
		int i = 0;
		for (T object : list) {
			if (obj.equals(object)) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	public boolean contains(T obj) {
		return indexOf(obj) != -1;
	}
	
	public int size() {
		return list.length - 1;
	}
}
