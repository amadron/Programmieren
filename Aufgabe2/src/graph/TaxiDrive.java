package graph;
import graph.AdjencyListUndirectedGraph;

import java.awt.Color;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import sim.SYSimulation;

import java.util.Collections;

public class TaxiDrive<V> {
	
	
	
	public static void main(String[] args){
		
		File f = new File("/rzhome/beroth/git/Programmieren/Aufgabe2/ScotlandYard.txt");
		//File f = new File("/home/benedict/git/Programmieren/Aufgabe2/ScotlandYard.txt");
		AdjencyListUndirectedGraph<Integer> taxiGraph = Fileread("Taxi", f);
		System.out.println(taxiGraph.getVertexList());
		
		
		SYSimulation sim1;
		try {
			sim1 = new SYSimulation();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		//List<Integer> taxiDepth = depthFirstSearch(taxiGraph, 1, sim1);
		List<Integer> taxiBreath = breadthFirstSearchAnim(taxiGraph, 1, sim1);
		
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
	
	public static List<Integer> depthFirstSearch(Graph<Integer> g, Integer s, SYSimulation sim){
		sim.startSequence("Tiefensuche"); 
		List<Integer> visitList = new LinkedList<>();
		depthFirstSearchR(s, g, visitList, sim, s);
		sim.stopSequence();
		return visitList;
	}
	
	private static void depthFirstSearchR(Integer s, Graph<Integer> g, List<Integer> visitList, SYSimulation sim, Integer vorg){
		visitList.add(s);
		sim.drive(vorg, s);
		sim.visitStation(s);
		List<Integer> adjList = g.getAdjacentVertexList(s);
		
		for(Integer vert : adjList){
			if(!visitList.contains(vert)){
				depthFirstSearchR(vert, g, visitList, sim, s);
			}
		}
	}
	
	public static List<Integer> breadthFirstSearchAnim(Graph<Integer> g, Integer s, SYSimulation sim){
		sim.startSequence("Tiefensuche");
		List<Integer> visitList = new LinkedList<>();
		Queue<Integer> vQueue = new LinkedList<>();
		vQueue.add(s);
		sim.visitStation(s);
		while(!vQueue.isEmpty()){
			Integer v = vQueue.remove();
			
			visitList.add(v);
			
			List<Integer> adjList =  g.getAdjacentVertexList(v);
			for(Integer vert : adjList){
				if(!visitList.contains(vert)){
					sim.drive( v, vert);
					vQueue.add(vert);
					visitList.add(vert);
					sim.visitStation(vert);
				}
			}
		}
		sim.stopSequence();
		return visitList;
	}
}
