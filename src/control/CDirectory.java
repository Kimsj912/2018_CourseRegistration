package control;

import java.util.Vector;

import Model.MDirectory;
import valueObject.VCDirectory;
import valueObject.VMDirectory;

public class CDirectory {

	private MDirectory mDirectory;
	private Vector<VCDirectory> vcDirectories;

	public CDirectory() {
		this.mDirectory = new MDirectory();
	}

	public Vector<VCDirectory> getData(String fileName) {
		Vector<VMDirectory> veDirectories = this.mDirectory.getData(fileName);
		this.vcDirectories = new Vector<VCDirectory>();
		
		for(VMDirectory veDirectory: veDirectories) {
			VCDirectory vcDirectory = new VCDirectory();
			vcDirectory.setId(veDirectory.getId());
			vcDirectory.setText(veDirectory.getText());
			vcDirectory.setFileName(veDirectory.getFileName());
			this.vcDirectories.add(vcDirectory);

		}

		return this.vcDirectories;
	}
}
