package dictionary;


public class TreeDictionary <K extends Comparable<? super K>,V>  implements Dictionary<K,V> {
	public TreeDictionary(){
	}
	
	static private class Node<K,V>{
		int height;
		K key;
		V value;
		Node<K,V> left;
		Node<K,V> right;
		
		private Node(K k, V v){
			height = 0;
			key = k;
			value = v;
			left = null;
			right = null;
		}
	}
	
	private static class Entry<K, V>{
		private K key;
		private V value;
	}
	
	private Node<K,V> root;
	
	
	private int getHeight(Node<K, V> p) {
		if(p == null){
			return -1;
		} else {
			return p.height;
		}
		
	}
	
	private int getBalance(Node<K,V> p){
		if(p == null){
			return 0;
		} else
			return getHeight(p.right)-getHeight(p.left);
	}
	
	
		
	private Node<K,V> balance(Node<K,V> p){
		if(p == null)
			return null;
		p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
		if(getBalance(p) == -2){
			if(getBalance(p.left) <= 0)
				p = rotateRight(p); 
			else
				p= rotateLeftRight(p);
		}
		else if (getBalance(p) == +2){
			if(getBalance(p.right) >= 0)
				p = rotateLeft(p);
			else
				p = rotateRightLeft(p);
		}
		return p;
	}
	
	private Node<K,V> rotateRight(Node<K,V> p){
		assert p.left != null;
		Node<K,V> q = p.left;
		p.left = q.right;
		q.right = p;
		p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
		q.height = Math.max(getHeight(q.left), getHeight(q.right)) + 1;
		return q;
	}
	
	private Node<K,V> rotateLeft(Node<K,V> p){
		assert p.right != null;
		Node<K,V> q = p.right;
		p.right = q.left;
		q.left = p;
		p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
		q.height = Math.max(getHeight(q.left), getHeight(q.right)) + 1;
		return q;
	}
	
	private Node <K,V> rotateLeftRight(Node<K,V> p){
		assert p.left != null;
		p.left = rotateLeft(p.left);
		return rotateRight(p);
	}
	
	private Node <K,V> rotateRightLeft(Node<K,V> p){
		assert p.right != null;
		p.right = rotateRight(p.right);
		return rotateLeft(p);
	}
	
	@Override
	public V insert(K key, V value) {
		V ret = search(key);
		root = insertR(key, value, root);
		return ret;
		
	}
	
	private Node<K,V> insertR(K key, V value, Node<K,V> p){
		if(p == null)
			p = new Node<K, V>(key, value);
		else if(key.compareTo(p.key) < 0) 
			p.left = insertR(key, value, p.left);
		else if(key.compareTo(p.key) > 0)
			p.right = insertR(key, value, p.right);
		else {
			p.value = value;
		}
			
		p = balance(p);
		return p;
		}
	
	@Override
	public V search(K key) {
		return searchR(key, root);		
	}
	
	private V searchR(K key, Node<K,V> p){
		if(p == null)
			return null;
		else if(key.compareTo(p.key) < 0){
			return searchR(key,p.left);
		}
		else if(key.compareTo(p.key) > 0){
			return searchR(key,p.right);
		}
		else
			return p.value;
	}
	
	@Override
	public V remove(K key) {
		V ret = search(key);
		root = removeR(key, root);
		return ret;
	}
	
	private Node<K, V> removeR(K key, Node<K,V> p){
		if(p == null){ }
		else if(key.compareTo(p.key)< 0)
			p.left = removeR(key, p.left);
		else if (key.compareTo(p.key) > 0)
			p.right = removeR(key, p.right);
		else {
			if(p.left == null || p.right ==null){
				p = (p.left != null) ? p.left : p.right;
			}
			else {
				Entry<K,V> min = new Entry<K,V>();
				p.right = getRemMinR(p.right, min);
				p.key = min.key;
				p.value = min.value;
			}
		}
		p = balance(p);
		return p;
	}
	
	private Node<K,V> getRemMinR(Node<K,V> p, Entry<K,V> min){
		assert p != null;
		if(p.left == null) {
			min.key = p.key;
			min.value = p.value;
			p = p.right;
		}
		else
			p.left = getRemMinR(p.left, min);
		return p;
	}
	
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		toStringR(root, sb);
		return sb.toString();
	}
	
	private void toStringR(Node node, StringBuilder sb){
		if(node == null)
			return;
		else {
			toStringR(node.left, sb);
			sb.append(node.key + " " + node.value + System.getProperty("line.separator"));
			toStringR(node.right, sb);
		}
	}
}
