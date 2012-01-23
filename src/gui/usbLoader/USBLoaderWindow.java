package gui.usbLoader;

import tools.WizardCollector;
import gui.SwitchFrame;

public class USBLoaderWindow extends SwitchFrame {

	private static final long serialVersionUID = 4051029101252325498L;

	public USBLoaderWindow() {
		super("ModMiiGui - USB Wizard + Guide", new WizardCollector());
		setPanel(new FormatPanel(null, this));
		setCollectorMode("U");
		setVisible(true);
	}

}
