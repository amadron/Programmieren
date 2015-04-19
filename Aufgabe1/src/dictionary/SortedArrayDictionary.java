package dictionary;

public class SortedArrayDictionary<K extends Comparable<? super K>,V> implements Dictionary<K,V>{
	
	private static class Entry<K,V> {
		K key;
		V value;
		
		Entry(K k, V v)
		{
			key = k;
			value = v;
		}
	}
	
	private static final int DEF_CAPACITY = 16;
	private int size;
	private Entry<K,V>[] data;
	
	@SuppressWarnings("uncecked")
	public SortedArrayDictionary() {
		size = 0;
		data = new Entry[DEF_CAPACITY];
	}
	
	@SuppressWarnings("unchecked")
	private void ensureCapacity(int newCapacity) {
		if (newCapacity < size)
			return;
		Entry[] old  = data;
		data = new Entry[newCapacity];
		System.arraycopy(old, 0, data, 0, size);
		
	}
	
	@Override
	public V insert(K key, V value) {
		int i = searchKey(key);
		
		if (i != -1) {
			V r = data[i].value;
			data[i].value = value;
			return r;
		}
		
		if (data.length == size){
			ensureCapacity(2*size);
		}
		int j = size-1;
		while (j >= 0 && key.compareTo(data[j].key) < 0){
			data[j+1] = data[j];
			j--;
		}
		data[j+1] = new Entry<K,V>(key, value);
		size++;
		return null;
	}
	
	@Override
	public V search(K key) {
		int i = searchKey(key);
		if(i >=0)
		return data[i].value;
		else
			return null;
	}
	
	private int searchKey(K key){
		int li = 0;
		int re = size-1;
		
		while (re >= li){
			int m = (li+re)/2;
			if(key.compareTo(data[m].key) < 0)
				re = m-1;
			else if (key.compareTo(data[m].key) > 0)
				li = m +1;
			else
				return m;
		}
		return -1;
		
	}

	@Override
	public V remove(K key) {
		int i = searchKey(key);
		if(i == -1)
			return null;
		
		V r = data[i].value;
		for (int j = i; j < size-1; j++)
			data[j] = data[j+1];
		data[--size] = null;
		return r;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i++){
			sb.append(data[i].key+ " " + data[i].value + System.getProperty("line.separator"));
		}
		return sb.toString();
	}

}
