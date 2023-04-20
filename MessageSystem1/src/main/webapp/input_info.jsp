<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="result.jsp" align="center">
		<h1 >설문조사 시스템</h1>
		<table align="center" border='1'>
			<tr>
				<td>이름</td>
				<td>
					<input type = "text" name = "name">
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type = "radio" name = "gender" value="여자"> 여자
					<input type = "radio" name = "gender" value="남자"> 남자
				</td>
			</tr>
			<tr>
				<td>좋아하는 음식</td>
				<td>
					<input type = "checkbox" name = "food" value="햄버거">햄버거
					<input type = "checkbox" name = "food" value="피자">피자
					<input type = "checkbox" name = "food" value="치킨">치킨
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type = "submit" value ="전송">
				</td>
			</tr>
		
		</table>
	</form>
</body>
</html>