package gui.wizard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import gui.SequencePanel;
import gui.SwitchFrame;
import gui.Title;
import gui.TransparentTextArea;

public class FirmwarePanel extends SequencePanel {

	private static final long serialVersionUID = 3167242679541518662L;
	private JComboBox firmware;
	public FirmwarePanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		add(new Title(labels.getString("firmware")));
		add(Box.createVerticalStrut(30));
		add(new TransparentTextArea(textAreas.getString("firmware")));
		String[] firmStrings = new String[] {"4.3","4.2","4.1","4.0","3.0-3.5",menuItems.getString("other") + " (" + menuItems.getString("under") + " 2.2)"};
		firmware = new JComboBox(firmStrings);
		add(firmware);
		JButton help = new JButton(basicButtons.getString("help"));
		help.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				openHelp();
			}
		});
		JButton next = new JButton(basicButtons.getString("next"));
		next.addActionListener(nextListener);
		addButton(help);
		addButton(next);
	}

	protected void openHelp() {
		try {
			browse("SMver.html");
		} catch (URISyntaxException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	@Override
	public SequencePanel getNextPanel() {
		String firmware = (String)this.firmware.getSelectedItem();
		firmware = firmware.substring(0, 3);
		if(firmware.startsWith("3"))
			firmware = "3.X";
		else if(firmware.equals(menuItems.getString("other").substring(0, 2)))
			firmware = "O";
		parent.feedCollector("firmware", firmware);
		return new RegionPanel(this, parent);
	}

}
