package dao;
import java.util.ArrayList;
import model.EmployeeModel;

public interface EmployeeDao {
    // to store employee data
    public abstract boolean saveEmployee(EmployeeModel em);
    // to get single employee information
    public abstract EmployeeModel getEmployee(EmployeeModel em);
    // to get all employees
    public abstract ArrayList<EmployeeModel> getEmployees();
    // to udpate employee information
    public abstract boolean updateEmployee(EmployeeModel em);
    // to delete single employee
    public abstract boolean deleteEmployee(EmployeeModel em);
}
