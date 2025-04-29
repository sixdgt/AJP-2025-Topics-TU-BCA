package case_study_one.dao;

import java.util.ArrayList;
import case_study_one.model.Enroll;

public interface EnrollDao {
	public abstract boolean update(Enroll enroll);
	public abstract boolean create(Enroll enroll);
	public abstract ArrayList<Enroll> select();
	public abstract Enroll selectById(Enroll enroll);
	public abstract boolean delete(Enroll enroll);
}
