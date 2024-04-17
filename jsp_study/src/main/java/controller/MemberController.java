package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;

@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	private RequestDispatcher rdp;
	private MemberService msv;
	private int isOk;
	private String destPage;
    
    public MemberController() {
    	msv = new MemberServiceImpl();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		switch(path){
			case "join" : 
				try {
					String id = request.getParameter("id");
					String password = request.getParameter("password");
					String email = request.getParameter("email");
					int age = Integer.parseInt(request.getParameter("age"));
					MemberVO mvo = new MemberVO(id, password, email, age);
					int isOk = msv.join(mvo);
					if(isOk > 0) {
						destPage = "/index.jsp";
						request.setAttribute("msg_join", -1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			break;
			case "login" : 
				try {
					String id = request.getParameter("id");
					String password = request.getParameter("password");
					MemberVO mvo = new MemberVO(id,password);
					MemberVO mvoIn = msv.login(mvo);
					if(mvoIn != null) {
						HttpSession ses = request.getSession();
						ses.setAttribute("ses", mvoIn);
						destPage = "/main.jsp";
					}else {
						request.setAttribute("msg_loginCheck", -1);
						destPage = "/index.jsp";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "detail" :
				destPage = "/member/detail.jsp";
				break;
			case "modify" :
				try {
					String id = request.getParameter("id");
					String password = request.getParameter("password");
					String email = request.getParameter("email");
					int age = Integer.parseInt(request.getParameter("age"));
					MemberVO mvo = new MemberVO(id, password, email, age);
					int isOk = msv.modify(mvo);
					if(isOk > 0) {
						HttpSession ses = request.getSession();
						ses.setAttribute("ses", mvo);
						request.setAttribute("msg_modify", -1);
						destPage = "/index.jsp";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "logout" :
				try {
					HttpSession ses = request.getSession();
					MemberVO mvo = (MemberVO)ses.getAttribute("ses");
					int isOk = msv.lastLogin(mvo.getId());
					request.setAttribute("msg_logout", -1);
					ses.invalidate();
					destPage = "/index.jsp";
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "delete" :
				try {
					HttpSession ses = request.getSession();
					MemberVO mvo = (MemberVO)ses.getAttribute("ses");
					int isOk = msv.delete(mvo.getId());
					ses.invalidate();
					destPage = "/index.jsp";
					request.setAttribute("msg_delete", -1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
		}
		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}
}