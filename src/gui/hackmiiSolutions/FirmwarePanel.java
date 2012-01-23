package gui.hackmiiSolutions;

import gui.ConfirmationPanel;
import gui.SequencePanel;
import gui.SwitchFrame;

public class FirmwarePanel extends gui.wizard.FirmwarePanel {

	private static final long serialVersionUID = -3792342793531278733L;

	public FirmwarePanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		parent.feedCollector("firstTime", "false");
	}
	@Override
	public SequencePanel getNextPanel() {
		super.getNextPanel();
		if(parent.getData("firmware").equals("4.3") || parent.getData().equals("O"))
			return new RegionPanel(this, parent);
		else
			return new ConfirmationPanel(this, parent);
	}

}
