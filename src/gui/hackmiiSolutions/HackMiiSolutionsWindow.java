package gui.hackmiiSolutions;

import tools.WizardCollector;
import gui.SwitchFrame;

public class HackMiiSolutionsWindow extends SwitchFrame {

	private static final long serialVersionUID = 8178870069339223587L;

	public HackMiiSolutionsWindow() {
		super("ModMiiGui - HackMii Solutions", new WizardCollector());
		setCollectorMode("HS");
		setPanel(new FirmwarePanel(null, this));
		setVisible(true);
	}
	
}
