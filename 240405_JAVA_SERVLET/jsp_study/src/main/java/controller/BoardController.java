package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import handler.FileRemoveHandler;
import handler.PagingHandler;
import net.coobird.thumbnailator.Thumbnails;
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
	private String savePath;
    
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
					savePath = getServletContext().getRealPath("/_fileUpload");
					File fileDir = new File(savePath);
					DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
					fileItemFactory.setRepository(fileDir);		
					fileItemFactory.setSizeThreshold(1024*1024*3); 
					BoardVO bvo = new BoardVO();
					ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
					List<FileItem> itemList = fileUpload.parseRequest(request);
					for(FileItem item : itemList) {
						switch(item.getFieldName()) {
						case "title" :
							String title = item.getString("utf-8");
							bvo.setTitle(title);
							break;
						case "writer" :
							bvo.setWriter(item.getString("utf-8"));					
							break;
						case "content" :
							bvo.setContent(item.getString("utf-8"));
							break;
						case "imageFile" :
							if(item.getSize() > 0) {
								String fileName = item.getName().substring(item.getName().lastIndexOf(File.separator)+1);
								fileName = System.currentTimeMillis()+"_"+fileName;
								File uploadFilePath = new File(fileDir+File.separator+fileName);
								log.info("uploadFilePath > {}",uploadFilePath);
								try {
									item.write(uploadFilePath);
									bvo.setImageFile(fileName);	
									Thumbnails.of(uploadFilePath).size(75, 75).toFile(new File(fileDir+File.separator+"_th_"+fileName));
								} catch (Exception e) {
									log.info("file writer on disk error");
									e.printStackTrace();
								}
							}
							log.info("{}",bvo);
							int isOk = bsv.register(bvo);
							log.info("insert " +(isOk>0?"성공":"실패")+ isOk);
							destPage ="/main.jsp";
							break;
				}
					}
				}catch (Exception e) {
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
				savePath = getServletContext().getRealPath("/_fileUpload");
				File fileDir = new File(savePath);
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				fileItemFactory.setRepository(fileDir);
				fileItemFactory.setSizeThreshold(1024*1024*3);
				BoardVO bvo = new BoardVO();
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
				List<FileItem> itemList = fileUpload.parseRequest(request);
				String old_file = null;
				for(FileItem item : itemList) {
					switch(item.getFieldName()) {
					case "bno" : 
						bvo.setBno(Integer.parseInt(item.getString("utf-8")));
						break;
					case "title" :
						bvo.setTitle(item.getString("utf-8"));
						break;
					case "content" :
						bvo.setContent(item.getString("utf-8"));
						break;
					case "imageFile" :
						old_file = item.getString("utf-8");
						break;
					case "newFile" :
						if(item.getSize() > 0) {
							if(old_file != null) {
								FileRemoveHandler fileHandler = new FileRemoveHandler();
								isOk = fileHandler.deleteFile(path, old_file);
							}
							String fileName = item.getName().substring(item.getName().lastIndexOf(File.separator)+1);
							log.info("new File Name > {}",fileName);
							fileName = System.currentTimeMillis()+"_"+fileName;
							File uploadFilePath = new File(fileDir+File.separator+fileName);
							try {
								item.write(uploadFilePath);
								bvo.setImageFile(fileName);
								Thumbnails.of(uploadFilePath).size(75, 75).toFile(new File(fileDir+File.separator+"_th_"+fileName));
								} catch (Exception e) {
									log.info("File Writer update error");
									e.printStackTrace();
							}
						}else {
							bvo.setImageFile(old_file);
						}
						break;
					}
				}
				int isOk = bsv.update(bvo);
				log.info("insert " +(isOk>0?"성공":"실패")+ isOk);
				destPage ="list";
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "remove" :
				try {
					savePath = getServletContext().getRealPath("/_fileUpload");
					int bno = Integer.parseInt(request.getParameter("bno"));
					String fileName = bsv.getFilePath(bno);
					if(fileName != null) {
						FileRemoveHandler fileHandler = new FileRemoveHandler();
						fileHandler.deleteFile(savePath, fileName);
					}
					int isDel = bsv.removeComment(bno);
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