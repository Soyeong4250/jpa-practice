# JPA Data Mapping 실습 프로젝트

### 1️⃣ Book Management

#### Data

**book2**

![image-20221123220926530](./assets/image-20221123220926530.png)

<br />

**author2**

![image-20221123213242255](./assets/image-20221123213242255.png)

<br />

**publisher2**

![image-20221123213320684](./assets/image-20221123213320684.png)

<br />

<br />

#### EndPoint

|        기능         |   API Mapping    |                             EC2                              |
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

<br />

**review2**

![image-20221123223249656](./assets/image-20221123223249656.png)

<br />

<br />

#### EndPoint

|            기능            |        API Mapping        |                             EC2                              |
| :------------------------: | :-----------------------: | :----------------------------------------------------------: |
| 병원 상세정보 및 댓글 조회 | GET api/v1/hospitals/{id} | http://ec2-3-35-227-194.ap-northeast-2.compute.amazonaws.com:8080/api/v1/hospitals/4 |
|                            |                           |                                                              |
|                            |                           |                                                              |
|                            |                           |                                                              |

