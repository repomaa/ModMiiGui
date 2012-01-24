package gui.sneek.sneekInstall;

import tools.WizardCollector;
import gui.SwitchFrame;

public class SneekWizard extends SwitchFrame {

	private static final long serialVersionUID = -4148382497034946145L;

	public SneekWizard() {
		super("ModMiiGui - SNEEK Wizard", new WizardCollector());
		setCollectorMode("S");
		setPanel(new SneekTypePanel(null, this));
		setVisible(true);
	}

}
