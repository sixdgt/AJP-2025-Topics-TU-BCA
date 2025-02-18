package dao.impl;

import dao.EmployeeDao;
import config.DatabaseConnection;
import controller.DepartmentController;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.DepartmentModel;
import model.EmployeeModel;

public class EmployeeDaoImpl implements EmployeeDao {

    DatabaseConnection connection = DatabaseConnection.getInstance();
    DepartmentController dc;
    @Override
    public boolean saveEmployee(EmployeeModel em) {
        boolean status = false;
        String query = "INSERT INTO employee"
                + "(`first_name`, `middle_name`, `last_name`, `dob`,"
                + " `join_date`, `gender`, `department_id`, `designation`) VALUES("
                + "'" + em.getFirstName() + "', '" + em.getMiddleName() + "', "
                + "'" + em.getLastName() + "', '" + em.getDob() + "', "
                + "'" + em.getJoinDate() + "','" + em.getGender() + "', "
                + "" + em.getDepartment().getDepartmentId() + ","
                + "'" + em.getDesignation() + "')";
        if (connection.iudQueryBuilder(query) > 0) {
            status = true;
        }
        return status;
    }

    @Override
    public EmployeeModel getEmployee(EmployeeModel em) {
        String query = "SELECT * FROM employee WHERE ID=" + em.getEmpNo();
        ResultSet data = connection.selectQueryBuilder(query);
        DepartmentModel dm = new DepartmentModel();
        try {
            while (data.next()) {
                em.setFirstName(data.getString("first_name"));
                em.setMiddleName(data.getString("middle_name"));
                em.setLastName(data.getString("last_name"));
                dm.setDepartmentId(data.getInt("department_id"));
                em.setDepartment(dm);
                em.setDesignation(data.getString("designation"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return em;
    }

    @Override
    public ArrayList<EmployeeModel> getEmployees() {
        ArrayList<EmployeeModel> list = new ArrayList<>();
        String query = "SELECT * FROM employee";
        ResultSet data = connection.selectQueryBuilder(query);
        try {
            while (data.next()) {
                dc = new DepartmentController();
                EmployeeModel em = new EmployeeModel();
                DepartmentModel dm = new DepartmentModel();
                em.setEmpNo(data.getInt("emp_no"));
                em.setFirstName(data.getString("first_name"));
                em.setMiddleName(data.getString("middle_name"));
                em.setLastName(data.getString("last_name"));
                em.setJoinDate(data.getString("join_date"));
                em.setDob(data.getString("dob"));
                em.setGender(data.getString("gender"));
                dm = dc.getDepartmentById(data.getInt("department_id"));
                em.setDepartment(dm);
                em.setDesignation(data.getString("designation"));
                list.add(em); // adding employee object to arraylist
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean updateEmployee(EmployeeModel em) {
        return true;
    }

    @Override
    public boolean deleteEmployee(EmployeeModel em) {
        return true;
    }

}
