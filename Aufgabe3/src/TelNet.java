import graph.AdjencyListUndirectedGraph;
import graph.Edge;

import java.awt.Color;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class TelNet {
	/*Klasse zur Verwaltung von Telefonknoten mit
	 * (x,y)-Koordinaten zur Berechnung eines minimal
	 * aufspannenden Baums mit dem Algorythmus von
	 * Kruskal. Kantengewichte sind durch den Manhatten
	 * abstand definiert.
	 */
	private int lbg;
	private AdjencyListUndirectedGraph<TelKnoten> telNet = 
			new AdjencyListUndirectedGraph<>();
	private LinkedList<TelKnoten> telKnoten = new LinkedList<>();
	
	//For drawing the telNet
	int tXMax = 0; 
	int tYMax = 0;
	
	public static void main(String[] args){
//		TelNet net = new TelNet(7);
//		net.addTelKnoten(1, 1);
//		net.addTelKnoten(3, 1);	
//		net.addTelKnoten(4, 2);	
//		net.addTelKnoten(3, 4);	
//		net.addTelKnoten(2, 6);	
//		net.addTelKnoten(4, 7);	
//		net.addTelKnoten(7, 5);
//		net.drawOptTelNet(640, 640);
//		System.out.println("Kosten: " + net.getOptTelNetKosten());
		TelNet telnet = new TelNet(100);
		telnet.generateRandomTelNet(1000, 1000, 1000);
		telnet.drawOptTelNet(840, 840);
		System.out.println("Kosten: " + telnet.getOptTelNetKosten());
	}
	
	public TelNet(int lbg){
		this.lbg = lbg;
	}
	
	public int Manhattendistance(TelKnoten t1, TelKnoten t2){
		return Math.abs(t1.x-t2.x) + Math.abs(t1.y-t2.y);
	}
	
	public void addTelKnoten(int x, int y){
		if(x > tXMax)
			tXMax = x;
		if(y > tYMax)
			tYMax = y;
		TelKnoten knoten = new TelKnoten(x,y);
		telNet.addVertex(knoten);
		for(TelKnoten t : telNet.getVertexList()){
			int dist = Manhattendistance(knoten, t);
			if(dist <= lbg)
				if(knoten != t){
					telNet.addEdge(knoten, t, dist);
				}
		}
	}
	
	public void drawOptTelNet(int xMax, int yMax){
		StdDraw.clear();
		StdDraw.setCanvasSize(xMax, yMax);
		List<Edge<TelKnoten>> list = getOptTelNet();
		int vers = 1;
		float pen = (((float)1/tXMax)*5);
		float factorX = (float)1/(tXMax);
		float factorY = (float)1/(tYMax);
		for(Edge<TelKnoten> edge : list){
			
			float x1 = (edge.getSource().x) * factorX;
			float y1 = (edge.getSource().y) * factorY;
			float x2 = (edge.getTarget().x) * factorX;
			float y2 = (edge.getTarget().y) * factorY;
			StdDraw.setPenColor(Color.BLUE);
			StdDraw.filledCircle(x1,y1, pen);//Draws the Node 1
			StdDraw.filledCircle(x2, y2, pen);//Draws the Node2 
			StdDraw.setPenColor(Color.RED);
			StdDraw.line(x1, y1, x2, y1); //Draws the Line x side			
			StdDraw.line(x2, y1, x2, y2);//Draws the Line y side
			
		}
		StdDraw.show();
	}
	
	public void generateRandomTelNet(int n, int xMax, int yMax){
		for(int i = 0; i < n; i++){
			int x = (int) (Math.random() * xMax);
			int y = (int) (Math.random() * yMax);
			addTelKnoten(x,y);
		}
	}
	
	public List<Edge<TelKnoten>> getOptTelNet(){
		UnionFind forest = new UnionFind(telNet.getVertexList().size());
		PriorityQueue<Edge<TelKnoten>> edges = new PriorityQueue<>(telNet.getEdgeList());
		List<Edge<TelKnoten>> minSpanTree = new LinkedList<>(); 
		while(forest.size() != 1 && !edges.isEmpty()){
			Edge<TelKnoten> e = edges.poll();
			TelKnoten k1 = e.getSource();
			TelKnoten k2 = e.getTarget();
			int n1 = 0;
			int n2 = 0;
			int counter = 0;
			for(TelKnoten tk : telNet.getVertexList()){
				if(tk == k1){
					n1 = counter;
				}
				if(tk == k2){
					n2 = counter;
				}
				counter++;
			}
			int t1 = forest.find(n1);
			int t2 = forest.find(n2);
			if(t2 != t1){
				forest.union(t1, t2);
//				boolean cont = false;
//				for(Edge<TelKnoten> edge: minSpanTree){
//					if(edge.getSource() ==  e.getTarget() && edge.getTarget() == e.getSource())
//						cont = true;
//				}
//				if(cont == false)				
					minSpanTree.add(e);
			}
		}
		return minSpanTree;
	}
	
	
	public int getOptTelNetKosten(){
		int costs = 0;
		for(Edge<TelKnoten> e : getOptTelNet()){
			costs += e.getWeight();
		}
		return costs;
	}
	
	public String toString(){
		String str = "";
		for(TelKnoten tel : telNet.getVertexList())
			str = str + "x: " + tel.x + ", y:" + tel.y + "\n";
		str = str + "Number of elements: " + telNet.getVertexList().size();
		return str;
	}
}
