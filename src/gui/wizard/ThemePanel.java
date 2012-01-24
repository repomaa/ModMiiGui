package gui.wizard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import gui.SequencePanel;
import gui.SwitchFrame;

public class ThemePanel extends SequencePanel {

	private static final long serialVersionUID = -2303275474271533153L;
	private Theme[] theme;
	public ThemePanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		ButtonGroup theme = new ButtonGroup();
		JRadioButton red = new JRadioButton("DarkWii " + menuItems.getString("redTheme"));
		JRadioButton green = new JRadioButton("DarkWii " + menuItems.getString("greenTheme"));
		JRadioButton blue = new JRadioButton("DarkWii " + menuItems.getString("blueTheme"));
		JRadioButton orange = new JRadioButton("DarkWii " + menuItems.getString("orangeTheme"));
		JRadioButton boring = new JRadioButton(menuItems.getString("boringTheme"));
		this.theme = new Theme[] {new Theme(red), new Theme(green), new Theme(blue), new Theme(orange), new Theme(boring, true)};
		for(Theme current : this.theme) {
			theme.add(current.button);
			add(current);
		}
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Theme current : ThemePanel.this.theme) {
					if(current.button.isSelected())
						current.setSelectionsEnabled(true);
					else
						current.setSelectionsEnabled(false);
				}
			}
		};
		for(Theme current : this.theme)
			current.button.addActionListener(listener);
		red.setSelected(true);
		this.theme[0].setSelectionsEnabled(true);
		JButton preview = new JButton(menuItems.getString("darkWiiPreview"));
		preview.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					browse("WiiThemes.html");
				} catch (URISyntaxException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		addButton(preview);
		addNextButton();
	}
	@Override
	public SequencePanel getNextPanel() {
		for(int i = 0; i < theme.length; i++)
			if(theme[i].isSelected()) {
				switch(i) {
				case 0:
					parent.feedCollector("theme", "Red");
					break;
				case 1:
					parent.feedCollector("theme", "Green");
					break;
				case 2:
					parent.feedCollector("theme", "Blue");
					break;
				case 3:
					parent.feedCollector("theme", "Orange");
					break;
				}
				switch(theme[i].getEffect()) {
				case 0:
					parent.feedCollector("effect", "CE:NS");
					break;
				case 1:
					parent.feedCollector("effect", "CE:S");
					break;
				case 2:
					parent.feedCollector("effect", "CE:FS");
				}
			}
		return new USBLoaderNowPanel(this, parent);
	}
	private class Theme extends Box {
		private static final long serialVersionUID = 8448115173235863952L;
		private JRadioButton[] effect;
		private JRadioButton button;
		private Theme(JRadioButton theme) {
			this(theme, false);
			add(Box.createHorizontalGlue());
			ButtonGroup effect = new ButtonGroup();
			JRadioButton noSpin = new JRadioButton(menuItems.getString("noSpin"));
			noSpin.setSelected(true);
			JRadioButton spin = new JRadioButton(menuItems.getString("spin"));
			JRadioButton fastSpin = new JRadioButton(menuItems.getString("fastSpin"));
			this.effect = new JRadioButton[] {noSpin, spin, fastSpin};
			for(JRadioButton button : this.effect) {
				effect.add(button);
				add(button);
			}
			setSelectionsEnabled(false);
		}
		private Theme(JRadioButton theme, boolean boring) {
			super(BoxLayout.X_AXIS);
			this.button = theme;
			this.effect = new JRadioButton[0];
			add(theme);
		}
		private int getEffect() {
			for(int i = 0; i < effect.length; i++)
				if(effect[i].isSelected())
					return i;
			return -1;
		}
		private boolean isSelected() {
			return button.isSelected();
		}
		private void setSelectionsEnabled(boolean value) {
			for(JRadioButton current : effect)
				current.setEnabled(value);
		}
	}
	@Override
	protected String getInfo() {
		return null;
	}
	@Override
	protected String getTitle() {
		return "theme";
	}
}
