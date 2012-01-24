package gui.sneek.sneekNand;

import tools.WizardCollector;
import gui.SwitchFrame;

public class SneekNandWizard extends SwitchFrame {

	private static final long serialVersionUID = -1836908683096181897L;

	public SneekNandWizard() {
		super("ModMiiGui - SNEEK NAND Wizard", new WizardCollector());
		this.setPanel(new SneekTypePanel(null, this));
		setVisible(true);
	}

}
