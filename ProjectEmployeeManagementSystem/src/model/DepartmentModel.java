package model;

public class DepartmentModel {
    private int department_id;
    private String department_code;
    private String department_name;
    
    public void setDepartmentId(int department_id){
        this.department_id = department_id;
    }
    
    public int getDepartmentId(){
        return this.department_id;
    }
    
    public void setDepartmentCode(String code){
        this.department_code = code;
    }
    
    public String getDepartmentCode(){
        return this.department_code;
    }
    
    public void setDepartmentName(String name){
        this.department_name = name;
    }
    
    public String getDepartmentName(){
        return this.department_name;
    }
}
