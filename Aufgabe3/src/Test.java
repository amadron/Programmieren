

public class Test {
	public static void main(String[] args){
	UnionFind union = new UnionFind(20);
	System.out.println(union.size());
	union.union(4, 2);
	System.out.println(union.size());
	System.out.println(union.find(2));
	System.out.println(union.toString());
	}
}
