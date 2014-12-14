package graph;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import sim.SYSimulation;

public class DijkstraTest {
	
	public static void main(String[] args){
		//File f = new File("/rzhome/beroth/git/Programmieren/Aufgabe2/ScotlandYard.txt");
		File f = new File("/home/benni/git/Programmieren/Aufgabe2/ScotlandYard.txt");
		Graph<Integer> scotlandGraph = Fileread(f);
		DijkstraShortestPath<Integer> dijkstra = new DijkstraShortestPath<>();
		dijkstra.DijkstraShortestPath(scotlandGraph);
		dijkstra.searchShortestPath(9, 20);
		List<Integer> shortList = dijkstra.getShortestPath();
		System.out.println(shortList);
		SYSimulation sim1;
		try {
			sim1 = new SYSimulation();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		sim1.startSequence("Dijkstrashortest path");
		int last = shortList.get(0);
		for(int st : shortList){
			sim1.visitStation(st);
			sim1.drive(st, last);
			last = st;
		}
		sim1.stopSequence();
		System.out.println("Entfernung: " + dijkstra.getDistance());
	}
	
	public static AdjencyListUndirectedGraph<Integer> Fileread(File f){
		AdjencyListUndirectedGraph<Integer> graph = new AdjencyListUndirectedGraph<Integer>();
		LineNumberReader in = null;
		try{
			in = new LineNumberReader(new FileReader(f));
				String line;
			while ((line= in.readLine())!=null){
				String[] sf = line.split(" ");
				if(sf.length == 3){
					double weight = 0;
					if(sf[2].equals("UBahn")){
						weight = 5;
					} else if (sf[2].equals("Taxi")){
						weight = 3;
					} else if (sf[2].equals("Bus")){
						weight = 2;
					}
					graph.addVertex(Integer.valueOf(sf[0]));
					graph.addVertex(Integer.valueOf(sf[1]));
					graph.addEdge(Integer.valueOf(sf[0]),Integer.valueOf(sf[1]), weight);
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
