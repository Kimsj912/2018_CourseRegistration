package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import control.CDetailPersonalInfo;
import control.CLogin;
import global.Constants.EFindCenterPanel;
import global.Constants.EFindCenterPanel;
import valueObject.VCLogin;
import valueObject.VMLogin;

public class FindCenterPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private FindIDPanel findIDPanel;
	private FindPWPanel findPWPanel;

	public FindCenterPanel(ActionListener actionHandler) {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.white);

		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.white);
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		this.findIDPanel = new FindIDPanel(actionHandler);
		this.findIDPanel.setBackground(Color.white);
		centerPanel.add(this.findIDPanel);

		centerPanel.add(Box.createVerticalStrut(15));

		this.findPWPanel = new FindPWPanel(actionHandler);
		this.findPWPanel.setBackground(Color.white);
		centerPanel.add(this.findPWPanel);
		this.add(centerPanel, BorderLayout.CENTER);

		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.white);
		southPanel.add(Box.createVerticalStrut(15));
		this.add(southPanel, BorderLayout.SOUTH);

		this.setVisible(true);
	}

	public void initialize() {
		// TODO Auto-generated method stub

	}

	public void refresh() {
		findIDPanel.refresh();
		findPWPanel.refresh();

	}

	public boolean ValidateUser(int codeNum) {
		boolean ifFinResult = false;
		if (codeNum == 1) {
			this.findIDPanel.ValidateUser();// id값 리턴
		} else if (codeNum == 2) {
			ifFinResult = this.findPWPanel.ValidateUser(); // 패스워드 관려돼서 갖고와
		}
		if (ifFinResult) {
			refresh();
		}
		return ifFinResult;

	}

	private class FindIDPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		private JPanel explainPane;
		private JPanel namePane;
		private JPanel personNumPane;
		private JPanel eMailPane;
		private JPanel searchBtnPane;

		private JTextField fixedNameText;
		private JTextField fixedPersonNumFirstText;
		private JTextField fixedEMailText;
		private JPanel miniNPane;
		private JPanel miniPNPane;
		private JPanel miniEMPane;
		private JPasswordField fixedPersonNumSecondText;
		private Vector<String> inputDirectories;
		private CDetailPersonalInfo cDetailPersonalInfo;

		public FindIDPanel(ActionListener actionHandler) {

			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

			// 설명패널
			this.explainPane = new JPanel();
			this.explainPane.setBackground(Color.white);

			this.explainPane.setLayout(new BorderLayout());
			JLabel fixedexplainLabel = new JLabel(EFindCenterPanel.fixedIDexplain.getString());

			this.explainPane.add(Box.createHorizontalStrut(15), BorderLayout.WEST);
			this.explainPane.add(fixedexplainLabel, BorderLayout.CENTER);

			// 이름 입력 패널
			this.namePane = new JPanel();
			this.namePane.setBackground(Color.white);

			this.miniNPane = new JPanel();
			this.miniNPane.setBackground(Color.white);

			JLabel fixedNameLabel = new JLabel(EFindCenterPanel.fixedName.getString());
			this.fixedNameText = new JTextField(EFindCenterPanel.nameTextSize.getInt());

			this.miniNPane.add(fixedNameLabel);
			this.miniNPane.add(Box.createHorizontalStrut(65));
			this.miniNPane.add(fixedNameText);
			this.miniNPane.add(Box.createHorizontalStrut(65));

			this.namePane.add(Box.createHorizontalStrut(10));
			this.namePane.add(miniNPane);

			// 주민번호 패널
			this.personNumPane = new JPanel();
			this.personNumPane.setBackground(Color.white);

			this.miniPNPane = new JPanel();
			this.miniPNPane.setBackground(Color.white);

			JLabel fixedPersonNumLabel = new JLabel(EFindCenterPanel.fixedPersonNum.getString());
			this.fixedPersonNumFirstText = new JTextField(EFindCenterPanel.PersonNum1stTextSize.getInt());
			JLabel fixedPersonNumLine = new JLabel(EFindCenterPanel.fixedPersonNumLine.getString());
			this.fixedPersonNumSecondText = new JPasswordField(EFindCenterPanel.PersonNum2ndTextSize.getInt());
			this.miniPNPane.add(fixedPersonNumLabel);
			this.miniPNPane.add(Box.createHorizontalStrut(65));
			this.miniPNPane.add(fixedPersonNumFirstText);
			this.miniPNPane.add(fixedPersonNumLine);
			this.miniPNPane.add(fixedPersonNumSecondText);
			this.miniPNPane.add(Box.createHorizontalStrut(65));

			this.personNumPane.add(Box.createHorizontalStrut(7));
			this.personNumPane.add(miniPNPane);

			// 이메일 패널
			this.eMailPane = new JPanel();
			this.eMailPane.setBackground(Color.white);

			this.miniEMPane = new JPanel();
			this.miniEMPane.setBackground(Color.white);

			JLabel fixedeMailLabel = new JLabel(EFindCenterPanel.fixedEMail.getString());
			this.fixedEMailText = new JTextField(EFindCenterPanel.EmailTextSize.getInt());
			this.miniEMPane.add(fixedeMailLabel);
			this.miniEMPane.add(Box.createHorizontalStrut(65));
			this.miniEMPane.add(fixedEMailText);
			this.miniEMPane.add(Box.createHorizontalStrut(65));

			this.eMailPane.add(Box.createHorizontalStrut(10));
			this.eMailPane.add(miniEMPane);

			// 조회 버튼 패널
			this.searchBtnPane = new JPanel();
			this.searchBtnPane.setBackground(Color.white);

			JButton searchBtn = new JButton(EFindCenterPanel.searchIDBtn.getString());
			searchBtn.addActionListener(actionHandler);
			searchBtn.setActionCommand(EFindCenterPanel.searchIDBtn.getString());
			this.searchBtnPane.add(Box.createHorizontalStrut(15));
			this.searchBtnPane.add(searchBtn);

			// 추가과정
			this.add(explainPane);
			this.add(namePane);
			this.add(personNumPane);
			this.add(eMailPane);
			this.add(searchBtnPane);

		}

		public void refresh() {

			// 이름 입력 패널
			this.fixedNameText.setText("");

			// 주민번호 패널
			this.fixedPersonNumFirstText.setText("");
			this.fixedPersonNumSecondText.setText("");

			// 이메일 패널
			this.fixedEMailText.setText("");

		}

		public void ValidateUser() {

			String inputName = this.fixedNameText.getText();
			String inputPersonNumFirst = this.fixedPersonNumFirstText.getText();
			String inputPersonNumSecond = this.fixedPersonNumSecondText.getText();
			String inputEMail = this.fixedEMailText.getText();

			this.inputDirectories = new Vector<String>();
			this.inputDirectories.addElement(inputName);
			this.inputDirectories.addElement(inputPersonNumFirst);
			this.inputDirectories.addElement(inputPersonNumSecond);
			this.inputDirectories.addElement(inputEMail);

			this.cDetailPersonalInfo = new CDetailPersonalInfo();
			String id = cDetailPersonalInfo.ValudateUser(inputDirectories);
			if (id != null) {
				JOptionPane.showMessageDialog(this,
						EFindCenterPanel.successedFindingIDMessage1.getString()
								+ EFindCenterPanel.successedFindingIDMessage2.getString() + id
								+ EFindCenterPanel.successedFindingIDMessage3.getString(),
						EFindCenterPanel.successedFindingIDtitle.getString(), JOptionPane.CLOSED_OPTION);
				refresh();
			} else {
				JOptionPane.showMessageDialog(this, EFindCenterPanel.FailedFindingMessage.getString(),
						EFindCenterPanel.FaileFindingtitle.getString(), JOptionPane.OK_OPTION);
			}
		}

	}

	private class FindPWPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		private JPanel explainPane;
		private JPanel namePane;
		private JPanel personNumPane;
		private JPanel eMailPane;
		private JPanel IDPane;
		private JPanel searchBtnPane;

		private JTextField fixedNameText;
		private JTextField fixedEMailText;
		private JTextField fixedPersonNumFirstText;
		private JPasswordField fixedPersonNumSecondText;
		private JTextField fixedIDlText;

		private JPanel miniNPane;
		private JPanel miniPNPane;
		private JPanel miniEMPane;
		private JPanel miniIDPane;
		private Vector<String> inputDirectories;
		private CDetailPersonalInfo cDetailPersonalInfo;
		private CLogin cLogin;

		public FindPWPanel(ActionListener actionHandler) {

			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

			// 설명패널
			this.explainPane = new JPanel();
			this.explainPane.setBackground(Color.white);

			this.explainPane.setLayout(new BorderLayout());
			JLabel fixedexplainLabel = new JLabel(EFindCenterPanel.fixedPWexplain.getString());

			this.explainPane.add(Box.createHorizontalStrut(15), BorderLayout.WEST);
			this.explainPane.add(fixedexplainLabel, BorderLayout.CENTER);

			// 이름 입력 패널
			this.namePane = new JPanel();
			this.namePane.setBackground(Color.white);

			this.miniNPane = new JPanel();
			this.miniNPane.setBackground(Color.white);

			JLabel fixedNameLabel = new JLabel(EFindCenterPanel.fixedName.getString());
			this.fixedNameText = new JTextField(EFindCenterPanel.nameTextSize.getInt());
			this.miniNPane.add(fixedNameLabel);
			this.miniNPane.add(Box.createHorizontalStrut(65));
			this.miniNPane.add(fixedNameText);
			this.miniNPane.add(Box.createHorizontalStrut(65));

			this.namePane.add(Box.createHorizontalStrut(10));
			this.namePane.add(miniNPane);

			// 아이디 패널
			this.IDPane = new JPanel();
			this.IDPane.setBackground(Color.white);

			this.miniIDPane = new JPanel();
			this.miniIDPane.setBackground(Color.white);

			JLabel fixedIDLabel = new JLabel(EFindCenterPanel.fixedID.getString());
			this.fixedIDlText = new JTextField(EFindCenterPanel.IDTextSize.getInt());

			this.miniIDPane.add(fixedIDLabel);
			this.miniIDPane.add(Box.createHorizontalStrut(65));
			this.miniIDPane.add(fixedIDlText);
			this.miniIDPane.add(Box.createHorizontalStrut(65));

			this.IDPane.add(Box.createHorizontalStrut(10));
			this.IDPane.add(miniIDPane);

			// 주민번호 패널
			this.personNumPane = new JPanel();
			this.personNumPane.setBackground(Color.white);

			this.miniPNPane = new JPanel();
			this.miniPNPane.setBackground(Color.white);

			JLabel fixedPersonNumLabel = new JLabel(EFindCenterPanel.fixedPersonNum.getString());
			this.fixedPersonNumFirstText = new JTextField(EFindCenterPanel.PersonNum1stTextSize.getInt());
			JLabel fixedPersonNumLine = new JLabel(EFindCenterPanel.fixedPersonNumLine.getString());
			this.fixedPersonNumSecondText = new JPasswordField(EFindCenterPanel.PersonNum2ndTextSize.getInt());
			
			this.miniPNPane.add(fixedPersonNumLabel);
			this.miniPNPane.add(Box.createHorizontalStrut(65));
			this.miniPNPane.add(fixedPersonNumFirstText);
			this.miniPNPane.add(fixedPersonNumLine);
			this.miniPNPane.add(fixedPersonNumSecondText);
			this.miniPNPane.add(Box.createHorizontalStrut(65));

			this.personNumPane.add(Box.createHorizontalStrut(7));
			this.personNumPane.add(miniPNPane);

			// 이메일 패널
			this.eMailPane = new JPanel();
			this.eMailPane.setBackground(Color.white);

			this.miniEMPane = new JPanel();
			this.miniEMPane.setBackground(Color.white);

			JLabel fixedeMailLabel = new JLabel(EFindCenterPanel.fixedEMail.getString());
			this.fixedEMailText = new JTextField(EFindCenterPanel.EmailTextSize.getInt());
			this.miniEMPane.add(fixedeMailLabel);
			this.miniEMPane.add(Box.createHorizontalStrut(65));
			this.miniEMPane.add(fixedEMailText);
			this.miniEMPane.add(Box.createHorizontalStrut(65));

			this.eMailPane.add(Box.createHorizontalStrut(10));
			this.eMailPane.add(miniEMPane);

			// 조회 버튼 패널
			this.searchBtnPane = new JPanel();
			this.searchBtnPane.setBackground(Color.white);

			JButton searchBtn = new JButton(EFindCenterPanel.searchPWBtn.getString());
			searchBtn.addActionListener(actionHandler);
			searchBtn.setActionCommand(EFindCenterPanel.searchPWBtn.getString());
			this.searchBtnPane.add(Box.createHorizontalStrut(15));
			this.searchBtnPane.add(searchBtn);

			this.add(explainPane);
			this.add(namePane);
			this.add(IDPane);
			this.add(personNumPane);
			this.add(eMailPane);
			this.add(searchBtnPane);

		}

		public void refresh() {
			// 아이디 패널
			this.fixedIDlText.setText("");

			// 이름 입력 패널
			this.fixedNameText.setText("");

			// 주민번호 패널
			this.fixedPersonNumFirstText.setText("");
			this.fixedPersonNumSecondText.setText("");

			// 이메일 패널
			this.fixedEMailText.setText("");
		}

		public boolean ValidateUser() {

			String inputName = this.fixedNameText.getText();
			String inputID = this.fixedIDlText.getText();
			String inputPersonNumFirst = this.fixedPersonNumFirstText.getText();
			String inputPersonNumSecond = this.fixedPersonNumSecondText.getText();
			String inputEMail = this.fixedEMailText.getText();

			this.inputDirectories = new Vector<String>();
			this.inputDirectories.addElement(inputName);
//			this.inputDirectories.addElement(inputID);
			this.inputDirectories.addElement(inputPersonNumFirst);
			this.inputDirectories.addElement(inputPersonNumSecond);
			this.inputDirectories.addElement(inputEMail);

			this.cDetailPersonalInfo = new CDetailPersonalInfo();
			String id = cDetailPersonalInfo.ValudateUser(inputDirectories);

			this.cLogin = new CLogin();
			if (id == null) {
				JOptionPane.showMessageDialog(this, EFindCenterPanel.FailedFindingMessage.getString(),
						EFindCenterPanel.FaileFindingtitle.getString(), JOptionPane.OK_OPTION);

			} else if (id.equals(inputID)) {
				// 로그인가서 아디 비번확인한겨
				VMLogin veLogin = cLogin.getUserLoginData(inputID);// pw를 통채로 가져올거야. 스트링으로말고 전체로 그래서 가져온걸로 바꿀겨
				String newPW = JOptionPane.showInputDialog(this, EFindCenterPanel.successedFindingPWMessage.getString(),
						EFindCenterPanel.successedFindingPWtitle.getString(), JOptionPane.INFORMATION_MESSAGE);
//				System.out.println(newPW);//취소하면 null뜨고 확인하면 그 스트링이 옴
				if (newPW != null) {
					VCLogin vcLogin = new VCLogin();
					vcLogin.setUserID(id);
					vcLogin.setUserPW(newPW);
					cLogin.changeUserPW(vcLogin);
					JOptionPane.showMessageDialog(this, EFindCenterPanel.successedChangingPW.getString(),
							EFindCenterPanel.successedFindingPWtitle.getString(), JOptionPane.INFORMATION_MESSAGE);
					return true;
				}
			}
			return false;

		}

	}

}
