package gui.wizard;

import gui.SequencePanel;
import gui.SwitchFrame;

public class FirstPanel extends SequencePanel {
	
	private static final long serialVersionUID = -4396233122618654765L;
	private YesNo yesNo;
	public FirstPanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		yesNo = new YesNo();
		yesNo.setYes(true);
		add(yesNo);
		addNextButton();
	}

	@Override
	public SequencePanel getNextPanel() {
		parent.feedCollector("firstTime", String.valueOf(yesNo.isYes()));
		return new FirmwarePanel(this, parent);
	}

	@Override
	protected String getInfo() {
		return "firstTime";
	}

	@Override
	protected String getTitle() {
		return "firstTime";
	}

}
