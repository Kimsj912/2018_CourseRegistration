package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import global.Constants.EBasictopPanel;
import global.Constants.EFindBottomPanel;
import global.Constants.EFindCenterPanel;
import global.Constants.EFindCenterPanel;
import global.Constants.ELoginDialog;
import global.Constants.EPersonaliInfoPanel;

public class Main {

	private mainFrame MainFrame;
	private LoginDialog loginDialog;
	private ActionHandler actionHandler;
	private KeyHandler keyHandler;

	private boolean InfoOpen;

	public Main() { 
		// child window (로그인 다이얼로그)
		this.actionHandler = new ActionHandler();
		this.keyHandler = new KeyHandler();
		this.loginDialog = new LoginDialog(actionHandler, keyHandler);
		this.InfoOpen = false;
	}

	private void initialize() {
		this.loginDialog.initialize();
	}
	public void finish() {
		this.MainFrame.finish();
	}

	private void loginOK() {
		String id = loginDialog.ValidateUser();
		if (id != null) {
			loginDialog.dispose();
			this.MainFrame = new mainFrame(this.actionHandler);
			this.MainFrame.initialize(id);
		}
	}

	private void loginCancel() {
		loginDialog.dispose();
	}

	public void mainCancel() {
		MainFrame.dispose();
	}

	public void setlogout() {
		this.loginDialog.refresh();
		this.loginDialog.setVisible(true);
	}

	public void showInfo() {
		if (!InfoOpen) {
			MainFrame.showInfo(this.actionHandler);
			InfoOpen = true;
		} else {
			MainFrame.showSugang(this.actionHandler);
			InfoOpen = false;
		}
	}

	public void loginFindIDPWOpen() {
		this.loginDialog.loginFindIDPWJoin();
	}
	

	
	class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (actionEvent.getActionCommand().equals(ELoginDialog.okButton.getString())) {
				loginOK();
			} else if (actionEvent.getActionCommand().equals(ELoginDialog.cancelButton.getString())) {
				loginCancel();
			} else if (actionEvent.getActionCommand().equals(ELoginDialog.findIDPW.getString())) {
				loginFindIDPWOpen();
			} else if (actionEvent.getActionCommand().equals(EPersonaliInfoPanel.btninfo.getString())) {
				showInfo();
			} else if (actionEvent.getActionCommand().equals(EPersonaliInfoPanel.btnlogout.getString())) {
				InfoOpen = false;
				mainCancel();
				finish();
				setlogout();
			} else if (actionEvent.getActionCommand().equals(EPersonaliInfoPanel.btnfinish.getString())) {
				finish();
			}
			
		}

	}

	class KeyHandler implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				loginOK();
			} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				loginCancel();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}
	}

	public static void main(String[] args) { // main은 이게 거의 끝
		Main main;
		main = new Main();
		main.initialize();

	}

	
}