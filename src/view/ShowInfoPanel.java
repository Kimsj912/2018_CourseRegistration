package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.MLogin;
import control.CDetailPersonalInfo;
import control.CPersonalInfo;
import global.Constants.EMenuPane;
import valueObject.VCDetailPersonalInfo;
import valueObject.VCPersonalInfo;

public class ShowInfoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private UserPicPane userPicPane;
	private userPersonalPane userPersonalPane;
	private MenuPane menuPane;
	private JPanel sidePane;
	private int codeNum;

	public ShowInfoPanel() {
		this.setLayout(new BorderLayout());

		this.sidePane = new JPanel();
		sidePane.setLayout(new BorderLayout());

		this.userPicPane = new UserPicPane();
		sidePane.add(userPicPane, BorderLayout.NORTH);

		ActionListener actionHandler = new ActionHandler();
		this.menuPane = new MenuPane(actionHandler);
		sidePane.add(menuPane, BorderLayout.CENTER);

		this.add(sidePane, BorderLayout.WEST);

		this.userPersonalPane = new userPersonalPane();
		this.add(userPersonalPane, BorderLayout.CENTER);

		this.add(Box.createHorizontalStrut(10), BorderLayout.EAST);

		this.setVisible(true);

	}

	public void initialize(String id) {
		this.userPicPane.initialize(id);
		this.userPersonalPane.initialize(id);
		this.menuPane.initialize(id);
		this.codeNum = 1;
	}

	public void finish(String id) {

	}

	public void MenuPaneControl() {
		this.menuPane.MenuPaneControl();
	}

	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(EMenuPane.changePW)) {
				codeNum = 1;
			} else if (e.getSource().equals(EMenuPane.changeUserInfo)) {
				codeNum = 2;
			} else if (e.getSource().equals(EMenuPane.systemoption)) {
				codeNum = 3;
			}
			MenuPaneControl();
		}

	}

}
