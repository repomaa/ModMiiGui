package gui.wizard;

import javax.swing.Box;

import gui.SequencePanel;
import gui.SwitchFrame;
import gui.Title;
import gui.TransparentTextArea;

public class FirstPanel extends SequencePanel {
	
	private static final long serialVersionUID = -4396233122618654765L;
	private YesNo yesNo;
	public FirstPanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		add(new Title(labels.getString("firstTime")));
		add(Box.createVerticalStrut(30));
		add(new TransparentTextArea(textAreas.getString("firstTime")));
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

}
