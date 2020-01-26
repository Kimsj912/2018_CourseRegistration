package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import global.Constants.EMDirectory;
import valueObject.VCLecture;
import valueObject.VMDirectory;
import valueObject.VMLecture;

public class MLecture {
	private Vector<VMLecture> vmLectures;
	private VMLecture vmLecture;

	public MLecture() {
		this.vmLectures = new Vector<VMLecture>();
	}

	public Vector<VMLecture> getData(String fileName) {
		try {
			this.vmLectures.clear();
			File file = new File(EMDirectory.fileAdr.getString() + fileName);
			if (!file.exists()) {
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.close();
			}
			Scanner scanner = new Scanner(file);

			while (scanner.hasNext()) {
				VMLecture vmLecture = new VMLecture();
				vmLecture.readFromFile(scanner);
				this.vmLectures.add(vmLecture);

			}
			scanner.close();
			return this.vmLectures;
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void setData(String fileName, Vector<VMLecture> vmLectures) throws IOException {
		File realfile = new File(EMDirectory.fileAdr.getString() + fileName);
		FileWriter fileWriter = new FileWriter(realfile);

		for (VMLecture vmLecture : vmLectures) {
			vmLecture.writeToFile(fileWriter);
		}

		fileWriter.close();

	}
}
