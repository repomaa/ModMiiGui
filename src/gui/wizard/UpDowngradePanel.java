package gui.wizard;

import javax.swing.Box;
import javax.swing.JComboBox;

import gui.SequencePanel;
import gui.SwitchFrame;
import gui.Title;
import gui.TransparentTextArea;

public class UpDowngradePanel extends SequencePanel {

	private static final long serialVersionUID = 5143516525926229369L;
	private JComboBox newFirmware;
	public UpDowngradePanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		add(new Title(labels.getString("upDowngrade")));
		add(Box.createVerticalStrut(30));
		add(new TransparentTextArea(textAreas.getString("upDowngrade")));
		String[] firmwares = new String[] {"4.3","4.2","4.1"};
		String recommended = " (" + menuItems.getString("recommended") + ")";
		int selected = 2;
		if(parent.getData("firmware").equals("4.3")) {
			firmwares[0] += recommended;
			selected = 0;
		}
		else if(parent.getData("firmware").equals("4.2")) {
			firmwares[1] += recommended;
			selected = 1;
		}
		else
			firmwares[2] += recommended;
		newFirmware = new JComboBox(firmwares);
		newFirmware.setSelectedIndex(selected);
		add(newFirmware);
		addNextButton();
	}

	@Override
	public SequencePanel getNextPanel() {
		parent.feedCollector("newFirmware", ((String)newFirmware.getSelectedItem()).substring(0,3));
		return new ChannelsPanel(this, parent);
	}

}
