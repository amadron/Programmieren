package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;

public class AdjencyListUndirectedGraph<V> implements UndirectedGraph<V> {
	
	HashMap<V, HashMap<V, Double>> adjencyList;
	HashMap<V, V> edgeList;
	
	@Override
	public boolean addVertex(V v) {
		adjencyList.put(v, new HashMap<V, Double>());
		return true;
	}

	@Override
	public boolean addEdge(V v, V w) {
		adjencyList.get(v).put(w, 1.0);
		adjencyList.get(w).put(v, 1.0);
		edgeList.put(v, w);
		return true;
	}

	@Override
	public boolean addEdge(V v, V w, double weight) {
		adjencyList.get(v).put(w, weight);
		adjencyList.get(w).put(v, weight);
		edgeList.put(v, w);
		return true;
	}

	@Override
	public boolean containsVertex(V v) {
		if(adjencyList.get(v) != null){
		return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean containsEdge(V v, V w) {
		if(adjencyList.get(v).get(w) != null){
			return true;
		} else {
		return false;
		}
	}

	@Override
	public double getWeight(Object v, Object w) {
		return adjencyList.get(v).get(w);
	}

	@Override
	public int getNumberOfVertexes() {
		return adjencyList.size();
	}

	@Override
	public int getNumberOfEdges() {
		int i = 0;
		
		return 0;
	}

	@Override
	public List getVertexList() {
		LinkedList<V> retList = new LinkedList<V>();
		return null;
	}

	@Override
	public List getEdgeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAdjacentVertexList(V v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getIncidentEdgeList(V v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDegree(V v) {
		// TODO Auto-generated method stub
		return 0;
	}

}
