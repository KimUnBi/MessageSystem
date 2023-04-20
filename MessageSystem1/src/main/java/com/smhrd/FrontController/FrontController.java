package com.smhrd.FrontController;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.controller.Command;
import com.smhrd.controller.EmailCheckService;
import com.smhrd.controller.JoinService;
import com.smhrd.controller.LoginService;
import com.smhrd.controller.MsgSendService;
import com.smhrd.controller.SelectService;
import com.smhrd.controller.UpdateService;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Command> map = null;

	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String, Command>();
		map.put("Login.do", new LoginService());
		map.put("Update.do", new UpdateService());
		map.put("Join.do", new JoinService());
		map.put("SelectAll.do", new SelectService());
		map.put("EmailCheck.do", new EmailCheckService());
		map.put("MsgSend.do", new MsgSendService());

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// uri 가져오기
		String uri = request.getRequestURI();
		// 경로 가져오기
		String path = request.getContextPath();
		// uri에서 경로 자르기
		String finaluri = uri.substring(path.length() + 1);

		Command con = null;
		String finalpath = null;
		// Go가 붙었을 때 페이지 이동하게끔 하는 로직                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
		if (finaluri.substring(0, 2).equals("Go")) {
			finalpath = finaluri.substring(2).replaceAll(".do", "").toLowerCase();
		} else {
			con = map.get(finaluri);
			finalpath = con.execute(request, response);
		}
		if (finalpath == null) {
			//ajax 요청 처리하는 로직
		} else if (finalpath.contains("redirect:/")) {
			// --> .do로 다시 요청 들어온다면? 여기서 로직 처리 다시!
			// --> 전체적으로 servlet을 거쳐서만 jsp파일로 넘어갈 수 있음
			response.sendRedirect(finalpath.substring(10));
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/" + finalpath + ".jsp");
			rd.forward(request, response);
		}

	}

}
