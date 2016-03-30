package prog3_pr7b_oefentoets;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel{
	public ButtonPanel(){
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
	}
	
	public void add(JComponent comp){
		super.add(comp);
	}
}
