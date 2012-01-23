package gui.wizard;

import javax.swing.Box;
import javax.swing.JCheckBox;

import gui.SequencePanel;
import gui.SwitchFrame;
import gui.Title;

public class ChannelsPanel extends SequencePanel {
	
	private static final long serialVersionUID = -5965145044582278319L;
	JCheckBox[] channels;
	public ChannelsPanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		add(new Title(labels.getString("channels")));
		add(Box.createVerticalStrut(30));
		JCheckBox photo = new JCheckBox(menuItems.getString("photo"));
		JCheckBox internet = new JCheckBox(menuItems.getString("net"));
		JCheckBox weather = new JCheckBox(menuItems.getString("weather"));
		JCheckBox news = new JCheckBox(menuItems.getString("news"));
		JCheckBox mii = new JCheckBox(menuItems.getString("mii"));
		JCheckBox shopping = new JCheckBox(menuItems.getString("shop"));
		JCheckBox wiiSpeak = new JCheckBox(menuItems.getString("speak"));
		channels = new JCheckBox[] {photo, internet, weather, news, mii, shopping, wiiSpeak};
		for(JCheckBox current : channels)
			add(current);
		addNextButton();
	}

	@Override
	public SequencePanel getNextPanel() {
		boolean[] channels = new boolean[this.channels.length];
		for(int i = 0; i < channels.length; i++)
			if(this.channels[i].isSelected()) {
				switch(i) {
				case 0:
					parent.feedCollector("PHOTO", "PHOTO");
					break;
				case 1:
					parent.feedCollector("NET", "NET");
					break;
				case 2:
					parent.feedCollector("WEATHER", "WEATHER");
					break;
				case 3:
					parent.feedCollector("NEWS", "NEWS");
					break;
				case 4:
					parent.feedCollector("MII", "MII");
					break;
				case 5:
					parent.feedCollector("SHOP", "SHOP");
					break;
				case 6:
					parent.feedCollector("SPEAK", "SPEAK");
				}
			}
		if(parent.getData("firstTime").equals("true"))
			return new ThemePanel(this, parent);
		return new SpecifiedInstallsPanel(this, parent);
	}

}
