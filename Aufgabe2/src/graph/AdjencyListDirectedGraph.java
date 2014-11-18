package graph;

import java.util.HashMap;
import java.util.List;

public class AdjencyListDirectedGraph<V> implements DirectedGraph<V> {

	HashMap<V, HashMap<V, Double>> adjencyList;
	
	@Override
	public boolean addVertex(V v) {
		adjencyList.put(v, new HashMap<V, Double>());
		return false;
	}

	@Override
	public boolean addEdge(V v, V w) {
		adjencyList.get(v).put(w, 1.0);
		return false;
	}

	@Override
	public boolean addEdge(V v, V w, double weight) {
		adjencyList.get(v).put(w, weight);
		return false;
	}

	@Override
	public boolean containsVertex(V v) {
		if(adjencyList.get(v) != ){
			return true;
		}
		return false;
	}

	@Override
	public boolean containsEdge(V v, V w) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getWeight(V v, V w) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfVertexes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfEdges() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List getVertexList() {
		// TODO Auto-generated method stub
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
	public int getInDegree(V v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getOutDegree(V v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List getPredecessorVertexList(V v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getSuccessorVertexList(Object v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getOutgoingEdgeList(Object v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getIncomingEdgeList(Object v) {
		// TODO Auto-generated method stub
		return null;
	}

}
