package controller;

import dao.EmployeeDao;
import dao.impl.EmployeeDaoImpl;
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
    public int department_id;
    public String designation;
    
    EmployeeModel em;
    DepartmentModel dm;
    EmployeeDao ed = new EmployeeDaoImpl();
    
    public boolean insert(EmployeeController ec){
        boolean status = false;
        dm = new DepartmentModel();
        em = new EmployeeModel();
        em.setFirstName(ec.first_name);
        em.setMiddleName(ec.middle_name);
        em.setLastName(ec.last_name);
        em.setEmpNo(ec.emp_no);
        em.setDesignation(ec.designation);
        dm.setDepartmentId(ec.department_id); // department object
        em.setDepartment(dm); // department object in employeemodel
        em.setDob(ec.dob);
        em.setGender(ec.gender);
        em.setJoinDate(ec.join_date);
        if(ed.saveEmployee(em)){
            status = true;
        }
        return status;
    }
}
