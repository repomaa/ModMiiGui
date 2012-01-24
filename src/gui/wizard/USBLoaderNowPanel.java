package gui.wizard;

import gui.ConfirmationPanel;
import gui.PathSelectionPanel;
import gui.SequencePanel;
import gui.SwitchFrame;
import gui.usbLoader.FormatPanel;

public class USBLoaderNowPanel extends SequencePanel {

	private static final long serialVersionUID = -773545427947318125L;
	private YesNo yesNo;
	public USBLoaderNowPanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
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
		return new PathSelectionPanel(this, parent);
	}

	@Override
	protected String getInfo() {
		return "usbLoaderToo";
	}

	@Override
	protected String getTitle() {
		return "usbLoaderToo";
	}

}
