package valueObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class VMLogin {
	private String userID;
	private String userPW;

	public void readFromFile(Scanner scanner) {
		setUserID(scanner.next());
		setUserPW(scanner.next());
	}

	public void whiteToFile(FileWriter fileWriter, Scanner scanner) throws IOException {
		Vector<String> logindirectoriesAll = new Vector<String>();
		Vector<String> logindirectories = new Vector<String>();

		while (scanner.hasNext()) {
			logindirectories.clear();
			logindirectories.addElement(scanner.next()); // 아이디
			if (logindirectories.elementAt(0).equals(getUserID())) {
				logindirectories.addElement(getUserPW());
				scanner.next();// 순서맞추기용 비번
			} else {
				logindirectories.addElement(scanner.next()); // 비밀번호
			}
			logindirectoriesAll.addAll(logindirectories);
		}

		for (int i = logindirectoriesAll.indexOf(logindirectoriesAll.lastElement()); i >= 0; i--) {
			if (i % 2 == 1) {
				String index = logindirectoriesAll
						.get(logindirectoriesAll.indexOf(logindirectoriesAll.lastElement()) - i);
				fileWriter.write(index);
				fileWriter.write(" ");
			} else if (i % 2 == 0) {
				String index = logindirectoriesAll
						.get(logindirectoriesAll.indexOf(logindirectoriesAll.lastElement()) - i);
				fileWriter.write(index);
				fileWriter.write("\n");
			}
		}
	}

	public File copyFile(File realfile, File pastefile) {
		try {
			FileWriter fileWriter = new FileWriter(pastefile);
			Scanner sc = new Scanner(realfile);
			while (sc.hasNextLine()) {
				fileWriter.write(sc.nextLine() + "\n");
			}
			fileWriter.close();
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pastefile;

	}

	public String getUserPW() {
		return userPW;
	}

	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

}
