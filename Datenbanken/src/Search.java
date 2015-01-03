import javax.swing.*;

public class Search extends JFrame{
	private JPanel contentPane = new JPanel();
	
	private JLabel apartmentLabel = new JLabel("Ferienwohnung: ");
	private JTextField apartmentField = new JTextField();
	private JPanel apartmentPanel = new JPanel();

	private JLabel roomLabel = new JLabel("Mindestanzahl Zimmer: ");
	private JTextField roomField = new JTextField();
	private JPanel roomPanel = new JPanel();
	
	private JPanel row1 = new JPanel();
	
	private JLabel startLabel = new JLabel("Anreisetermin: ");
	private JTextField startField = new JTextField();;
	private JPanel startPanel = new JPanel();
	
	private JLabel endLabel = new JLabel("Abreisetermin: ");
	private JTextField endField = new JTextField();;
	private JPanel endPanel = new JPanel();
	
	private JPanel row2 = new JPanel();
	
	private JLabel customerLabel = new JLabel("Kunde: ");
	private JTextField customerField = new JTextField();;
	private JPanel customerPanel = new JPanel();
	
	private JLabel bookNoTextLabel = new JLabel("Kundennummer: ");
	private JLabel bookNoLabel = new JLabel();
	private JPanel bookPanel = new JPanel();
	
	private JPanel row3 = new JPanel();
	
	private JButton searchButton = new JButton("Suchen");
	
	public Search(){
		this.setTitle("Suche");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		apartmentPanel.add(apartmentLabel);
		apartmentPanel.add(apartmentField);
		row1.add(apartmentPanel);
		
		roomPanel.add(roomLabel);
		roomPanel.add(roomField);
		row1.add(roomPanel);
		
		contentPane.add(row1);
		
		startPanel.add(startLabel);
		startPanel.add(startField);
		row2.add(startPanel);
		
		endPanel.add(endLabel);
		endPanel.add(endField);
		row2.add(endPanel);
		
		contentPane.add(row2);
		
		customerPanel.add(customerLabel);
		customerPanel.add(customerField);
		row3.add(customerPanel);
		
		bookPanel.add(bookNoTextLabel);
		bookPanel.add(bookNoLabel);
		row3.add(bookPanel);
		
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
