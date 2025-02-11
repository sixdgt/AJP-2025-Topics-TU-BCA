package model;

public class EmployeeModel {
    private int emp_no;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String gender;
    private String join_date;
    private String dob;
    private DepartmentModel department;
    private String designation;
    
    public void setEmpNo(int emp_no){
        this.emp_no = emp_no;
    }
    
    public int getEmpNo(){
        return this.emp_no;
    }
    
    public void setFirstName(String first_name){
        this.first_name = first_name;
    }
    
    public String getFirstName(){
        return this.first_name;
    }
    
    public void setLastName(String last_name){
        this.last_name = last_name;
    }
    
    public String getLastName(){
        return this.last_name;
    }
    
    public void setMiddleName(String middle_name){
        this.middle_name = middle_name;
    }
    
    public String getMiddleName(){
        return this.middle_name;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    
    public String getGender(){
        return this.gender;
    }
    
    public void setJoinDate(String join_date){
        this.join_date = join_date;
    }
    
    public String getJoinDate(){
        return this.join_date;
    }
    
    public void setDob(String dob){
        this.dob = dob;
    }
    
    public String getDob(){
        return this.dob;
    }
    
    public void setDepartment(DepartmentModel department){
        this.department = department;
    }
    
    public DepartmentModel getDepartment(){
        return this.department;
    }
    
    public void setDesignation(String designation){
        this.designation = designation;
    }
    
    public String getDesignation(){
        return this.designation;
    }
}
