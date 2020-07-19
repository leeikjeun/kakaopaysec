# kakaopaysec


## 목차
 - [개발 프레임워크](#개발-프레임워크-및-데이터베이스)
 - [빌드 및 실행방법](#빌드-및-실행방법)
 - [문제해결 방법](#문제해결-방법)
 
## 개발 프레임워크 및 데이터베이스
 - 스프링 부트
 - mybatis
 - lombok
 - h2 db
 
## 빌드 및 실행-방법
 - git clone(https://github.com/leeikjeun/kakaopaysec.git)
 - gradle build
 - TestApplication실행
     
##문제해결 방법

### 1. 2018,2019년도별 합계 금액이 가장 많은 고객 추출
 - requset
 ```
 http:localhost:8080/solution1
 ```
 
 - response
 ```json[
          {
              "year": "2018",
              "name": "테드",
              "acctNo": "11111114",
              "sumAmt": 28992000
          },
          {
              "year": "2019",
              "name": "에이스",
              "acctNo": "11111112",
              "sumAmt": 40998400
          }
      ]
 ```

