package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwitchFrame extends JFrame {
	
	private static final long serialVersionUID = -4311063486017120215L;

	public SwitchFrame(String title) {
		super(title);
		
	}
	public void setPanel(JPanel panel) {
		int index = 0;
		for(index = 0; index < getComponentCount(); index++)
			if(getComponent(index) instanceof JPanel) {
				remove(getComponent(index));
				break;
			}
		add(panel, index - 1);
		pack();
	}
}
