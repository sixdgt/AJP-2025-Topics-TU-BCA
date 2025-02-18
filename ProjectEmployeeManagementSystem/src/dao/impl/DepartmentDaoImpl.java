package dao.impl;

import config.DatabaseConnection;
import dao.DepartmentDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DepartmentModel;

public class DepartmentDaoImpl implements DepartmentDao {

    DatabaseConnection connection = DatabaseConnection.getInstance();

    @Override
    public boolean saveDepartment(DepartmentModel dm) {
        return true;
    }

    @Override
    public DepartmentModel getDepartment(DepartmentModel dm) {
        String query = "SELECT * FROM department WHERE department_id=" + dm.getDepartmentId();
        ResultSet data = connection.selectQueryBuilder(query);
        try {
            while (data.next()) {
                dm.setDepartmentId(data.getInt("department_id"));
                dm.setDepartmentCode(data.getString("department_code"));
                dm.setDepartmentName(data.getString("department_name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dm;
    }

    @Override
    public ArrayList<DepartmentModel> getAllDepartment() {
        ArrayList<DepartmentModel> list = new ArrayList<>();
        String query = "SELECT * FROM department";
        ResultSet data = connection.selectQueryBuilder(query);
        try {
            while (data.next()) {
                DepartmentModel dm = new DepartmentModel();
                dm.setDepartmentId(data.getInt("department_id"));
                dm.setDepartmentCode(data.getString("department_code"));
                dm.setDepartmentName(data.getString("department_name"));
                list.add(dm); // adding department object to arraylist
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
