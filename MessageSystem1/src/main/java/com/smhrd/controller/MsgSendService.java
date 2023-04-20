package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.smhrd.model.DAO;
import com.smhrd.model.MessageVO;

@WebServlet("/MsgSendService")
public class MsgSendService implements Command {
	private static final long serialVersionUID = 1L;

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String send_name = request.getParameter("send_name");
		String receive_email = request.getParameter("receive_email");
		String content = request.getParameter("content");
		
		System.out.println(receive_email);
		
		MessageVO vo = new MessageVO();
		vo.setSend_name(send_name);
		vo.setReceive_email(receive_email);
		vo.setContent(content);
		
		List<MessageVO> result = new DAO().send(vo);
		
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println(result);
		out.print(new Gson().toJson(result));
		return "main";
		
		
		
	}

}
