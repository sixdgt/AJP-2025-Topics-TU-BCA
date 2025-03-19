package main;

public class Main {
    public static void main(String[] args) {
        CustomerBeans cb = new CustomerBeans();
        // storing data into beans properties
        cb.setFullName("Prabesh Khatri");
        cb.setContact("9874214");
        cb.setEmail("prabesh@gmail.com");
        cb.setGender("Male");
        cb.setId(1);
        // accessing data of beans properties
        System.out.println("Full Name: " + cb.getFullName());
        System.out.println("Email: " + cb.getEmail());
        System.out.println("Contact: " + cb.getContact());
        System.out.println("Gender: " + cb.getGender());
        
        System.out.println("Beans object: " + cb);
    }
}
