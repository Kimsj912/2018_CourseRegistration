package view;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MovePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton leftButton;
	private JButton rightButton;

	

	public MovePanel(ActionListener actionHandler) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.leftButton = new JButton("<");
		this.leftButton.setActionCommand("leftButton");
		this.leftButton.addActionListener(actionHandler);
		this.add(this.leftButton);

		this.rightButton = new JButton(">");
		this.rightButton.setActionCommand("rightButton");
		this.rightButton.addActionListener(actionHandler);
		this.add(this.rightButton);
	}

	public void initialize() {

	}
	
	
	public JButton getLeftButton() {
		return leftButton;
	}

	public JButton getRightButton() {
		return rightButton;
	}
	
}
