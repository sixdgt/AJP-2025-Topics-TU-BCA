package case_study_one.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import case_study_one.dao.CourseDao;
import case_study_one.dbconfig.DbConnection;
import case_study_one.model.Admin;
import case_study_one.model.Course;

public class CourseDaoImpl implements CourseDao{
	DbConnection db;
	@Override
	public boolean update(Course course) {
		boolean status = false;
		try {
			db = DbConnection.getInstance();
			String query = "UPDATE course set course_code=?, course_title=?, course_desc=?"
					+ ", course_start=?, course_end=?, admin_id=?, course_category=? WHERE course_id=?";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setString(0, course.getCourseCode());
			stmt.setString(1, course.getCourseTitle());
			stmt.setString(2, course.getCourseDesc());
			stmt.setString(3, course.getCourseStart());
			stmt.setString(4, course.getCourseEnd());
			stmt.setInt(5, course.getAdmin().getAdminId());
			stmt.setString(6, course.getCourseCategory());
			stmt.setInt(7, course.getCourseId());
			if(stmt.executeUpdate() > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean create(Course course) {
		boolean status = false;
		try {
			db = DbConnection.getInstance();
			String query = "INSERT INTO course (`course_code`, `course_title`, `course_desc`, `course_start`,"
					+ " `course_end`, `admin_id`, `course_category`) VALUES(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setString(0, course.getCourseCode());
			stmt.setString(1, course.getCourseTitle());
			stmt.setString(2, course.getCourseDesc());
			stmt.setString(3, course.getCourseStart());
			stmt.setString(4, course.getCourseEnd());
			stmt.setInt(5, course.getAdmin().getAdminId());
			stmt.setString(6, course.getCourseCategory());
			if(stmt.executeUpdate() > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<Course> select() {
		ArrayList<Course> data = new ArrayList<Course>();
		try {
			db = DbConnection.getInstance();
			String query = "SELECT * FROM course INNER JOIN admin ON admin.admin_id=course.admin_id";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Course course = new Course();
				Admin admin = new Admin();
				admin.setAdminId(rs.getInt("admin_id"));
				admin.setAdminFullName(rs.getString("admin_full_name"));
				admin.setAdminEmail(rs.getString("admin_email"));
				course.setCourseId(rs.getInt("course_id"));
				course.setCourseCode(rs.getString("course_code"));
				course.setCourseTitle(rs.getString("course_title"));;
				course.setCourseDesc(rs.getString("course_desc"));
				course.setCourseStart(rs.getString("course_start"));
				course.setCourseEnd(rs.getString("course_end"));
				course.setAdmin(admin);
				course.setCourseCode(rs.getString("course_category"));
				course.setIsRemoved(rs.getInt("is_removed"));
				data.add(course);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public Course selectById(Course course) {
		try {
			db = DbConnection.getInstance();
			String query = "SELECT * FROM course INNER JOIN admin ON admin.admin_id=course.admin_id WHERE course_id=?";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setInt(0, course.getCourseId());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Admin admin = new Admin();
				admin.setAdminId(rs.getInt("admin_id"));
				admin.setAdminFullName(rs.getString("admin_full_name"));
				admin.setAdminEmail(rs.getString("admin_email"));
				course.setCourseId(rs.getInt("course_id"));
				course.setCourseCode(rs.getString("course_code"));
				course.setCourseTitle(rs.getString("course_title"));;
				course.setCourseDesc(rs.getString("course_desc"));
				course.setCourseStart(rs.getString("course_start"));
				course.setCourseEnd(rs.getString("course_end"));
				course.setAdmin(admin);
				course.setCourseCode(rs.getString("course_category"));
				course.setIsRemoved(rs.getInt("is_removed"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
	}

	@Override
	public boolean delete(Course course) {
		boolean status = false;
		try {
			db = DbConnection.getInstance();
			String query = "DELETE FROM course WHERE course_id=?";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setInt(0, course.getCourseId());
			if(stmt.executeUpdate() > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

}
