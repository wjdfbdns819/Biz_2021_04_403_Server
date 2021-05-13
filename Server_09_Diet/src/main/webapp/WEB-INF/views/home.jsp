<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1 {
		background-color: rgba(0, 255, 0, 0.7);
		color: white;
		padding: 1.2rem;
		text-align: center;
	}
	
	a {
		text-decoration: none; /* --> 섭취정보 등록 그어진 밑줄을 생략 */ 
	}
	
	/* 
	CSS 3 사용한 interactive 스타일 지정
	 동적(Dynamic) 스타일 지정 
	*/
	/* a tag에 마우스가 떠 있으면 */
	a:hover { 
		text-decoration: underline; /* 마우스가 올라가면 밑줄이 나타남 */
		background-color: rgba(0,0,255,0.3);
	}
}
</style>
</head>
<body>
	<h1>다이어트를 도와죠</h1>
	<%-- /diet/food/search --%>
	<a href="${pageContext.request.contextPath}/food/search">섭취정보 등록</a>

</body>
</html>