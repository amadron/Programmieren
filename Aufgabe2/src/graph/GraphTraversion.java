package graph;
import java.util.AbstractSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphTraversion<V> {
	//returns a List of the depth of node s
	public static <V> List<V> depthFirstSearch(Graph<V> g, V s){
		List<V> visitList = new LinkedList<V>();
		Stack<V> stk = new Stack<V>();
		stk.push(s);
		
		while(!stk.empty()){
			V v = stk.pop();
			if(visitList.contains(v)){
				continue;
			}
			
			visitList.add(v);
			
			List<V> tmpList = g.getAdjacentVertexList(v);
			for(int i = 0; i < tmpList.size(); i++){
				if(!visitList.contains(tmpList.get(i))){
					stk.push(tmpList.get(i));
				}
			}
		}
		return visitList;
	}
	
	
	//returns a List of the breadth of node s
	public List<V> breadthFirstSearch(Graph<V> g, V s){
		List<V> visitList = new LinkedList<V>();
		Queue<V> vQueue = new LinkedList<V>();
		vQueue.add(s);
		
		while(!vQueue.isEmpty()){
			V v = vQueue.remove();
			
			if(visitList.contains(v)){
				continue;
			}
			
			visitList.add(v);
			
			List<V> tmpList =  g.getAdjacentVertexList(v);
			for(int i = 0; i < tmpList.size(); i++){
				if(!visitList.contains(tmpList.get(i))){
					vQueue.add(tmpList.get(i));
				}
			}
		}
		return visitList;
	}
	
	//returns topological Sort of directed graph as a List
	public List<V> topologicalSort(DirectedGraph<V> g){
		List<V> ts;
		Map<V, Integer> inDegree = new HashMap<V, Integer>();
		Queue<V> q = new LinkedList<V>();
		List<Edge<V>> edgeList = g.getEdgeList();
		
		List<V> vertexList = g.getVertexList();
		for(int i = 0; i < vertexList.size(); i++)
		{
			V vertex = vertexList.get(i);
			inDegree.put(vertex, g.getInDegree(vertex));
			if(g.getInDegree(vertex)==0){
				q.add(vertex);
			}
		}
		
		while(!q.isEmpty()){
			V v = q.remove();
			ts.add(v);
			List<V> list = g.getAdjacentVertexList(v);
			for(;;){
				
			}
		}
		if(ts.size() != g.getNumberOfVertexes()){
			return null;
		}
		else {
			return ts;
		}
	}
}
