package graph;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DijkstraShortestPath<V> {
	public void DijkstraShortestPath(Graph<V> g){
		
	}
	
	public boolean searchShortestPath(V s, V g){
		return true;
	}
	
	public List<V> getShortestPath(){
		return null;
		
	}
	
	public double getDistance(){
		return 0;
	}
	
	void shortestPath(V s, Graph<V> G,HashMap<V, Double> d, HashMap<V, V> p){
		LinkedList<V> kl = new LinkedList<V>();
		List<Edge<V>> edgeList = G.getEdgeList();
 		for(V vert : G.getVertexList()){
			d.put(vert, 99999999999999999.9999999);
			p.put(vert, null);
		}
		d.put(s, 0.0);
		kl.add(s);
		
		while(!kl.isEmpty()){
			V v = kl.get(0);
			for (int i = 0; i < kl.size(); i++){
				if(kl.get(i) < d.get(v))
				{
					
				}
			}
			double weight = G.getIncidentEdgeList(v).get(0).weight;
			for(Edge<V> edge: G.getIncidentEdgeList(v)){
				if(edge.weight < weight)
					weight = edge.weight;
			}
			List<V> adjaList = G.getAdjacentVertexList(v);
			for(V w: adjaList){
				Edge c = null;
				for(Edge e: edgeList)
				{
					if(e.source == v && e.target == w){
						c = e;
					}
				}
				if(d.get(w) == null){
					kl.add(w);
				}
				if((d.get(v) + c.weight) < d.get(w)){
					p.put(v, w);
					d.put(v, c.weight);					
				}
			}
		}
	}
}
