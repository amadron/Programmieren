package graph;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DijkstraShortestPath<V> {
	private HashMap<V, Double> d = new HashMap<V, Double>(); //Distanz
	private HashMap<V, V> p = new HashMap<V, V>();			//Vorgängerfeld
	private Graph<V> G;
	private double distance = 0.0;
	boolean initialised;
	V start;
	V target;
		
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
			start = s;
			target = g;
			boolean target = false;
			LinkedList<V> kl = new LinkedList<V>();
			d.put(s, 0.0);
			
			kl.add(s);
			
			while(!kl.isEmpty() && target == false){
				// Knoten v aus kl mit d[v] minimal
				V v = kl.get(0);
				int index = 0;
				for(int i = 0; i < kl.size(); i++){
					if(d.get(kl.get(i)) < d.get(v)){
						index = i;
						v = kl.get(i);
					}
				}
				if(v == g){
					target = true;
					break;
				}
				kl.remove(index);
				for(V w : G.getAdjacentVertexList(v)){
					
					if(d.get(w)== Double.POSITIVE_INFINITY){
						kl.add(w);
					}
					Edge<V> c = null;
					for(Edge<V> E: G.getEdgeList()){
						if(E.target == w){
							 c = E;
						}	
					}
					if((d.get(v) + c.getWeight()) < d.get(w)){
						p.put(w, v);
						d.put(w, d.get(v) + c.getWeight());
					}
				}
			}
			System.out.println("Value: "+ d.get(g));
			distance = d.get(g);
			System.out.println("Shortest path: " + p);
			return target;
		} else {
			System.out.println("Bitte zuerst initialisieren");
			return false;
		}
	}
		
	
	public List<V> getShortestPath(){
		LinkedList<V> vertList = new LinkedList<V>();
		V g = target;
		vertList.add(g);
		while(g != start){
			g = p.get(g);
			vertList.add(g);
		}
		Collections.reverse(vertList);
		return vertList;
	}
	
	public double getDistance(){
		return distance;
	}
}
