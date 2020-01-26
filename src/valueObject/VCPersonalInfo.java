package valueObject;

public class VCPersonalInfo { //get과 set밖에없다. //우클릭 source generate getter&setter눌러서 만들수있어. //다 공유해. 
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


}
