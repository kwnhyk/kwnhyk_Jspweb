package Lecture.Evaluation.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BoardDTO implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String content;
	private String writer;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	private Integer viewcnt;
	private Integer bno;
	private String[] files;
	private int fileCnt;
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
		 setFileCnt(files.length);
	}
	public int getFileCnt() {
		return fileCnt;
	}
	public void setFileCnt(int fileCnt) {
		this.fileCnt = fileCnt;
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
		//SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
		//return sdf.format(regdate);
		return regdate;
		
		
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Integer getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(Integer viewcnt) {
		this.viewcnt = viewcnt;
	}
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	@Override
	public String toString() {
		return "BoardDTO [title=" + title + ", content=" + content + ", writer=" + writer + ", regdate=" + regdate
				+ ", viewcnt=" + viewcnt + ", bno=" + bno + ", files=" + Arrays.toString(files) + ", fileCnt=" + fileCnt
				+ "]";
	}
	
	
	
	
}
