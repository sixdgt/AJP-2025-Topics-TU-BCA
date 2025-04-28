package case_study_one.dao;

import case_study_one.model.Admin;
import java.util.ArrayList;

public interface AdminDao {
	public abstract boolean login(Admin admin);
	public abstract Admin profile(Admin admin);
	public abstract boolean update(Admin admin);
	public abstract boolean changePassword(Admin admin);
	public abstract boolean create(Admin admin);
	public abstract ArrayList<Admin> select();
	public abstract Admin selectById(Admin admin);
	public abstract boolean delete(Admin admin);
}
