package view;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import global.Constants.ELecturePanel;
import valueObject.VCLecture;

public class LecturePanel extends JPanel { //긜라고해야해. //선택된거 다 내놓으라고 나중에 셀렉트판넬에서 미리담기까지 가는데
	private static final long serialVersionUID = 1L;
	private LectureList lectureList;
	private CLecture cLecture;
	private Vector<VCLecture> vcLectures;

	public LecturePanel() {
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		
		this.lectureList = new LectureList();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(this.lectureList);
		this.add(scrollPane);

	}

	public void refresh(String fileName) {// 컨트롤하고 연결지어야함. 컨트롤러를 여기서 만들어야함.
		// 패널은 추ㄱ상적개념이지
		this.cLecture = new CLecture();
		this.vcLectures = cLecture.getData(fileName); // 어레이를 받아와. 디렉토리하는 거랑 똑같아.

		this.lectureList.addRows(this.vcLectures);
	}

	public Vector<VCLecture> getSelectedLectures() {
		return this.lectureList.getSelectedLectures(this.vcLectures);
	}

	public void initialize(String id) {
	}

	private class LectureList extends JTable {// 이엃게 하면 제테가 되든 드박이 되든 할수있게하려고.

		private DefaultTableModel tableModel;
		private VCLecture vcLecture;

		public LectureList() {// 얘의 모델을만들겨
			this.vcLecture = new VCLecture();

			Vector<String> header = new Vector<String>();
			for (int i = 1; i < ELecturePanel.values().length; i++)
				header.add(ELecturePanel.values()[i].getString());

			this.tableModel = new DefaultTableModel(header, 0);
			this.setModel(this.tableModel);


		}

		public void addRows(Vector<VCLecture> vcLectures) {

			this.tableModel.setRowCount(0); // 테이블모델을 리셋.
			Vector<String> rowData;
			for (VCLecture vcLecture : vcLectures) {
				rowData = new Vector<String>();
				rowData.add(vcLecture.getId());
				rowData.add(vcLecture.getName());
				rowData.add(vcLecture.getProfessorName());
				rowData.add(vcLecture.getTime());
				rowData.add(vcLecture.getCredit());

				this.tableModel.addRow(rowData);
			}
			this.getSelectionModel().addSelectionInterval(0, 0);
		}

		public Vector<VCLecture> getSelectedLectures(Vector<VCLecture> vcLectures) {
			Vector<VCLecture> selectedVCLectures = new Vector<VCLecture>();
			for (int i = 0; i < this.getRowCount(); i++) {
				if (this.isRowSelected(i)) {
					selectedVCLectures.add(vcLectures.elementAt(i));
				}
			}
			return selectedVCLectures;
		}


	}
}
