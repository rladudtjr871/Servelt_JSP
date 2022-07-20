<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			
			<h2>Ajax</h2>
			
			<h3>기존 방식</h3>
			<div>
				<input type="text" id="txt1" value="${cnt}">
				<input type="button" value="확인" id="btn1"
				onclick="location.href='/toy/ajax/ex02data.do';">			
			</div>
			<div>
				<input type="text">
			</div>
			
			
			<h3>Ajax 방식</h3>
			<div>
				<input type="text" id="txt2">
				<input type="button" value="확인" id="btn2"
				onclick="test();">			
			</div>
			<div>
				<input type="text">
			</div>
			
			
			<h3>Ajax 방식</h3>
			<div>				
				<input type="button" value="확인" id="btn3"
				onclick="test2();">
				<span id="txt3"></span>			
			</div>
			<div>
				<input type="text">
			</div>
			
			
		</section>
	</main>
	
	<script>
	
		let ajax;
				
	
		function test() {
			
			//Ajax 통신을 지원하는 자바스크립트 객체
			ajax = new XMLHttpRequest();
			
			
			if (ajax != null) {
				
				ajax.onreadystatechange = m1;
				ajax.open('GET', '/toy/ajax/ex02data2.do'); //<form method action>
				ajax.send(); //<input type="submit">
				
			} else {
				alert('접속한 브라우저가 XMLHttpRequest를 지원하지 않습니다.');	
			}
			
			
		}
	
		
		function m1() {

			if (ajax.readyState == 4 && ajax.status == 200) {
				
				//서버에게 요청한 뒤 돌려받은 데이터
				//alert(ajax.responseText);
				$('#txt2').val(ajax.responseText);
								
			}
			
		}
		
		
		function test2() {
			
			ajax = new XMLHttpRequest();
						
			ajax.onreadystatechange = m2;
			
			//ajax.open('GET', '/toy/data.txt');
			//ajax.open('GET', '/toy/data.xml');
			//ajax.open('GET', '/toy/data.json');
			//ajax.open('GET', '/toy/data.do');
			
			ajax.open('GET', '/toy/data.txt');
			
			
			ajax.send(); //통신 요청
												
		}
		
		
		function m2() {
			
			console.log('ajax.readyState', ajax.readyState);
			console.log('ajax.status', ajax.status);
			
			//데이터를 취해야하는 시점      / 올바르게 데이터를 가져왔는지 에러가 안 났는지 확인
			if (ajax.readyState == 4 && ajax.status == 200) {
				
				console.log(ajax.responseText);
				
				//ajax.responseText > 단일 데이터
				//ajax.responseXML  > 다중 데이터
				
				$('#txt3').text(ajax.responseText);
				
			}
			
			console.log('');
			
		}
		
		
		
	</script>

</body>
</html>







