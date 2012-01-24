package gui.sneek.sneekNand;

import gui.SequencePanel;
import gui.SwitchFrame;

public class SneekTypePanel extends gui.sneek.sneekInstall.SneekTypePanel {

	private static final long serialVersionUID = 2973691653274637826L;
	public SneekTypePanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
	}
	@Override
	protected String getTitle() {
		return "sneekTypeNand";
	}
	@Override
	public SequencePanel getNextPanel() {
		super.getNextPanel();
		return new RegionPanel(this, parent);
	}

}
