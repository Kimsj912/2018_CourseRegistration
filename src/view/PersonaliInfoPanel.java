package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import control.CPersonalInfo;
import global.Constants.EPersonaliInfoPanel;
import valueObject.VCPersonalInfo;
import view.Main.ActionHandler;

public class PersonaliInfoPanel extends JPanel {
	private static final long serialVersionUID = EPersonaliInfoPanel.serialVersionUID.getInt();

	private JLabel lbinsa;
	private JLabel lbinsaPrefix;
	private JLabel lbinsaPostfix;

	private String btninfoText;

	private JButton btninfo;
	private JButton btnlogout;
	private JButton btnfinish;

	private String id;


	public PersonaliInfoPanel(ActionHandler actionHandler) {

		this.setLayout(new BorderLayout());
		this.setBackground(Color.white.darker());

		MouseMotionListener mouseMotionHandler = new MouseMotionHandler();
		MouseListener mouseHandler = new MouseHandler();

		//유저 환영 인사 panel
		JPanel helloUserPanel = new JPanel();
		helloUserPanel.setBackground(Color.white.darker());
		helloUserPanel.setLayout(new BoxLayout(helloUserPanel, BoxLayout.X_AXIS));
		
		helloUserPanel.add(Box.createHorizontalStrut(10));
		
		this.lbinsaPrefix = new JLabel(EPersonaliInfoPanel.lninsaPrefix.getString());
		helloUserPanel.add(this.lbinsaPrefix);

		this.lbinsa = new JLabel();
		helloUserPanel.add(this.lbinsa);
		
		this.lbinsaPostfix = new JLabel(EPersonaliInfoPanel.lbinsaPostfix.getString());
		helloUserPanel.add(this.lbinsaPostfix);
		this.add(helloUserPanel, BorderLayout.WEST);

		//각종 btn panel
		JPanel BtnPanel = new JPanel();
		BtnPanel.setBackground(Color.white.darker());

		ClockPanel timePanel = new ClockPanel();
		BtnPanel.add(timePanel);

		this.btninfoText = EPersonaliInfoPanel.btninfo.getString();
		this.btninfo = new JButton(btninfoText);
		btninfo.setActionCommand(EPersonaliInfoPanel.btninfo.getString());
		btninfo.addActionListener(actionHandler);
		BtnPanel.add(this.btninfo);

		this.btnlogout = new JButton(EPersonaliInfoPanel.btnlogout.getString());
		btnlogout.setActionCommand(EPersonaliInfoPanel.btnlogout.getString());
		btnlogout.addActionListener(actionHandler);
		BtnPanel.add(this.btnlogout);

		this.btnfinish = new JButton(EPersonaliInfoPanel.btnfinish.getString());
		btnfinish.setActionCommand(EPersonaliInfoPanel.btnfinish.getString());
		btnfinish.addActionListener(actionHandler);
		btnfinish.addMouseMotionListener(mouseMotionHandler);
		btnfinish.addMouseListener(mouseHandler);
		BtnPanel.add(this.btnfinish);

		this.add(BtnPanel, BorderLayout.EAST);

	}

	public void initialize(String id) {
		this.showPersonalInfo(id);
		this.id = id;
	}

	public void initialize() {
		this.showPersonalInfo(this.id);
	}

	private void showPersonalInfo(String id) {
		CPersonalInfo cPersonalInfo = new CPersonalInfo();
		VCPersonalInfo vPersonalInfo = cPersonalInfo.getPersonalInfo(id);
		this.lbinsa.setText(vPersonalInfo.getName());
	}

	public void initializeInfo1() {
		this.btninfo.setText(EPersonaliInfoPanel.btninfo.getString());

	}

	public void initializeInfo2() {
		this.btninfo.setText(EPersonaliInfoPanel.btnback.getString());
	}

	public void openWarningBox(boolean ifon) {
		if (ifon) {
			this.btnfinish.setText(EPersonaliInfoPanel.btnfinishClicked.getString());
		} else {
			this.btnfinish.setText(EPersonaliInfoPanel.btnfinish.getString());
		}

	}

	class ClockPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private JTextField timeField;
		private Timer t;

		public ClockPanel() {
			this.setBackground(Color.white.darker());
			timeField = new JTextField(17);
			timeField.setBackground(Color.white.darker());
			timeField.setEditable(false);
			timeField.setFont(new Font("sansserif", Font.PLAIN, 15));
			timeField.setBorder(BorderFactory.createLineBorder(Color.white.darker()));
			this.add(timeField);
			t = new Timer(500, new ClockListener());
			t.start();
		}

		private class ClockListener implements ActionListener {
			boolean flag = false;

			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				SimpleDateFormat g = new SimpleDateFormat("yyyy년  MM월 dd일 ");

				Calendar time = Calendar.getInstance();
				int hour = time.get(Calendar.HOUR);
				int min = time.get(Calendar.MINUTE);
				int sec = time.get(Calendar.SECOND);
				int amPm = time.get(Calendar.AM_PM);
				timeField.setText(g.format(date) + (amPm == 0 ? "am " : "pm ") + (hour < 10 ? "0" + hour : hour)
						+ (flag ? ":" : " ") + (min < 10 ? "0" + min : min) + (flag ? ":" : " ")
						+ (sec < 10 ? "0" + sec : sec));
				flag = !flag; // 콜론 깜빡이도록 체크해주는 플래그 값
			}

		}
	}

	private class MouseMotionHandler implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			if (e.getSource().equals(btnfinish)) {
				openWarningBox(true);
			}

		}

	}

	private class MouseHandler implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getSource().equals(btnfinish)) {
				openWarningBox(false);
			}
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

}
