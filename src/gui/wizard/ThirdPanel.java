package gui.wizard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import gui.SequencePanel;
import gui.SwitchFrame;
import gui.TransparentTextArea;

public class ThirdPanel extends SequencePanel {
	
	private JComboBox region;
	public ThirdPanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		add(new TransparentTextArea(textAreas.getString("region")));
		String[] regions = new String[] { "U (USA)", "E (Europe/PAL)", "J (Japan)", "K (Korea)" };
		region = new JComboBox(regions);
		add(region);
		JButton help = new JButton(basicButtons.getString("help"));
		help.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		JButton next = new JButton(basicButtons.getString("next"));
		next.addActionListener(nextListener);
		addButton(help);
		addButton(next);
	}

	@Override
	public SequencePanel getNextPanel() {
		parent.feedCollector("region", region.getSelectedIndex());
		switch(parent.<Integer>getData("firmware")) {
		case 0:
			return new Exploit4_3Panel(this, parent);
		default:
			return null;
		}
	}

}
