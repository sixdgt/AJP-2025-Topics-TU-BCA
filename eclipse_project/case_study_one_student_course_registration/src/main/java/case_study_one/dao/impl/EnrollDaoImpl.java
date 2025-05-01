package case_study_one.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import case_study_one.dao.EnrollDao;
import case_study_one.dbconfig.DbConnection;
import case_study_one.model.Course;
import case_study_one.model.Enroll;
import case_study_one.model.Student;

public class EnrollDaoImpl implements EnrollDao{
	@Override
	public boolean update(Enroll enroll) {
		boolean status = false;
		try {
			String query = "UPDATE enroll set student_id=?, course_id=?, enrolled_at=?"
					+ ", enroll_status=? WHERE enroll_id=?";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setInt(1, enroll.getStudent().getStudentId());
		    stmt.setInt(2, enroll.getCourse().getCourseId());
		    stmt.setString(3, enroll.getEnrolledAt());
		    stmt.setInt(4, enroll.getEnrollStatus());
		    stmt.setInt(5, enroll.getEnrollId());
			if(stmt.executeUpdate() > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean create(Enroll enroll) {
		boolean status = false;
		try {
			String query = "INSERT INTO enroll (`student_id`, `course_id`, `enrolled_at`, `enroll_status`) VALUES(?, ?, ?, ?)";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setInt(1, enroll.getStudent().getStudentId());
	        stmt.setInt(2, enroll.getCourse().getCourseId());
	        stmt.setString(3, enroll.getEnrolledAt());
	        stmt.setInt(4, enroll.getEnrollStatus());
			if(stmt.executeUpdate() > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<Enroll> select() {
		ArrayList<Enroll> data = new ArrayList<Enroll>();
		try {
			String query = "SELECT * FROM enroll INNER JOIN course ON course.course_id=enroll.course_id "
					+ "INNER JOIN student ON student.student_id=enroll.student_id";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Enroll enroll = new Enroll();
				Course course = new Course();
				Student student = new Student();
				student.setStudentId(rs.getInt("student_id"));
				student.setStudentFirstName(rs.getString("student_first_name"));
				student.setStudentMiddleName(rs.getString("student_middle_name"));;
				student.setStudentLastName(rs.getString("student_last_name"));
				student.setAddress(rs.getString("address"));
				student.setProfileImg(rs.getString("profile_img"));
				student.setGender(rs.getString("gender"));
				student.setDob(rs.getString("dob"));
				student.setStudentEmail(rs.getString("student_email"));
				student.setStudentPassword(rs.getString("student_password"));
				student.setIsRemoved(rs.getInt("is_removed"));
				course.setCourseId(rs.getInt("course_id"));
				course.setCourseCode(rs.getString("course_code"));
				course.setCourseTitle(rs.getString("course_title"));;
				course.setCourseDesc(rs.getString("course_desc"));
				course.setCourseStart(rs.getString("course_start"));
				course.setCourseEnd(rs.getString("course_end"));
				course.setCourseCode(rs.getString("course_category"));
				course.setIsRemoved(rs.getInt("is_removed"));
				enroll.setStudent(student);
				enroll.setCourse(course);
				enroll.setEnrolledAt(rs.getString("enrolled_at"));
				enroll.setEnrollStatus(rs.getInt("enroll_status"));
				enroll.setEnrollId(rs.getInt("enroll_id"));
				data.add(enroll);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public Enroll selectById(Enroll enroll) {
		try {
			String query = "SELECT * FROM enroll INNER JOIN course ON course.course_id=enroll.course_id "
					+ "INNER JOIN student ON student.student_id=enroll.student_id WHERE enroll_id=?";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setInt(1, enroll.getEnrollId());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Course course = new Course();
				Student student = new Student();
				student.setStudentId(rs.getInt("student_id"));
				student.setStudentFirstName(rs.getString("student_first_name"));
				student.setStudentMiddleName(rs.getString("student_middle_name"));;
				student.setStudentLastName(rs.getString("student_last_name"));
				student.setAddress(rs.getString("address"));
				student.setProfileImg(rs.getString("profile_img"));
				student.setGender(rs.getString("gender"));
				student.setDob(rs.getString("dob"));
				student.setStudentEmail(rs.getString("student_email"));
				student.setStudentPassword(rs.getString("student_password"));
				student.setIsRemoved(rs.getInt("is_removed"));
				course.setCourseId(rs.getInt("course_id"));
				course.setCourseCode(rs.getString("course_code"));
				course.setCourseTitle(rs.getString("course_title"));;
				course.setCourseDesc(rs.getString("course_desc"));
				course.setCourseStart(rs.getString("course_start"));
				course.setCourseEnd(rs.getString("course_end"));
				course.setCourseCode(rs.getString("course_category"));
				course.setIsRemoved(rs.getInt("is_removed"));
				enroll.setStudent(student);
				enroll.setCourse(course);
				enroll.setEnrolledAt(rs.getString("enrolled_at"));
				enroll.setEnrollStatus(rs.getInt("enroll_status"));
				enroll.setEnrollId(rs.getInt("enroll_id"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enroll;
	}

	@Override
	public boolean delete(Enroll enroll) {
		boolean status = false;
		try {
			String query = "DELETE FROM enroll WHERE enroll_id=?";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setInt(1, enroll.getEnrollId());
			if(stmt.executeUpdate() > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

}
