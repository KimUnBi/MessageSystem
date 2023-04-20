package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.DAO;
import com.smhrd.model.MessageVO;

@WebServlet("/EmailCheckService")
public class EmailCheckService implements Command {
	private static final long serialVersionUID = 1L;

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String receive_email = request.getParameter("receive_email");

		System.out.println(receive_email);
		
		MessageVO vo = new MessageVO();
		vo.setReceive_email(receive_email);

		System.out.println(vo.getReceive_email());
		String chk = new DAO().check(vo);
		System.out.println(chk);

		PrintWriter out = response.getWriter();
		if (chk != null) {
			out.print("true");
		} else {
			out.print("false");
		}

		return null;
	}

}
