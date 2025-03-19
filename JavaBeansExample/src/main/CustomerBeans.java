package main;
import java.io.Serializable;

public class CustomerBeans implements Serializable{
    // serialVersionUID
    private static final long serialVersionUID = 1L;
    
    // private fields
    private String full_name;
    private int id;
    private String email;
    private String contact;
    private String gender;
    
    // no-argument constructor
    public CustomerBeans(){}
    // access modifier i.e getter and setter method
    public String getFullName(){return this.full_name;}
    public void setFullName(String full_name){this.full_name = full_name;}
    
    public int getId(){return this.id;}
    public void setId(int id){this.id=id;}
    
    public String getEmail(){return this.email;}
    public void setEmail(String email){this.email = email;}
    
    public String getContact(){return this.contact;}
    public void setContact(String contact){this.contact = contact;}
    
    public String getGender(){return this.gender;}
    public void setGender(String gender){this.gender = gender;}
    
    // converting object properties into String
    @Override
    public String toString(){
        return "CustomerBeans: full_name='" + this.full_name + "', "
                + " email='" + this.email + "'";
    }
}
