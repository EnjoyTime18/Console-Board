package Board;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Board {
	Scanner scan = new Scanner(System.in);

	ArrayList<User> userlist = new ArrayList<User>(); // 회원(회원가입 한) 유저 리스트
	ArrayList<Article> articlelist = new ArrayList<Article>(); // 게시글 리스트

	boolean LoginState = false; // 로그인상태 - false: 로그아웃 true: 로그인
	int Joincont; // 회원가입 완료 시 유저(사람) 증가 카운트
	int Postwritecont; // 게시글 갯수 카운트
	
	String inputIDcheck; // 작성자를 출력하기 위한 변수

	public void start() {
		System.out.println("<<< 게시판 프로그램을 실행합니다. >>> ");
		System.out.println();
		System.out.println("<< 명령어를 선택하여 입력해주세요 >>");
		System.out.println("회원가입: join  로그인: login  로그아웃: logout  종료: exit");
		System.out.println("게시글 추가: write  게시글 수정: change  게시글 삭제: delete  게시글 목록: list  게시글 상세보기: showlist");
		System.out.println("도움말 명령어: showhelp");
		System.out.println();
		System.out.print("명령어 - ");
		

		while (true) {
			String command = scan.next();

			if (command.equals("join")) { // 회원가입
				Join();
			} else if (command.equals("login")) { // 로그인
				login();
			} else if (command.equals("logout")) { // 로그아웃
				logOut();
			} else if (command.equals("write")) { // 게시글 쓰기
				Postadd();
			} else if (command.equals("change")) { // 게시글 수정
				PostChange();
			} else if (command.equals("delete")) { // 게시글 삭제
				PostDelet();
			} else if (command.equals("list")) { // 게시글 목록
				Postlist();
			} else if (command.equals("showlist")) { // 게시물 상세보기
				Showpost();
			} else if (command.equals("showhelp")) { // 도움말 명령어
				Showhelp();
			} else if (command.equals("exit")) { // 프로그램 종료
				System.out.println("<< 게시판 프로그램을 종료합니다. >>");
				scan.close();
				System.exit(0);
				break;
			} else {
				System.out.println("일치하는 명령어가 없습니다.");
				System.out.print("명령어 - ");
			}
		}
	}

	public void Join() { // 회원가입
		System.out.println("<< 회원가입을 진행 합니다 >>");
		System.out.print("아이디를 입력하세요 : ");
		String inputID = scan.next();
		System.out.print("비밀번호를 입력하세요 : ");
		String inputPW = scan.next();
		System.out.print("이름 또는 닉네임을 입력하세요 : ");
		String inputName = scan.next();
		

		Joincont++; // 회원가입이 정상적으로 완료되면 사람 수 카운트함.
		userlist.add(new User(inputID, inputPW, inputName, Joincont)); // 회원가입을 완료 했으니 사람(유저) 객체 생성
		System.out.println(inputName + " 회원님! 회원가입이 완료되었습니다.");
		System.out.print("명령어 - " + scan.nextLine());
	}

	public void login() { // 로그인
		if (LoginState == true) {
			System.out.println("이미 로그인 상태 입니다.");
			System.out.print("명령어 - " + scan.nextLine());
		} else {
			System.out.println("<< 로그인을 진행합니다 >>");

			System.out.print("ID : ");
			String inputID2 = scan.next();
			System.out.print("password : ");
			String inputPW2 = scan.next();
			
			inputIDcheck = inputID2; // 글 게시판에 작성자를 출력하기 위해 로그인한 ID값을 작성자 출력 변수에 값을 넣음.
		
			for (int i = 0; i < userlist.size(); i++) {
				if (userlist.get(i).getID().equals(inputID2) && userlist.get(i).getPassword().equals(inputPW2)) {
					LoginState = true;
					break; // for문을 빠져나옴 // 조건이 true이면 for문을 빠져나와 끝내야 되는데 break를 걸지 않으면 조건이 true임에도 불구하고 다음 요소를 꺼내서 비교함. 
				} else { // userlist에 처음 꺼낸 요소(아이디,비밀번호)와 사용자가 입력한 아이디와 비밀번호가 일치하지 않을 때 무조건 실행됨.
					LoginState = false;
					//break; //break 절대 걸면 안됨 걸게 되면 userlist에 계속 요소를 꺼내서 비교해야 되는데 for문이 종료되면 비교를 못함.
				}
			}
			
			if(LoginState) {
				System.out.println("로그인 성공!");
				System.out.print("명령어 - " + scan.nextLine());
			} else if (Joincont == 0) { // 프로그램 실행 시 회원가입을 먼저 진행 안하고 로그인 먼저 진행할 때 회원가입된 리스트가 0이 되기 때문에 회원 리스트가 없는 상태에서 로그인을 시도하는 경우
										// ArrayList에 userlist에 null 값이 아닌 userlist에 Usercont가 값이 0일 때
				System.out.println("아이디와 비밀번호가 맞지 않습니다. 다시 로그인 해주세요");
				System.out.print("명령어 - " + scan.nextLine());
			} else {
				System.out.println("아이디와 비밀번호가 맞지 않습니다. 다시 로그인 해주세요");
				System.out.print("명령어 - " + scan.nextLine());
			}
		}
	}

	public void logOut() { // 로그아웃
		if (LoginState == false) {
			System.out.println("이미 로그아웃 상태입니다.");
			System.out.print("명령어 - " + scan.nextLine());
		} else {
			System.out.println("정상적으로 로그아웃 되었습니다.");
			LoginState = false;
			System.out.print("명령어 - " + scan.nextLine());
		}
	}

	public void Postadd() { // 게시글 추가
		if (LoginState == false) {
			System.out.println("권한이 없습니다.");
			System.out.print("명령어 - " + scan.nextLine());
		} else {
			for(int i=0; i<userlist.size(); i++) {
				User name = userlist.get(i); // userlist에 있는 요소를 차례대로 꺼내서 User객체에 대입함.
				if(name.getID().equals(inputIDcheck)) { // 로그인한 ID와 User객체에 있는 ID가 같은지 비교 
					System.out.println("<< 추가 할 게시글의 제목과 내용을 입력하세요 >>");

					System.out.print("제목 : ");
					String title = scan.next();
						
					System.out.print("내용 : ");
					String body = scan.next();
					
					Postwritecont++;                        
					articlelist.add(new Article(Postwritecont, title, body, DateTime.PostDateTime(), inputIDcheck, 0, 0));
					
					System.out.println(Postwritecont + "번째 글이 추가되었습니다.");
					System.out.print("명령어 - ");
				}
				
			}
			
		}
		
	}

	public void PostChange() { // 게시글 수정
		if (LoginState == false) {
			System.out.println("권한이 없습니다.");
			System.out.print("명령어 - " + scan.nextLine());
		} else if (Postwritecont == 0) {
			System.out.println("게시글이 존재 하지 않습니다.");
			System.out.print("명령어 - " + scan.nextLine());
		} else {
			while (true) {
				try {
					System.out.println("<< 수정할 게시글의 번호를 입력하세요 >>");
					int Postnum4 = scan.nextInt();

					Article Changefound = null;

					for (int i = 0; i < articlelist.size(); i++) {
						Article article = articlelist.get(i);
						if (article.getPostnum() == Postnum4) {
							if(article.getWritename().equals(inputIDcheck)) { // 다른 사용자가 다른 사용자의 게시물을 수정하지 못하게 함.
								Changefound = article;

								System.out.print("제목 : ");
								String title = scan.next();
								System.out.print("내용 : ");
								String body = scan.next();

								Changefound.setTitle(title);
								Changefound.setBody(body);

								System.out.println(Postnum4 + "번 게시글이 수정되었습니다.");
								System.out.print("명령어 - ");
							} else {
								System.out.println("수정할 해당 게시글의 작성자의 ID와 현재 로그인한 ID가 일치하지 않아 해당 게시글은 수정할 수 없습니다.");
								System.out.print("명령어 - " + scan.nextLine());
							}
							
						} else if(Changefound == null) {
							System.out.println(Postnum4 + "번 게시글은 존재하지 않습니다");
							System.out.print("명령어 - " + scan.nextLine());
						}
						
					break;
			}
				} catch (InputMismatchException ime) {
					System.out.println("수정할 게시글 번호(숫자)만 입력해주세요.");
					scan.next();
					continue;
				}
				
				break;
			}
		}
	}

	public void PostDelet() { // 게시글 삭제
		if (LoginState == false) {
			System.out.println("권한이 없습니다.");
			System.out.print("명령어 - " + scan.nextLine());
		} else if (Postwritecont == 0) {
			System.out.println("게시글이 존재 하지 않습니다.");
			System.out.print("명령어 - " + scan.nextLine());
		} else {
			while (true) {
				try {
					System.out.println("<< 삭제할 게시글 번호를 입력하세요 >>");
					int Postnum3 = scan.nextInt();
					Article Deletfound = null;

					for (int i = 0; i < articlelist.size(); i++) {
						Article article = articlelist.get(i);
						if (article.getPostnum() == Postnum3) {
							if (article.getWritename().equals(inputIDcheck)) { // 다른 사용자가 다른 사용자의 게시물을 삭제하지 못하게 함.
								Deletfound = article;
								articlelist.remove(Deletfound);
								System.out.println(Postnum3 + "번 게시글이 삭제되었습니다.");
								Postwritecont--;
								System.out.print("명령어 - " + scan.nextLine()); // 삭제이 완료 되면 이게 먼저 실행이 되고 break가 실행 됨. break가
																				// 실행되면서 무한루프 빠져나옴.
																				// break를 안 걸면 얘가 먼저 실행 되고 break가 없기 때문에
																				// 무한루프가 지속되면서
																				// << 삭제할 게시글 번호를 입력하세요 >> 가 계속 실행됨.
							} else {
								System.out.println("삭제할 해당 게시글의 작성자의 ID와 현재 로그인한 ID가 일치하지 않아 해당 게시글은 삭제할 수 없습니다.");
								System.out.print("명령어 - " + scan.nextLine());
							}
						} 	else if (Deletfound == null) {
							System.out.println(Postnum3 + "번 게시글은 존재하지 않습니다.");
							System.out.print("명령어 - " + scan.nextLine()); // 위 아래 설명과 동일
						}
						
					break;
			}
			
				} catch (InputMismatchException ime) {
					System.out.println("삭제할 게시글 번호(숫자)만 입력해주세요.");
					scan.next(); // 이 코드가 실행되면서 락이 걸림 즉, 삭제할 게시글 번호(숫자)만 입력해주세요. 와 삭제할 게시물 번호가 같이 실행이 되는데 이 코드
									// 때문에 무한으로 지속되지 않고 락이 걸림.
					continue; // 다른 타입이 아닌 정상적으로 계속 숫자(정수)로 입력될 때까지 무한루프 돌기 (continue문 안 써줘도 무한루프가 돌음)
					// break; // -> 숫자(정수)가 아닌 다른 타입으로 입력했을 때 무한루프를 도는게 아닌 무한루프를 종료하고 명령어로 바로 빠져나올 시
					// (즉, 이 break문은 무한루르를 빠져나옴)
				} catch (IndexOutOfBoundsException ioe) { // 얘 예외처리를 왜 해줬더라?
					System.out.print("명령어 - " + scan.nextLine());
					scan.next();
				}
				
				// while문의 무한루프 종료 시키기
				break; // 삭제이 완료되거나 숫자로 입력했지만 게시글이 존재하지 않을 때 무한루프를 빠져나옴. 명령어가 실행 되는 이유는 위의 if문의 마지막 줄
						// 명령어 코드가 실행되서..
						// 여기서 break를 안걸면 바로 위의 if문의 미자믹 줄인 print 명령어가 실행되면서 삭제할 게시글 번호를 입력하세요가 같이 실행이 됨.
			}

			// System.out.print("명령어 - " + scan.nextLine()); // -> 숫자(정수)가 아닌 다른 타입으로 입력했을 때 무한루프를 도는게 아닌 명령어로 바로 빠져나올 시
			// catch절에 break문이 실행되었을 때 무한루프가 종료되고 명령어가 바로 출력되는게 필요할 시에 사용함.
		}  
	}

	public void Postlist() { // 게시글 목록(리스트) 간략하게 출력 ( 게시글 번호, 제목, 날짜와 시간, 조회수, 좋아요, 작성자 출력 )
		if (Postwritecont == 0) {
			System.out.println("게시글이 존재 하지 않습니다.");
			System.out.print("명령어 - " + scan.nextLine());
		} else {
			System.out.println("<< 게시글 리스트 >>");
			System.out.println("번호    |   제목   |   날짜와 시간   |   조회수   |    좋아요    |    작성자");

			for (int i = 0; i < articlelist.size(); i++) {
				System.out.println(articlelist.get(i).getPostnum() + "         " + articlelist.get(i).getTitle()
						+ "     " + articlelist.get(i).getPostdate() + "   " + articlelist.get(i).getHitCount()
						+ "        " + articlelist.get(i).getLikeCount()+ "          " + userlist.get(i).getName());
			}
			System.out.print("명령어 - " + scan.nextLine());
		}
	}

	public void Showpost() { // 게시글 상세보기 (게시글 번호, 제목, 내용, 날짜와 시간, 조회수, 좋아요, 작성자)
		if (Postwritecont == 0) { // Postwritecont 이 부분을 article 또는 articlelist로 조건을 줘도 됨 == null 로 줘야됨 0이 아닌..
			System.out.println("게시글이 존재 하지 않습니다.");
			System.out.print("명령어 - " + scan.nextLine());
		} else {
			System.out.println("<< 게시글 리스트 >>");
			System.out.println("번호    |   제목   |   날짜와 시간   |   조회수   |    좋아요    |    작성자");

			for (int i = 0; i < articlelist.size(); i++) {
				System.out.println(articlelist.get(i).getPostnum() + "         " + articlelist.get(i).getTitle()
						+ "     " + articlelist.get(i).getPostdate() + "   " + articlelist.get(i).getHitCount()
						+ "        " + articlelist.get(i).getLikeCount()+ "          " + articlelist.get(i).getWritename());
			}
			
			for (;;) { // 바깥쪽
				try {
					System.out.println("<< 상세하게 볼 게시글 번호를 입력하세요 >>");
					int Postnum2 = scan.nextInt();

					Article Showfound = null;

					for (int i = 0; i < articlelist.size(); i++) { 
						Article article = articlelist.get(i);
						
						if (LoginState == false) { // 로그아웃 상태일 때 게시글의 좋아요를 누를수 있는 기능을 수행하지 못하면서 로그아웃 상태에도 전체 게시글 목록을 봐야 할 때 // 바깥쪽
							if(article.getPostnum() == Postnum2) { // 안쪽 if문
								Showfound = article;
								Showfound.IncreaseHit();
								System.out.println("번호: " + Showfound.getPostnum());
								System.out.println("제목: " + Showfound.getTitle());
								System.out.println("내용: " + Showfound.getBody());
								System.out.println("날짜와 시간: " + Showfound.getPostdate());
								System.out.println("조회수: " + Showfound.getHitCount());
								System.out.println("좋아요: " + Showfound.getLikeCount());
								System.out.println("작성자: " + Showfound.getWritename());
								System.out.print("명령어 - " + scan.nextLine()); // 로그인을 하지 않고 로그아웃 상태일 때 좋아요를 못눌러야 되니까 명령어로 탈출
							}
						} else if (article.getPostnum() == Postnum2) { // 로그인 상태일 때 // 바깥쪽 if문의 else if 문
							Showfound = article;
							Showfound.IncreaseHit();
							System.out.println("번호: " + Showfound.getPostnum());
							System.out.println("제목: " + Showfound.getTitle());
							System.out.println("내용: " + Showfound.getBody());
							System.out.println("날짜와 시간: " + Showfound.getPostdate());
							System.out.println("조회수: " + Showfound.getHitCount());
							System.out.println("좋아요: " + Showfound.getLikeCount());
							System.out.println("작성자: " + Showfound.getWritename());
							
							if(LoginState == true) { // 로그인을 해야지만 좋아요를 누를 수 있게 구현 (if문을 구지 작성 안해도 else if문 자체에서 로그인 상태이니까.. 그냥 명확하게 알아보기 쉽게 작성..)
								System.out.println(Showfound.getPostnum() + "번 게시글의 좋아요을 누르시겠습니까?");
								for (;;) { // 안쪽
									System.out.println("좋아요: Like or 돌아가기 : return");
									String likeorreturn = scan.next();
									if (likeorreturn.equals("Like")) {
										Showfound.IncreaseLike();
										System.out.println(Showfound.getPostnum() + "번 게시글의 좋아요를 눌렀습니다.");
										System.out.print("명령어 - " + scan.nextLine()); // 바깥쪽 for문의 무한루프가 종료가 안되면 얘가 먼저 실행되면서
																						// 바로 밑에 코드인 break문이 안쪽 for문의 무한루프가
																						// 죵료가 되지만 바깥족 for문의 무한루프가 되면서 << 게시글 번호를 입력하세요 >>와 print 명령어 출력이 함께 실행이 됨.
										break; // 바깥쪽 for문의 무한루프를 끝내는게 아닌 이 해당되는 안쪽 for문의 무한루프가 종료 됨.
									} else if (likeorreturn.equals("return")) {
										System.out.print("명령어 - " + scan.nextLine()); // 위와 동일
										break; // 바깥쪽 for문의 무한루프를 끝내는게 아닌 이 해당되는 안쪽 for문의 무한루프가 종료 됨.
									} else {
										System.out.println("\"Like\" or \"return\" 만 입력해주세요."); // 이 실행 문장이 끝나고 안쪽 for문으로 가서 무한루프가 돌게 됨.
										//break; //break를 걸게 되면 Like or return을 계속 입력받아야 되는데 안쪽 for문의 무한루프가 끝나버려서 계속 입력받지 못하게 됨.
										         // 무한루프가 돌면서 System.out.println("좋아요: Like or 돌아가기 : return"); 이 문장이 계속 반복이 되야되는데
										         // break를 걸면 처음 1번만 출력되고 문장이 반복적으로 실행 되지 않고 끝나버림
									}
								}
							}
						}
					}

					if (Showfound == null) {
						System.out.println(Postnum2 + "번 게시글은 존재하지 않습니다.");
						System.out.print("명령어 - " + scan.nextLine()); // 위 아래 설명과 동일
					}

					// 바깥쪽 for문의 무한루프 종료 시키기
					break; // Like or return 을 입력하거나 숫자로 입력했지만 게시글이 존재하지 않을 때 무한루프를 빠져나옴. 명령어가 실행 되는 이유는 바로
							// 위의 if문의 마지막 줄 명령어 코드가 실행되거나 안쪽 for문의 무한루프인 명령어 출력문이 실행되서..
							// 여기서 break를 안걸면 바로 위의 if문의 미자믹 줄인 print 명령어가 실행되면서 게시판 상세보기의 게시글 번호를 입력하세요.를
							// 입력하세요가 같이 실행이 됨.
							// 여기서 break를 안걸면 안쪽 for문의 무한루프인 명령어 출력문과 게시판 상세보기의 게시글 번호를 입력하세요.를 입력하세요가 같이
							// 실행이 됨.
				} catch (InputMismatchException ime) {
					System.out.println("게시글 번호(숫자)만 입력해주세요.");
					scan.next();
					continue; // 다른 타입이 아닌 정상적으로 계속 숫자(정수)로 입력될 때까지 무한루프 돌기 (continue문 안 써줘도 무한루프가 돌음)
					// break; -> 숫자(정수)가 아닌 다른 타입으로 입력했을 때 무한루프를 도는게 아닌 명령어로 바로 빠져나올 시
				}
			}

			// System.out.print("명령어 - " + scan.nextLine()); // -> 숫자(정수)가 아닌 다른 타입으로 입력했을 때 무한루프를 도는게 아닌 명령어로 바로 빠져나올 시
			// catch절에 break문이 실행되었을 때 무한루프가 종료되고 명령어가 바로 출력되는게 필요할 시에 사용함.
		} 
	}

	public void Showhelp() { // 도움말 명령어
		System.out.println("회원가입: join  로그인: login  로그아웃: logout  종료: exit");
		System.out.println("게시글 추가: write  게시글 수정: change  게시글 삭제: delete  게시글 간략출력: list  게시글 상세보기: showlist");
		System.out.println("도움말 명령어: showhelp");
		System.out.print("명령어 - " + scan.nextLine());
	}
}