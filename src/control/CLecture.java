package control;

import java.io.IOException;
import java.util.Vector;

import Model.MDirectory;
import Model.MLecture;
import valueObject.VCDirectory;
import valueObject.VCLecture;
import valueObject.VMDirectory;
import valueObject.VMLecture;

public class CLecture {

	private MLecture mLecture;

	public CLecture() {
		this.mLecture = new MLecture();
	}

	public Vector<VCLecture> getData(String fileName) {
		Vector<VMLecture> vmLectures = this.mLecture.getData(fileName);
		Vector<VCLecture> vcLectures = new Vector<VCLecture>();

		for (VMLecture vmLecture : vmLectures) {
			VCLecture vcLecture = new VCLecture();
			vcLecture.setId(vmLecture.getId());
			vcLecture.setName(vmLecture.getName());
			vcLecture.setProfessorName(vmLecture.getProfessorName());
			vcLecture.setTime(vmLecture.getTime());
			vcLecture.setCredit(vmLecture.getCredit());

			vcLectures.add(vcLecture);
		}

		return vcLectures;
	}

	public void setData(String fileName, Vector<VCLecture> vcLectures) throws IOException {
		Vector<VMLecture> vmLectures = new Vector<VMLecture>();

		for (VCLecture vcLecture : vcLectures) {
			VMLecture vmLecture = new VMLecture();
			vmLecture.setId(vcLecture.getId());
			vmLecture.setName(vcLecture.getName());
			vmLecture.setProfessorName(vcLecture.getProfessorName());
			vmLecture.setTime(vcLecture.getTime());
			vmLecture.setCredit(vcLecture.getCredit());

			vmLectures.add(vmLecture);
		}
		this.mLecture.setData(fileName, vmLectures);

	}
}

//여러개를 갖고올수도있고 여기서 평균을 내릴수도있엇. 그외에도 파일받는것과 관련된 여러작업을 하기위해서 얘가있는거야.
//100개를 20개씩 나오게하려는등 화면에서 원하는 데이터를 "가공"해서 주는 역할
