package Board;

class User {
	private String ID; // 사용자 아이디
	private String password; // 사용자 비밀번호
	private String name; // 닉네임 또는 이름
	private int Usercont; // 회원가입된 유저 수 카운트
	
	public User(String id, String password, String name, int Usercont) {
		this.ID = id;
		this.password = password;
		this.name = name;
		this.Usercont = Usercont;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		this.ID = iD;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUsercont() {
		return Usercont;
	}
	
}