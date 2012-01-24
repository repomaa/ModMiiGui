package gui.wizard;

import javax.swing.JCheckBox;

import gui.SequencePanel;
import gui.SwitchFrame;

public class SpecifiedInstallsPanel extends SequencePanel {

	private static final long serialVersionUID = 5758603019125142903L;
	private JCheckBox[] checkBoxes;
	public SpecifiedInstallsPanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		JCheckBox hbc = new JCheckBox("HomeBrew " + menuItems.getString("channel") + " " + menuItems.getString("andOr") + " BootMii");
		hbc.setToolTipText(tooltips.getString("hbc"));
		JCheckBox cIOSs = new JCheckBox(menuItems.getString("recommended") + " cIOS" + menuItems.getString("pluralSuffix"));
		cIOSs.setToolTipText(tooltips.getString("cIOSs"));
		JCheckBox yawmm = new JCheckBox("Yet Another Wad Manager Mod (YAWMM)");
		yawmm.setToolTipText(tooltips.getString("yawmm"));
		JCheckBox ios236 = new JCheckBox("ios236");
		ios236.setToolTipText(tooltips.getString("ios236"));
		JCheckBox priiLoader = new JCheckBox("Priiloader 0.7 (" + menuItems.getString("orSMHacks") + ")");
		checkBoxes = new JCheckBox[] {hbc, cIOSs, yawmm, ios236, priiLoader};
		add(new CheckBoxArray(checkBoxes));
		addNextButton();
	}

	@Override
	public SequencePanel getNextPanel() {
		for(int i = 0; i < checkBoxes.length; i++) {
			switch (i) {
			case 0:
				parent.feedCollector("HBC", "HBC");
				break;
			case 1:
				parent.feedCollector("REC", "REC");
				break;
			case 2:
				parent.feedCollector("YAWMM", "YAWMM");
				break;
			case 3:
				parent.feedCollector("236", "236");
				break;
			case 4:
				parent.feedCollector("Pri", "Pri");
				break;
			default:
				break;
			}
		}
		return new ThemePanel(this, parent);
	}

	@Override
	protected String getInfo() {
		return null;
	}

	@Override
	protected String getTitle() {
		return "specifiedInstalls";
	}

}
