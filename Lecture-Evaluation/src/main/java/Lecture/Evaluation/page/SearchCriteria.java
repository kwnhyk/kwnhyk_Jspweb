package Lecture.Evaluation.page;

public class SearchCriteria extends Criteria {
	private String searchType ="";
	private String search = "";
	private String lectureDivide ="";
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	public String getLectureDivide() {
		return lectureDivide;
	}
	public void setLectureDivide(String lectureDivide) {
		this.lectureDivide = lectureDivide;
	}
	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", search=" + search + ", lectureDivide=" + lectureDivide
				+ "]";
	}
	
	
}
