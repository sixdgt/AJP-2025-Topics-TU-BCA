package case_study_one.dao;

import case_study_one.model.Student;
import java.util.ArrayList;

public interface StudentDao {
	public abstract boolean login(Student student);
	public abstract Student profile(Student student);
	public abstract boolean update(Student student);
	public abstract boolean changePassword(Student student);
	public abstract boolean create(Student student);
	public abstract ArrayList<Student> select();
	public abstract Student selectById(Student student);
	public abstract boolean delete(Student student);
	public abstract boolean uploadProfile(Student student);
}
