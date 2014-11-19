package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Set;

public class AdjencyListUndirectedGraph<V> implements UndirectedGraph<V> {
	
	HashMap<V, HashMap<V, Double>> adjencyList;
	LinkedList<Edge<V>> edgeList;
	
	@Override
	public boolean addVertex(V v) {
		adjencyList.put(v, new HashMap<V, Double>());
		return true;
	}

	@Override
	public boolean addEdge(V v, V w) {
		adjencyList.get(v).put(w, 1.0);
		adjencyList.get(w).put(v, 1.0);
		edgeList.add(new Edge<V>(v, w));
		return true;
	}

	@Override
	public boolean addEdge(V v, V w, double weight) {
		adjencyList.get(v).put(w, weight);
		adjencyList.get(w).put(v, weight);
		edgeList.add(new Edge<V>(v, w, weight));
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
		return edgeList.size();
	}

	@Override
	public List getVertexList() {
		LinkedList<V> vertList = new LinkedList<V>();
		Set<V> set = adjencyList.keySet();
		for(V it: set) {
			vertList.add(it);
		}
		return vertList;
	}

	@Override
	public List getEdgeList() {
		return edgeList;
	}

	@Override
	public List getAdjacentVertexList(V v) {
		LinkedList<V> retList = new LinkedList<V>();
		Set<V> set = adjencyList.get(v).keySet();
		for(V it: set){
			retList.add(it);
		}
		return retList;
	}

	@Override
	public List getIncidentEdgeList(V v) {
		LinkedList<Edge<V>> retList = new LinkedList();
		for(int i = 0; i < edgeList.size(); i++){
			if(edgeList.get(i).source == v)
				retList.add(edgeList.get(i));
		}
		return retList;
	}

	@Override
	public int getDegree(V v) {
		return adjencyList.get(v).size();
	}

}
