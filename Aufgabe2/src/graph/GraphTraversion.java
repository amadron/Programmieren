package graph;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GraphTraversion<V> {
	//returns a List of the depth of node s
	public <V> List<V> depthFirstSearch(Graph<V> g, V s){
		LinkedList<V> visitList = new LinkedList<V>();
		visitList.add(s);
		depthFirstSearchR(g, s, visitList);
		
		return visitList;
	}
	private void depthFirstSearchR(Graph<V> g, V s, LinkedList<V> visitList){
		List<Edge<V>> eList = g.getIncidentEdgeList(s);
		for(int i = 0; i < eList.size(); i++){
			if(!visitList.contains(eList.get(i).target)){
				visitList.add(eList.get(i).target);
				if(g.getIncidentEdgeList(eList.get(i).target).size() > 0){
					depthFirstSearchR(g, eList.get(i).target, visitList);
				}
			}
		}
	}
	
	//returns a List of the breadth of node s
	<V> List<V> breadthFirstSearch(Graph<V> g, V s){
		return g.getAdjacentVertexList(s);
	}
	
	//returns topological Sort of directed graph as a List
	<V> List<V> topologicalSort(DirectedGraph<V> g){
		
	}
}
