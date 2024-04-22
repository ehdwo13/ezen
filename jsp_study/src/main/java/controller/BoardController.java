package controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import handler.PagingHandler;
import service.BoardService;
import service.BoardServiceImpl;


@WebServlet("/brd/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	private RequestDispatcher rdp;
	private BoardService bsv;
	private int isOk;
	private String destPage;
    
    public BoardController() {
    	bsv = new BoardServiceImpl();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");	
		response.setContentType("text/html; charset=UTF-8");
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		switch(path) {
			case "list" : 
				try {
					PagingVO pgvo = new PagingVO();	
					if(request.getParameter("pageNo") != null && request.getParameter("qty") != null) {
						int pageNo = Integer.parseInt(request.getParameter("pageNo"));
						int qty = Integer.parseInt(request.getParameter("qty"));
						String type = request.getParameter("type");
						String keyword = request.getParameter("keyword");
						pgvo = new PagingVO(pageNo, qty, type, keyword);	
					}
					log.info("{}",pgvo);
					List<BoardVO> list = bsv.getList(pgvo);
					log.info("{}",list);
					int totalCount = bsv.getTotal(pgvo);
					PagingHandler ph = new PagingHandler(pgvo, totalCount);
					request.setAttribute("ph", ph);
					log.info("{}",ph);
					request.setAttribute("list", list);
					destPage = "/board/list.jsp";
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "insert" :
				try {
					String title = request.getParameter("title");
					String writer = request.getParameter("writer");
					String content = request.getParameter("content");
					BoardVO bvo = new BoardVO(title, writer, content);
					int isOk = bsv.register(bvo);
					String fromPath = request.getParameter("from");
					if(isOk > 0) {
						if(Objects.equals(fromPath, "my")) {
							destPage = "myList";
						}else {
							destPage = "list";
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "detail" :
				try {
					int bno = Integer.parseInt(request.getParameter("bno"));
					BoardVO bvo = bsv.detail(bno);
					request.setAttribute("bvo", bvo);
					destPage = "/board/detail.jsp";
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "modify" :
				try {
					int bno = Integer.parseInt(request.getParameter("bno"));
					BoardVO bvo = bsv.detail(bno);
					request.setAttribute("bvo", bvo);
					destPage = "/board/"+path+".jsp";
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "update" :
				try {
					int bno = Integer.parseInt(request.getParameter("bno"));
					String title = request.getParameter("title");
					String content = request.getParameter("content");
					BoardVO bvo = new BoardVO(bno, title, content);
					int isOk = bsv.update(bvo);
					if(isOk > 0) {
						destPage = "list";
						request.setAttribute("msg_update", -1);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "remove" :
				try {
					int bno = Integer.parseInt(request.getParameter("bno"));
					int isOk = bsv.delete(bno);
					if(isOk > 0) {
							destPage = "list";
							request.setAttribute("msg_delete", -1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "myList" :
				try {
					PagingVO pgvo = new PagingVO();
					if(request.getParameter("pageNo") != null && request.getParameter("qty") != null) {
						int pageNo = Integer.parseInt(request.getParameter("pageNo"));
						int qty = Integer.parseInt(request.getParameter("qty"));
						String type = request.getParameter("type");
						String keyword = request.getParameter("keyword");
						pgvo = new PagingVO(pageNo, qty, type, keyword);	
					}
					List<BoardVO> list = bsv.getList(pgvo);
					request.setAttribute("list", list);
					BoardVO bvo = new BoardVO();
					request.setAttribute("bvo", bvo);
					destPage = "/board/myList.jsp";
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
		}
		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
}