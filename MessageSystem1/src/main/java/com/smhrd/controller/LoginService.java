package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.DAO;
import com.smhrd.model.MemberVO;

@WebServlet("/LoginService")
public class LoginService implements Command {
	private static final long serialVersionUID = 1L;

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");		
		
		MemberVO vo = new MemberVO();
		vo.setEmail(email);
		vo.setPw(pw);
		
		MemberVO result = new DAO().login(vo);
		
		if(result != null) {
			request.getSession().setAttribute("member", result);
		}
		
		return "redirect:/GoMain.do";

	}

}
