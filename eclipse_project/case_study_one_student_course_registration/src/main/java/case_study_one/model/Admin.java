package case_study_one.model;

public class Admin {
	private int admin_id;
	private String admin_full_name;
	private String admin_email;
	private String admin_password;
	private int is_removed;
	
	public void setAdminId(int admin_id) {this.admin_id = admin_id;}
	public int getAdminId() {return this.admin_id;}
	
	public void setAdminFullName(String full_name) {this.admin_full_name = full_name;}
	public String getAdminFullName() {return this.admin_full_name;}
	
	public void setAdminEmail(String email) {this.admin_email = email;}
	public String getAdminEmail() {return this.admin_email;}
	
	public void setAdminPassword(String password) {this.admin_password = password;}
	public String getAdminPassword() {return this.admin_password;}
	
	public void setIsRemoved(int is_removed) {this.is_removed = is_removed;}
	public int getIsRemoved() {return this.is_removed;}
}
