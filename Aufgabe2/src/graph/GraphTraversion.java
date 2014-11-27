package graph;
import java.util.AbstractSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
		int inDegree;
		Queue<V> q;
		List<V> vertexList = g.getVertexList();
		return vertexList;
	}
}
