# kakaopaysec


## 목차
 - [개발 프레임워크](#개발-프레임워크-및-데이터베이스)
 - [빌드 및 실행방법](#빌드-및-실행방법)
 - [문제해결 방법](#문제해결-방법)
 
## 개발 프레임워크 및 데이터베이스
 - 스프링 부트
 - data-jdbc
 - lombok
 - h2 db
 
## 빌드 및 실행방법
 - git clone(https://github.com/leeikjeun/kakaopaysec.git)
 - gradle build
 - TestApplication실행
     
## 문제해결 방법
### 1. 2018,2019년도별 합계 금액이 가장 많은 고객 추출
 - requset
 ```
 http:localhost:8080/solution1
 ```
 
 - response
 ```json
      [
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

 - jdbcTemplate를 이용하여 사용할 년도를 입력받아 처리
 - 서비스에서 필요한 를 넣어 데이터를 뽑아 첫번째 데이터만 리턴

### 2. 2018, 2019 거래가 없는 고객을 추출하는 API 개발
 - requset
 ```
 http:localhost:8080/solution2
 ```
 
  - response
 ```json
      [
          {
              "year": "2018",
              "name": "제이",
              "acctNo": "11111111"
           },
          {
              "year": "2018",
              "name": "에이스",
              "acctNo": "11111112"
          },
          {
              "year": "2018",
              "name": "리노",
              "acctNo": "11111113"
          },
          {
              "year": "2018",
              "name": "테드",
              "acctNo": "11111114"
          },
          {
              "year": "2018",
              "name": "린",
              "acctNo": "11111116"
          },
          {
              "year": "2018",
              "name": "케빈",
              "acctNo": "11111117"
           },
           {
              "year": "2018",
              "name": "주디",
              "acctNo": "11111119"
           },
           {
              "year": "2018",
              "name": "로이",
              "acctNo": "11111120"
           },
           {
              "year": "2019",
              "name": "제이",
              "acctNo": "11111111"
           },
           {
              "year": "2019",
              "name": "에이스",
              "acctNo": "11111112"
           },
           {
              "year": "2019",
              "name": "리노",
              "acctNo": "11111113"
           },
           {
              "year": "2019",
              "name": "사라",
              "acctNo": "11111115"
           },
           {
              "year": "2019",
              "name": "린",
              "acctNo": "11111116"
           },
           {
              "year": "2019",
              "name": "케빈",
              "acctNo": "11111117"
           },
           {
              "year": "2019",
              "name": "주디",
              "acctNo": "11111119"
           },
           {
              "year": "2019",
              "name": "로이",
              "acctNo": "11111120"
           }
      ]
 ```
 - jdbcTemplate를 이용하여 사용할 년도를 입력받아 처리
 - 서비스에서 2018%,2019%를 넣어 데이터를 뽑아 데이터 리턴
 
 ### 3.연도별 관리점 별 거래금액 합계를 구하고 합계금액이 큰 순서로 출력
 - requset
 ```
 http:localhost:8080/solution3
 ```
 
 
 - response
 ```json
      [
           {
              "year": "2018",
              "dataList": [
                            {
                            "brCode": "B",
                            "brName": "분당점",
                            "sumAmt": 38500000
                            },
                            {
                            "brCode": "A",
                            "brName": "판교점",
                            "sumAmt": 20510000
                            },
                            {
                            "brCode": "C",
                            "brName": "강남점",
                            "sumAmt": 20234567
                            },
                            {
                            "brCode": "D",
                            "brName": "잠실점",
                            "sumAmt": 14000000
                            }
                            ]
           },
                            {
              "year": "2019",
              "dataList": [
                            {
                            "brCode": "A",
                            "brName": "판교점",
                            "sumAmt": 66800000
                            },
                            {
                            "brCode": "B",
                            "brName": "분당점",
                            "sumAmt": 45400000
                            },
                            {
                            "brCode": "C",
                            "brName": "강남점",
                            "sumAmt": 19500000
                            },
                            {
                            "brCode": "D",
                            "brName": "잠실점",
                            "sumAmt": 6000000
                            }
                            ]
           },
           {
              "year": "2020",
              "dataList": [
                           {
                            "brCode": "E",
                            "brName": "을지로점",
                            "sumAmt": 1000000
                            }
                            ]
              }
]
 ```
 - jdbcTemplate 이용하여 DB에 존재하는 거래내역 연도 출력
 - jdbcTemplate에서 연도를 입력받아 연도별 관리지점 합계금액 출력하도록 생성
 - 서비스에서 년도별로 데이터 포멧을 만들어서 리턴
 
### 4. 분당점과 판교점 통폐합하여 판교점으로 이관 지점명을 입력하면 해당 지점에 대한 거래금액 합계를 출력하는 API개발하시오
 - requset
 ```
 http:localhost:8080/solution4?dept_nm=판교점
 ```

 - response
 ```json
      {
            "brCode": "A",
            "brName": "판교점",
            "sumAmt": 171210000
      }
 ```
 - jdbcTemplate에서 관리점이름을 받아 리턴
 - 서비스에서 jdbcTemplate의 결과를 받아 데이터가 없으면 에러를 던지고 아닐경우 정상 데이터 세팅후 
 
 
