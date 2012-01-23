package gui;

import java.awt.Font;
import javax.swing.JLabel;

/**
 * A subclass of JLabel with bigger font size and bold style for Titles
 * @author Joakim Reinert
 *
 */
public class Title extends JLabel {
	
	private static final long serialVersionUID = 6610479718851676259L;

	public Title(String text) {
		super(text);
		Font oldFont = getFont();
		float oldSize = oldFont.getSize2D();
		float newSize = oldSize * 1.2F;
		Font newFont = oldFont.deriveFont(Font.BOLD, newSize);
		setFont(newFont);
	}

}
