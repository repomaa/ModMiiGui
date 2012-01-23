package gui;

import java.awt.Dimension;

import javax.swing.JTextArea;

/**
 * A subclass of JTextArea that has a transparent background,
 * no editing, line wrapping and a customized getPreferredSize
 * method for correct size calculation
 * @author Joakim Reinert
 *
 */
public class TransparentTextArea extends JTextArea {
	
	private static final long serialVersionUID = -1964588762171601325L;

	public TransparentTextArea(String text) {
		super(text);
		setOpaque(false);
		setEditable(false);
		setColumns(45);
		setLineWrap(true);
		setWrapStyleWord(true);
	}
	@Override
	public Dimension getPreferredSize() {
		Dimension dim = super.getPreferredSize();
		char[] text = getText().toCharArray();
		int space = 0;
		int charsSinceLB = 0;
		for(char current : text)
			if(current == '\n') {
				space+=getColumns() - charsSinceLB;
				charsSinceLB = 0;
			}
			else {
				space++;
				charsSinceLB++;
			}
		int lines = space / getColumns() + 2;
		dim.setSize(dim.width, lines * getRowHeight());
		return dim;
	}

}
