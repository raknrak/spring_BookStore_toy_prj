# C\\upload 사용시 주의사항

### 코드 추가
```
* <resources mapping="/upload/**" location="file:///C:/upload/" /> 을 servlet-context.xml에 추가
```
### 코드 수정
```
 book.jsp 및 books.jsp 4개의 경로 수정
 <img src="<c:url value="C:\\upload\\${book.getBookId()}.png"/>" style="width: 60%" />
-> <img src="${pageContext.request.contextPath}/upload/${book.getBookId()}.png" style="width: 60%"/>
```
