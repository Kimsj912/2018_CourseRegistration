package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

import global.Constants.EMDirectory;
import global.Constants.EMLogin;
import valueObject.VCLogin;
import valueObject.VMLogin;

public class MLogin {

	private VMLogin vmLogin;

	public MLogin() {
		this.vmLogin = new VMLogin();

	}

	public boolean validateUser(String inputID, String inputPW) {

		try {
			File file = new File(EMDirectory.fileAdr.getString()+EMLogin.loginfileAdr.getString());
			Scanner scanner = new Scanner(file);

			while (scanner.hasNext()) {
				vmLogin.readFromFile(scanner);
				if (inputID.equals(vmLogin.getUserID()) && inputPW.equals(vmLogin.getUserPW()))
					return true;

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public VMLogin getUserPW(String inputID) {
		try {
			File file = new File(EMDirectory.fileAdr.getString()+EMLogin.loginfileAdr.getString());
			Scanner scanner = new Scanner(file);

			while (scanner.hasNext()) {
				vmLogin.readFromFile(scanner);
				if (inputID.equals(vmLogin.getUserID()))
					return vmLogin;

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void changeUserPW(VMLogin vmLogin) {
		try {
			File realfile = new File(EMDirectory.fileAdr.getString()+EMLogin.loginfileAdr.getString());
			File pastefile = new File(EMDirectory.fileAdr.getString()+EMLogin.loginfileAdr.getString()+EMLogin.copy.getString());
			pastefile=vmLogin.copyFile(realfile, pastefile);
			
			FileWriter fileWriter = new FileWriter(realfile);
			Scanner scanner = new Scanner(pastefile);

			vmLogin.whiteToFile(fileWriter, scanner);
			scanner.close();
			fileWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
