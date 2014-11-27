package graph;

public class Test {
	public static void main(String[] args){
		Graph<Integer> g = new AdjencyListUndirectedGraph<Integer>();
		g.addVertex(0);
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(0, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(1, 4);
		g.addEdge(2, 4);
		GraphTraversion<Integer> gTrav = new GraphTraversion<Integer>();
		System.out.println("Breitensuche Ungerichteter:"+gTrav.breadthFirstSearch(g, 1));
		System.out.println("Tiefensuche Ungerichteter:"+gTrav.depthFirstSearch(g, 1));
		
		Graph<Integer> f = new AdjencyListDirectedGraph<Integer>();
		f.addVertex(0);
		f.addVertex(1);
		f.addVertex(2);
		f.addVertex(3);
		f.addVertex(4);
		f.addVertex(5);
		f.addEdge(1, 0);
		f.addEdge(1, 2);
		f.addEdge(0, 4);
		f.addEdge(2, 3);
		f.addEdge(3, 4);
		f.addEdge(4, 5);
		f.addEdge(1, 4);
		f.addEdge(2, 4);
		System.out.println("Breitensuche Gerichteter:"+gTrav.breadthFirstSearch(f, 1));
		System.out.println("Tiefensuche Gerichteter:"+gTrav.depthFirstSearch(f, 1));
		
	}
}
