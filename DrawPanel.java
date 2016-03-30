package prog3_pr7b_oefentoets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawPanel extends JPanel{
	public DrawPanel(){
		this.setPreferredSize(new Dimension(300, 300));
		this.setBackground(Color.YELLOW);
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.RED);
		g.fillRect(50, 50, 150, 150);
		g.setColor(Color.BLACK);
		g.drawRect(50, 50, 150, 150);
		g.setColor(Color.BLUE);
		g.fillOval(this.getWidth()-150, this.getHeight()-150, 100, 100);
		g.setColor(Color.BLACK);
		g.drawOval(this.getWidth()-150, this.getHeight()-150, 100, 100);
	}
}
