package view;

import java.awt.*;
import javax.swing.*;

import control.CLogin;
import global.Constants.EBasictopPanel;
import global.Constants.EErrorDialog;
import global.Constants.EFindBottomPanel;
import global.Constants.EFindCenterPanel;
import global.Constants.EFindCenterPanel;
import global.Constants.ELoginDialog;
import global.Constants.EPersonaliInfoPanel;
import view.Main.ActionHandler;
import view.Main.KeyHandler;

import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginDialog extends JDialog {// 상속을 받았는데연ㄱ려이안되서 컨스트럭터를 불러서 해결하는데 jdialog의 컨스트럭터이름이 수퍼야.
	private static final long serialVersionUID = 1L;

	// components
	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel passwordLabel;
	private JPasswordField passwordText;

	// Associations
	private CLogin cLogin;
	private FindDialog findDialog;
	// handler
	private WindowHandler windowHandler;
	private ActionListener actionHandler;

	private JButton CancelButton;
	private JButton okButton;

	private JButton findIDPW;
	private JButton findpwBtn;
	private JButton newjoin;

	public LoginDialog(ActionListener actionHandler, KeyHandler keyHandler) {
		// attribute

		Dimension dimLDMinSize = new Dimension(ELoginDialog.width.getInt(), ELoginDialog.height.getInt());
		this.setMinimumSize(dimLDMinSize);
		this.setTitle(ELoginDialog.title.getString());
		this.setSize(ELoginDialog.width.getInt(), ELoginDialog.height.getInt());
		Dimension dimLDLocation = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dimLDLocation.width / 2 - this.getSize().width / 2,
				dimLDLocation.height / 2 - this.getSize().height / 2);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);

		// components
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

		// Handler
		this.actionHandler = actionHandler;
		this.windowHandler = new WindowHandler();

		// 아이디와 관련된 판넬 panel1
		JPanel aboutIDPanel = new JPanel();
		aboutIDPanel.setLayout(new BoxLayout(aboutIDPanel, BoxLayout.X_AXIS));

		nameLabel = new JLabel(ELoginDialog.nameLabel.getString());

		nameText = new JTextField(ELoginDialog.nameTextSize.getInt());
		nameText.addKeyListener(keyHandler);

		aboutIDPanel.add(new JLabel("         "));
		aboutIDPanel.add(nameLabel);
		aboutIDPanel.add(new JLabel("         "));
		aboutIDPanel.add(nameText);
		aboutIDPanel.add(new JLabel("         "));

		// 비밀번호와 관련된 판넬 panel2
		JPanel aboutPWPanel = new JPanel();
		aboutPWPanel.setLayout(new BoxLayout(aboutPWPanel, BoxLayout.X_AXIS));

		passwordLabel = new JLabel(ELoginDialog.passwordLabel.getString());
		passwordText = new JPasswordField(ELoginDialog.passwordTextSize.getInt());
		passwordText.addKeyListener(keyHandler);

		aboutPWPanel.add(new JLabel("         "));
		aboutPWPanel.add(passwordLabel);
		aboutPWPanel.add(new JLabel("         "));
		aboutPWPanel.add(passwordText);
		aboutPWPanel.add(new JLabel("         "));

		// 버튼과 관련된 판넬 panel3
		JPanel aboutBtnPanel = new JPanel();
		aboutBtnPanel.setLayout(new BoxLayout(aboutBtnPanel, BoxLayout.X_AXIS));

		this.okButton = new JButton(ELoginDialog.okButton.getString());
		okButton.addActionListener(actionHandler);
		okButton.setActionCommand(ELoginDialog.okButton.getString());
		okButton.setBackground(Color.white);

		this.CancelButton = new JButton(ELoginDialog.cancelButton.getString());
		CancelButton.addActionListener(actionHandler);
		CancelButton.setActionCommand(ELoginDialog.cancelButton.getString());
		CancelButton.setBackground(Color.white);

		aboutBtnPanel.add(new JLabel("               "));
		aboutBtnPanel.add(okButton);
		aboutBtnPanel.add(new JLabel("                  "));
		aboutBtnPanel.add(CancelButton);
		aboutBtnPanel.add(new JLabel("               "));

		JPanel aboutFindPanel = new JPanel();
		aboutFindPanel.setLayout(new BoxLayout(aboutFindPanel, BoxLayout.X_AXIS));

		this.findIDPW = new JButton(ELoginDialog.findIDPW.getString());
		findIDPW.addActionListener(actionHandler);
		findIDPW.setActionCommand(ELoginDialog.findIDPW.getString());
		findIDPW.setBackground(Color.white);

		aboutFindPanel.add(new JLabel("               "));
		aboutFindPanel.add(findIDPW);
		aboutFindPanel.add(new JLabel("               "));

		// 판넬 추가작업
		c.add(new JLabel(" "));
		c.add(new JLabel(" "));
		c.add(aboutIDPanel);
		c.add(new JLabel(" "));
		c.add(aboutPWPanel);
		c.add(new JLabel(" "));
		c.add(aboutFindPanel);
		c.add(new JLabel(" "));
		c.add(aboutBtnPanel);
		c.add(new JLabel(" "));

		this.setVisible(true);

	}

	public void refresh() {
		// TODO Auto-generated method stub
		this.nameText.setText("");
		this.passwordText.setText("");
	}

	public void initialize() {

	}

	public void loginFindIDPWJoin() {
		this.LoginDialogDisable();
		this.findDialog = new FindDialog(this.windowHandler, new ActionHandler());
		findDialog.initialize();

	}

	@SuppressWarnings("deprecation")
	public void LoginDialogAble() {
		this.enable();
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	@SuppressWarnings("deprecation")
	public void LoginDialogDisable() {
		this.disable();
	}

	public String ValidateUser() {
		String inputID = nameText.getText();
		String inputPW = passwordText.getText();

		this.cLogin = new CLogin();
		boolean result = cLogin.ValudateUser(inputID, inputPW);
		if (result) {
			return inputID;
		} else {
			JOptionPane.showMessageDialog(this, EErrorDialog.message.getString(), EErrorDialog.title.getString(),
					JOptionPane.INFORMATION_MESSAGE);
			return null;
		}
	}

	public void FindDialogifAll(int codeNum) {
		// TODO Auto-generated method stub
		LoginDialogAble();
		boolean canFinResult = findDialog.AfternewDialog(codeNum);
		if (canFinResult) {
			this.findDialog.dispose();
		}
	}

	class WindowHandler implements WindowListener {
		@Override
		public void windowClosing(WindowEvent e) {
			LoginDialogAble();
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
		}

		@Override
		public void windowActivated(WindowEvent arg0) {
		}

	}

	class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			// 아이디 비밀번호 찾기 다이얼로그
			if (actionEvent.getActionCommand().equals(EBasictopPanel.backToFindPanelBtn.getString())) { // 탑
				LoginDialogAble();
				findDialog.dispose();
			} else if (actionEvent.getActionCommand().equals(EBasictopPanel.rePanelBtn.getString())) { // 탑
				findDialog.refresh();
			} else if (actionEvent.getActionCommand().equals(EFindCenterPanel.searchIDBtn.getString())) { // 미들
				FindDialogifAll(1);
			} else if (actionEvent.getActionCommand().equals(EFindCenterPanel.searchPWBtn.getString())) { // 미들
				FindDialogifAll(2);
			}
		}

	}

}