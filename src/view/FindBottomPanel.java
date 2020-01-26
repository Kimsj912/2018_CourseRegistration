package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import global.Constants.EFindBottomPanel;

public class FindBottomPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public FindBottomPanel() {
		this.setBackground(Color.white); // 프레임 배경색 화이트
		this.setLayout(new BorderLayout());

		JPanel centerPanel = new JPanel() ;
		centerPanel.setBackground(Color.white);
		this.add(centerPanel, BorderLayout.CENTER);

		
		ImageIcon myongjiMinIcon = new ImageIcon(EFindBottomPanel.myongjiMinIcon.getString());
		JPanel eastPanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				g.drawImage(myongjiMinIcon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		Dimension dim = new Dimension(190,50);
		eastPanel.setPreferredSize(dim);
		eastPanel.setLayout(new BorderLayout());
		eastPanel.setBackground(Color.white);
		this.add(eastPanel, BorderLayout.EAST);

		JPanel westPanel = new JPanel();
		westPanel.setBackground(Color.white);
		this.add(westPanel, BorderLayout.WEST);

		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.white);
		this.add(southPanel, BorderLayout.SOUTH);

		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.white);
		this.add(northPanel, BorderLayout.NORTH);
	}

	public void initialize() {

	}

	public void refresh() {
		// TODO Auto-generated method stub

	}

}
