package case_study_one.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import case_study_one.dao.StudentDao;
import case_study_one.dao.impl.StudentDaoImpl;
import case_study_one.model.Student;

public class StudentController {
	private StudentDao student_dao;
	private Student student;
	
	public StudentController() {
		this.student_dao = new StudentDaoImpl();
	}
	
	public boolean doLogin(String email, String password) {
		boolean status = false;
		student = new Student();
		student.setStudentEmail(email);
		student.setStudentPassword(password);
		if(this.student_dao.login(student)) {
			status = false;
		}
		return status;
	}
	
	public Map<String, String> getProfile(String email){
		student = new Student();
		student.setStudentEmail(email);
		student = student_dao.profile(student);
		Map<String, String> profile_data = new HashMap<>();
		profile_data.put("student_id", student.getStudentId() + "");
		profile_data.put("first_name", student.getStudentFirstName());
		profile_data.put("middle_name", student.getStudentMiddleName());
		profile_data.put("last_name", student.getStudentLastName());
		profile_data.put("email", student.getStudentEmail());
		profile_data.put("address", student.getAddress());
		profile_data.put("gender", student.getGender());
		profile_data.put("dob", student.getDob());
		profile_data.put("profile_img", student.getProfileImg());
		profile_data.put("is_removed", student.getIsRemoved() + "");
		profile_data.put("password", student.getStudentPassword());
		return profile_data;
	}
	
	public boolean updateProfile(Map<String, String> data) {
		boolean status = false;
		student = new Student();
		student.setStudentId(Integer.parseInt(data.get("student_id")));
		student.setStudentFirstName(data.get("student_first_name"));
		student.setStudentMiddleName(data.get("student_middle_name"));;
		student.setStudentLastName(data.get("student_last_name"));
		student.setAddress(data.get("address"));
		student.setProfileImg(data.get("profile_img"));
		student.setGender(data.get("gender"));
		student.setDob(data.get("dob"));
		student.setStudentEmail(data.get("student_email"));
		student.setStudentPassword(data.get("student_password"));
		student.setIsRemoved(Integer.parseInt(data.get("is_removed")));
		if(this.student_dao.update(student)) {
			status = true;
		}
		return status;
	}
	
	public boolean changestudentPassword(Map<String, String> data) {
		boolean status = false;
		student = new Student();
		student.setStudentId(Integer.parseInt(data.get("student_id")));
		student.setStudentEmail(data.get("email"));
		student.setStudentPassword(data.get("password"));
		if(this.student_dao.changePassword(student)) {
			status = true;
		}
		return status;
	}
	
	public boolean addStudent(Map<String, String> data) {
		boolean status = false;
		student = new Student();
		student.setStudentId(Integer.parseInt(data.get("student_id")));
		student.setStudentFirstName(data.get("student_first_name"));
		student.setStudentMiddleName(data.get("student_middle_name"));;
		student.setStudentLastName(data.get("student_last_name"));
		student.setAddress(data.get("address"));
		student.setProfileImg(data.get("profile_img"));
		student.setGender(data.get("gender"));
		student.setDob(data.get("dob"));
		student.setStudentEmail(data.get("student_email"));
		student.setStudentPassword(data.get("student_password"));
		student.setIsRemoved(Integer.parseInt(data.get("is_removed")));
		if(this.student_dao.create(student)) {
			status = true;
		}
		return status;
	}
	
	public Map<Integer, Map<String, String>> getAllStudent(){
		ArrayList<Student> data = student_dao.select();
		Map<String, String> student_data = new HashMap<>();
		Map<Integer, Map<String, String>> all_student = new HashMap<>();
		int counter = 0;
		for(Student student: data) {
			student_data.put("student_id", student.getStudentId() + "");
			student_data.put("first_name", student.getStudentFirstName());
			student_data.put("middle_name", student.getStudentMiddleName());
			student_data.put("last_name", student.getStudentLastName());
			student_data.put("email", student.getStudentEmail());
			student_data.put("address", student.getAddress());
			student_data.put("gender", student.getGender());
			student_data.put("dob", student.getDob());
			student_data.put("profile_img", student.getProfileImg());
			student_data.put("is_removed", student.getIsRemoved() + "");
			student_data.put("password", student.getStudentPassword());
			all_student.put(counter, student_data);
			counter++;
		}
		return all_student;
	}
	
	public Map<String, String> getStudent(int id){
		student = new Student();
		student.setStudentId(id);
		student = student_dao.selectById(student);
		Map<String, String> data = new HashMap<>();
		data.put("student_id", student.getStudentId() + "");
		data.put("first_name", student.getStudentFirstName());
		data.put("middle_name", student.getStudentMiddleName());
		data.put("last_name", student.getStudentLastName());
		data.put("email", student.getStudentEmail());
		data.put("address", student.getAddress());
		data.put("gender", student.getGender());
		data.put("dob", student.getDob());
		data.put("profile_img", student.getProfileImg());
		data.put("is_removed", student.getIsRemoved() + "");
		data.put("password", student.getStudentPassword());
		return data;
	}
	
	public boolean removeStudent(int id) {
		boolean status = false;
		student = new Student();
		student.setStudentId(id);
		if(student_dao.delete(student)) {
			status = true;
		}
		return status;
	}
}
