package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import global.Constants.EMDirectory;
import global.Constants.EMPersonalInfo;
import valueObject.VMPersonalInfo;

public class MPersonalInfo { //파일에 관련해서 불러오는건 얘만 알아.

	public VMPersonalInfo getPersonalInfo(String id) {
		VMPersonalInfo vEPersonalInfo = new VMPersonalInfo();
		
		try {// 파일에서 아이디와 비밀번호를 불러온다.
			File file = new File(EMDirectory.fileAdr.getString()+EMPersonalInfo.studentfileAdr.getString());
			Scanner scanner = new Scanner(file);

			while(scanner.hasNext()){
				vEPersonalInfo.readFromFile(scanner);
				if(vEPersonalInfo.getId().equals(id)) {
					return vEPersonalInfo;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
