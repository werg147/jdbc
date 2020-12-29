package com.javaex.book01;

import java.util.List;

public class BookAuthorApp {

	public static void main(String[] args) {
		
		
		AuthorDao authorDao = new AuthorDao();
		List<AuthorVo> authorList;
		
		BookDao bookDao = new BookDao();
		List<BookVo> bookList;
		
		//작가 6명 등록
		//AuthorDao, AuthorVo 이용해서 등록
		/*
		AuthorVo authorVo1 = new AuthorVo("이문열", "경북영양");
		authorDao.authorInsert(authorVo1);

		AuthorVo authorVo2 = new AuthorVo("박경리", "경상남도 통영");
		authorDao.authorInsert(authorVo2);
		
		AuthorVo authorVo3 = new AuthorVo("유시민", "17대 국회의원");
		authorDao.authorInsert(authorVo3);
		
		AuthorVo authorVo4 = new AuthorVo("기안84", "기안동 84년생");
		authorDao.authorInsert(authorVo4);
		
		AuthorVo authorVo5 = new AuthorVo("강풀", "온라인 만화가 1세대");
		authorDao.authorInsert(authorVo5);
		
		AuthorVo authorVo6 = new AuthorVo("김영하", "알쓸신잡");
		authorDao.authorInsert(authorVo6);
		*/
		//리스트
		//authorList = authorDao.getAuthorList();
		
		//(수정, 삭제, 리스트)
		//authorDao.authorDelete(4);
		
		//AuthorVo authorVo7 = new AuthorVo(1, "이문열", "경상북도 영양");
		//authorDao.authorUpdate(authorVo7);
		
		/*
		System.out.println("==========작가 리스트==========");
		for(int i=0; i<authorList.size(); i++) {
			AuthorVo vo = authorList.get(i);
			System.out.println(vo.getAuthorId() + ". " + vo.getAuthorName() + ", " + vo.getAuthorDesc());
		}
		*/
		
		//책 8권 등록
		//BookDao, BookVo 이용해서 등록
		/*
		BookVo bookVo1 = new BookVo("우리들의 일그러진 영웅", "다림", "1998-02-22", 1);
		bookDao.bookInsert(bookVo1);
		
		BookVo bookVo2 = new BookVo("삼국지", "민음사", "2002-03-01", 1);
		bookDao.bookInsert(bookVo2);
		
		BookVo bookVo3 = new BookVo("토지", "마로니에북스", "2012-08-15", 2);
		bookDao.bookInsert(bookVo3);
		
		BookVo bookVo4 = new BookVo("유시민의 글쓰기 특강", "생각의길", "2015-04-01", 3);
		bookDao.bookInsert(bookVo4);
		
		BookVo bookVo5 = new BookVo("패션왕", "중앙북스(books)", "2012-02-22", 4);
		bookDao.bookInsert(bookVo5);
		
		BookVo bookVo6 = new BookVo("순정만화", "재미주의", "2011-08-03", 5);
		bookDao.bookInsert(bookVo6);
		
		BookVo bookVo7 = new BookVo("오직두사람", "문학동네", "2017-05-04", 6);
		bookDao.bookInsert(bookVo7);
		
		BookVo bookVo8 = new BookVo("26년", "재미주의", "2012-02-04", 5);
		bookDao.bookInsert(bookVo8);
		*/
		
		//리스트
		bookList = bookDao.getBookList();
		
		//(수정, 삭제, 리스트)
		//bookDao.bookDelete(1);
		
		//BookVo bookVo9 = new BookVo(2, "마로니에Books", "2012-08-15");
		//bookDao.bookUpdate(bookVo9);
		
		/*
	    System.out.println("==========책 리스트==========");
	    for(int i=0; i<bookList.size(); i++) {
	    	BookVo vo = bookList.get(i);
	    	System.out.println(vo.getBookId() + ". " + vo.getTitle() + ", " + vo.getPubs() + ", " +
	    			           vo.getPubDate() + ", " + vo.getAuthorId());
	    }
		*/
		
		//전체 출력 (책+작가)
		//BookVo -> 책정보+작가정보
	    System.out.println("==========책+작가 리스트==========");
	    for(int i=0; i<bookList.size(); i++) {
	    	BookVo vo = bookList.get(i);
	    	System.out.println(vo.getBookId() + ". " + vo.getTitle() + ", " + vo.getPubs() + ", " +
	    			           vo.getPubDate() + ", " + vo.getAuthorId() + ", " + vo.getAuthorName() + ", " + vo.getAuthorDesc());
	    }
		

	}

}
