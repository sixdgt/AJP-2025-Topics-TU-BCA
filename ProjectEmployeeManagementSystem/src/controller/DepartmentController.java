package controller;

import dao.DepartmentDao;
import dao.impl.DepartmentDaoImpl;
import java.util.ArrayList;
import model.DepartmentModel;

public class DepartmentController {
    DepartmentDao dd = new DepartmentDaoImpl();
    
    public ArrayList<DepartmentModel> getDepartmentList(){
        return dd.getAllDepartment();
    }
}
