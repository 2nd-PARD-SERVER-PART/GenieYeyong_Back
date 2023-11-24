# GenieYeyong_Back

<div align="center"> 
 <img src="./yong.png"> <br/> <br/>
  🙏🏽새해 맞이 학부 별 다짐을 적는 웹 페이지🙏🏽
</div>

---

### 기술 스택
  <div style={display:flex}>
    <img src="https://img.shields.io/badge/Springboot-6DB33F?style=for-the-badge&logo=html5&logoColor=white">
    <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
    <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
  </div>

---

### API 명세서: [바로가기](https://young-stallion-a88.notion.site/7da8fcb063114c4081d21d333b400bad?pvs=4)

--- 

### 🧾 board
<details>
<summary>wish</summary>
<div markdown="1">

```
nickname text
contents varchar(255)
type varchar(255)
password varchar(255)
```
</div>
</details>

---

### ⭐️ 주요기능
<details>
<summary> 1. 다짐하기 : /wish2024/wishWrite</summary>
<div markdown="2">

#### RequestBody
  
```
{
  "nickname": "string",
  "contents": "string",
  "type": "string",
  "password": "string"
}
```
다짐을 적는 페이지입니다.<br/>
nickname: 원하는 닉네임으로 올리기<br/>
contents: 원하는 다짐을 적기
type: 해당 학부 선택
password: 해당 다짐에 부여하는 나만의 비밀번호


#### ResponseBody
```
{
  "result": true,
  "message": "string",
  "data": {
    "id": int,
    "nickname": "string",
    "contents": "string",
    "type": "string",
    "password": "string"
  },
  "total": 0
}

// create 페이지에서는 total = 0
```


</div>
</details>

<details>
<summary>2. 다짐 둘러보기: /wish2024/findAll</summary>
<div markdown="3">
  
#### ResponseBody
```
{
  "result": boolean,
  "message": "string",
  "data": [
    {
      "id": int,
      "nickname": "string",
      "contents": "string",
      "type": "string",
      "password": "string"
    }
  ],
  "total": int
}
```

</div>
</details>

<details>
<summary>3. 학부별 다짐 둘러보기: /wish2024/findTypeWish/{type}</summary>
<div markdown="4">


#### PathVariable
```
type: String

//학부 이름
```

#### ResponseBody
```
{
  "result": boolean,
  "message": "string",
  "data": [
    {
      "id": int,
      "nickname": "string",
      "contents": "string",
      "type": "string",
      "password": "string"
    }
  ],
  "total": int
}
```

</div>
</details>

<details>
<summary>4. 다짐 지우기: /wish2024/deleteWish/{id}</summary>
<div markdown="5">

#### PathVariable
```
id: int
```
#### RequestBody
```
{
  "password": "string"
}
```
#### ResponseBody
```
{
  "result": true,
  "message": "string",
  "data": {},
  "total": 0
}
```

</div>
</details>

