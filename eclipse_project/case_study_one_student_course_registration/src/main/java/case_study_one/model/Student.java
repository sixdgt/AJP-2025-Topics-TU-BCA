package case_study_one.model;

public class Student {
	private int student_id;
	private String student_first_name;
	private String student_middle_name;
	private String student_last_name;
	private String address;
	private String profile_img;
	private String gender;
	private String dob;
	private String student_email;
	private String student_password;
	private Admin admin;
	private int is_removed;
	
	public void setStudentId(int student_id) {this.student_id = student_id;}
	public int getStudentId() {return this.student_id;}
	
	public void setStudentFirstName(String first_name) {this.student_first_name = first_name;}
	public String getStudentFirstName() {return this.student_first_name;}
	
	public void setStudentMiddleName(String middle_name) {this.student_middle_name = middle_name;}
	public String getStudentMiddleName() {return this.student_middle_name;}
	
	public void setStudentLastName(String last_name) {this.student_last_name = last_name;}
	public String getStudentLastName() {return this.student_last_name;}
	
	public void setAddress(String address) {this.address = address;}
	public String getAddress() {return this.address;}
	
	public void setProfileImg(String profile_img) {this.profile_img = profile_img;}
	public String getProfileImg() {return this.profile_img;}
	
	public void setGender(String gender) {this.gender = gender;}
	public String getGender() {return this.gender;}
	
	public void setDob(String dob) {this.dob = dob;}
	public String getDob() {return this.dob;}
	
	public void setStudentEmail(String email) {this.student_email = email;}
	public String getStudentEmail() {return this.student_email;}
	
	public void setStudentPassword(String password) {this.student_password = password;}
	public String getStudentPassword() {return this.student_password;}
	
	public void setAdmin(Admin admin) {this.admin = admin;}
	public Admin getAdmin() {return this.admin;}
	
	public void setIsRemoved(int is_removed) {this.is_removed = is_removed;}
	public int getIsRemoved() {return this.is_removed;}
}
