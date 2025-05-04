package case_study_one.controller;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import case_study_one.dao.AdminDao;
import case_study_one.dao.impl.AdminDaoImpl;
import case_study_one.model.Admin;
import org.mindrot.jbcrypt.BCrypt;

public class AdminController {
	private AdminDao admin_dao;
	private Admin admin;
	
	public AdminController() {
		this.admin_dao = new AdminDaoImpl();
	}
	
	public boolean doLogin(String email, String password) {
		boolean status = false;
		admin = new Admin();
		admin.setAdminEmail(email);
		admin.setAdminPassword(password);
		if(this.admin_dao.login(admin)) {
			status = false;
		}
		return status;
	}
	
	public Map<String, String> getProfile(String email){
		admin = new Admin();
		admin.setAdminEmail(email);
		admin = admin_dao.profile(admin);
		Map<String, String> profile_data = new HashMap<>();
		profile_data.put("admin_id", admin.getAdminId() + "");
		profile_data.put("full_name", admin.getAdminFullName());
		profile_data.put("email", admin.getAdminEmail());
		return profile_data;
	}
	
	public boolean updateProfile(Map<String, String> data) {
		boolean status = false;
		admin = new Admin();
		admin.setAdminId(Integer.parseInt(data.get("admin_id")));
		admin.setAdminEmail(data.get("email"));
		admin.setAdminFullName(data.get("full_name"));
		if(this.admin_dao.update(admin)) {
			status = true;
		}
		return status;
	}
	
	public boolean changeAdminPassword(Map<String, String> data) {
		boolean status = false;
		admin = new Admin();
		admin.setAdminId(Integer.parseInt(data.get("admin_id")));
		admin.setAdminEmail(data.get("email"));
		admin.setAdminPassword(data.get("password"));
		if(this.admin_dao.changePassword(admin)) {
			status = true;
		}
		return status;
	}
	
	public boolean addAdmin(Map<String, String> data) {
		boolean status = false;
		admin = new Admin();
		admin.setAdminEmail(data.get("email"));
		admin.setAdminFullName(data.get("full_name"));
		admin.setAdminPassword(BCrypt.hashpw(data.get("password"), BCrypt.gensalt()));
		if(this.admin_dao.create(admin)) {
			status = true;
		}
		return status;
	}
	
	public Map<Integer, Map<String, String>> getAllAdmin(){
		ArrayList<Admin> data = admin_dao.select();
		Map<String, String> admin_data = new HashMap<>();
		Map<Integer, Map<String, String>> all_admin = new HashMap<>();
		int counter = 0;
		for(Admin admin: data) {
			admin_data.put("admin_id", admin.getAdminId() + "");
			admin_data.put("full_name", admin.getAdminFullName());
			admin_data.put("email", admin.getAdminEmail());
			admin_data.put("password", admin.getAdminPassword());
			all_admin.put(counter, admin_data);
			counter++;
		}
		return all_admin;
	}
	
	public Map<String, String> getAdmin(int id){
		admin = new Admin();
		admin.setAdminId(id);
		admin = admin_dao.selectById(admin);
		Map<String, String> profile_data = new HashMap<>();
		profile_data.put("admin_id", admin.getAdminId() + "");
		profile_data.put("full_name", admin.getAdminFullName());
		profile_data.put("email", admin.getAdminEmail());
		return profile_data;
	}
	
	public boolean removeAdmin(int id) {
		boolean status = false;
		admin = new Admin();
		admin.setAdminId(id);
		if(admin_dao.delete(admin)) {
			status = true;
		}
		return status;
	}
}
