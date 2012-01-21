package gui.wizard;

import gui.SwitchFrame;
import javax.swing.JPanel;

public class WizardWindow extends SwitchFrame {
	
	private static final long serialVersionUID = -1782485785505290771L;
	public WizardWindow() {
		super("ModMiiGui - ModMii Wizard + Guide");
		setPanel(getFirstPanel());
		setVisible(true);
	}
	private JPanel getFirstPanel() {
		return new FirstPanel(null, this);
	}
}
