package dictionary;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

import dictionary.*;

public class DictionaryGui extends JFrame implements ActionListener{
	JMenuBar fMenuBar = new JMenuBar();
	JMenu fMenu = new JMenu("Datei");
	JMenuItem itemLesen = new JMenuItem("Woerterbuch laden");
	JMenuItem itemSpeichern = new JMenuItem("Woerterbuch speichern");
	JMenuItem itemExit = new JMenuItem("Beenden");
	
	//Menu for choosing dictionary type
	JMenu tMenu = new JMenu("Woerterbuch Typ");
	ButtonGroup typeGroup = new ButtonGroup();
	JRadioButtonMenuItem hashDict = new JRadioButtonMenuItem("Hasch dictionary");
	JRadioButtonMenuItem tmapDict = new JRadioButtonMenuItem("TreeMap dictionary");
	JRadioButtonMenuItem hmapDict = new JRadioButtonMenuItem("HashMap dictionary");
	JRadioButtonMenuItem treeDict = new JRadioButtonMenuItem("Tree dictionary");
	JRadioButtonMenuItem sortDict = new JRadioButtonMenuItem("Sorted Array dictionary");
	
	JFileChooser fileChoos = new JFileChooser();
	
	//Wordpanel
	JPanel tPanel = new JPanel();
	JTextField kField = new JTextField("",20);
	JTextField vField = new JTextField("",20);
	
	//Components for Buttonpanel
	JPanel bPanel = new JPanel();
	JButton bSearch = new JButton("Suchen");
	JButton bDelete = new JButton("Loeschen");
	JButton bInsert = new JButton("Einfuegen");
	JButton bAll = new JButton("Alle Woerter");
	JButton bPerf = new JButton("Performancetest");
	//JTextArea with a scrollpane to display the dictionary
	public JTextArea display = new JTextArea();
	public JScrollPane sPane = new JScrollPane(display);
	
	JLabel pDisplay = new JLabel();
	
	
	Dictionary<String,String> dict = new TreeDictionary<String, String>();
	JPanel mainPanel = new JPanel();
	//Panel with Buttons and Display
	JPanel wPanel = new JPanel();
	
	//Arrays for performaceTest
	String[] wGer = new String[16000];
	String[] wEng = new String[16000];
	
	//Vars
	double startTime = 0;
	double dictBuildTime8 = 0;
	double dictBuildTime16 = 0;
	int toSeconds = 1000000;
	String tFormat = "mSec";
	
	public DictionaryGui(){
		//Menu
		fMenu.add(itemLesen);
		itemLesen.addActionListener(this);
		fMenu.add(itemExit);
		itemExit.addActionListener(this);
		fMenuBar.add(fMenu);
		
		typeGroup.add(hashDict);
		typeGroup.add(tmapDict);
		typeGroup.add(hmapDict);
		typeGroup.add(treeDict);
		typeGroup.add(sortDict);
		tMenu.add(hashDict);
		tMenu.add(tmapDict);
		tMenu.add(hmapDict);
		tMenu.add(treeDict);
		tMenu.add(sortDict);
		sortDict.setSelected(true);
		fMenuBar.add(tMenu);
		
		//Assemble the Textfield panel
		tPanel.add(kField);		
		tPanel.add(vField);
		
				
		//Assemble the Button panel and add all buttons to action listener
		bPanel.add(bSearch);
		bSearch.addActionListener(this);
		bPanel.add(bDelete);
		bDelete.addActionListener(this);
		bPanel.add(bInsert);
		bInsert.addActionListener(this);
		bPanel.add(bAll);
		bAll.addActionListener(this);
		bPanel.add(bPerf);
		bPerf.addActionListener(this);
		
		//Assemble the panels
		wPanel.setLayout(new GridLayout(4,1));
		wPanel.add(tPanel);
		wPanel.add(bPanel);	//Panel mit den Buttons
		wPanel.add(sPane); //Display for dictionary
		wPanel.add(pDisplay); //Display for performance
		
		//this
		this.setSize(500, 300);
		this.setLocation(100, 100);
		this.setJMenuBar(fMenuBar);
		this.add(wPanel);
		
		this.setVisible(true);
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == itemLesen){
			int retVal = fileChoos.showOpenDialog(this);
			if (retVal == fileChoos.APPROVE_OPTION) {
				File file = fileChoos.getSelectedFile();
				if(hashDict.isSelected() == true){
					dict = new HashDictionary<String, String>();
					System.out.println("Hashdictionary is selected");
				} if(hmapDict.isSelected() == true) {
					HashMap<String,String> hMap = new HashMap<String,String>();
					dict = new MapDictionary<String, String>(hMap);
					System.out.println("Map Hashmap Dictionary is selected");
				} if(tmapDict.isSelected() == true) {
					TreeMap<String,String> tMap = new TreeMap<String,String>();
					dict = new MapDictionary<String,String>(tMap);
					System.out.println("Map Treemap Dictionary is selected");
				}
			    if(treeDict.isSelected() == true) {
					dict = new TreeDictionary<String, String>();
					System.out.println("Treedictionary is selected");
				} if(sortDict.isSelected() == true) {
					dict = new SortedArrayDictionary<String, String>();
					System.out.println("SortedArrayDictionary is selected");
				}
				arrayRead(file);
				startTime = System.nanoTime();
				for(int i = 0; i < wGer.length; i++){
					if(wGer[i] != null){
					dict.insert(wGer[i], wEng[i]);
					}
					if(i == 8000) {
						dictBuildTime8 = ((System.nanoTime() - startTime)/toSeconds);
					}
				}
				dictBuildTime16 = (System.nanoTime() - startTime)/toSeconds; 
				
			}
		}
		
			
		if(e.getSource() == itemExit){
			int eingabe = JOptionPane.showConfirmDialog(this,
					"Willst du wirklich Beenden?", "Beenden",
					JOptionPane.OK_CANCEL_OPTION);
			if (eingabe == JOptionPane.OK_OPTION) {
				System.exit(0);
				}
		}
		
	
		
		//action for search button
		if(e.getSource() == bSearch){
			if(!kField.getText().equals("")){
				if(dict.search(kField.getText())!= null){	
					display.setText(kField.getText()+ " " + dict.search(kField.getText()));	
				} else {
					JOptionPane.showMessageDialog(this, "Eintrag nicht vorhanden");
				}
			}
		}
		
		//Action for delete button
		if(e.getSource() == bDelete){
			if(!kField.getText().equals("")){
				if(dict.search(kField.getText())!= null){
					String rem = dict.remove(kField.getText());
					JOptionPane.showMessageDialog(this, "Loeschen von " + kField.getText() 
							+ " " + rem + " erfolgreich!");
				}
			} 
		}
		
		//Action for Insert button
		if(e.getSource() == bInsert){
			if(!kField.getText().equals("")&&(!vField.getText().equals(""))){
				dict.insert(kField.getText(), vField.getText());
			} else {
				JOptionPane.showMessageDialog(this, "Bitte Beide Felder befuellen");
			}
		}
		
		//Action for show all button
		if(e.getSource() == bAll){
			display.setText(dict.toString());
		}
		
		//Action for PerformancetestButton
		if(e.getSource() == bPerf){
			performanceTest();
		}
	}
	
	public void arrayRead(File f){
		LineNumberReader in = null;
		try{
			in = new LineNumberReader(new FileReader(f));
				String line;
			int i = 0;
			while ((line= in.readLine())!=null){
				String[] sf = line.split(" ");
				if(i < wGer.length && i < wEng.length){
				wGer[i] = sf[0];
				wEng[i] = sf[1];
				}i++;
			}
			in.close();
		} catch (IOException ex){
			Logger.getLogger(DictionaryGui.class.getName()).log(Level.SEVERE,
					null, ex);
			
		}
	}
	
	public void performanceTest(){
		double successTime8, successTime16 = 0, failTime8 = 0, failTime16 = 0;
		startTime = System.nanoTime();
		autoSearch(wGer, 8000);
		successTime8 = (System.nanoTime()-startTime)/toSeconds;
		startTime = System.nanoTime();
		autoSearch(wGer, 16000);
		successTime16 = (System.nanoTime()-startTime)/toSeconds;
		startTime = System.nanoTime();
		autoSearch(wEng, 8000);
		failTime8 = (System.nanoTime()-startTime)/toSeconds;
		startTime = System.nanoTime();
		autoSearch(wEng,16000);
		failTime16 = (System.nanoTime()-startTime)/toSeconds;
		StringBuilder sb = new StringBuilder();
		sb.append("Performance: " + System.getProperty("line.separator"));
		sb.append("Aufbauen des Woerterbuches 8000: " + dictBuildTime8 + tFormat + System.getProperty("line.separator"));
		sb.append("Aufbauen des Woerterbuches 16000: " + dictBuildTime16 + tFormat + System.getProperty("line.separator"));
		sb.append("Erfolgreiche Suche 8000: " + successTime8 +  tFormat + System.getProperty("line.separator"));
		sb.append("Erfolgreiche Suche 16000: " + successTime16 + tFormat + System.getProperty("line.separator"));
		sb.append("Nicht erfolgreiche Suche 8000: " + failTime8 + tFormat + System.getProperty("line.separator"));
		sb.append("Nicht erfolgreiche Suche 16000: " + failTime16 + tFormat + System.getProperty("line.separator"));
		JOptionPane.showMessageDialog(this, sb.toString());
	}
	
	public void autoSearch(String arr[], int count){
		for(int i = 0; i < count; i++){
			if(i < arr.length && arr[i] != null)
			dict.search(arr[i]);
		}
	}
	
	
}

