package graph;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DijkstraShortestPath<V> {
	private List<V> shortestPath = new LinkedList<V>();
	private double Distance;
	private HashMap<V, Double> d = new HashMap<V, Double>();
	private HashMap<V, V> p = new HashMap<V, V>();
	private Graph<V> G;
		
	public void DijkstraShortestPath(Graph<V> g){
		G = g;
		for(V vert : G.getVertexList()){
			d.put(vert, Double.POSITIVE_INFINITY);
			p.put(vert, null);
		}
	}
	
	public boolean searchShortestPath(V s, V g){
		boolean target = false;
		LinkedList<V> kl = new LinkedList<V>();
		List<Edge<V>> edgeList = G.getEdgeList();
		
		d.put(s, 0.0);
		kl.add(s);
		
		while(!kl.isEmpty()|| target == false){
			V v = kl.get(0);
			for (int i = 0; i < kl.size(); i++){
				if(d.get(kl.get(i)) < d.get(v))
				{
					v = kl.get(i);
				}
			}
			
			double weight = G.getIncidentEdgeList(v).get(0).weight;
			for(Edge<V> edge: G.getIncidentEdgeList(v)){
				if(edge.weight < weight)
					weight = edge.weight;
			}
			
			List<V> adjaList = G.getAdjacentVertexList(v);
			for(V w: adjaList){
				if(w == g){
					target = true;
					break;
				}
				Edge c = null;
				for(Edge e: edgeList)
				{
					if(e.source == v && e.target == w){
						c = e;
					}
				}
				if(d.get(w) == Double.POSITIVE_INFINITY){
					kl.add(w);
				}
				if((d.get(v) + c.weight) < d.get(w)){
					p.put(v, w);
					d.put(v, c.weight);
				}
			}
		}
		return target;
	}
		
	
	public List<V> getShortestPath(){
		return shortestPath;
	}
	
	public double getDistance(){
		return Distance;
	}
}
