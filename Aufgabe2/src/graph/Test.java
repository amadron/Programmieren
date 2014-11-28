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
		
		GraphTraversion<String> sTrav = new GraphTraversion<String>();
		
		//Topologische Sortierung für Folie 3-40
		DirectedGraph<Integer> topBsp = new AdjencyListDirectedGraph<Integer>();
		topBsp.addVertex(1);
		topBsp.addVertex(2);
		topBsp.addVertex(3);
		topBsp.addVertex(4);
		topBsp.addVertex(5);
		topBsp.addVertex(6);
		topBsp.addVertex(7);
		topBsp.addEdge(1, 3);
		topBsp.addEdge(2, 3);
		topBsp.addEdge(3, 5);
		topBsp.addEdge(3, 4);
		topBsp.addEdge(4, 6);
		topBsp.addEdge(5, 6);
		topBsp.addEdge(6, 7);
		System.out.println("Topologische Sortierung Bsp S. 3-40:" + gTrav.topologicalSort(topBsp));
		
		DirectedGraph<String> anziehen = new AdjencyListDirectedGraph<String>();
		anziehen.addVertex("Unterhose");
		anziehen.addVertex("Strümpfe");
		anziehen.addVertex("Schuhe");
		anziehen.addVertex("Unterhemd");
		anziehen.addVertex("Hose");
		anziehen.addVertex("Hemd");
		anziehen.addVertex("Gürtel");
		anziehen.addVertex("Pullover");
		anziehen.addVertex("Mantel");
		anziehen.addVertex("Handschuhe");
		anziehen.addVertex("Mütze");
		anziehen.addVertex("Schal");
		anziehen.addEdge("Unterhemd", "Unterhose");
		anziehen.addEdge("Handschuhe", "Schal");
		anziehen.addEdge("Unterhose", "Strümpfe");
		anziehen.addEdge("Strümpfe", "Hemd");
		anziehen.addEdge("Hemd", "Hose");
		anziehen.addEdge("Hose", "Gürtel");
		anziehen.addEdge("Gürtel", "Pullover");
		anziehen.addEdge("Pullover", "Schuhe");
		anziehen.addEdge("Schuhe", "Mantel");
		anziehen.addEdge("Mantel", "Handschuhe");
		anziehen.addEdge("Schal", "Mütze");
		
		
		System.out.println("Topologische Sortierung Anziehen: " + sTrav.topologicalSort(anziehen));
		
	}
}
