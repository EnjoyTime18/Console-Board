# :blue_book: 콘솔 게시판

## ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)

## :calendar: Project Period
> 2022.07.08 ~ 2022.07.16

## :open_book: Summary 
>
> * Java Object-Oriented Programming(OOP)에 대한 개념을 잡기 위해 진행한 연습용 개인 프로젝트 입니다.
> * 콘솔 게시판 기능 – 회원가입, 로그인, 로그아웃, 프로그램 종료 기능, 게시글 추가, 수정, 삭제, 전체 게시글 목록 출력, 게시글 상세하게 보는 기능, 도움말 명령어

## :open_book: Main Functions
> ### :memo::bookmark_tabs: 회원가입, 로그인, 게시글 쓰기, 게시글 보기
> 
> ![image19](https://github.com/EnjoyTime18/Console-Board/assets/122413012/328431e8-fb02-4191-92f5-638803e61267)
> ![image16](https://github.com/EnjoyTime18/Console-Board/assets/122413012/b593cc7d-0e7d-4a8e-a090-2635415b3fa5)
<br/><br/>
> ![image7](https://github.com/EnjoyTime18/Console-Board/assets/122413012/721e2240-215b-414e-a985-81f00d1c31d3)
> ![image12](https://github.com/EnjoyTime18/Console-Board/assets/122413012/5d61ee2b-b3d9-40a3-912a-ba7ae6b731d8)
> 
> * 무한루프를 통해 사용자로부터 명령어를 입력 받아 주요 기능들을 실행하는 로직을 구현함.
> * 프로그램 실행 시 로그인 상태여야만 이용할 수 있게 구현하여 즉, 로그인을 필요로 하는데 회원가입을 먼저 진행을 해야 되며 가입이 완료되면 ArrayList를 통해 가입된 회원의 정보가 저장되게 구현을 함. For문을 통해 userlist의 요소를 꺼내와 로그 
    인을 할 때 입력받은 ID와 비밀번호가 회원가입을 완료할 때 userlist에 저장된 ID와 비밀번호가 일치하는지 검사하는 로직을 구현함.
> * 또한, 로그인을 한 사용자가 다른 사용자의 게시글을 수정, 삭제 하지 못하게 하는 로직을 구현했습니다. 게시글을 추가하면 ArrayList를 통해 게시글이 저장됨.
> * 게시글을 볼 때 실제처럼 로그아웃 상태여도 볼 수 있고 로그아웃 상태 일 때 게시글의 좋아요를 못 수행하게 구현을 했습니다. 반대로 로그인 상태여야만 좋아요를 누를 수 있게 되며 게시글의 조회수는 상세 보기 기능을 통해서만 게시글을 볼 때 조회수 
    가 증가시키게 구현했습니다.
<br/><br/>

> ### :pencil: 게시글 수정, 삭제
>
> ![image11](https://github.com/EnjoyTime18/Console-Board/assets/122413012/0aa51b2c-8040-4798-8ea4-231b7cdc0007)
> ![image10](https://github.com/EnjoyTime18/Console-Board/assets/122413012/7412bb0b-2a41-4154-94ea-471a3d68d1db)
>
> * 게시글을 수정, 삭제하고 싶은 게시글 번호를 사용자로부터 입력을 받게하는데 articlelist의 요소를 꺼내 와 저장된 게시글 번호가 입력 받은 번호가 일치하지 않거나 존재하지 않으면 다시 입력 받게 무한루프를 사용했습니다.


