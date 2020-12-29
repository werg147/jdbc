package com.javaex.book01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.author01.AuthorVo;

public class BookDao {

	// 필드 /JDBC 드라이버 (Oracle) 로딩, Connection 얻어오기 관리
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "webdb";
	private String pw = "webdb";

	// 생성자 - 디폴트 생성자 생략

	// 메소드 gs

	// 일반메소드

	// 수정하기
	public int bookUpdate(BookVo bookVo) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;

		int count = 0;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " update author ";
			query += " set author_name = ? , ";
			query += "     author_desc = ? ";
			query += " where author_id = ? ";
			System.out.println(query);

			pstmt = conn.prepareStatement(query); // 쿼리로 만들기
			pstmt.setString(1, bookVo.getPubs());
			pstmt.setString(2, bookVo.getPubDate());
			pstmt.setInt(3, bookVo.getBookId());

			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println("[dao] " + count + " 건 수정");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

		}
		return count;
	}

	// 삭제하기
	public int bookDelete(int bookId) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;

		int count = 0;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " delete from book ";
			query += " where book_id = ? ";

			// 테스트
			System.out.println(query);

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);

			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println("[dao]" + count + "건 삭제");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

		}

		return count;
	}

	// 저장하기
	public int bookInsert(BookVo bookVo) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;

		int count = 0;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " insert into book ";
			query += " values (SEQ_BOOK_ID.nextval, ?, ?, ?, ?) ";

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, bookVo.getTitle());
			pstmt.setString(2, bookVo.getPubs());
			pstmt.setString(3, bookVo.getPubDate());
			pstmt.setInt(4, bookVo.getAuthorId());

			count = pstmt.executeUpdate();

			// 4.결과처리

			System.out.println("[dao]" + count + " 건 저장");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

		}

		return count;

	}

	// 책+작가 리스트 가져오기
	public List<BookVo> getBookList() {

		List<BookVo> bookList = new ArrayList<BookVo>();

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " select bo.book_id, ";
			query += "        bo.title, ";
			query += "        bo.pubs, ";
			query += "        to_char(bo.pub_date, 'YYYY-MM-DD') pub_date, ";
			query += "        au.author_id, ";
			query += "        au.author_name, ";
			query += "        au.author_desc ";
			query += " from book bo, author au ";
			query += " where bo.author_id = au.author_id ";

			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			// 4.결과처리
			// rs에 있는 데이터를 List<BookVo>로 구성

			while (rs.next()) {
				int bookId = rs.getInt("book_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pubDate = rs.getString("pub_date");
				int authorId = rs.getInt("author_id");
				String authorName = rs.getString("author_name");
				String authorDesc = rs.getString("author_desc");

				BookVo vo = new BookVo(bookId, title, pubs, pubDate, authorId, authorName, authorDesc);
				bookList.add(vo);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

		}

		return bookList;
	}

}
