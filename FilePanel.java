package prog3_pr7b_oefentoets;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

@SuppressWarnings("serial")
public class FilePanel extends JPanel {

	final static Charset ENCODING = StandardCharsets.UTF_8;
	private ButtonPanel myButtonPanel = new ButtonPanel();
	private JTextArea myTextArea = new JTextArea();
	private JFileChooser myFileChooser = new JFileChooser();

	public FilePanel() {
		JButton mySaveButton = new JButton("Save");
		JButton myOpenButton = new JButton("Open");
		this.setPreferredSize(new Dimension(300, 300));
		this.setLayout(new BorderLayout());

		myTextArea.setPreferredSize(new Dimension(300, 250));
		myButtonPanel.setPreferredSize(new Dimension(300, 50));

		mySaveButton.addActionListener(new SaveButtonListener());
		myOpenButton.addActionListener(new OpenButtonListener());

		myButtonPanel.add(myOpenButton);
		myButtonPanel.add(mySaveButton);

		this.add(myButtonPanel, BorderLayout.PAGE_START);
		this.add(myTextArea, BorderLayout.CENTER);
	}

	private class SaveButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int result = myFileChooser.showSaveDialog(FilePanel.this);

			if (result == JFileChooser.APPROVE_OPTION) {
				try {
					Path path = Paths.get(myFileChooser.getSelectedFile().toURI());
					BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.WRITE);

					int lineCount = myTextArea.getLineCount();
					int lineStart;
					int lineEnd;
					
					for (int i = 0; i < lineCount; i++) {
						lineStart = myTextArea.getLineStartOffset(i);
						lineEnd = myTextArea.getLineEndOffset(i);
						String line = myTextArea.getText(lineStart, lineEnd - lineStart);
						bw.append(line);
						bw.append(System.lineSeparator());
					}

					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private class OpenButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int result = myFileChooser.showOpenDialog(FilePanel.this);

			if (result == JFileChooser.APPROVE_OPTION) {
				try {
					
					Path path = Paths.get(myFileChooser.getSelectedFile().toURI());
					String content = "";
					
					for(String s: Files.readAllLines(path, StandardCharsets.UTF_8)){
						content = content + s + "\n";
					}
					
					myTextArea.setText(content);
					
					/*File myFile = myFileChooser.getSelectedFile();
					if (myFile.isFile() && myFile.length() > 0) {
						Scanner fileScanner = new Scanner(
								myFileChooser.getSelectedFile());

						fileScanner.useDelimiter("\\Z");
						myTextArea.setText(fileScanner.next());
						fileScanner.close();
					}*/
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

	}
}
