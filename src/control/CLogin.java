package control;

import java.io.IOException;

import Model.MLogin;
import valueObject.VCLogin;
import valueObject.VMLogin;;

public class CLogin {
	private MLogin mLogin;
	private VCLogin vcLogin;
	private VMLogin vmLogin;

	public boolean ValudateUser(String inputID, String inputPW) {
		this.mLogin = new MLogin();

		return this.mLogin.validateUser(inputID, inputPW);
	}

	public VMLogin getUserLoginData(String inputID) {
		this.mLogin = new MLogin();

		return this.mLogin.getUserPW(inputID);
	}

	public void changeUserPW(VCLogin vcLogin) {
		this.vmLogin = new VMLogin();

		this.vmLogin.setUserID(vcLogin.getUserID());
		this.vmLogin.setUserPW(vcLogin.getUserPW());
		this.mLogin.changeUserPW(vmLogin);

	}

}
