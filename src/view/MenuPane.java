
//전공 끝나고 방학때 만들자. 시험기간이라 아무리 시간만들어도 아직은 내가 이 부분을 끝낼 수는 없을 것 같다...

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CDetailPersonalInfo;
import global.Constants.EBasketPanel;
import global.Constants.EMainFrame;
import global.Constants.EMenuPane;
import global.Constants.EuserPersonalPane;
import global.Constants.EuserPicPane;
import valueObject.VCDetailPersonalInfo;

public class MenuPane extends JPanel {
	private static final long serialVersionUID = 1L;

	private CDetailPersonalInfo cDetailPersonalInfo;

	private Vector<String> fixedData;
	private Vector<String> gottenData;

	private ImageIcon myongjiIcon;

	public MenuPane(ActionListener actionHandler) {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);

//		JPanel btnPanel = new JPanel();
//		btnPanel.setBackground(Color.WHITE);
//
//		for (int i = 1; i < EMenuPane.values().length; i++) {
//			JButton btn = new JButton(EMenuPane.values()[i].getString());
//			btn.setAlignmentX(CENTER_ALIGNMENT);
//			btn.addActionListener(actionHandler);
//			btn.setActionCommand(EMenuPane.values()[i].getString());
//			btnPanel.add(btn);
//
//		}
//		btnPanel.setLayout(new GridLayout(6, 1, 15, 10));
//		this.add(btnPanel, BorderLayout.CENTER);

		this.myongjiIcon = new ImageIcon("graphic\\Myongji_ui\\8_10.gif");
		JPanel nonePicPane = new JPanel() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				g.drawImage(myongjiIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
				g.setColor(Color.white);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		Dimension dim = new Dimension(100, 40);
		nonePicPane.setPreferredSize(dim);
		nonePicPane.setBackground(Color.WHITE);

		this.add(nonePicPane, BorderLayout.SOUTH);

		this.setVisible(true);

	}

	public void initialize(String id) {

	}

	public void MenuPaneControl() {
		// TODO Auto-generated method stub

	}

}
