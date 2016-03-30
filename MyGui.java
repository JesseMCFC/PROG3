package prog3_pr7b_oefentoets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MyGui extends JFrame{

	private FilePanel myFilePanel = new FilePanel();
	private DrawPanel myDrawPanel = new DrawPanel();
	
	public MyGui(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFilePanel();
		createMenu();
		
		this.pack();
		this.setVisible(true);
	}
	
	private void setFilePanel(){
		this.setTitle("File Panel");
		this.setContentPane(myFilePanel);
		this.validate();
	}
	
	private void setDrawPanel(){
		this.setTitle("Draw Panel");
		this.setContentPane(myDrawPanel);
		this.validate();
	}
	
	private void createMenu(){
		JMenuBar 	myMenuBar 	= new JMenuBar();
		JMenu		myFileMenu 	= new JMenu("File");
		JMenu		myPanelMenu	= new JMenu("Panel");
		
		JMenuItem	myExitItem		= new JMenuItem("exit");
		JMenuItem	myDrawPanelItem	= new JMenuItem("draw panel");
		JMenuItem	myFilePanelItem	= new JMenuItem("file panel");
		
		this.setJMenuBar(myMenuBar);
		myMenuBar.add(myFileMenu);
		myMenuBar.add(myPanelMenu);
		
		myFileMenu.add(myExitItem);
		myPanelMenu.add(myDrawPanelItem);
		myPanelMenu.add(myFilePanelItem);
		
		myDrawPanelItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				setDrawPanel();
			}
			
		});
		
		myFilePanelItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				setFilePanel();
			}
		});
		
		myExitItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		});
	}
}
