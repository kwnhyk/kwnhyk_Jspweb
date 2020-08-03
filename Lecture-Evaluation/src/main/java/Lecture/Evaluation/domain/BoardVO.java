package Lecture.Evaluation.domain;

import java.util.Date;

public class BoardVO {
	
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Double viewcnt;
	private Integer bno;
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
	public Double getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(Double viewcnt) {
		this.viewcnt = viewcnt;
	}
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public BoardVO(String title, String content, String writer, Date regdate, Double viewcnt, Integer bno) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.viewcnt = viewcnt;
		this.bno = bno;
	}
	
}
