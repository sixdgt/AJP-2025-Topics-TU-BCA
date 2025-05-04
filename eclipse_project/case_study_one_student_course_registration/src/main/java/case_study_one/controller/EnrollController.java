package case_study_one.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import case_study_one.dao.EnrollDao;
import case_study_one.dao.impl.EnrollDaoImpl;
import case_study_one.model.Course;
import case_study_one.model.Enroll;
import case_study_one.model.Student;

public class EnrollController {
	private EnrollDao enroll_dao;
	private Enroll enroll;
	
	public EnrollController() {
		this.enroll_dao = new EnrollDaoImpl();
	}
	
	public boolean updateEnroll(Map<String, String> data) {
		boolean status = false;
		enroll = new Enroll();
		Student student = new Student();
		Course course = new Course();
		student.setStudentId(Integer.parseInt(data.get("student_id")));
		course.setCourseId(Integer.parseInt(data.get("course_id")));
		enroll.setEnrollId(Integer.parseInt(data.get("Enroll_id")));
		enroll.setCourse(course);
		enroll.setStudent(student);
		enroll.setEnrolledAt(data.get("enroll_date"));
		enroll.setEnrollStatus(Integer.parseInt(data.get("status")));
		if(this.enroll_dao.update(enroll)) {
			status = true;
		}
		return status;
	}
	
	
	public boolean addEnroll(Map<String, String> data) {
		boolean status = false;
		enroll = new Enroll();
		Student student = new Student();
		Course course = new Course();
		student.setStudentId(Integer.parseInt(data.get("student_id")));
		course.setCourseId(Integer.parseInt(data.get("course_id")));
		enroll.setCourse(course);
		enroll.setStudent(student);
		enroll.setEnrolledAt(data.get("enroll_date"));
		if(this.enroll_dao.create(enroll)) {
			status = true;
		}
		return status;
	}
	
	public Map<Integer, Map<String, String>> getAllEnroll(){
		ArrayList<Enroll> data = enroll_dao.select();
		Map<String, String> enroll_data = new HashMap<>();
		Map<Integer, Map<String, String>> all_enroll = new HashMap<>();
		Student student = new Student();
		Course course = new Course();
		int counter = 0;
		for(Enroll Enroll: data) {
			enroll_data.put("enroll_id", Enroll.getEnrollId() + "");
			enroll_data.put("student_id", student.getStudentId() + "");
			enroll_data.put("first_name", student.getStudentFirstName());
			enroll_data.put("middle_name", student.getStudentMiddleName());
			enroll_data.put("last_name", student.getStudentLastName());
			enroll_data.put("email", student.getStudentEmail());
			enroll_data.put("address", student.getAddress());
			enroll_data.put("gender", student.getGender());
			enroll_data.put("dob", student.getDob());
			enroll_data.put("profile_img", student.getProfileImg());
			enroll_data.put("is_removed", student.getIsRemoved() + "");
			enroll_data.put("course_id", course.getCourseId() + "");
			enroll_data.put("code", course.getCourseCode());
			enroll_data.put("title", course.getCourseTitle());
			enroll_data.put("description", course.getCourseDesc());
			enroll_data.put("start_date", course.getCourseStart());
			enroll_data.put("end_date", course.getCourseEnd());
			enroll_data.put("course_status", course.getCourseStatus() + "");
			enroll_data.put("category", course.getCourseCategory());
			enroll_data.put("enroll_status", Enroll.getEnrollStatus() + "");
			enroll_data.put("enroll_date", Enroll.getEnrolledAt());
			all_enroll.put(counter, enroll_data);
			counter++;
		}
		return all_enroll;
	}
	
	public Map<String, String> getEnroll(int id){
		enroll = new Enroll();
		enroll.setEnrollId(id);
		enroll = enroll_dao.selectById(enroll);
		Student student = new Student();
		Course course = new Course();
		Map<String, String> enroll_data = new HashMap<>();
		enroll_data.put("enroll_id", enroll.getEnrollId() + "");
		enroll_data.put("student_id", student.getStudentId() + "");
		enroll_data.put("first_name", student.getStudentFirstName());
		enroll_data.put("middle_name", student.getStudentMiddleName());
		enroll_data.put("last_name", student.getStudentLastName());
		enroll_data.put("email", student.getStudentEmail());
		enroll_data.put("address", student.getAddress());
		enroll_data.put("gender", student.getGender());
		enroll_data.put("dob", student.getDob());
		enroll_data.put("profile_img", student.getProfileImg());
		enroll_data.put("is_removed", student.getIsRemoved() + "");
		enroll_data.put("course_id", course.getCourseId() + "");
		enroll_data.put("code", course.getCourseCode());
		enroll_data.put("title", course.getCourseTitle());
		enroll_data.put("description", course.getCourseDesc());
		enroll_data.put("start_date", course.getCourseStart());
		enroll_data.put("end_date", course.getCourseEnd());
		enroll_data.put("course_status", course.getCourseStatus() + "");
		enroll_data.put("category", course.getCourseCategory());
		enroll_data.put("enroll_status", enroll.getEnrollStatus() + "");
		enroll_data.put("enroll_date", enroll.getEnrolledAt());
		return enroll_data;
	}
	
	public boolean removeEnroll(int id) {
		boolean status = false;
		enroll = new Enroll();
		enroll.setEnrollId(id);
		if(enroll_dao.delete(enroll)) {
			status = true;
		}
		return status;
	}
}
