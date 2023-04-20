package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.DAO;
import com.smhrd.model.MemberVO;

@WebServlet("/UpdateService")
public class UpdateService implements Command {
	private static final long serialVersionUID = 1L;

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberVO vo = new MemberVO();
		vo.setPw(pw);
		vo.setAddress(address);
		vo.setTel(tel);
		String email = ((MemberVO)request.getSession().getAttribute("member")).getEmail();
		vo.setEmail(email);
		
		int cnt = new DAO().update(vo);
		
		String path = null;
		if(cnt > 0) {
			path = "redirect:/GoMain.do";
		}else {
			path = "update";
		}
		
		return path;
		
		
		
		
	}

}
