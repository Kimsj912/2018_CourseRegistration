package view;

import java.io.IOException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import global.Constants.EBasketPanel;
import global.Constants.EErrorDialog;
import global.Constants.ELecturePanel;
import valueObject.VCLecture;

public class BasketPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private CLecture cLecture;
	private Vector<VCLecture> vcLectures;

	private BasketList basketList;

	public BasketPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.basketList = new BasketList();
		
		this.vcLectures = new Vector<VCLecture>();
		this.cLecture = new CLecture();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(this.basketList);
		this.add(scrollPane);

	}

	public void initialize(String id) {
		Vector<VCLecture> vcLectures=this.cLecture.getData(id);
		this.basketList.addRows(vcLectures);
	}

	public void finish(String fileName) {
		try {
			this.cLecture.setData(fileName, this.vcLectures);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,
					EErrorDialog.message.getString(),
					EErrorDialog.title.getString(),
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public Vector<VCLecture> getSelectedLectures() {
		return this.basketList.getSelectedLectures();
	}

	public void addRows(Vector<VCLecture> selectedLectures) { // 액션커맨드가 눌리면 할것. //벡터인 이유는 멀티플 셀렉션이 되기 때문임.
		this.basketList.addRows(selectedLectures); // basketList는 밖에서 안보이기 때문에 basketPanel을 이용함.

	}

	public void removeSelectedRows() {
		this.basketList.removeSelectedRows();
	}

	private class BasketList extends JTable {// 이엃게 하면 제테가 되든 드박이 되든 할수있게하려고.

		private DefaultTableModel tableModel;
		private Vector<VCLecture> BaskettableData;
		private boolean idt;

		public BasketList() {// 얘의 모델을만들겨
			Vector<String> header = new Vector<String>();
			for (int i = 1; i < EBasketPanel.values().length; i++)
				header.add(EBasketPanel.values()[i].getString());

			this.tableModel = new DefaultTableModel(header, 0);
			this.setModel(this.tableModel);
			// BasketPanel 전용 저장공간
			this.BaskettableData = new Vector<VCLecture>();
		}

		public Vector<VCLecture> getSelectedLectures() {
			Vector<VCLecture> selectedLectures = new Vector<VCLecture>();
			for (int i = 0; i < this.getRowCount(); i++) {
				if (this.isRowSelected(i)) {
					selectedLectures.add(this.BaskettableData.get(i));
				}
			}
			return selectedLectures;

		}

		public void addRows(Vector<VCLecture> selectedLectures) {

			Vector<String> rowData;
			for (VCLecture vcLecture : selectedLectures) {
				rowData = new Vector<String>();
				rowData.add(vcLecture.getId());
				rowData.add(vcLecture.getName());
				rowData.add(vcLecture.getProfessorName());
				rowData.add(vcLecture.getTime());
				rowData.add(vcLecture.getCredit());

				idt = addRowsIdentitySame(rowData);
				if (idt) {
					this.tableModel.addRow(rowData);
					this.BaskettableData.add(vcLecture);
				}

			}
			selectionInterval();

		}

		public boolean addRowsIdentitySame(Vector<String> rowData) {
			if (this.tableModel.getRowCount() == 0) {
				return true;
			}
			for (int i = 0; i < this.tableModel.getRowCount(); i++) {
				if (this.tableModel.getDataVector().elementAt(i).equals(rowData)) {
					return false;
				}
			}
			return true;
		}
		

		public void removeSelectedRows() {
			for (int i = this.tableModel.getRowCount() - 1; i >= 0; --i) {
				if (this.isRowSelected(i) && this.getRowCount() != 0) {
					this.tableModel.removeRow(i);
					this.BaskettableData.remove(i);

				}

			}
			selectionInterval();

		}
		

		public void selectionInterval() {
			for (int i = this.tableModel.getRowCount() - 1; i >= 0; --i) {
				this.getSelectionModel().removeSelectionInterval(i, 0);
			}
			this.getSelectionModel().addSelectionInterval(0, 0);
			vcLectures.clear();
			vcLectures.addAll(this.BaskettableData);
		}

	}

}
