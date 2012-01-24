package gui.sneek.sneekNand;

import gui.SequencePanel;
import gui.SwitchFrame;

public class FirmwarePanel extends gui.wizard.UpDowngradePanel {

	private static final long serialVersionUID = -6939796988833806506L;

	public FirmwarePanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
	}
	@Override
	protected String getTitle() {
		return "firmwareNand";
	}
	@Override
	protected String getInfo() {
		return null;
	}
}
