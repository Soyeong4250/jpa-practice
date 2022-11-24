# JPA Data Mapping 실습 프로젝트

### 1️⃣ Book Management

#### Data

**book2**

![image-20221123220926530](./assets/image-20221123220926530.png)

<br />

**author2**

![image-20221123213242255](./assets/image-20221123213242255.png)

**publisher2**

![image-20221123213320684](./assets/image-20221123213320684.png)

<br />

<br />

#### EndPoint

|        기능         |   API Mapping    |                              Ex                              |
| :-----------------: | :--------------: | :----------------------------------------------------------: |
| 도서 전체 목록 조회 | GET api/v1/books | http://ec2-3-35-227-194.ap-northeast-2.compute.amazonaws.com:8080/api/v1/books |
|                     |                  |                                                              |
|                     |                  |                                                              |
|                     |                  |                                                              |

<br />

<br />

---

### 2️⃣ Hospital Board

#### Data

**hospital2**

![image-20221123214546638](./assets/image-20221123214546638.png)

**review2**

![image-20221124160901793](./assets/image-20221124160901793.png)

<br />

<br />

#### EndPoint

|                기능                 |            API Mapping             |                              Ex                              |
| :---------------------------------: | :--------------------------------: | :----------------------------------------------------------: |
|    병원 전체 리스트 조회(미완성)    |        GET api/v1/hospital         | http://ec2-3-35-227-194.ap-northeast-2.compute.amazonaws.com:8080/api/v1/hospitals |
| 병원 상세정보 및 댓글 조회 (미완성) |     GET api/v1/hospitals/{id}      | http://ec2-3-35-227-194.ap-northeast-2.compute.amazonaws.com:8080/api/v1/hospitals/4 |
|              댓글 등록              | POST api/v1/hospitals/{id}/reviews | http://ec2-3-35-227-194.ap-northeast-2.compute.amazonaws.com:8080/api/v1/hospitals/4/reviews |
|           특정 댓글 조회            | GET api/v1/hospitals/reviews/{id}  | http://ec2-3-35-227-194.ap-northeast-2.compute.amazonaws.com:8080/api/v1/hospitals/reviews/2 |

