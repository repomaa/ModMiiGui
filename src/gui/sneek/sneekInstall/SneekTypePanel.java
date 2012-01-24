package gui.sneek.sneekInstall;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import gui.ConfirmationPanel;
import gui.PathSelectionPanel;
import gui.SequencePanel;
import gui.SwitchFrame;
import gui.TransparentTextArea;

public class SneekTypePanel extends SequencePanel {
	
	private static final long serialVersionUID = 6497226450309988651L;
	private JRadioButton[] sneekType;
	
	public SneekTypePanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		ButtonGroup sneekTypes = new ButtonGroup();
		JRadioButton uneekDi = new JRadioButton("UNEEK+DI");
		uneekDi.setSelected(true);
		JRadioButton sneekDi = new JRadioButton("SNEEK+DI");
		JRadioButton uneek = new JRadioButton("UNEEK");
		JRadioButton sneek = new JRadioButton("SNEEK");
		sneekType = new JRadioButton[] {uneekDi, sneekDi, uneek, sneek};
		for(JRadioButton current : sneekType) {
			current.setFont(current.getFont().deriveFont(Font.ITALIC));
			sneekTypes.add(current);
		}
		add(uneekDi);
		add(new TransparentTextArea(textAreas.getString("uneekDiInfo")));
		add(sneekDi);
		add(new TransparentTextArea(textAreas.getString("sneekDiInfo")));
		add(uneek);
		add(new TransparentTextArea(textAreas.getString("uneekInfo")));
		add(sneek);
		add(new TransparentTextArea(textAreas.getString("sneekInfo")));
		addNextButton();
	}

	protected String getTitle() {
		return "sneekType";
	}

	@Override
	public SequencePanel getNextPanel() {
		for(int i = 0; i < sneekType.length; i++) {
			if(sneekType[i].isSelected()) {
				parent.feedCollector("sneekType", sneekType[i].getText());
				break;
			}
		}
		return new PathSelectionPanel(this, parent);
	}

	@Override
	protected String getInfo() {
		return null;
	}

}
