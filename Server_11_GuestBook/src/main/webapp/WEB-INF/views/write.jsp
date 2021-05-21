<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style>
	form.v1 {
		width: 80%;
		margin: 10px auto;
	}
	
	form.v1 fieldset {
		border: 1px solid blue;
		border-radius: 10px;
		padding: 5px;	
	}
	
	/* label과 input의 공통 속성을 한번에 지정하기 */
	form.v1 label, form.v1 input, form.v1 textarea {
		display: inline-block;
		padding: 5px;
		margin: 5px;
	}
	
	form.v1 label {
		
		width: 150px;
		text-align: right;
		
	}
	
	form.v1 input, form.v1 textarea {
		
		width: 300px;
		border: 1px solid green;
		border-radius: 5px;	
	}

	form.v1 button {
		outline: 0;
		border: 0;
		width: 100px;
		color: white;
	
	}
	
	form.v1 button:nth-child(2) {
		background-color: green;
	}
	
	form.v1 button:nth-child(3) {
		background-color: red;
	}
	
	form.v1 button:nth-child(4) {
		background-color: blue;
	}
	
	form.v1 button:hover {
		box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.3);
	
	}
</style>

<script>
	// script를 본문어디에나 두기위해 document에 Event 설정
	// 화면에 모든 요소가 다 그려지면
	document.addEventListener("DOMContentLoaded",function(){
		// :D alert("start")
		document.querySelector("button.btn_save")
		.addEventListener("click",function(ev){
			
			// :D alert("click")
			
			let dom = document;
			let gb_writer = dom.querySelector("input[name='gb_writer']");
			let gb_email = dom.querySelector("input[name='gb_email']");
			let gb_password = dom.querySelector("input[name='gb_password']");
			let gb_content = dom.querySelector("textarea");
		
			
			
			if(gb_writer.value == "") {
				alert("작성자 이름은 반드시 입력해야 합니다");
				
				//dom.querySelector("input[name='gb_writer']").focus()
				gb_writer.focus();
				
				// 이벤트 코드 진행을 멈춰라
				return false; // 일반적으로 event 버블링을 멈추는 코드 
				
			}
			
			if(gb_email.value == "") {
				alert("작성자 이메일을 입력하세요");
				gb_email.focus();
				return false;
			}
			
			if(gb_password.value == "") {
				alert("비밀번호를 입력하세요");
				gb_password.focus();
				return false;
			}
			
			if(gb_content.value == "") {
				alert("내용을 입력하세요");
				gb_content.focus();
				return false;
			}
			
			alert("저장버튼"
				+ gb_writer.value + "\n"
				+ gb_email.value+ "\n"
				+ gb_password.value+ "\n"
				+ gb_content.value+ "\n"
			)
			
			// 서버로 전송하라
			dom.querySelector("form.v1").submit();
			
		})
	})
	

</script>

</head>
<body>
	<%@ include file="/WEB-INF/views/include_nav.jsp"%>
	<form class="v1" method="POST">
		<fieldset>
		<%--legend를 사용하려면 fieldset으로 반드시 감싸야한다 즉 단독으로 사용할수 없음 --%>
		<legend>방명록 쓰기</legend>
		<div>
			<label>작성일자</label>		
			<input name="gb_date" type="date" value="${GB.gb_date}">
		</div>
		
		<div>
			<label>작성시각</label>		
			<input name="gb_time" type="time" value="${GB.gb_time}">
		</div>
		
		<div>
			<label>작성자</label>		
			<input name="gb_writer" type="text" value="${GB.gb_writer}">
		</div>
		
		<div>
			<label>작성자 Email</label>		
			<input name="gb_email" type="email" value="${GB.gb_email}">
		</div>
		
		<div>
			<label>비밀번호</label>		
			<input name="gb_password" type="password">
		</div>
		
		<div>
			<label>내용</label>		
			<%-- textarea tag를 사용할때 줄바꿈이나 빈칸을 넣을경우 웹에서 의도치 않는 오류가 발생 --%>
			<textarea name="gb_content" rows="5">${GB.gb_content}</textarea> 
		</div>
		
		<div>
			<label></label>
			<%-- 
			button의 기본타입은 submit이기때문에 그냥 누르게되면 어디론가 데이터를 전송하게된다
			 그러므로 type을 button으로 변경한다
			 --%>
			<button class="btn_save" type="button">저장</button>
			<button type="reset">다시작성</button>
			<button class="btn_homm" type="button">처음으로</button>
		</div>
		</fieldset>
	</form>
</body>
</html>