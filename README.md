## C\\upload 사용시 주의사항

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
## cart.jsp에서 javascript 삭제하기 및 삭제 미작동
### 코드 추가
```
JSP 상단에 추가하기
<!DOCTYPE html>
```
### 코드 수정
```
 <a href="#" onclick="clearCart()"  class="btn btn-danger pull-left">삭제하기</a>
 <a href="#" onclick="removeFromCart('../cart/remove/${item.value.book.bookId}')"  class="badge badge-danger">삭제</a>
 
```


