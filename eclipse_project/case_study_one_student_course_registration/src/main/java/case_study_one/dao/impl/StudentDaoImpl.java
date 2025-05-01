package case_study_one.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import case_study_one.dao.StudentDao;
import case_study_one.dbconfig.DbConnection;
import case_study_one.model.Student;

public class StudentDaoImpl implements StudentDao{

	@Override
	public boolean login(Student student) {
		boolean status = false;
		try {
			String query = "SELECT * FROM student WHERE student_email=?";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setString(1, student.getStudentEmail());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				if(rs.getString("student_email").equals(student.getStudentEmail()) && 
						rs.getString("student_password").equals(student.getStudentPassword())) {
					status = true;
					break;
				}
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student profile(Student student) {
		try {
			String query = "SELECT * FROM student WHERE student_email=?";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setString(1, student.getStudentEmail());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
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
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public boolean update(Student student) {
		boolean status = false;
		try {
			String query = "UPDATE student set student_first_name=?, student_middle_name=?, student_last_name=?"
					+ ", address=?, profile_img=?, gender=?, dob=?, student_email=? WHERE student_id=?";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setString(1, student.getStudentFirstName());
			stmt.setString(2, student.getStudentMiddleName());
			stmt.setString(3, student.getStudentLastName());
			stmt.setString(4, student.getAddress());
			stmt.setString(5, student.getProfileImg());
			stmt.setString(6, student.getGender());
			stmt.setString(7, student.getDob());
			stmt.setString(8, student.getStudentEmail());
			stmt.setString(9, student.getStudentPassword());
			stmt.setInt(10, student.getStudentId());
			if(stmt.executeUpdate() > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean changePassword(Student student) {
		boolean status = false;
		try {
			String query = "UPDATE student set student_password=? WHERE admin_id=?";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setString(1, student.getStudentPassword());
			stmt.setInt(2, student.getStudentId());
			if(stmt.executeUpdate() > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean create(Student student) {
		boolean status = false;
		try {
			String query = "INSERT INTO admin (`student_first_name`, `student_middle_name`, "
					+ "`student_last_name`, `address`, `profile_img`, `gender`, `dob`, `student_email`, "
					+ "`student_password`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setString(1, student.getStudentFirstName());
			stmt.setString(2, student.getStudentMiddleName());
			stmt.setString(3, student.getStudentLastName());
			stmt.setString(4, student.getAddress());
			stmt.setString(5, student.getProfileImg());
			stmt.setString(6, student.getGender());
			stmt.setString(7, student.getDob());
			stmt.setString(8, student.getStudentEmail());
			stmt.setString(9, student.getStudentPassword());
			if(stmt.executeUpdate() > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<Student> select() {
		ArrayList<Student> data = new ArrayList<Student>();
		try {
			String query = "SELECT * FROM student";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
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
				data.add(student);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public Student selectById(Student student) {
		try {
			String query = "SELECT * FROM student WHERE student_id=?";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setInt(1, student.getStudentId());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
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
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public boolean delete(Student student) {
		boolean status = false;
		try {
			String query = "DELETE FROM student WHERE student_id=?";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setInt(1, student.getStudentId());
			if(stmt.executeUpdate() > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean uploadProfile(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

}
