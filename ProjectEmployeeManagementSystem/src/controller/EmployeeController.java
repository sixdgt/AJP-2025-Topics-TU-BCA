package controller;

import dao.EmployeeDao;
import dao.impl.EmployeeDaoImpl;
import java.util.ArrayList;
import model.DepartmentModel;
import model.EmployeeModel;

public class EmployeeController {
    public int emp_no;
    public String first_name;
    public String middle_name;
    public String last_name;
    public String gender;
    public String join_date;
    public String dob;
    public DepartmentModel department;
    public String designation;
    
    EmployeeModel em;
    DepartmentModel dm;
    EmployeeDao ed = new EmployeeDaoImpl();
    
    public boolean insert(EmployeeController ec){
        boolean status = false;
        em = new EmployeeModel();
        em.setFirstName(ec.first_name);
        em.setMiddleName(ec.middle_name);
        em.setLastName(ec.last_name);
        em.setEmpNo(ec.emp_no);
        em.setDesignation(ec.designation); // department object
        em.setDepartment(ec.department); // department object in employeemodel
        em.setDob(ec.dob);
        em.setGender(ec.gender);
        em.setJoinDate(ec.join_date);
        if(ed.saveEmployee(em)){
            status = true;
        }
        return status;
    }
    
    public ArrayList<EmployeeModel> getEmployeeList(){
        return ed.getEmployees();
    }
}
