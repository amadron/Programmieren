 package dictionary;

import java.lang.Math;
import java.util.LinkedList;

public class HashDictionary<K,V> implements Dictionary<K,V>{
	
	private class entry<K,V>
	{
		K key;
		V value;
		
		entry(K Key, V Value){
			key = Key;
			value = Value;
		}
	}
	
	private int size = 16001;
	LinkedList<entry<K,V>>[] entries = new LinkedList[size];
	
	public HashDictionary(){
		for(int i = 0; i < entries.length;i++){
			entries[i] = new LinkedList<entry<K,V>>();
		}
	}
		

	@Override
	public V insert(K key, V value) {
		int no = (key.hashCode()%entries.length);
		if(no < 0)
			no = -no;
		if(no < entries.length){
			V ret = search(key);
			entries[no].add(new entry(key, value));
			return ret;
		} else return null;
	}

	@Override
	public V search(K key) {
		int no = key.hashCode()%entries.length;
		if (no < 0)
			no = -no;
		for(int i = 0; i < entries[no].size(); i++){
			if(entries[no].get(i).key.equals(key)){
			   return entries[no].get(i).value;
			}
		}
		return null;
	}

	@Override
	public V remove(K key) {
		V value = null;
		int no = key.hashCode()%entries.length;
		if (no < 0)
			no = -no;
		for(int i = 0; i < entries[no].size(); i++){
			if(entries[no].get(i).key.equals(key)){
				value = entries[no].get(i).value;
				entries[no].remove(i);
			}
		}
		return value;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < entries.length; i++){
			for(int j=0; j < entries[i].size(); j++){
				sb.append(entries[i].get(j).key +  " " + entries[i].get(j).value + System.getProperty("line.separator"));
			}
		}
		return sb.toString();
	}
	
}
