package Lecture.Evaluation.page;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	   private int totalCount;
	    private int startPage;
	    private int endPage;
	   
		private boolean prev;
	    
		private boolean next;

	    private int displayPageNum = 5;

	    private Criteria criteria;
	   
	    
	    public boolean isPrev() {
			return prev;
		}

		public void setPrev(boolean prev) {
			this.prev = prev;
		}

		public boolean isNext() {
			return next;
		}

		public void setNext(boolean next) {
			this.next = next;
		}

		public void setCriteria(Criteria criteria) {
	        this.criteria = criteria;
	    }

	    public void setTotalCount(int totalCount) {
	        this.totalCount = totalCount;
	        calcData();
	    }
	    
	    public int getStartPage() {
			return startPage;
		}

		public void setStartPage(int startPage) {
			this.startPage = startPage;
		}

		public int getEndPage() {
			return endPage;
		}

		public void setEndPage(int endPage) {
			this.endPage = endPage;
		}

		public int getDisplayPageNum() {
			return displayPageNum;
		}

		public void setDisplayPageNum(int displayPageNum) {
			this.displayPageNum = displayPageNum;
		}

		public int getTotalCount() {
			return totalCount;
		}
		
		public Criteria getCriteria() {
			return criteria;
		}

		private void calcData() {

	        endPage = (int) (Math.ceil(criteria.getPage() / (double) displayPageNum) * displayPageNum);

	        startPage = (endPage - displayPageNum) + 1;

	        int tempEndPage = (int) (Math.ceil(totalCount / (double) criteria.getPerPageNum()));

	        if (endPage > tempEndPage) {
	            endPage = tempEndPage;
	        }
	        prev = startPage ==1 ? false:true ;

	        next = endPage * criteria.getPerPageNum() >= totalCount ? false : true;
	       
	    }

	    public String makeQuery(int page) {
	        UriComponents uriComponents = UriComponentsBuilder.newInstance()
	                .queryParam("page", page)
	                .queryParam("perPageNum", criteria.getPerPageNum())
	              
	                .build();

	        return uriComponents.toUriString();
	    }

	    public String makeSearch(int page) {
	        UriComponents uriComponents = UriComponentsBuilder.newInstance()
	                .queryParam("page", page)
	                .queryParam("perPageNum", criteria.getPerPageNum())
	                .queryParam("searchType",((SearchCriteria) criteria).getSearchType())
	                .queryParam("search",encoding(((SearchCriteria) criteria).getSearch()))
	                .build();

	        return uriComponents.toUriString();
	    }
	    private String encoding(String search) {
	    	
	    	if(search==null || search.trim().length()==0) {
	    		return"";
	    	}
	    	try {
	    		return URLEncoder.encode(search,"UTF-8");
	    		
	    	}catch(UnsupportedEncodingException e) {
	    		return "";
	    	}
	    }
	}

