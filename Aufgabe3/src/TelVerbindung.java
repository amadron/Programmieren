

public class TelVerbindung {
	TelKnoten u;
	TelKnoten v;
	
	public TelVerbindung(TelKnoten u, TelKnoten v){
		this.u = u;
		this.v = v;
	}
	
	public String toString(){
		return "Knoten u: " + u.toString() + 
				", Knoten v:" + v.toString();
	}
}
