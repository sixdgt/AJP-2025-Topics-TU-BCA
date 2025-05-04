package case_study_one.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import case_study_one.dao.CourseDao;
import case_study_one.dao.impl.CourseDaoImpl;
import case_study_one.model.Course;
import case_study_one.model.Admin;

public class CourseController {
	private CourseDao course_dao;
	private Course course;
	
	public CourseController() {
		this.course_dao = new CourseDaoImpl();
	}

	
	public boolean updateCourse(Map<String, String> data) {
		boolean status = false;
		course = new Course();
		Admin admin = new Admin();
		course.setCourseId(Integer.parseInt(data.get("course_id")));
		course.setCourseTitle(data.get("title"));
		course.setCourseCategory(data.get("category"));
		course.setCourseCode(data.get("code"));
		course.setCourseDesc(data.get("description"));
		course.setCourseStart(data.get("start_date"));
		course.setCourseEnd(data.get("end_date"));
		course.setCourseEnd(data.get("end_date"));
		admin.setAdminId(Integer.parseInt(data.get("admin_id")));
		course.setAdmin(admin);
		if(this.course_dao.update(course)) {
			status = true;
		}
		return status;
	}
	
	
	public boolean addCourse(Map<String, String> data) {
		boolean status = false;
		course = new Course();
		Admin admin = new Admin();
		course.setCourseId(Integer.parseInt(data.get("course_id")));
		course.setCourseTitle(data.get("title"));
		course.setCourseCategory(data.get("category"));
		course.setCourseCode(data.get("code"));
		course.setCourseDesc(data.get("description"));
		course.setCourseStart(data.get("start_date"));
		course.setCourseEnd(data.get("end_date"));
		course.setCourseEnd(data.get("end_date"));
		admin.setAdminId(Integer.parseInt(data.get("admin_id")));
		course.setAdmin(admin);
		if(this.course_dao.create(course)) {
			status = true;
		}
		return status;
	}
	
	public Map<Integer, Map<String, String>> getAllCourse(){
		ArrayList<Course> data = course_dao.select();
		Map<String, String> course_data = new HashMap<>();
		Map<Integer, Map<String, String>> all_course = new HashMap<>();
		int counter = 0;
		for(Course course: data) {
			course_data.put("course_id", course.getCourseId() + "");
			course_data.put("code", course.getCourseCode());
			course_data.put("title", course.getCourseTitle());
			course_data.put("description", course.getCourseDesc());
			course_data.put("start_date", course.getCourseStart());
			course_data.put("end_date", course.getCourseEnd());
			course_data.put("status", course.getCourseStatus() + "");
			course_data.put("category", course.getCourseCategory());
			course_data.put("admin", course.getAdmin().getAdminId() + "");
			all_course.put(counter, course_data);
			counter++;
		}
		return all_course;
	}
	
	public Map<String, String> getCourse(int id){
		course = new Course();
		course.setCourseId(id);
		course = course_dao.selectById(course);
		Map<String, String> course_data = new HashMap<>();
		course_data.put("course_id", course.getCourseId() + "");
		course_data.put("code", course.getCourseCode());
		course_data.put("title", course.getCourseTitle());
		course_data.put("description", course.getCourseDesc());
		course_data.put("start_date", course.getCourseStart());
		course_data.put("end_date", course.getCourseEnd());
		course_data.put("status", course.getCourseStatus() + "");
		course_data.put("category", course.getCourseCategory());
		course_data.put("admin", course.getAdmin().getAdminId() + "");
		return course_data;
	}
	
	public boolean removeCourse(int id) {
		boolean status = false;
		course = new Course();
		course.setCourseId(id);
		if(course_dao.delete(course)) {
			status = true;
		}
		return status;
	}
}
