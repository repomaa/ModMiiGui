package gui.wizard;

import javax.swing.JCheckBox;

import gui.SequencePanel;
import gui.SwitchFrame;

public class ChannelsPanel extends SequencePanel {
	
	private static final long serialVersionUID = -5965145044582278319L;
	JCheckBox[] channels;
	public ChannelsPanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		JCheckBox photo = new JCheckBox(menuItems.getString("photo"));
		JCheckBox internet = new JCheckBox(menuItems.getString("net"));
		JCheckBox weather = new JCheckBox(menuItems.getString("weather"));
		JCheckBox news = new JCheckBox(menuItems.getString("news"));
		JCheckBox mii = new JCheckBox(menuItems.getString("mii"));
		JCheckBox shopping = new JCheckBox(menuItems.getString("shop"));
		JCheckBox wiiSpeak = new JCheckBox(menuItems.getString("speak"));
		channels = new JCheckBox[] {photo, internet, weather, news, mii, shopping, wiiSpeak};
		add(new CheckBoxArray(channels));
		addNextButton();
	}

	@Override
	public SequencePanel getNextPanel() {
		boolean all = true;
		for(int i = 0; i < channels.length; i++)
			all &= channels[i].isSelected();
		if(all)
			parent.feedCollector("CH", "CH");
		else {
			for(int i = 0; i < channels.length; i++) {
				if(channels[i].isSelected()) {
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
			}
		}
		if(parent.getData("firstTime").equals("true"))
			return new ThemePanel(this, parent);
		return new SpecifiedInstallsPanel(this, parent);
	}

	@Override
	protected String getInfo() {
		return null;
	}

	@Override
	protected String getTitle() {
		return "channels";
	}

}
