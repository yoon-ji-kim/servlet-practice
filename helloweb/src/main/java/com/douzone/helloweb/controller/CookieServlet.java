package com.douzone.helloweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int visitCount=0;
		//쿠키 읽기
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length >0) {
			//쿠키가 있다면
			for(Cookie cookie : cookies) {
				if ("visitCount".equals(cookie.getName())) {
					visitCount = Integer.parseInt(cookie.getValue());
				}
			}
		}
		visitCount++;
		//쿠키 발급(쓰기)
		Cookie cookie = new Cookie("visitCount", String.valueOf(visitCount));
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(24 * 60 * 60);  //1day
		response.addCookie(cookie);
		
		//화면 출력
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out= response.getWriter(); //writer와 빈개행
		//body
		out.println("<h1>방문횟수: "+ visitCount+"</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
