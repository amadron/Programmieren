package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;

public class AdjencyListUndirectedGraph<V> implements UndirectedGraph<V> {
	
	HashMap<V, HashMap<V, Double>> adjencyList = new HashMap<V, HashMap<V,Double>>();
	LinkedList<Edge<V>> edgeList = new LinkedList<Edge<V>>();
	
	@Override
	public boolean addVertex(V v) {
		if(containsVertex(v) == false){
		adjencyList.put(v, new HashMap<V, Double>());
			return true;
		}
			return false;
	}

	@Override
	public boolean addEdge(V v, V w) {
		if(!containsVertex(v) || !containsVertex(w)){
			throw new IllegalArgumentException("Einer der Vertexes ist nicht enthalten");
		}
		if(v == w){
			throw new IllegalArgumentException("Beide Knoten sind gleich!");
		}
		boolean ret = containsEdge(v, w);
		adjencyList.get(v).put(w, 1.0);
		adjencyList.get(w).put(v, 1.0);
		edgeList.add(new Edge<V>(v, w));
		edgeList.add(new Edge<V>(w, v));
		return ret;
	}

	@Override
	public boolean addEdge(V v, V w, double weight) {
		if(containsVertex(v) == false && containsVertex(w)){
			throw new IllegalArgumentException("Einer der Vertexes ist nicht enthalten");
		}
		if(v == w){
			throw new IllegalArgumentException("Beide Knoten sind gleich!");
		}
		boolean ret = containsEdge(v, w);
		adjencyList.get(v).put(w, weight);
		adjencyList.get(w).put(v, weight);
		edgeList.add(new Edge<V>(v, w, weight));
		edgeList.add(new Edge<V>(w, v, weight));
		return ret;
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
		if(!containsVertex(v) || !containsVertex(w)){
			throw new IllegalArgumentException("Einer der Knoten nicht enthalten");
		}
		boolean ret = false;
		for(int i = 0; i < edgeList.size(); i++)
			if(edgeList.get(i).source == v && edgeList.get(i).target == w){
				ret = true;
			}
		return ret;	
	}

	@Override
	public double getWeight(V v, V w) {
		if(!containsVertex(v) || !containsVertex(w)){
			throw new IllegalArgumentException("Einer der Knoten nicht enthalten");
		}
		if(containsEdge(v, w)){
			return adjencyList.get(v).get(w);
		} else
			return 0;
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
	public List<V> getVertexList() {
		LinkedList<V> vertList = new LinkedList<V>();
		for(V it: adjencyList.keySet()) {
			vertList.add(it);
		}
		return vertList;
	}

	@Override
	public List<Edge<V>> getEdgeList() {
		return edgeList;
	}

	@Override
	public List<V> getAdjacentVertexList(V v) {
		if(!containsVertex(v)){
			throw new IllegalArgumentException("Knoten nicht enthalten");
		}
		return new LinkedList<V>(adjencyList.get(v).keySet());
	}

	@Override
	public List<Edge<V>> getIncidentEdgeList(V v) {
		if(!containsVertex(v)){
			throw new IllegalArgumentException("Knoten nicht enthalten");
		}
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
