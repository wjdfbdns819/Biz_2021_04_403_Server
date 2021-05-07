package com.callor.book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.book.model.BookDTO;
import com.callor.book.model.BookVO;
import com.callor.book.service.BookService;
import com.callor.book.service.impl.BookServiceImplV1;

// localhost:8080/book/book/~~~~로 요청을 하면
//	여기에서 처리를 하겠다
@WebServlet("/book/*")

public class BookController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private BookService bService;
	public BookController() {
		bService = new BookServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// ~~~로 되어있는 문자열을 추출하기
		// localhost:8080/book/book/input 로 요청을 하면
		// input 라는 문자열이 추출된다
		String subPath =  req.getPathInfo();
		
		// 요청에 응답하기 위한 준비
		resp.setContentType("text/html;charset= UTF-8"); // -> 한글 인코딩 세팅
		
		PrintWriter out = resp.getWriter(); // -> 데이터를 보낼 출력장치 설정
		
		if(subPath.equals("/input")) {
			
			// 첨부된 선물 꾸러미를 열어서 내용물을 확인
			String bk_isbn = req.getParameter("bk_isbn");
			String bk_title = req.getParameter("bk_title");
			String bk_price = req.getParameter("bk_price");
			
			BookVO bookVO = new BookVO();
			bookVO.setBk_isbn(bk_isbn);
			bookVO.setBk_title(bk_title);
			bookVO.setBk_price(Integer.valueOf(bk_price));
			
			// 실험하기 위한 가상의 데이터
			bookVO.setBk_ccode("C0001");
			bookVO.setBk_acode("A0001");
			bookVO.setBk_date("2019-10-01");
			
			// ORA-00001: unique constraint 오류는 같은 값의 데이터를 입력할때 뜸
					
			bService.insert(bookVO);
			
			
			out.println("받은 데이터 확인");
			out.printf("ISBN : %S", bk_isbn);
			out.printf("도서명 : %S", bk_title);
			out.printf("가격 : %S", bk_price);
			out.close();
			
			
		} else if(subPath.equals("/select")) {
			
			List<BookDTO> bookList = bService.selectAll();
		} else if(subPath.equals("/isbn")) {
			String bk_isbn = req.getParameter("bk_isbn");
			
			BookDTO bookDTO 
				= bService.findById(bk_isbn);
			
			ServletContext app = this.getServletContext();
			app.setAttribute("BOOK", bookDTO);
			
			RequestDispatcher disp
				= app.getRequestDispatcher("/WEB-INF/views/book.jsp");
			
		} else {
			out.println("반갑습니다");
			out.close();
		}
	}
}