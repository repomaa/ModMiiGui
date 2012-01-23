package gui.wizard;

import javax.swing.Box;

import gui.SequencePanel;
import gui.SwitchFrame;
import gui.Title;
import gui.TransparentTextArea;

public class ActiveIOSs extends SequencePanel {

	private static final long serialVersionUID = 222989460115708097L;
	private YesNo yesNo;
	public ActiveIOSs(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		add(new Title(labels.getString("dlActiveIOSs")));
		add(Box.createVerticalStrut(30));
		yesNo = new YesNo();
		if(parent.getData("firmware").equals("4.3") && parent.getData("firstTime").equals("true"))
			add(new TransparentTextArea(textAreas.getString("dlActiveIOSs1_4_3")));
		else
			add(new TransparentTextArea(textAreas.getString("dlActiveIOSs1_modded")));
		add(new TransparentTextArea(textAreas.getString("dlActiveIOSs2")));
		yesNo.setYes(false);
		add(yesNo);
		addNextButton();
	}

	@Override
	public SequencePanel getNextPanel() {
		if(yesNo.isYes())
			parent.feedCollector("activeIOSs", "UIOS:E");
		else
			parent.feedCollector("activeIOSs", "UIOS:D");
		return new UpDowngradePanel(this, parent); 
	}

}
