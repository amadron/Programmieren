import java.util.LinkedList;
import java.util.List;


public class TelNet {
	/*Klasse zur Verwaltung von Telefonknoten mit
	 * (x,y)-Koordinaten zur Berechnung eines minimal
	 * aufspannenden Baums mit dem Algorythmus von
	 * Kruskal. Kantengewichte sind durch den Manhatten
	 * abstand definiert.
	 */
	private int lbg;
	private LinkedList<TelKnoten> telKnoten = new LinkedList<>();
	
	
	public TelNet(int lbg){
		this.lbg = lbg;
	}
	
	public void addTelKnoten(int x, int y){
		telKnoten.add(new TelKnoten(x, y));
	}
	
	public void drawOptTelNet(int xMax, int yMax){
		
	}
	
	public void generateRandomTelNet(int n, int xMax, int yMax){
		
	}
	
	public List<TelVerbindung> getOptTelNet(){
		List<TelVerbindung> tList = new LinkedList<>();
		
		return tList;
	}
	
	public int getOptTelNetKosten(){
		
		return 0;
	}
	
	public static void main(String[] args){
		
	}
	
	public String toString(){
		
	}
}
