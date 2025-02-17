package controller;

import dao.DepartmentDao;
import dao.impl.DepartmentDaoImpl;
import java.util.ArrayList;
import model.DepartmentModel;

public class DepartmentController {
    public int department_id;
    public String department_code;
    public String department_name;
    
    DepartmentDao dd = new DepartmentDaoImpl();
    
    public ArrayList<DepartmentModel> getDepartmentList(){
        return dd.getAllDepartment();
    }
}
