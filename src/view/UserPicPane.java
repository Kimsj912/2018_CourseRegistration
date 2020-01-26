package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import global.Constants.EuserPicPane;
import javafx.scene.layout.BorderImage;
import javafx.scene.layout.BorderPane;
import valueObject.VCPersonalInfo;

public class UserPicPane extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon myongjiMinIcon;

	public UserPicPane() {
		// attributes
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		this.setSize(160,220);
		this.setBorder(BorderFactory.createLineBorder(Color.white, 5));
		
		
		//picture
		this.myongjiMinIcon = new ImageIcon(EuserPicPane.profileDefaultPic.getString());

		JPanel nonePicPane = new JPanel() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				g.drawImage(myongjiMinIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
				g.setColor(Color.white);
				g.drawRect(0, 0, 150, 210);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		Dimension dim = new Dimension(150, 210);
		nonePicPane.setPreferredSize(dim);
		nonePicPane.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(nonePicPane,BorderLayout.CENTER);

		//모양잡기용 
		this.add(Box.createHorizontalStrut(5),BorderLayout.EAST);
		this.add(Box.createHorizontalStrut(5),BorderLayout.WEST);
		this.add(Box.createVerticalStrut(5),BorderLayout.NORTH);
		this.add(Box.createVerticalStrut(5),BorderLayout.SOUTH);

		this.setVisible(true);

	}

	public void initialize(String id) {
		// get Data
		ImageIcon profileUserPic = new ImageIcon("graphic\\userPic\\" + id + "userPic.jpeg");
		this.myongjiMinIcon = profileUserPic;

		this.updateUI();
	}

}
