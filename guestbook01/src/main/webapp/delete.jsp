<%@page import="com.douzone.guestbook.dao.GuestbookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
	int no =Integer.parseInt(request.getParameter("no"));
	String password = request.getParameter("password");
	String result = new GuestbookDao().findPasswordByno(no);
	if(password.equals(result)){
		new GuestbookDao().deleteByNoAndPassword(no, password);
	}
		response.sendRedirect(request.getContextPath());
%>