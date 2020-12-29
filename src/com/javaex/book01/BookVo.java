package com.javaex.book01;

public class BookVo extends AuthorVo {

	// 필드
	private int bookId;
	private String title;
	private String pubs;
	private String pubDate;
	private int authorId;

	// 생성자
	public BookVo() {
	}

	public BookVo(int bookId, String pubs, String pubDate) {
		super();
		this.bookId = bookId;
		this.pubs = pubs;
		this.pubDate = pubDate;
	}

	public BookVo(String title, String pubs, String pubDate, int authorId) {
		super();
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.authorId = authorId;
	}

	public BookVo(int bookId, String title, String pubs, String pubDate, int authorId, String authorName,
			String authorDesc) {
		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.authorId = authorId;
		super.authorName = authorName;
		super.authorDesc = authorDesc;
	}

	// 메소드 gs
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubs() {
		return pubs;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	// 메소드 일반
	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", title=" + title + ", pubs=" + pubs + ", pubDate=" + pubDate
				+ ", authorId=" + authorId + ", authorName=" + authorName + ", authorDesc=" + authorDesc + "]";
	}

}
