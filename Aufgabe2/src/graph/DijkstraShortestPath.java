package graph;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DijkstraShortestPath<V> {
	private HashMap<V, Double> d = new HashMap<V, Double>(); //Distanz
	private HashMap<V, V> p = new HashMap<V, V>();			//Vorgängerfeld
	private Graph<V> G;
	private double distance;
	boolean initialised;
		
	public void DijkstraShortestPath(Graph<V> g){
		d = new HashMap<V, Double>();
		p = new HashMap<V, V>();
		G = g;
		for(V vert : G.getVertexList()){
			d.put(vert, Double.POSITIVE_INFINITY);
			p.put(vert, null);
		}
		initialised = true;
	}
	
	public boolean searchShortestPath(V s, V g){
		if(initialised == true){
			boolean target = false;
			LinkedList<V> kl = new LinkedList<V>();
			List<Edge<V>> edgeList = G.getEdgeList();
			
			d.put(s, 0.0);
			kl.add(s);
			
			while(!kl.isEmpty()|| target == false){
				V v = kl.get(0);
				int index = 0;
				for (int i = 0; i < kl.size(); i++){
					if(d.get(kl.get(i)) < d.get(v))
					{
						v = kl.get(i);
						index = i;
					}
				}
				kl.remove(index);
								
				double weight = G.getIncidentEdgeList(v).get(0).weight;
				for(Edge<V> edge: G.getIncidentEdgeList(v)){
					if(edge.weight < weight)
						weight = edge.weight;
				}
				
				List<V> adjaList = G.getAdjacentVertexList(v);
				for(V w: adjaList){
					if(w == g){
						target = true;
						distance = d.get(g);
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
			distance = d.get(g);
			return target;
		} else {
			System.out.println("Bitte zuerst initialisieren");
			return false;
		}
	}
		
	
	public List<V> getShortestPath(){
		LinkedList<V> shortestPath = new LinkedList<V>();
		for(int i = 0; i < d.size(); i++){
			
		}
		return shortestPath;		
	}
	
	public double getDistance(){
		return distance;
	}
}
