package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AdjencyListDirectedGraph<V> implements DirectedGraph<V> {

	HashMap<V, HashMap<V, Double>> nextList;
	HashMap<V, HashMap<V, Double>> prevList;
	LinkedList<Edge<V>> edgeList;
	
	@Override
	public boolean addVertex(V v) {
		if(containsVertex(v) == false){
		nextList.put(v, new HashMap<V, Double>());
			return true;
		} else
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
		nextList.get(v).put(w, 1.0);
		prevList.get(w).put(v, 1.0);
		edgeList.add(new Edge<V>(v, w, 1.0));
		return ret;
	}

	@Override
	public boolean addEdge(V v, V w, double weight) {
		if(!containsVertex(v) || !containsVertex(w)){
			throw new IllegalArgumentException("Einer der Vertexes ist nicht enthalten");
		}
		if(v == w){
			throw new IllegalArgumentException("Beide Knoten sind gleich!");
		}
		boolean ret = containsEdge(v, w);
		nextList.get(v).put(w, weight);
		prevList.get(w).put(v, weight);
		edgeList.add(new Edge<V>(v,w,weight));
		return ret;
	}

	@Override
	public boolean containsVertex(V v) {
		if(nextList.get(v) != null){
			return true;
		} else
			return false;
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
		if(containsEdge(v,w))
			return nextList.get(v).get(w);
		else
			return 0; //
	}

	@Override
	public int getNumberOfVertexes() {
		return nextList.size();
	}

	@Override
	public int getNumberOfEdges() {
		return edgeList.size();
	}

	@Override
	public List getVertexList() {
		LinkedList<V> retList = new LinkedList<V>();
		Set<V> set = nextList.keySet();
		for(V it: set){
			retList.add(it);
		}
		return retList;
	}

	@Override
	public List getEdgeList() {
		return edgeList;
	}

	@Override
	public List getAdjacentVertexList(V v) {
		if(!containsVertex(v)){
			throw new IllegalArgumentException("Knoten nicht enthalten");
		}
		LinkedList<V> retList = new LinkedList<V>();
		for(int i = 0; i < edgeList.size(); i++){
			if(edgeList.get(i).source == v){
				retList.add(edgeList.get(i).target);
			}
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
	public int getInDegree(V v) {
		if(!containsVertex(v)){
			throw new IllegalArgumentException("Knoten nicht enthalten");
		}
		int count = 0;
		for(int i = 0; i < edgeList.size(); i++){
			if(edgeList.get(i).target == v){
				count++;
			}
		}
		return count;
	}

	@Override
	public int getOutDegree(V v) {
		if(!containsVertex(v)){
			throw new IllegalArgumentException("Knoten nicht enthalten");
		}
		int count = 0;
		for(int i = 0; i < edgeList.size(); i++){
			if(edgeList.get(i).source == v){
				count++;
			}
		}
		return count;
	}

	@Override
	public List getPredecessorVertexList(V v) {
		if(!containsVertex(v)){
			throw new IllegalArgumentException("Knoten nicht enthalten");
		}
		LinkedList<V> retList = new LinkedList<V>();
		for(V it : prevList.get(v).keySet()){
			retList.add(it);
		}
		return retList;
	}

	@Override
	public List getSuccessorVertexList(V v) {
		if(!containsVertex(v)){
			throw new IllegalArgumentException("Knoten nicht enthalten");
		}
		LinkedList<V> retList = new LinkedList<V>();
		for(V it : nextList.get(v).keySet()){
			retList.add(it);
		}
		return retList;
	}

	@Override
	public List getOutgoingEdgeList(V v) {
		if(!containsVertex(v)){
			throw new IllegalArgumentException("Knoten nicht enthalten");
		}
		LinkedList<Edge<V>> retList = new LinkedList<Edge<V>>();
		for(int i = 0; i < edgeList.size(); i++){
			if(edgeList.get(i).source == v){
				retList.add(edgeList.get(i));
			}
		}
		return retList;
	}

	@Override
	public List getIncomingEdgeList(V v) {
		if(!containsVertex(v)){
			throw new IllegalArgumentException("Knoten nicht enthalten");
		}
		LinkedList<Edge<V>> retList = new LinkedList<Edge<V>>();
		for(int i = 0; i < edgeList.size(); i++){
			if(edgeList.get(i).target == v){
				retList.add(edgeList.get(i));
			}
		}
		return retList;
	}

}
