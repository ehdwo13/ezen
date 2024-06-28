package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ProductVO;
import service.ProductService;
import service.ProductServiceImpl;

@WebServlet("/pro/*")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	private RequestDispatcher rdp;
	private ProductService psv;
	private int isOk;
	private String destPage;
       
    public ProductController() {
        psv = new ProductServiceImpl();
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		switch(path) {
			case "main" :
				destPage = "/product/main.jsp";
				break;
			case "add" :
				destPage = "/product/register.jsp";
				break;
			case "insert" :
				try {
					String category = request.getParameter("category");
					String name = request.getParameter("name");
					int price = Integer.parseInt(request.getParameter("price"));
					int total_amount = Integer.parseInt(request.getParameter("total_amount"));
					ProductVO pvo = new ProductVO(category, name, price, total_amount);
					int isOk = psv.register(pvo);
					if(isOk > 0) { 
						destPage = "/product/main.jsp";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "list" :
				try {
					List<ProductVO> list = psv.getList();
					request.setAttribute("list", list);
					destPage = "/product/list.jsp";
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "detail" :
				try {
					int pnum = Integer.parseInt(request.getParameter("pnum"));
					ProductVO pvo = psv.detail(pnum);
					request.setAttribute("pvo", pvo);
					destPage = "/product/detail.jsp";
				} catch (Exception e) {
					e.printStackTrace();
				}
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
