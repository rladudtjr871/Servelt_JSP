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
			
			<h2>Unregister</h2>
			
			<div>Lorem ipsum dolor sit amet, consectetur adipisicing elit. A cum reiciendis recusandae magni aspernatur incidunt suscipit eius dolore quibusdam omnis iure debitis accusantium. Incidunt hic rerum soluta eum at vitae.</div>
			
			<input type="button" value="돌아가기" class="btn btn-secondary" onclick="location.href='/toy/index.do';">
			<input type="button" value="탈퇴하기" class="btn btn-primary" onclick="location.href='/toy/member/unregisterok.do'">
			
		</section>
	</main>
	
	<script>
	
	</script>

</body>
</html>