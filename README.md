
강의 원문
: https://samsungcic.udemy.com/course/software-architecture-essentials-for-business-applications/learn/lecture/25759698#overview



## Problems with Layered Arch.



UI -> Service
Service -> Repo
Repo -> DataClass
Service -> DataClass

아직 각 레이어간 dependent하고 한 방향으로 내려가도록 되어있다.
-> Data Centric Architecture



### 문제점 #1. Lack of Intent
1. 코드 파일과 폴더 구조가 개발자의 의도를 표현해주지 못함
구조 -> 개발자의 생각을 코드로 변경할 때 쓰는 것
그런데 DCA는 데이터를 중심으로 생각하게 됨 -> 데이터로부터 올라감
코드 파일과 폴더 구조가 Intent를 reflect해주지 못함 (Intent of the Business)
> 코드 파일과 폴더 구조가 개발자의 의도를 표현해주지 못함

data centric namaing approach -> 데이터 테이블 이름에 따라 파일 이름이 결정됨
프로젝트가 커지면 커질수록, usecase가 아니라 이러한 형태의 이름으로 이루어진 파일구조를 보게 될 것 -> Business 의도와 거리가 멀다!

유지보수, 버그 수정, 새로운 기능 추가 등
-> (의도치 않은 동작) 버그는 Business 의도에 따라 오게 되는데 이는 레이어 이름으로 오는게 아니다!
-> 신기능 같은 경우에도 동작 기준으로 말하게 된다.

Business intent와 구조가 끊어져있다. -> 어디서 어떤 기능하는지 다시 찾기가 어렵다!


### 문제점 #2. Leeks of Logic

비즈니스 로직을 감싸고있는(encapsulated) 서비스가
서비스 -> 레포 구조이기 때문에
래포, 데이터로 business 로직이 누출되게 됨

Lack of intent -> UI로도 누출될 수 있음!
비즈니스 로직이 변경되는 경우, 이를 모두 감싸주기 위헤
1. 누출된 곳까지(UI 등) 매우 많은 부분을 수정해주어야 함!
2. 레포까지 누출된 경우, 다른 레포, data store로 변경하는 경우 비슷한 문제가 발생할 수 있음.

Lack of intent로 business logic이 다른 레이어(repo, ui)로 새는 경향이 있음
-> Business logic을 잘 감싸줄 필요가 없어짐 (?)

