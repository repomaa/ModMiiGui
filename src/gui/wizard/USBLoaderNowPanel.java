package gui.wizard;

import javax.swing.Box;

import gui.ConfirmationPanel;
import gui.SequencePanel;
import gui.SwitchFrame;
import gui.Title;
import gui.TransparentTextArea;
import gui.usbLoader.FormatPanel;

public class USBLoaderNowPanel extends SequencePanel {

	private static final long serialVersionUID = -773545427947318125L;
	private YesNo yesNo;
	public USBLoaderNowPanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		add(new Title(labels.getString("usbLoaderToo")));
		add(Box.createVerticalStrut(30));
		add(new TransparentTextArea(textAreas.getString("usbLoaderToo")));
		yesNo = new YesNo();
		yesNo.setYes(false);
		add(yesNo);
		addNextButton();
	}

	@Override
	public SequencePanel getNextPanel() {
		if(yesNo.isYes()) {
			parent.feedCollector("usb", "USB");
			return new FormatPanel(this, parent);
		}
		return new ConfirmationPanel(this, parent);
	}

}
