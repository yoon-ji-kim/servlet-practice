<%@page import="com.douzone.guestbook.dao.GuestbookDao"%>
<%@page import="com.douzone.guestbook.vo.GuestbookVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<GuestbookVo> list = new GuestbookDao().findAll();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/guestbook01/add.jsp" method="post">
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
		</tr>
	</table>
	</form>
	<br>
		<%
			int size = list.size();
			for(GuestbookVo vo : list){
		%>
			<table width=510 border=1>
				<tr>
					<td>[<%=size-- %>]</td>
					<td><%=vo.getName() %></td>
					<td><%=vo.getRegDate() %></td>
					<td><a href="/guestbook01/deleteform.jsp?no=<%=vo.getNo()%>">삭제</a></td>
				</tr>
				<tr>
					<td colspan=4><%=vo.getMessage() %></td>
				</tr>
			</table>
		<%
			}
		%>
</body>
</html>