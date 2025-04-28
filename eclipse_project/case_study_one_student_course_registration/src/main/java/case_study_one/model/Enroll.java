package case_study_one.model;

public class Enroll {
	private int enroll_id;
	private Student student;
	private Course course;
	private String enrolled_at;
	private int enroll_status;
	
	public void setEnrollId(int enroll_id) {this.enroll_id = enroll_id;}
	public int getEnrollId() {return this.enroll_id;}
	
	public void setStudent(Student student) {this.student = student;}
	public Student getStudent() {return this.student;}
	
	public void setCourse(Course course) {this.course = course;}
	public Course getCourse() {return this.course;}
	
	public void setEnrolledAt(String enrolled_at) {this.enrolled_at = enrolled_at;}
	public String getEnrolledAt() {return this.enrolled_at;}
	
	public void setEnrollStatus(int enroll_status) {this.enroll_status = enroll_status;}
	public int getEnrollStatus() {return this.enroll_status;}
}
