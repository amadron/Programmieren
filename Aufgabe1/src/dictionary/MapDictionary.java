package dictionary;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapDictionary<K,V> implements Dictionary<K,V> {
	
	private Map<K,V> Map;
	
	public MapDictionary(Map<K, V> map){
		Map = map;	
	}
	
	@Override
	public V insert(K key, V value) {
		V vOld = Map.get(key);
		Map.put(key, value);
		return vOld;
	}

	@Override
	public V search(K key) {
		if(Map.containsKey(key)){
			return Map.get(key);
		} else
			return null;
	}
	
	@Override
	public V remove(K key) {
		if(Map.containsKey(key)){
			V value = Map.get(key);
			Map.remove(key);
			return value;
		}
		else
			return null;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		Iterator entries = Map.entrySet().iterator();
		while(entries.hasNext()){
			Entry thisEntry = (Entry) entries.next();
			Object key = thisEntry.getKey();
			Object value = thisEntry.getValue();
			sb.append(key + " " + value + System.getProperty("line.separator"));
		}
		return sb.toString();
	}
}
