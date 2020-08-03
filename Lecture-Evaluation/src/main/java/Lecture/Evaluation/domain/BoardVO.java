package Lecture.Evaluation.domain;

import java.util.Date;

public class BoardVO {
	
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int viewcnt;
	private int bno;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public BoardVO(String title, String content, String writer, Date regdate, int viewcnt, int bno) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.viewcnt = viewcnt;
		this.bno = bno;
	}
	@Override
	public String toString() {
		return "BoardVO [title=" + title + ", content=" + content + ", writer=" + writer + ", regdate=" + regdate
				+ ", viewcnt=" + viewcnt + ", bno=" + bno + "]";
	}
	
}
