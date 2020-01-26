package view;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import control.CDirectory;
import global.Constants.EDirectoryPanel;
import valueObject.VCDirectory;

public class DirectoryPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private DirectoryList directoryList1;
	private DirectoryList directoryList2;
	private DirectoryList directoryList3;

	public DirectoryPanel(ListSelectionListener listSelectionListener) {
		this.setLayout(new GridLayout(1,3));

		JScrollPane scrollpane;

		scrollpane = new JScrollPane();
		this.directoryList1 = new DirectoryList();
		this.directoryList1.addListSelectionListener(listSelectionListener);
		scrollpane.setViewportView(this.directoryList1);
		this.add(scrollpane);

		scrollpane = new JScrollPane();
		this.directoryList2 = new DirectoryList();
		this.directoryList2.addListSelectionListener(listSelectionListener);
		scrollpane.setViewportView(this.directoryList2);
		this.add(scrollpane);

		scrollpane = new JScrollPane();
		this.directoryList3 = new DirectoryList();
		this.directoryList3.addListSelectionListener(listSelectionListener);

		scrollpane.setViewportView(this.directoryList3);
		this.add(scrollpane);


	}

	public void initialize(String id) {
		this.refresh(null); 
		
		this.directoryList1.initialize(id);
		this.directoryList2.initialize(id);
		this.directoryList3.initialize(id);


	}

	public String refresh(Object source) {
		String fileName = null;
		if (source == null) {
			this.directoryList1.refresh(EDirectoryPanel.rootfileName.getString());//
			fileName = this.directoryList1.getSelectedFile();
			this.directoryList2.refresh(fileName);
			fileName = this.directoryList2.getSelectedFile();
			this.directoryList3.refresh(fileName);
			fileName = this.directoryList3.getSelectedFile();
		} else if (source.equals(this.directoryList1)) {
			fileName = this.directoryList1.getSelectedFile();
			this.directoryList2.refresh(fileName);
			fileName = this.directoryList2.getSelectedFile();
			this.directoryList3.refresh(fileName);
			fileName = this.directoryList3.getSelectedFile();
		} else if (source.equals(this.directoryList2)) {
			 fileName = this.directoryList2.getSelectedFile();
			 this.directoryList3.refresh(fileName);
			 fileName = this.directoryList3.getSelectedFile();
		} else if (source.equals(this.directoryList3)) {
			 fileName = this.directoryList3.getSelectedFile();
		}
		return fileName;
	}

	private class DirectoryList extends JList<String> {
		
		private static final long serialVersionUID = 1L;
		private Vector<String> listData;
		private Vector<VCDirectory> vcDirectories;
		private CDirectory cDirectory;

		public DirectoryList() {

			this.listData = new Vector<String>();
			this.setListData(this.listData);
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		

			this.cDirectory = new CDirectory();
		}

		public void initialize(String id) {
			
		}

		public String getSelectedFile() {
			String fileName = this.vcDirectories.get(this.getSelectedIndex()).getFileName();
			return fileName;
		}

		public void refresh(String fileName) {
			if (fileName == null) {
				return; 
			}
			this.cDirectory = new CDirectory();
			this.vcDirectories = cDirectory.getData(fileName); 
			this.listData.clear(); 
			for (VCDirectory vcDirectory : vcDirectories) {
				this.listData.add(vcDirectory.getText());
			}
			this.setSelectedIndex(0);
			this.updateUI();

		}
	}

}
