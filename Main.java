import java.util.*;
// main Class
class Main{
    public static void main(String[] args){

        // scanner class object
        Scanner input = new Scanner(System.in);
        // product catalogue class object
        var catalogue = new ProductCatalogue(15);
        
        int menuChoice;
        char option = ' ';

        do{
            System.out.println("----------------------------------------");
            System.out.println("\tProduct Catalogue Menu");
            System.out.println("----------------------------------------");
            System.out.println("1. View Catalogue");
            System.out.println("2. Add Product");
            System.out.println("3. Search Product by Name");
            System.out.println("4. Search Product by Price Range");
            System.out.println("5. Exit");
            System.out.println("*****************************************");
            System.out.print("Enter your choice : ");
            menuChoice = input.nextInt();

            if(menuChoice == 1){
                    catalogue.viewCatalogue();
            }else if(menuChoice == 2){
                System.out.println("----------------------------------------");
                System.out.print("Enter product name : ");
                String name = input.next();
                System.out.print("Enter product price : ");
                double price;
                try{
                    price = input.nextDouble();
                }catch(NumberFormatException e){
                    System.out.println("Invalid price format. Please enter a numeric value.");
                    continue;
                }
                
                // creating product class object
                var product = new Product(name, price);
                catalogue.addProduct(product);
            }else if(menuChoice == 3){
                System.out.println("----------------------------------------");
                System.out.print("Enter the product name to Search : ");
                String searchName = input.next();
                catalogue.findProductByName(searchName);
            }else if(menuChoice == 4){
                System.out.println("----------------------------------------");
                System.out.print("Enter minimum price : ");
                double minPrice = input.nextDouble();
                System.out.print("Enter maximum price : ");
                double maxPrice = input.nextDouble();

                catalogue.getProductInPriceRange(minPrice, maxPrice);
            }else if(menuChoice == 5){
                System.out.println("Exiting the program!");
            }else{
                System.out.println("Enter valid option");
            }
            System.out.println("...........................................");
            System.out.println("Do you want to continue?");
            System.out.print("Enter 'y' for yes and 'n' for No : ");
            option = input.next().charAt(0);
        }while(option != 'n');
    }
}
// Product Class
class Product{
    private String name;
    private double price;

    // constructor
    Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    // accessors and mutators
    // setters
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    // getters
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }

}
// Product Catalogue Class
class ProductCatalogue{
    private Product[] products;
    private int numberOfProducts;

    // constructor
    ProductCatalogue(int capacity){
        products = new Product[capacity];
        numberOfProducts = 0;
    }

    // addproduct method
    public void addProduct(Product product){
        if(numberOfProducts < products.length){
            products[numberOfProducts] = product;
            numberOfProducts++;
            System.out.println("Product added to the catalogue.");
        }else{
            System.out.println("Product catalogue is full.");
        }
    }

    // find product by name method
    public void findProductByName(String name){
        boolean productFound = false;
        for(Product product: products){
            if(product.getName().equals(name)){
                System.out.println("Product Found : ");
                System.out.print("Name : "+product.getName());
                System.out.println(", Price : "+product.getPrice());
                productFound = true;
                break;
            }
        }
        if(!(productFound)){
            System.out.println("Product not Found.");
        }
    }

    // get product in price range method
    public void getProductInPriceRange(double minPrice, double maxPrice) {
        for (Product product : products) {
            double price = product.getPrice();  // Retrieve the price once for readability
            if (product != null && price >= minPrice && price <= maxPrice) {
                System.out.println("Name: " + product.getName() + ", Price: " + price);
            }
        }
    }
    
    

    // view catalogue method
    public void viewCatalogue(){
        System.out.println("----------------------------------------");
        System.out.println("\tProduct Catalogue");
        System.out.println("----------------------------------------");
        for(Product product: products){
            if(product != null){
                System.out.println("Name : "+product.getName()+", Price :"+product.getPrice());
            }else{
                System.out.println("Catalogue is Empty!");
                break;
            }
            
        }
    }
}