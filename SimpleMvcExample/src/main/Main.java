package main;
import view.AddProductView;
import controller.ProductController;

public class Main {
    public static void main(String args[]){
        AddProductView apv = new AddProductView();
        // here addProduct() method returns ProductController object
        ProductController pc = apv.addProduct();
        System.out.println("Your Product is added.");
        System.out.println("Displaying your added product.");
        pc.displayProduct();     
    }
}
