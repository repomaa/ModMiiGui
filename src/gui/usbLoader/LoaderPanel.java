package gui.usbLoader;

import javax.swing.JComboBox;

import gui.ConfirmationPanel;
import gui.SequencePanel;
import gui.SwitchFrame;

public class LoaderPanel extends SequencePanel {

	private static final long serialVersionUID = -3485232732906061086L;
	JComboBox loader;
	public LoaderPanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		String[] loaders = new String[] {"Configurable USB-Loader (" + menuItems.getString("recommended") + ")", "WiiFlow", menuItems.getString("both")}; 
		loader = new JComboBox(loaders);
		add(loader);
		addNextButton();
	}

	@Override
	public SequencePanel getNextPanel() {
		switch(loader.getSelectedIndex()) {
		case 0:
			parent.feedCollector("loader", "CFG");
			break;
		case 1:
			parent.feedCollector("loader", "FLOW");
			break;
		case 2:
			parent.feedCollector("loader", "CFG-FLOW");
		}
		if(parent.getData("format").equals("WBFS"))
			return new ConfirmationPanel(this, parent);
		return new ConfigPanel(this, parent);
	}

	@Override
	protected String getInfo() {
		return null;
	}

	@Override
	protected String getTitle() {
		return "loader";
	}

}
