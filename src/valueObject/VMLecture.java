package valueObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import global.Constants.EBasketPanel;

public class VMLecture {

	private String id;
	private String name;
	private String professorName;
	private String credit;
	private String time;

	public void readFromFile(Scanner scanner) {
		// TODO Auto-generated method stub
		this.setId(scanner.next());
		this.setName(scanner.next());
		this.setProfessorName(scanner.next());
		this.setCredit(scanner.next());
		this.setTime(scanner.next());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void writeToFile(FileWriter fileWriter) throws IOException {
		Vector<String> lecturedirectories = new Vector<String>();

		lecturedirectories.add(this.id);
		lecturedirectories.add(this.name);
		lecturedirectories.add(this.professorName);
		lecturedirectories.add(this.credit);
		lecturedirectories.add(this.time);

		for (String index : lecturedirectories) {
			fileWriter.append(index);
			if (lecturedirectories.lastElement().equals(index)) {
				fileWriter.write("\n");
			} else {
				fileWriter.write(" ");
			}
		}

	}

}
