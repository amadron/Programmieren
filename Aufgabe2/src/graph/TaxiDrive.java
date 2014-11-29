package graph;
import graph.AdjencyListUndirectedGraph;

import java.awt.Color;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.LinkedList;
import java.util.List;

import sim.SYSimulation;

public class TaxiDrive {
	
	public static void main(String[] args){
		File f = new File("/home/benni/git/Programmieren/Aufgabe2/ScotlandYard.txt");
		AdjencyListUndirectedGraph<Integer> taxiGraph = Fileread("Taxi", f);
		GraphTraversion<Integer> gTrav = new GraphTraversion<Integer>();
		System.out.println(taxiGraph.getVertexList());
		List<Integer> taxiBreadth = gTrav.breadthFirstSearch(taxiGraph, taxiGraph.getVertexList().get(0));
		System.out.println(taxiBreadth);
		List<Integer> taxiDepth = gTrav.depthFirstSearch(taxiGraph, taxiGraph.getVertexList().get(0));
		System.out.println(taxiDepth);
		
		/*SYSimulation sim1;
		try {
			sim1 = new SYSimulation();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		sim1.startSequence("BreitenSuche");
		LinkedList<Integer> visitedBreadth = new LinkedList<Integer>();
		for(int i = 0; i < taxiBreadth.size(); i++){
			if(!visitedBreadth.contains(taxiBreadth.get(i))){
				sim1.visitStation(taxiBreadth.get(i));
				visitedBreadth.add(taxiBreadth.get(i));
			}
			List<Integer> nextList = taxiGraph.getAdjacentVertexList(taxiBreadth.get(i));
			for(int j = 0; j < nextList.size(); j++){
				sim1.drive(taxiBreadth.get(i), nextList.get(j), Color.BLUE);
				if(!visitedBreadth.contains(nextList.get(j))){
					sim1.visitStation(nextList.get(j));
					visitedBreadth.add(nextList.get(j));
				}
			} 
		
		sim1.stopSequence(); */
		
		SYSimulation sim2;
		try {
			sim2 = new SYSimulation();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		sim2.startSequence("Tiefensuche");
		LinkedList<Integer> visitedDepth = new LinkedList<Integer>();
		for(int i = 0; i < taxiDepth.size(); i++){
			if(!visitedDepth.contains(taxiDepth.get(i))){
				sim2.visitStation(taxiDepth.get(i));
				visitedDepth.add(taxiDepth.get(i));
			}
			List<Integer> nextDepthList = taxiGraph.getAdjacentVertexList(taxiBreadth.get(i));
			for(int j = 0; j < nextDepthList.size(); j++){
				sim2.drive(taxiDepth.get(i), nextDepthList.get(j), Color.BLACK);
				if(!visitedDepth.contains(nextDepthList.get(j))){
					sim2.visitStation(nextDepthList.get(j));
					visitedDepth.add(nextDepthList.get(j));
				}
			}
		}
		sim2.stopSequence();
	}
	
	public static AdjencyListUndirectedGraph<Integer> Fileread(String param, File f){
		AdjencyListUndirectedGraph<Integer> graph = new AdjencyListUndirectedGraph<Integer>();
		LineNumberReader in = null;
		try{
			in = new LineNumberReader(new FileReader(f));
				String line;
			while ((line= in.readLine())!=null){
				String[] sf = line.split(" ");
				if(sf.length == 3 && sf[2].equals(param)){
					graph.addVertex(Integer.valueOf(sf[0]));
					graph.addVertex(Integer.valueOf(sf[1]));
					graph.addEdge(Integer.valueOf(sf[0]),Integer.valueOf(sf[1]));
				}
				
			}
			in.close();
		} catch (IOException ex){
			Logger.getLogger(TaxiDrive.class.getName()).log(Level.SEVERE,
					null, ex);
			
		}
		
		return graph;
	}
}
