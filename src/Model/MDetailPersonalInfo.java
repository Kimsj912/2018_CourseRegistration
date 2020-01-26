package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import global.Constants.EMDetailPersonalInfo;
import valueObject.VMDetailPersonalInfo;
import valueObject.VMPersonalInfo;

public class MDetailPersonalInfo {
	public VMDetailPersonalInfo getPersonalInfo(String id) { 
		VMDetailPersonalInfo vmDetailPersonalInfo = new VMDetailPersonalInfo();

		try {// 파일에서 아이디와 비밀번호를 불러온다.
			File file = new File(EMDetailPersonalInfo.studentDetail.getString());
			Scanner scanner = new Scanner(file);

			while (scanner.hasNext()) {
				vmDetailPersonalInfo.readFromFile(scanner);
				if (vmDetailPersonalInfo.getUserID().equals(id)) {
					return vmDetailPersonalInfo;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getPersonalInfo(Vector<String> inputDirectories) {
		String name = inputDirectories.elementAt(0);
		String PersonNum = inputDirectories.elementAt(1) + "-" + inputDirectories.elementAt(2);
		String Email = inputDirectories.elementAt(3);

		VMDetailPersonalInfo vmDetailPersonalInfo = new VMDetailPersonalInfo();

		try {// 파일에서 아이디와 비밀번호를 불러온다.
			File file = new File(EMDetailPersonalInfo.studentDetail.getString());
			Scanner scanner = new Scanner(file);

			while (scanner.hasNext()) {
				vmDetailPersonalInfo.readFromFile(scanner);
				if (vmDetailPersonalInfo.getUserName().equals(name)
						&& vmDetailPersonalInfo.getUserPersonNum().equals(PersonNum)
						&& vmDetailPersonalInfo.getUserEMail().equals(Email)) {

					return vmDetailPersonalInfo.getUserID();
				}

			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
