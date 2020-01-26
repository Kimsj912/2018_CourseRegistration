package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import global.Constants.EMDirectory;
import valueObject.VMDirectory;


public class MDirectory {
	private Vector<VMDirectory> veDirectories;
	
	public MDirectory() {
		this.veDirectories = new Vector<VMDirectory>();
	}

	public Vector<VMDirectory> getData(String fileName) {
		try {
			this.veDirectories.clear();//다음거하니까 비워.
			File file = new File(EMDirectory.fileAdr.getString()+fileName);
			Scanner scanner = new Scanner(file);

			while(scanner.hasNext()){
				VMDirectory veDirectory= new VMDirectory();
				veDirectory.readFromFile(scanner);
				this.veDirectories.add(veDirectory);
				
			}
			scanner.close();
			return this.veDirectories;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
