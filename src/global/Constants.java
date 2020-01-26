package global;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.CLogin;

public class Constants {
	public static enum EMainFrame {
		serialVersionUID("1"),
		Title("수강신청");

		private String value;
		private EMainFrame(String value) {this.value = value;	}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}

	public static enum EPersonaliInfoPanel {
		serialVersionUID("1"),
		lninsaPrefix("환영합니다! "),lbinsaPostfix("님, 명지대학교 수강신청 프로그램입니다."),
		btninfo("개인정보"), btnback("수강신청"), btnlogout("로그아웃"), btnfinish("저장"), 
		btnfinishClicked("데이터 저장을 위해 꼭 해주세요");

		private String value;
		private EPersonaliInfoPanel(String value) {this.value = value;	}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}

	}

	public static enum ELoginDialog {
		serialVersionUID("1"),
		width("300"),height("230"), title("명지대학교 수강신청 프로그램"), 
		nameLabel(" 아이디    "), nameTextSize("15"),
		passwordLabel("비밀번호 "), passwordTextSize("15"), 
		cancelButton("Cancel"), okButton("OK"),
		findIDPW("앗, 로그인이 되지않습니까?");

		
		private String value;
		private ELoginDialog(String value) {this.value = value;	}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	
	
	public static enum EErrorDialog {
		serialVersionUID("1"),
		title("오류"),
		message("잘못입력했음.");
		
		private String value;
		private EErrorDialog(String value) {this.value = value;	}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EDirectoryPanel {
		serialVersionUID("1"),
		rootfileName("root");
		
		private String value;
		private EDirectoryPanel(String value) {this.value = value;	}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EuserPersonalPane {
		serialVersionUID("1"),
		fixedName("이름"),
		fixedCollegeNum("학번"),
		fixedPersonNum("주민번호"),
		fixedPersonNumLine("-"),
		fixedEMail("이메일"),
		fixedPhone1("연락처1"),
		fixedPhone2("연락처2");
		
		private String value;
		private EuserPersonalPane(String value) {this.value = value;	}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	public static enum EuserPicPane {
		serialVersionUID("1"),
		profileDefaultPic("graphic\\\\Myongji_UI\\\\5_3.gif"),
		fixedPhone2("연락처2  ");
		
		private String value;
		private EuserPicPane(String value) {this.value = value;	}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	
	public static enum EFindDialog {
		serialVersionUID("1"),
		title("명지대학교 수강신청 프로그램");
		
		private String value;
		private EFindDialog(String value) {this.value = value;	}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EBasictopPanel {
		serialVersionUID("1"),
		headerLabel("아이디/비밀번호 찾기"),
		rePanelBtn("다시쓰기"),
		backToFindPanelBtn("돌아가기");
		
		private String value;
		private EBasictopPanel(String value) {this.value = value;	}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	
	
	public static enum EFindCenterPanel {
		serialVersionUID("1"),
		fixedIDexplain("아이디찾기"),
		fixedPWexplain("비밀번호찾기"),
		fixedName("이름        "),
		fixedPersonNum("주민번호"),
		fixedPersonNumLine("-"),
		fixedEMail("이메일    "),
		fixedID("아이디    "),
		searchIDBtn(" 아이디 조회 "),
		searchPWBtn("비밀번호 조회"),
		nameTextSize("15"),
		IDTextSize("15"),
		PersonNum1stTextSize("6"),
		PersonNum2ndTextSize("7"),
		EmailTextSize("15"),
		FaileFindingtitle(""),
		FailedFindingMessage( "열심히 찾아보았지만 \n데이터를 찾지못했어요 ㅠㅠ"),
		successedFindingIDMessage1("휴 드디어 찾았습니다!\n"),
		successedFindingIDMessage2("당신의 ID는"),
		successedFindingIDMessage3("입니다."),
		successedFindingIDtitle("아이디 찾기"),
		successedFindingPWMessage("새로운 비밀번호를 입력해주세요"),
		successedFindingPWtitle("새로운 비밀번호 설정"),
		successedChangingPW("비밀번호가 변경되었습니다. 로그인을 시도해주세요.")
		;
		
		private String value;
		private EFindCenterPanel(String value) {this.value = value;	}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EFindBottomPanel {
		serialVersionUID("1"),
		myongjiMinIcon("graphic\\\\Myongji_ui\\\\8_10.gif")
		;
		
		private String value;
		private EFindBottomPanel(String value) {this.value = value;	}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum ELecturePanel {
		serialVersionUID("1"),
		id("강좌번호"),
		name("강좌명"),
		professor("교수명"),
		time("시간"),
		credit("학점");
		
		private String value;
		private ELecturePanel(String value) {this.value = value;	}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	public static enum EBasketPanel {
		serialVersionUID("1"),
		id("강좌번호"),
		name("강좌명"),
		professor("교수명"),
		time("시간"),
		credit("학점");

		
		private String value;
		private EBasketPanel(String value) {this.value = value;	}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EMenuPane {
		serialVersionUID("1"),
		changeUserInfo("회원정보"),
		changePW("비밀번호 변경"),
		systemoption("시스템 설정");

		private String value;
		private EMenuPane(String value) {this.value = value;	}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}

	}
	public static enum EMDetailPersonalInfo {
		serialVersionUID("1"),
		studentDetail("data\\studentdetail");

		private String value;
		private EMDetailPersonalInfo(String value) {this.value = value;	}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}

	}
	public static enum EMDirectory {
		serialVersionUID("1"),
		fileAdr("data\\");

		private String value;
		private EMDirectory(String value) {this.value = value;	}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}

	}
	public static enum EMLogin {
		serialVersionUID("1"),
		loginfileAdr("login"),
		copy("Copy");

		private String value;
		private EMLogin(String value) {this.value = value;	}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}

	}
	public static enum EMPersonalInfo {
		serialVersionUID("1"),
		studentfileAdr("student"),
		copy("Copy");

		private String value;
		private EMPersonalInfo(String value) {this.value = value;	}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}

	}
}
