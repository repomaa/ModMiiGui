package gui.wizard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import gui.SequencePanel;
import gui.SwitchFrame;
import gui.TransparentTextArea;

public class SecondPanel extends SequencePanel {

	private static final long serialVersionUID = 3167242679541518662L;
	private JComboBox firmware;
	public SecondPanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public SequencePanel getNextPanel() {
		parent.feedCollector("firmware", firmware.getSelectedIndex());
		return new ThirdPanel(this, parent);
	}

}
