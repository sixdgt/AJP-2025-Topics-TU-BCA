package case_study_one.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import case_study_one.dao.AdminDao;
import case_study_one.dbconfig.DbConnection;
import case_study_one.model.Admin;

public class AdminDaoImpl implements AdminDao{
	DbConnection db;
	
	@Override
	public boolean login(Admin admin) {
		boolean status = false;
		try {
			db = DbConnection.getInstance();
			String query = "SELECT * FROM admin WHERE admin_email=?";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setString(0, admin.getAdminEmail());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				if(rs.getString("admin_email").equals(admin.getAdminEmail()) && 
						rs.getString("admin_password").equals(admin.getAdminPassword())) {
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
	public Admin profile(Admin admin) {
		try {
			db = DbConnection.getInstance();
			String query = "SELECT * FROM admin WHERE admin_email=?";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setString(0, admin.getAdminEmail());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				admin.setAdminId(rs.getInt("admin_id"));
				admin.setAdminEmail(rs.getString("admin_email"));
				admin.setAdminFullName(rs.getString("admin_full_name"));
				admin.setAdminPassword(rs.getString("admin_password"));
				admin.setIsRemoved(rs.getInt("is_removed"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public boolean update(Admin admin) {
		boolean status = false;
		try {
			db = DbConnection.getInstance();
			String query = "UPDATE admin set admin_full_name=?, admin_email=? WHERE admin_id=?";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setString(0, admin.getAdminFullName());
			stmt.setString(1, admin.getAdminEmail());
			stmt.setInt(2, admin.getAdminId());
			if(stmt.executeUpdate() > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean changePassword(Admin admin) {
		boolean status = false;
		try {
			db = DbConnection.getInstance();
			String query = "UPDATE admin set admin_password=? WHERE admin_id=?";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setString(0, admin.getAdminPassword());
			stmt.setInt(1, admin.getAdminId());
			if(stmt.executeUpdate() > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean create(Admin admin) {
		boolean status = false;
		try {
			db = DbConnection.getInstance();
			String query = "INSERT INTO admin (`admin_full_name`, `admin_email`, `admin_password`) VALUES(?, ?, ?)";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setString(0, admin.getAdminFullName());
			stmt.setString(1, admin.getAdminEmail());
			stmt.setString(2, admin.getAdminPassword());
			if(stmt.executeUpdate() > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<Admin> select() {
		ArrayList<Admin> data = new ArrayList<Admin>();
		try {
			db = DbConnection.getInstance();
			String query = "SELECT * FROM admin";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Admin admin = new Admin();
				admin.setAdminId(rs.getInt("admin_id"));
				admin.setAdminEmail(rs.getString("admin_email"));
				admin.setAdminFullName(rs.getString("admin_full_name"));
				admin.setAdminPassword(rs.getString("admin_password"));
				admin.setIsRemoved(rs.getInt("is_removed"));
				data.add(admin);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public Admin selectById(Admin admin) {
		try {
			db = DbConnection.getInstance();
			String query = "SELECT * FROM admin WHERE admin_id=?";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setInt(0, admin.getAdminId());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				admin.setAdminId(rs.getInt("admin_id"));
				admin.setAdminEmail(rs.getString("admin_email"));
				admin.setAdminFullName(rs.getString("admin_full_name"));
				admin.setAdminPassword(rs.getString("admin_password"));
				admin.setIsRemoved(rs.getInt("is_removed"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public boolean delete(Admin admin) {
		boolean status = false;
		try {
			db = DbConnection.getInstance();
			String query = "DELETE FROM admin WHERE admin_id=?";
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(query);
			stmt.setInt(0, admin.getAdminId());
			if(stmt.executeUpdate() > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

}
