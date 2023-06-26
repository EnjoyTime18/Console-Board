package Board;

public class Article {
	private int Postnum; // 글 번호
	private String title; // 글 제목
	private String body; // 글 내용(본문)
	private String Postdate; // 글 날짜 시간 출력
	private String Writename; // 글 작성자 (ID)
	private int HitCount; // 조회수 카운트
	private int LikeCount; // 좋아요 카운트
	
	public Article(int Postnum, String title, String body, String Postdate, String Writename, int HitCount, int LikeCount) {
		this.Postnum = Postnum;
		this.title = title;
		this.body = body;
		this.Postdate = Postdate;
		this.Writename = Writename;
		this.HitCount = HitCount;
		this.LikeCount = LikeCount;
	}
	
	public int getPostnum() {
		return Postnum;
	}

	public void setPostnum(int postnum) {
		this.Postnum = postnum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getPostdate() {
		return Postdate;
	}

	public String getWritename() {
		return Writename;
	}

	public void setWritename(String writename) {
		Writename = writename;
	}

	public int getHitCount() {
		return HitCount;
	}
	
	public void IncreaseHit() { // 조회수 카운트 업 증가
		HitCount++;
	}

	public int getLikeCount() {
		return LikeCount;
	}
	
	public void IncreaseLike() { // 좋아요 카운트 업 증가
		LikeCount++;
	}
}
