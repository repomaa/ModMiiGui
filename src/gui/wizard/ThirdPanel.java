package gui.wizard;

import gui.SequencePanel;
import gui.SwitchFrame;
import gui.TransparentTextArea;

public class ThirdPanel extends SequencePanel {

	public ThirdPanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		add(new TransparentTextArea(textAreas.getString("region")));
	}

	@Override
	public SequencePanel getNextPanel() {
		// TODO Auto-generated method stub
		return null;
	}

}
