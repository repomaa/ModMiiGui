package gui.wizard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;

import javax.swing.Box;
import javax.swing.JButton;
import gui.SequencePanel;
import gui.SwitchFrame;
import gui.TransparentTextArea;

public class LetterBombPanel extends SequencePanel {

	private static final long serialVersionUID = -3371316892870730023L;

	public LetterBombPanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		add(new TransparentTextArea(textAreas.getString("letterBombInstr")));
		addNextButton();
	}
	@Override
	protected void addNextButton() {
		super.addNextButton();
		Box buttonBox = (Box)getComponent(getComponentCount() - 1);
		JButton nextButton = (JButton)buttonBox.getComponent(buttonBox.getComponentCount() - 1);
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					browse("LetterBombFrames.html");
				} catch (URISyntaxException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
	};
	@Override
	public SequencePanel getNextPanel() {
		return new ActiveIOSs(last, parent);
	}

}
