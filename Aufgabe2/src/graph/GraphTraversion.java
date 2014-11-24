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
	public <V> List<V> depthFirstSearch(Graph<V> g, V s){
		List<V> visitList = new LinkedList<V>();
		depthFirstSearchR(g, s, visitList);
		
		return visitList;
	}
	private void depthFirstSearchR(Graph<V> g, V s, List<V> visitList){
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
	}
	
	//returns a List of the breadth of node s
	<V> List<V> breadthFirstSearch(Graph<V> g, V s){
		List<V> visitList = new LinkedList<V>();
		breadthFirstSearchR(g, s, visitList);
		
		return visitList;
	}
	
	private void breadthFirstSearchR(Graph<V> g, V s, List<V> visitList){
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
	}
	
	//returns topological Sort of directed graph as a List
	<V> List<V> topologicalSort(DirectedGraph<V> g){
		
	}
}
