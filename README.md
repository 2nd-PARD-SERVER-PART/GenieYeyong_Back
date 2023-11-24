# GenieYeyong_Back
## API 명세서 - [Swagger Page](http://172.18.140.44:8080/)
### 1. 다짐하기
#### RequestBody
  
```
{
  "nickname": "string",
  "contents": "string",
  "type": "string",
  "password": "string"
}
```

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


### 2. 다짐 둘러보기
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

### 3. 학부별 다짐 둘러보기
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
### 4. 다짐 지우기
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
