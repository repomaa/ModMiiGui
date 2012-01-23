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

public class RegionPanel extends SequencePanel {
	
	private static final long serialVersionUID = 6828720018753892836L;
	private JComboBox region;
	public RegionPanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		add(new Title(labels.getString("region")));
		add(Box.createVerticalStrut(30));
		add(new TransparentTextArea(textAreas.getString("region")));
		String[] regions = new String[] { "U (USA)", "E (Europe/PAL)", "J (Japan)", "K (Korea)" };
		region = new JComboBox(regions);
		add(region);
		JButton help = new JButton(basicButtons.getString("help"));
		help.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openHelp();
			}
		});
		addButton(help);
		addNextButton();
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
		parent.feedCollector("region", ((String)region.getSelectedItem()).substring(0,1));
		String firmware = parent.getData("firmware");
		if((firmware.equals("4.3") && parent.getData("firstTime").equals("true")) || firmware.startsWith("O")) {
			return new ExploitPanel(this, parent);
		}
		else if(parent.getData("firstTime").equals("false"))
			return new ActiveIOSs(this, parent);
		return new UpDowngradePanel(this, parent);
	}

}
