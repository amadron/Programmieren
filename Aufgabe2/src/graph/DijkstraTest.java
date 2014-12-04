package graph;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DijkstraTest {
	
	public static void main(String[] args){
		
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
