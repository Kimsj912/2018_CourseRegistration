package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import control.CDetailPersonalInfo;
import global.Constants.EMainFrame;
import global.Constants.EuserPersonalPane;
import javafx.scene.layout.Border;
import valueObject.VCDetailPersonalInfo;
import valueObject.VCLecture;

public class userPersonalPane extends JPanel {
	private static final long serialVersionUID = 1L;

	private ShowDetailPersonalInfoPane showDetailPersonalInfoPane;

	public userPersonalPane() {
		this.setLayout(new BorderLayout());

		// 내용담을 중앙패널
		this.showDetailPersonalInfoPane = new ShowDetailPersonalInfoPane();
		this.add(showDetailPersonalInfoPane, BorderLayout.CENTER);

		// 모양잡기용
		this.add(Box.createVerticalStrut(10), BorderLayout.NORTH);
		this.add(Box.createHorizontalStrut(10), BorderLayout.WEST);
		this.add(Box.createVerticalStrut(10), BorderLayout.SOUTH);
		this.add(Box.createHorizontalStrut(10), BorderLayout.EAST);

		this.setVisible(true);

	}

	public void initialize(String id) {
		this.showDetailPersonalInfoPane.initialize(id);

	}

	private class ShowDetailPersonalInfoPane extends JPanel {
		private static final long serialVersionUID = 1L;

		private UserPersonalTable userPersonalTable;

		private Vector<String> fixedData;
		private Vector<String> gottenData;

		private String id;

		private CDetailPersonalInfo cDetailPersonalInfo;

		public ShowDetailPersonalInfoPane() {
			this.setLayout(new GridLayout(2, 2, 10, 10));

			// 명칭 Vect
			this.fixedData = new Vector<String>();
			this.fixedData.add(EuserPersonalPane.fixedName.getString());
			this.fixedData.add(EuserPersonalPane.fixedCollegeNum.getString());
			this.fixedData.add(EuserPersonalPane.fixedPersonNum.getString());
			this.fixedData.add(EuserPersonalPane.fixedEMail.getString());
			this.fixedData.add(EuserPersonalPane.fixedPhone1.getString());
			this.fixedData.add(EuserPersonalPane.fixedPhone2.getString());

			// 데이터 vect
			this.gottenData = new Vector<String>();

			// 데이터 테이블
			JPanel userPersonalTablePane = new JPanel();
			userPersonalTablePane.setLayout(new BorderLayout());
			userPersonalTablePane.setBorder(BorderFactory.createTitledBorder(null, "개인정보", TitledBorder.LEFT,
					TitledBorder.TOP, null, Color.black));
			this.userPersonalTable = new UserPersonalTable();
			userPersonalTablePane.add(this.userPersonalTable, BorderLayout.CENTER);
			userPersonalTablePane.add(Box.createHorizontalStrut(10), BorderLayout.WEST);
			userPersonalTablePane.add(Box.createHorizontalStrut(10), BorderLayout.EAST);
			userPersonalTablePane.add(Box.createVerticalStrut(10), BorderLayout.NORTH);
			userPersonalTablePane.add(Box.createVerticalStrut(10), BorderLayout.SOUTH);

			this.add(userPersonalTablePane);

			JPanel firstPane = new JPanel();
			firstPane.setBackground(getBackground());
			this.add(firstPane);
			JPanel secondPane = new JPanel();
			secondPane.setBackground(getBackground());
			this.add(secondPane);
			JPanel thirdPane = new JPanel();
			thirdPane.setBackground(getBackground());
			this.add(thirdPane);

			this.setVisible(true);

		}

		public void initialize(String id) {
			this.id = id;
			this.getDetailPersonalInfo();
		}

		public void getDetailPersonalInfo() {

			// get Data
			this.cDetailPersonalInfo = new CDetailPersonalInfo();
			VCDetailPersonalInfo vcDetailPersonalInfo = cDetailPersonalInfo.getPersonalInfo(id);
			// set Data
			this.gottenData = new Vector<String>();
			this.gottenData.add(vcDetailPersonalInfo.getUserName());
			this.gottenData.add(vcDetailPersonalInfo.getUserCollegeNum());
			this.gottenData.add(vcDetailPersonalInfo.getUserPersonNum());
			this.gottenData.add(vcDetailPersonalInfo.getUserEMail());
			this.gottenData.add(vcDetailPersonalInfo.getUserPhone1());
			this.gottenData.add(vcDetailPersonalInfo.getUserPhone2());

			// show Data
			this.userPersonalTable.getDetailPersonalInfo();

			this.updateUI();

		}

		private class UserPersonalTable extends JTable {
			private static final long serialVersionUID = 1L;
			private DefaultTableModel tableModel;

			public UserPersonalTable() {
				this.sizeColumnsToFit(12);

				this.tableModel = new DefaultTableModel(0, 2);
				this.setModel(this.tableModel);
				this.setGridColor(getBackground());
				this.setBackground(null);
				this.setRowHeight(37);

				this.setEnabled(false);
			}

			public void getDetailPersonalInfo() {
				Vector<String> rowData;
				for (int i = 0; i < fixedData.size(); i++) {
					rowData = new Vector<String>();
					rowData.add(fixedData.elementAt(i));
					rowData.add(gottenData.elementAt(i));
					this.tableModel.addRow(rowData);
				}

			}

		}

	}

}
