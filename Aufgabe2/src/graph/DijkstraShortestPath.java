package graph;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
			
			d.put(s, 0.0);
			kl.add(s);
			while(!kl.isEmpty() || target == false){
				// Knoten v aus kl mit d[v] minimal
				V v = kl.get(0);
				if(v == g){
					target = true;
					break;
				}
				int index = 0;
				for(int i = 0; i < kl.size(); i++){
					if(d.get(kl.get(i)) < d.get(v)){
						index = i;
						v = kl.get(i);
					}
				}
				kl.remove(index);
				System.out.println(v);
				for(V w : G.getAdjacentVertexList(v)){
					if(d.get(w)== Double.POSITIVE_INFINITY){
						kl.add(w);
					}
					Edge<V> c = null;
					for(Edge<V> E: G.getIncidentEdgeList(v)){
						if(E.target == w){
							 c = E;
						}	
					}
					if((d.get(v) + c.weight) < d.get(w)){
						p.put(w, v);
						d.put(w, d.get(v) + c.weight);
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
		Set<V> set = p.keySet();
		for(V vert : p.keySet()){
			if(p.get(vert) != null)
				shortestPath.add(vert);
		}
		return shortestPath;
	}
	
	public double getDistance(){
		return distance;
	}
}
