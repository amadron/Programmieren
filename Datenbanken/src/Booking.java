import javax.swing.*;

public class Booking extends JFrame{
	private JPanel contentPane = new JPanel();
	
	private JLabel landLabel = new JLabel("Land: ");
	private JTextField landField;
	private JPanel landPanel;
	
	private JLabel startLabel = new JLabel("Anreisetermin: ");
	private JTextField startField;
	private JPanel startPanel;
	
	private JLabel endLabel = new JLabel("Abreisetermin");
	private JTextField endField;
	private JPanel endPanel;
	
	private JLabel equipLabel = new JLabel("Ausstattung (Optional): ");
	private JTextField equipField;
	private JPanel equipPanel;

	public Booking(){
		this.setTitle("Buchung");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.setVisible(true);
	}
}
