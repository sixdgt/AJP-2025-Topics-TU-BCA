package case_study_one.dao;

import java.util.ArrayList;
import case_study_one.model.Course;

public interface CourseDao {
	public abstract boolean update(Course course);
	public abstract boolean create(Course course);
	public abstract ArrayList<Course> select();
	public abstract Course selectById(Course course);
	public abstract boolean delete(Course course);
}
