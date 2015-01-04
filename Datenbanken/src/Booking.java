import javax.swing.*;

public class Booking extends JFrame{
	private JPanel contentPane = new JPanel();
	
	private JLabel apartmentLabel = new JLabel("Ferienwohnung: ");
	private JTextField apartmentField = new JTextField("", 20);
	private JPanel apartmentPanel = new JPanel();
	
	private JLabel customerLabel = new JLabel("Kunde: ");
	private JTextField customerField = new JTextField("", 20);;
	private JPanel customerPanel = new JPanel();
	
	private JPanel row1 = new JPanel();
	
	private JLabel startLabel = new JLabel("Anreisetermin: ");
	private JTextField startField = new JTextField("", 20);
	private JPanel startPanel = new JPanel();
	
	private JLabel endLabel = new JLabel("Abreisetermin");
	private JTextField endField = new JTextField("", 20);
	private JPanel endPanel = new JPanel();
	
	private JPanel row2 = new JPanel();
	
	private JLabel bookNoTextLabel = new JLabel("Buchungsnummer: ");
	private JLabel bookNoLabel = new JLabel();
	private JPanel bookPanel = new JPanel();

	private JButton bookButton = new JButton("Buchen");
	
	public Booking(){
		this.setTitle("Buchung");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		apartmentPanel.setLayout(new BoxLayout(apartmentPanel, BoxLayout.Y_AXIS));
		apartmentPanel.add(apartmentLabel);
		apartmentPanel.add(apartmentField);
		row1.add(apartmentPanel);
		
		customerPanel.setLayout(new BoxLayout(customerPanel, BoxLayout.Y_AXIS));
		customerPanel.add(customerLabel);
		customerPanel.add(customerField);
		row1.add(customerPanel);
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
		
		bookNoLabel.setText("0000000");
		bookPanel.add(bookNoTextLabel);
		bookPanel.add(bookNoLabel);
		
		contentPane.add(bookPanel);
		contentPane.add(bookButton);
		
		this.add(contentPane);
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		Booking booking = new Booking();
	}
}
