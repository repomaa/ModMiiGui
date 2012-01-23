package gui.usbLoader;

import java.awt.Font;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import gui.ConfirmationPanel;
import gui.SequencePanel;
import gui.SwitchFrame;
import gui.Title;
import gui.TransparentTextArea;

public class ConfigPanel extends SequencePanel {

	private static final long serialVersionUID = 6259749516547482016L;
	private JRadioButton usb;
	public ConfigPanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		add(new Title(labels.getString("usbCfgFiles")));
		add(Box.createVerticalStrut(30));
		ButtonGroup locations = new ButtonGroup();
		usb = new JRadioButton("USB " + "(" + menuItems.getString("recommended") + ")");
		usb.setSelected(true);
		JRadioButton sd = new JRadioButton("SD");
		usb.setFont(usb.getFont().deriveFont(Font.ITALIC));
		sd.setFont(sd.getFont().deriveFont(Font.ITALIC));
		locations.add(usb);
		locations.add(sd);
		add(usb);
		add(new TransparentTextArea(textAreas.getString("usb")));
		add(sd);
		add(new TransparentTextArea(textAreas.getString("sd")));
		addNextButton();
		
	}

	@Override
	public SequencePanel getNextPanel() {
		if(usb.isSelected())
			parent.feedCollector("config", "USB");
		else
			parent.feedCollector("config", "SD");
		return new ConfirmationPanel(this, parent);
	}

}
