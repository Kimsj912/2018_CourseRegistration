package control;

import java.util.Vector;

import Model.MDetailPersonalInfo;
import Model.MPersonalInfo;
import valueObject.VCDetailPersonalInfo;
import valueObject.VCPersonalInfo;
import valueObject.VMDetailPersonalInfo;
import valueObject.VMPersonalInfo;

public class CDetailPersonalInfo {
	private MDetailPersonalInfo mDetailPersonalInfo;

	public CDetailPersonalInfo() {
		this.mDetailPersonalInfo = new MDetailPersonalInfo();
	}

	public VCDetailPersonalInfo getPersonalInfo(String id) { // id를 주면 데이터를 갖고온다.
		// get data from entity
		VMDetailPersonalInfo vmDetailPersonalInfo = this.mDetailPersonalInfo.getPersonalInfo(id);

		// create control value object and set data from entity value object
		VCDetailPersonalInfo vcDetailPersonalInfo = new VCDetailPersonalInfo();
		vcDetailPersonalInfo.setUserID(vmDetailPersonalInfo.getUserID());
		vcDetailPersonalInfo.setUserName(vmDetailPersonalInfo.getUserName());
		vcDetailPersonalInfo.setUserCollegeNum(vmDetailPersonalInfo.getUserCollegeNum());
		vcDetailPersonalInfo.setUserPersonNum(vmDetailPersonalInfo.getUserPersonNum());
		vcDetailPersonalInfo.setUserEMail(vmDetailPersonalInfo.getUserEMail());
		vcDetailPersonalInfo.setUserPhone1(vmDetailPersonalInfo.getUserPhone1());
		vcDetailPersonalInfo.setUserPhone2(vmDetailPersonalInfo.getUserPhone2());

		return vcDetailPersonalInfo;
	}

	public String ValudateUser(Vector<String> inputDirectories) {// 데이터를 주면 id를 갖고온다.
		// get data from entity
		String id = this.mDetailPersonalInfo.getPersonalInfo(inputDirectories); // 파일을 갖고와

		return id;
	}

}
