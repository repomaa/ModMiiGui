package gui.hackmiiSolutions;

import gui.ConfirmationPanel;
import gui.SequencePanel;
import gui.SwitchFrame;

public class LetterBombPanel extends gui.wizard.LetterBombPanel {

	private static final long serialVersionUID = -2321623097793776704L;
	public LetterBombPanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
	}
	@Override
	public SequencePanel getNextPanel() {
		return new ConfirmationPanel(this, parent);
	}

}
