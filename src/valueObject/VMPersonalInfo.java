package valueObject;

import java.util.Scanner;

public class VMPersonalInfo {
	private String id;
	private String name;
	
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
	public void readFromFile(Scanner scanner) {
		this.id = scanner.next();
		this.name = scanner.next();		
	}
}
