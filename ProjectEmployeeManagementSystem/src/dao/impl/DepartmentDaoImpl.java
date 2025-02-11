package dao.impl;

import dao.DepartmentDao;
import java.util.ArrayList;
import model.DepartmentModel;

public class DepartmentDaoImpl implements DepartmentDao{

    @Override
    public boolean saveDepartment(DepartmentModel dm) {
        return true;
    }

    @Override
    public DepartmentModel getDepartment(DepartmentModel dm) {
        return dm;
    }

    @Override
    public ArrayList<DepartmentModel> getAllDepartment() {
        ArrayList<DepartmentModel> list = new ArrayList<>();
        return list;
    }

    @Override
    public boolean updateDepartment(DepartmentModel dm) {
        return true;
    }

    @Override
    public boolean deleteDepartment(DepartmentModel dm) {
        return true;
    }
    
}
