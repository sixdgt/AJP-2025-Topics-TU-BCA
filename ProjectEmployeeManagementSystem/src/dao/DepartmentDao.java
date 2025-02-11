package dao;
import java.util.ArrayList;
import model.DepartmentModel;

public interface DepartmentDao {
    public abstract boolean saveDepartment(DepartmentModel dm);
    
    public abstract DepartmentModel getDepartment(DepartmentModel dm);
    
    public abstract ArrayList<DepartmentModel> getAllDepartment();
    
    public abstract boolean updateDepartment(DepartmentModel dm);
    
    public abstract boolean deleteDepartment(DepartmentModel dm);
}
