package gui.hackmiiSolutions;

import gui.SequencePanel;
import gui.SwitchFrame;

public class RegionPanel extends gui.wizard.RegionPanel {

	private static final long serialVersionUID = 1L;

	public RegionPanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
	}
	@Override
	public SequencePanel getNextPanel() {
		super.getNextPanel();
		return new ExploitPanel(this, parent);
	}

}
