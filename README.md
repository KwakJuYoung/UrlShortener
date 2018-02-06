URL 압축
=============
기능
-------------
### 1. localhost:8080 에서 URL 등록 / 삭제 /조회
 - 등록된 url은 4~8자의 url로 압축
 - 동일한 url은 중복 등록 불가 -> 이미 등록된 정보를 보여줌
### 2. localhost:8080/{압축url}
 - 압축 url에 해당하는 원본 url로 redirect
### 3. 사용기술
 - BackEnd : Java / Spring / Spring-boot / Hibernate / MySql / Rest-api
 - FrontEnd : Html / Javascript / Jquery / Css

문제 해결
-------------

### 1. 압축 알고리즘 생성
 - URL을 0-9, a-z, A-Z 로 표현하기 위해 총 62자가 필요
 - URL을 8자의 문자로 표현할 수는 없을까? x
 - DB에 저장하고 ID를 URL로 표현 한다면?
   * 숫자 ID를 62자의 문자로 변환(62진법)
   * 62^8 = 약 220조개의 URL 표현 가능.. 굳이? - (1)
 - 시작이 0, 1, 2... Y, Z, 10 으로 순차적으로 증가
   * 다음 URL을 예측할 수 있음 - (2)
 - (1), (2)의 이유로 알고리즘 분리
   * 3자리는 hash, 5자리는 id 영역
### 2. 알고리즘 수정
 - hash 영역
   * URL을 반복적으로 3자리씩 잘라서 hascode 생성
   * hash코드 생성시 & | 연산은 한값으로 수렴되기때문에 xor연산 수행
      > 1 ^ 1 = 0<br>
      > 1 ^ 0 = 1<br>
      > 0 ^ 1 = 1<br>
      > 0 ^ 0 = 0<br>
   * hash코드를 통해 동일 url찾기가 쉬워짐
   * hash코드를 통해 쿼리 조회 성능을 높일 수 있음
 - id 영역
   * 기존 62진법 활용
   * 62^5까지 표현가능 = 약 90억개까지 표현 가능

실행 방법

-------------
### 1. DB연결
   - appication.properties 에서
     * spring.datasource.url
     * spring.datasource.username
     * spring.datasource.password
   각각 수정
### 2. 구동
   - mvn spring-boot:run