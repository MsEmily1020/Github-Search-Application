# 💻 Github-Search-Application
2023 안드로이드 <깃허브 서치 프로젝트>

## ⌚ Project execution period
  - 2023.06.14 ~ 2023.06.16

## 🛠 Development Environment
  - Tool : `Android Studio`
  - device : `Pixel 2 API 30`

## 📃 Main Composition
  
  - 본인 깃허브 아이디 입력
  
  - User 정보 결과
    - 아이디, 이름, 생성 날짜, 공개 레파지토리 갯수, 팔로워 수, 팔로잉 수, 회사

  - Repo 정보 결과
    - Repo제목, url, star_count, watcher_count, fork_count, 언어
    
  - intent로 3개의 화면 구성 (Main, User, Repo)
  - retrofit (@GET)으로 api.github.com의 내용 받아옴
  - api.github.com의 data값들을 data class로 정의
  - userId 입력 시, 공백이 있을 경우 해당 공백 지운 후 검색
  - User 정보 불러오는 데 실패(Error.404)일경우 Toast로 메시지 띄우기

  - Repo 정보를 RecyclerView 구현하여 넣기
  
  - 각 Activity 자유 이동을 위해 front, back 기능 구현
  
## 🎞 깃허브 서치 프로젝트

https://github.com/MsEmily1020/Github-Search-Application/assets/121646949/573f402c-26b0-4a51-9e0b-b8be2d5ff04c

