package gui.sneek.sneekNand;

import gui.SequencePanel;
import gui.SwitchFrame;

public class RegionPanel extends gui.wizard.RegionPanel {

	private static final long serialVersionUID = 2587858354172028526L;

	public RegionPanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
	}	
	@Override
	public SequencePanel getNextPanel() {
		super.getNextPanel();
		return new FirmwarePanel(last, parent);
	}
	@Override
	protected String getTitle() {
		return "nandRegion";
	}
	@Override
	protected String getInfo() {
		return "nandRegionInfo";
	}

}
