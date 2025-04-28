package case_study_one.model;

public class Course {
	private int course_id;
	private String course_code;
	private String course_title;
	private String course_desc;
	private String course_start;
	private String course_end;
	private int course_status;
	private Admin admin;
	private String course_category;
	private int is_removed;
	
	public void setCourseId(int course_id) {this.course_id = course_id;}
	public int getCourseId() {return this.course_id;}
	
	public void setCourseCode(String course_code) {this.course_code = course_code;}
	public String getCourseCode() {return this.course_code;}
	
	public void setCourseTitle(String course_title) {this.course_title = course_title;}
	public String getCourseTitle() {return this.course_title;}
	
	public void setCourseDesc(String course_desc) {this.course_desc = course_desc;}
	public String getCourseDesc() {return this.course_desc;}
	
	public void setCourseStart(String course_start) {this.course_start = course_start;}
	public String getCourseStart() {return this.course_start;}
	
	public void setCourseEnd(String course_end) {this.course_end = course_end;}
	public String getCourseEnd() {return this.course_end;}
	
	public void setCourseStatus(int course_status) {this.course_status = course_status;}
	public int getCourseStatus() {return this.course_status;}
	
	public void setCourseCategory(String course_category) {this.course_category = course_category;}
	public String getCourseCategory() {return this.course_category;}
		
	public void setAdmin(Admin admin) {this.admin = admin;}
	public Admin getAdmin() {return this.admin;}
	
	public void setIsRemoved(int is_removed) {this.is_removed = is_removed;}
	public int getIsRemoved() {return this.is_removed;}
}
