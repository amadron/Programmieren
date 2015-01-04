import javax.swing.*;

public class Search extends JFrame{
	private JPanel contentPane = new JPanel();
	
	
	
	private JLabel landLabel = new JLabel("Land: ");
	private JTextField landField = new JTextField("", 15);
	private JPanel landPanel = new JPanel();

	private JLabel roomLabel = new JLabel("Mindestanzahl Zimmer: ");
	private JTextField roomField = new JTextField("", 5);
	private JPanel roomPanel = new JPanel();
	
	private JPanel row1 = new JPanel();
	
	private JLabel startLabel = new JLabel("Anreisetermin: ");
	private JTextField startField = new JTextField("", 10);
	private JPanel startPanel = new JPanel();
	
	private JLabel endLabel = new JLabel("Abreisetermin: ");
	private JTextField endField = new JTextField("", 10);
	private JPanel endPanel = new JPanel();
	
	private JPanel row2 = new JPanel();
	
	private JLabel equipLabel = new JLabel("Ausstattung (Optional): ");
	private JTextField equipField = new JTextField("", 10);
	private JPanel equipPanel = new JPanel();
	
	private JPanel row3 = new JPanel();
	
	private JButton searchButton = new JButton("Suchen");
	
	public Search(){
		this.setTitle("Suche");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		landPanel.setLayout(new BoxLayout(landPanel, BoxLayout.Y_AXIS));
		landPanel.add(landLabel);
		landPanel.add(landField);
		
		row1.add(landPanel);
		
		roomPanel.setLayout(new BoxLayout(roomPanel, BoxLayout.Y_AXIS));
		roomPanel.add(roomLabel);
		roomPanel.add(roomField);
		row1.add(roomPanel);
		
		contentPane.add(row1);
		
		startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.Y_AXIS));
		startPanel.add(startLabel);
		startPanel.add(startField);
		row2.add(startPanel);
		
		endPanel.setLayout(new BoxLayout(endPanel, BoxLayout.Y_AXIS));
		endPanel.add(endLabel);
		endPanel.add(endField);
		row2.add(endPanel);
		
		contentPane.add(row2);
		
		equipPanel.setLayout(new BoxLayout(equipPanel, BoxLayout.Y_AXIS));
		equipPanel.add(equipLabel);
		equipPanel.add(equipField);
		
		row3.add(equipPanel);
		
		contentPane.add(row3);
		contentPane.add(searchButton);
		
		this.add(contentPane);
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		Search suche = new Search();
	}
}
