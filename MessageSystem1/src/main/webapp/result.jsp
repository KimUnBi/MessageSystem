<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">

	
		<h1>설문조사 결과</h1>
		<table align="center" border='1'>
			<tr>
				<td>이름</td>
				<td>
				${param.name}
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
				${param.gender}
				</td>
			</tr>
			<tr>
				<td>좋아하는 음식</td>
				<td>
				<c:forEach items="${paramValues.food}" var="f">
				 ${f} 
				</c:forEach>
				</td>
			</tr>
		</table>
	
	
	
	
</body>
</html>