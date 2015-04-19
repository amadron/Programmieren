package dictionary;

public class Test {
	public static void main(String[] args){
		TreeDictionary dict = new TreeDictionary<String, String>();
		dict.insert("1", "what");
		dict.insert("2", "Hello");
		dict.insert("3", "where");
		dict.insert("4", "hallo");
		dict.insert("5", "flac");
		dict.insert("6", "Salle");
		dict.insert("7", "Salle");
		dict.insert("8", "Salle");
		dict.insert("9", "Salle");
		//dict.insert("10", "Salle");
		System.out.println(dict.toString());
		dict.remove("5");
		dict.remove("3");
		System.out.println(dict.toString());
		
	}	
}
