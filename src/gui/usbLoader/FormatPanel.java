package gui.usbLoader;

import java.awt.Font;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import gui.SequencePanel;
import gui.SwitchFrame;
import gui.Title;
import gui.TransparentTextArea;

public class FormatPanel extends SequencePanel {

	private static final long serialVersionUID = 483816102476321753L;
	private JRadioButton[] format;
	public FormatPanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		add(new Title(labels.getString("usbFormat")));
		add(Box.createVerticalStrut(30));
		ButtonGroup formats = new ButtonGroup();
		JRadioButton fat = new JRadioButton("FAT32 (" + menuItems.getString("recommended") + ")");
		fat.setSelected(true);
		JRadioButton ntfs = new JRadioButton("NTFS");
		JRadioButton fatAndNtfs = new JRadioButton(menuItems.getString("fatAndNtfs"));
		JRadioButton wbfs = new JRadioButton(menuItems.getString("wbfs"));
		JRadioButton fatSlashWbfs = new JRadioButton(menuItems.getString("fatSlashNtfs"));
		format = new JRadioButton[] {fat, ntfs, fatAndNtfs, wbfs, fatSlashWbfs};
		for(JRadioButton current : format) {
			formats.add(current);
			current.setFont(current.getFont().deriveFont(Font.ITALIC));
		}
		add(fat);
		add(new TransparentTextArea(textAreas.getString("fat")));
		add(ntfs);
		add(new TransparentTextArea(textAreas.getString("ntfs")));
		add(fatAndNtfs);
		add(new TransparentTextArea(textAreas.getString("fatAndNtfs")));
		add(wbfs);
		add(new TransparentTextArea(textAreas.getString("wbfs")));
		add(fatSlashWbfs);
		add(new TransparentTextArea(textAreas.getString("wbfs")));
		addNextButton();
	}

	@Override
	public SequencePanel getNextPanel() {
		for(int i = 0; i < format.length; i++)
			if(format[i].isSelected()) {
				switch (i) {
				case 0:
					parent.feedCollector("format", "FAT32");
					break;
				case 1:
					parent.feedCollector("format", "NTFS");
					break;
				case 2:
					parent.feedCollector("format", "FAT32-NTFS");
					break;
				case 3:
					parent.feedCollector("format", "WBFS");
					break;
				case 4:
					parent.feedCollector("format", "FAT32-WBFS");
				}
				break;
			}
		return new LoaderPanel(this, parent);
	}

}
