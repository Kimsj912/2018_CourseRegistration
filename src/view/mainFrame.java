package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import global.Constants.EMainFrame;
import view.Main.ActionHandler;

public class mainFrame extends JFrame {
	private static final long serialVersionUID = EMainFrame.serialVersionUID.getInt();

	private PersonaliInfoPanel personalInfo;
	private RegistrationPanel registration;
	private ShowInfoPanel showInfoPanel;
	
	private String id;

	// constructor
	public mainFrame(ActionHandler actionHandler) {
		// attributes 속성 정의,
		this.setTitle(EMainFrame.Title.getString());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(dim.width*3/4, dim.height*3/4);
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// components
		
		WindowListener windowHandler =new WindowHandler();
		this.addWindowListener(windowHandler);
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);

		this.personalInfo = new PersonaliInfoPanel(actionHandler);
		this.add(this.personalInfo, BorderLayout.NORTH);
		
		this.registration = new RegistrationPanel();
		this.add(this.registration, BorderLayout.CENTER);
		
		this.showInfoPanel = new ShowInfoPanel();

		this.setVisible(true);

	}

	public void initialize(String id) {
		this.personalInfo.initialize(id);
		this.registration.initialize(id);
		this.id=id;
	}
	public void finish() {
		this.registration.finish(this.id);
		this.showInfoPanel.finish(this.id);
	}
	
	public void showInfo(ActionHandler actionHandler) {
		this.personalInfo.initializeInfo2();
		this.registration.setVisible(false);
		this.registration.finish(this.id);
		this.showInfoPanel.setVisible(true);
		this.showInfoPanel.initialize(this.id);
		this.add(this.showInfoPanel, BorderLayout.CENTER);
		this.showInfoPanel.setVisible(true);
	}

	public void showSugang(ActionHandler actionHandler) {
		this.personalInfo.initializeInfo1();	
		this.showInfoPanel.setVisible(false);
		this.showInfoPanel.finish(id);
		this.registration.setVisible(true);
		this.registration.initialize();
		this.add(this.registration, BorderLayout.CENTER);
		this.setVisible(true);
	}

	
	private class WindowHandler implements WindowListener{

		@Override
		public void windowActivated(WindowEvent arg0) { 
		}

		@Override
		public void windowClosed(WindowEvent arg0) { 	
		}

		@Override
		public void windowClosing(WindowEvent arg0) { //클로징하는 순간
			finish();
		}

		@Override
		public void windowDeactivated(WindowEvent arg0)  { 
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) { 
		}

		@Override
		public void windowIconified(WindowEvent arg0) { //미니마이즈 되었을때
		}

		@Override
		public void windowOpened(WindowEvent arg0) { 
		}
		
		
	}
	

}