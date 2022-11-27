//Sadaf Saadman Jawad Ryerson Id #501126527
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;





/*
 * Models a simple ECommerce system. Keeps track of products for sale, registered customers, product orders and
 * orders that have been shipped to a customer
 */
public class ECommerceSystem
{
    private HashMap<String, Product> productsMap = new HashMap<String, Product>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    private HashMap<String, Integer> statsMap = new HashMap<String, Integer>();

    // (BONUS) arrayList storeBooksByYear used in the bonus part
    private ArrayList<Book> storeBooksByYear = new ArrayList<Book>();	
    
    private ArrayList<ProductOrder> orders   = new ArrayList<ProductOrder>();
    private ArrayList<ProductOrder> shippedOrders   = new ArrayList<ProductOrder>();
    
    // These variables are used to generate order numbers, customer id's, product id's 
    private int orderNumber = 500;
    private int customerId = 900;
    private int productId = 700;
    
    // General variable used to store an error message when something is invalid (e.g. customer id does not exist)  
    
    // Random number generator
    Random random = new Random();
    
    public ECommerceSystem()
    {
    	// NOTE: do not modify or add to these objects!! - the TAs will use for testing
    	// If you do the class Shoes bonus, you may add shoe products
      try
      {
        productsMap.putAll(readFromFile("products.txt"));         //read products from a file
      }
      catch (IOException ex)
      {
        System.out.println(ex.getMessage());
        System.exit(1);
      }

      // Create some customers. Notice how generateCustomerId() method is used
    	customers.add(new Customer(generateCustomerId(),"Inigo Montoya", "1 SwordMaker Lane, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Prince Humperdinck", "The Castle, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Andy Dufresne", "Shawshank Prison, Maine"));
    	customers.add(new Customer(generateCustomerId(),"Ferris Bueller", "4160 Country Club Drive, Long Beach"));
    }

    private HashMap<String, Product> readFromFile(String filename) throws IOException
    {
      HashMap<String, Product> newMap = new HashMap<String,Product>();
      File newFile = new File(filename);
      Scanner reader = new Scanner(newFile);
      while(reader.hasNextLine()){
        String category = reader.nextLine();
        if (category.equals("COMPUTERS")){
          // String category = reader.nextLine();                     //if category is computers then make computer product
          String name = reader.nextLine();
          double price = reader.nextDouble();
          int stock = reader.nextInt();
          String id = generateProductId();
          newMap.put(id,new Product(name, id, price, stock, Product.Category.COMPUTERS));
          statsMap.put(id, 0);
        }
        else if (category.equals("FURNITURE")){                 //if category is furniture then make furniture product
          String name = reader.nextLine();
          double price = reader.nextDouble();
          int stock = reader.nextInt();
          String id = generateProductId();
          newMap.put(id,new Product(name, id, price, stock, Product.Category.FURNITURE));
          statsMap.put(id, 0);

        }
        else if (category.equals("GENERAL")){
          String name = reader.nextLine();
          double price = reader.nextDouble();                         //if category is general then make general product
          int stock = reader.nextInt();
          String id = generateProductId();
          newMap.put(id,new Product(name, id, price, stock, Product.Category.GENERAL));
          statsMap.put(id, 0);

        }
        else if (category.equals("CLOTHING")){              //if clothing is general then make clothing product
          String name = reader.nextLine();
          double price = reader.nextDouble();
          int stock = reader.nextInt();
          String id = generateProductId();
          newMap.put(id,new Product(name, id, price, stock, Product.Category.CLOTHING));
          statsMap.put(id, 0);

        }
        else if (category.equals("BOOKS")){
          String name = reader.nextLine();
          double price = reader.nextDouble();
          int paperback = reader.nextInt();                     //if books is general then make book product
          int hardcover = reader.nextInt();
          String temp = reader.nextLine();
          String temp1 = reader.nextLine();
          Scanner reader1 = new Scanner(temp1);
          String id = generateProductId();
          reader1.useDelimiter(":");
          String title = "";
          String author = "";
          int year = 0;
          while (reader1.hasNext()){
            title += reader1.next();
            author += reader1.next();
            year += reader1.nextInt();
          }
          reader1.close();
          newMap.put(id, new Book(name, id, price, paperback, hardcover, title, author, year));
          statsMap.put(id, 0);

        }
      }
      reader.close();
      return newMap;
    }
    
    private String generateOrderNumber()
    {
    	return "" + orderNumber++;
    }

    private String generateCustomerId()
    {
    	return "" + customerId++;
    }
    
    private String generateProductId()
    {
    	return "" + productId++;
    }
    
    public void printAllProducts()
    {
    	for (Product p : productsMap.values())                //print all products in the productsMap
    		p.print();
    }
    
    // Print all products that are books. See getCategory() method in class Product
    public void printAllBooks()
    {
      for (Product p : productsMap.values()){
        if (p.getCategory().equals(Product.Category.BOOKS)){      //used a for loop to print all the products which are in the book category
          Book otherB = (Book) p;
          otherB.printWithYear(); 
        }
      }
    }

    // Print all products that are shoes.
    public void printAllShoes()
    {
      for (Product p : productsMap.values()){
        if (p.getCategory().equals(Product.Category.SHOES)){      //used a for loop to print all the products which are in the book category
          p.print();          
        }
      }
    }
    
    // Print all current orders
    public void printAllOrders()
    {
    	for (ProductOrder o : orders)       //used a for loop to print all the objects in the orders list
    		o.print();
    }
    // Print all shipped orders
    public void printAllShippedOrders()
    {
      for (ProductOrder s : shippedOrders)      //used for loop to print all the objects in the shipped order list
        s.print();
    }
    
    // Print all customers
    public void printCustomers()
    {
    	for (Customer cust : customers){      //print all the customers in the customers list
          cust.print();
      }
    }
    /*
     * Given a customer id, print all the current orders and shipped orders for them (if any)
     */
    public void printOrderHistory(String customerId)
    {
      // Make sure customer exists - check using customerId
    	// If customer does not exist, set errMsg String and return false
    	// see video for an appropriate error message string
    	// ... code here
      Customer newCust = null;
      for(Customer c : customers){
        if (customerId.equals(c.getId())){
          newCust=c;
        }
      }
      if (newCust==null){
        throw new CustomerNotFound("Customer "+customerId+" Not Found");           
      }

    	// Print current orders of this customer 
    	System.out.println("Current Orders of Customer " + customerId);   //print the line in proper format 
    	// enter code here
      for (ProductOrder ord: orders){
        if (ord.getCustomer().equals(newCust)){        //for every order in the order list if that order is the same customer as found earlier 
          ord.print();                              //then print
        }
      }
    	// Print shipped orders of this customer 
    	System.out.println("\nShipped Orders of Customer " + customerId);
    	//enter code here
      for (ProductOrder shipord: shippedOrders){      
        if (shipord.getCustomer().equals(newCust)){      //for every order in the shippedorder list if that order is the same customer as found earlier
          shipord.print();                            //then print
        }
      }
    }
    
    public String orderProduct(String productId, String customerId, String productOptions)
    {
    	// First check to see if customer object with customerId exists in array list customers
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Customer object
      
      Customer customer1 = new Customer(null, null, null);
    	for (Customer cust : customers){
        
        if ((cust.getId().equals(customerId))){             //for every customer in customers list if id matches 
           customer1 = cust;                                 //then store customer to reference customer1
        }
      }
      if ((customer1.getId() == null && customer1.getName() == null )) {                                //after the loop has finished, check whether the reference is empty or not
        throw new CustomerNotFound("Customer "+customerId+" Not Found");
      }
        
      
      
    	// Check to see if product object with productId exists in array list of products
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Product object 
      Product product1 = new Product(null);  
    	if (productsMap.containsKey(productId)){
        product1 = productsMap.get(productId);
      }
      if (product1.getId()==null){                                //after the loop has finished, check whether the reference is empty or not
        throw new ProductNotFound("Product "+productId+" Not Found");     
      }
      
      
    	// Check if the options are valid for this product (e.g. Paperback or Hardcover or EBook for Book product)
    	// See class Product and class Book for the method vaidOptions()
    	// If options are not valid, set errMsg string and return null;
    	
      if (!(product1.validOptions(productOptions))) {                             //check the productOption for each product to see whether it is valid or not by using the validOptions() method
        throw new InvalidProductOptions("Product "+product1.getCategory()+" ProductId "+productId+" Invalid Options: "+productOptions);
      }
      
    	// Check if the product has stock available (i.e. not 0)
    	// See class Product and class Book for the method getStockCount()
    	// If no stock available, set errMsg string and return null
    	
      if (product1.getStockCount(productOptions)<=0){                     //use getStockCount method and check whether it is out of stock or not
        throw new OutOfStock("Product "+product1.getCategory()+" ProductId "+productId+" out of stock");
      }

      // Create a ProductOrder, (make use of generateOrderNumber() method above)
    	// reduce stock count of product by 1 (see class Product and class Book)
    	// Add to orders list and return order number string
    	
      ProductOrder prodorder = new ProductOrder(generateOrderNumber(), product1, customer1, productOptions);    //create new product order object once all the check has been completed
      product1.reduceStockCount(productOptions);                                          //reduce the stock by one because of ordering the product
      orders.add(prodorder);                                                              //add the order object to orders list
      int tempFreq = 0;
      tempFreq += tempFreq + statsMap.get(product1.getId()) + 1;                          //increase frequency ordered by one
      statsMap.put(product1.getId(), tempFreq);
    	return "#"+prodorder.getOrderNumber(); // replace this line                         //return the order number of that object
    }
  
    
    /*
     * Create a new Customer object and add it to the list of customers
     */
    
    public void createCustomer(String name, String address)
    {
    	// Check name parameter to make sure it is not null or ""
    	// If it is not a valid name, set errMsg (see video) and return false
    	// Repeat this check for address parameter
      
    	if (name==null || name.equals("")){                               //if name is empty or null then cannot create customer, set errMsg and return false
        throw new InvalidCustName("Invalid Customer Name");
      }
      if (address==null || address.equals("")){                       //if address is empty or null then cannot cretae customer, set errMsg and return false
        throw new InvalidCustAddress("Invalid Customer Address");
      }

    	// Create a Customer object and add to array list

      Customer newcust1 = new Customer(generateCustomerId(), name, address);        //create new customer onject once check has been successful
      customers.add(newcust1);                                                     //add to customers list and return true
    }
    
    public ProductOrder shipOrder(String orderNumber)
    {
      // Check if order number exists first. If it doesn't, set errMsg to a message (see video) 
    	// and return false
    	// Retrieve the order from the orders array list, remove it, then add it to the shippedOrders array list
    	// return a reference to the order
      ProductOrder newprodorder = null;                             
      for (ProductOrder prod: orders){                          //for every order in orders list
        if ((prod.getOrderNumber().equals(orderNumber))){       //if the order id given in param is found
          shippedOrders.add(prod);                            //then add to shipped list
          orders.remove(prod);                              //then remove that order once shipped
          newprodorder = prod;                                //assign that order to a reference
          return newprodorder;                                 //return the reference
        }
      }
      throw new InvalidOrderNumber("Order "+orderNumber+" Not Found");
    }
    
    /*
     * Cancel a specific order based on order number
     */
    public void cancelOrder(String orderNumber)
    {
      int index = orders.indexOf(new ProductOrder(orderNumber,null,null,""));
		  if (index == -1)
		  {
		  	throw new InvalidOrderNumber("Order "+orderNumber+" Not Found");            //check the list of orders for the order with given ordernumber
		  }
		  ProductOrder order = orders.get(index);                                     //if fount then remove it if not then raise exception
		  orders.remove(index);
    }
    
    // Print products by increasing price
    public void sortByPrice()
    {
      ArrayList<Product>tempList = new ArrayList<Product>();
      for (Product p: productsMap.values()){
        tempList.add(p);
      }
      Collections.sort(tempList, new Comparator<Product>() {                  //sort and print using new comparator object
        public int compare(Product prod1, Product prod2){                     //compare two products
          return Double.compare(prod1.getPrice(), prod2.getPrice());          //compare the price of the two products and return to sort
        }
      });;
      for (Product prod: tempList){
        prod.print();
      }
    }
    
    
    // Print products alphabetically by product name
    public void sortByName()
    {
      ArrayList<Product>tempList = new ArrayList<Product>();
      for (Product p: productsMap.values()){
        tempList.add(p);
      }
  	  Collections.sort(tempList, new Comparator<Product>() {                //sort and print using new comparator object
        public int compare(Product prod1, Product prod2){                   //compare two products  
          return prod1.getName().compareTo(prod2.getName());                //compare the name of the two products and return to sort
        }
      });;
      for (Product prod: tempList){
        prod.print();
      }
    }
    
        
    // Sort products alphabetically by product name
    public void sortCustomersByName()
    {
  	  Collections.sort(customers, new Comparator<Customer>() {            //sort using new comparator object
        public int compare(Customer cust1, Customer cust2){               //compare two customers
          return cust1.getName().compareTo(cust2.getName());              //compare the name of the two customers and return to sort
        } 
      });;
    }

    // (BONUS) Sort products by the year published of the selected author
    public boolean sortAndPrintByYear(String author)
    {
      boolean authorFound = false;                                    
      storeBooksByYear.clear();                                       //clear the list to use again
      for(Product p: productsMap.values()){
        if (p.getCategory().equals(Product.Category.BOOKS)){              //check if the product is a book or not
          Book otherP = (Book) p;                                         //if book then cast to Book object
          if (otherP.getAuthor().equals(author) && otherP.getYear()>0){   //check whether author matches with the given author or not and if the book object has a year or not
            storeBooksByYear.add(otherP);                                 //add the matches to a list of books
            authorFound = true;                                           //raise authorFound
          }
        }
      }
      if (!authorFound){
        throw new AuthorNotFound("Author "+author+" not Found");
      }
      else{                                                     //if author is found
        Collections.sort(storeBooksByYear, new Comparator<Book>() {         //sort using new comparator object
          public int compare(Book book1, Book book2){                       //compare two books
            return Integer.compare(book1.getYear(), book2.getYear());       //compare the year of the two books and return to sort
          }
        });;
        for(Book b: storeBooksByYear){                      //print all the books using the printWithYeat() method in class book
          b.printWithYear();
        }
        return authorFound;
      }
      
    }

    // Add item to cart
    public void addToCart(String productId, String customerId, String productOptions)
    {
      //checks if inputs are valid
      Product newProd = null;
      Customer newCust = null;

      if (productsMap.containsKey(productId)){
        newProd = productsMap.get(productId);
      }
      for(Customer c : customers){
        if (customerId.equals(c.getId())){
          newCust=c;
        }
      }
      if (newCust==null){
        throw new CustomerNotFound("Customer "+customerId+" Not Found");
      }
      if (newProd==null){
        throw new ProductNotFound("Product "+productId+" Not Found");
      }
      if (!(newProd.validOptions(productOptions))) {                             //check the productOption for each product to see whether it is valid or not by using the validOptions() method
        throw new InvalidProductOptions("Product "+newProd.getCategory()+" ProductId "+productId+" Invalid Options: "+productOptions);
      }

      newCust.getCart().addItem(new CartItem(newProd, productOptions));         //add to cart
    }


    // remove an item from cart
    public void remCartItem(String productId, String customerId)
    {
      //checks if inputs are valid
      Product newProd = null;
      Customer newCust = null;

      if (productsMap.containsKey(productId)){
        newProd = productsMap.get(productId);
      }
      for(Customer c : customers){
        if (customerId.equals(c.getId())){
          newCust=c;
        }
      }
      if (newCust==null){
        throw new CustomerNotFound("Customer "+customerId+" Not Found");
      }
      if (newProd==null){
        throw new ProductNotFound("Product "+productId+" Not Found");
      }

      CartItem newItem = newCust.getCart().getItem(productId);
      newCust.getCart().removeItem(newItem);                          //remove from cart
    } 


    // print all items in cart
    public void printCart(String customerId)
    {
      //code for error handling
      Customer newCust = null;
      for(Customer c : customers){
        if (customerId.equals(c.getId())){
          newCust=c;
        }
      }
      if (newCust==null){
        throw new CustomerNotFound("Customer "+customerId+" Not Found");           
      }

      newCust.getCart().printItems();                       //print cart
    }

    // order all items in cart
    public String orderCart(String customerId)
    {
      String orderNumbers = "";

      //code for error handling
      Customer newCust = null;
      for(Customer c : customers){
        if (customerId.equals(c.getId())){
          newCust=c;
        }
      }
      if (newCust==null){
        throw new CustomerNotFound("Customer "+customerId+" Not Found");
      }

      ArrayList<CartItem> itemList = newCust.getCart().getItems();
      for (CartItem c: itemList){
        orderNumbers+=orderProduct(c.getProductId(), customerId, c.getProductOptions())+" ";    //order every product
      }
      newCust.getCart().clearCart();                //clear cart
      return orderNumbers;                          //return order numbers
    }

    //print stats
    public void printStats()
    {
      //code for printing all products along with the number of times ordered
      HashMap<String, Integer> statsMapSorted = sortByFrequency(statsMap);
      for(String key: statsMapSorted.keySet()){
        System.out.println("Product Id: " + key + " Name: " + productsMap.get(key).getName() + " Frequency: " + statsMap.get(key));
      }
    }

    //sort map in descending order
    public HashMap<String, Integer> sortByFrequency(HashMap<String, Integer> oldMap)
    {
      LinkedHashMap<String, Integer> sorted = new LinkedHashMap<String, Integer>();
      ArrayList<Map.Entry<String, Integer>> newList = new ArrayList<Map.Entry<String, Integer>>(oldMap.entrySet());         //put prods from map in a list to sort

      Collections.sort(newList, new Comparator<Map.Entry<String, Integer>>() {
        public int compare(Map.Entry<String, Integer> prod1, Map.Entry<String, Integer> prod2){
          return -1*(Integer.compare(prod1.getValue(), prod2.getValue()));        //sort list in descending order
        }
      });

      for (Map.Entry<String, Integer> prodFreq: newList){
        sorted.put(prodFreq.getKey(), prodFreq.getValue());
      }
      return sorted;
    }

    // BONUS Rating Methods
    public void setRating(String productId, String custRating)
    {
      //code for error handling
      Product prod = null;
      if (productsMap.containsKey(productId)){
        prod = productsMap.get(productId);
      }
      if (prod==null){
        throw new ProductNotFound("Product "+productId+" not found");
      }
      //set rating based on input
      Ratings rating = prod.getRatings();
      if (custRating.equalsIgnoreCase("ZEROSTAR")){
        rating.setZeroStar();
      }
      else if (custRating.equalsIgnoreCase("ONESTAR")){
        rating.setOneStar();
      }
      else if (custRating.equalsIgnoreCase("TWOSTAR")){
        rating.setTwoStar();
      }
      else if (custRating.equalsIgnoreCase("THREESTAR")){
        rating.setThreeStar();
      }
      else if (custRating.equalsIgnoreCase("FOURSTAR")){
        rating.setFourStar();
      }
      else if (custRating.equalsIgnoreCase("FIVESTAR")){
        rating.setFiveStar();
      }
      else{
        throw new InvalidProductOptions("Customer Rating "+custRating+" is invalid");
      }
    }

    public void getProdRating(String category, double threshold)
    {
      //code for error handling
      if(threshold>5.0 || threshold<0.0){
        throw new InvalidProductOptions("Threshold "+threshold+" is invalid");
      }
      ArrayList<Product> toPrint = new ArrayList<Product>();
      Ratings rating = null;
      //add the prods to a list based on category
      if (category.equalsIgnoreCase("GENERAL")){
        for (Product p: productsMap.values()){
          if (p.getCategory().equals(Product.Category.GENERAL)){
            toPrint.add(p);
          }
        }
      }
      else if (category.equalsIgnoreCase("CLOTHING")){
        for (Product p: productsMap.values()){
          if (p.getCategory().equals(Product.Category.CLOTHING)){
            toPrint.add(p);
          }
        }
      }
      else if (category.equalsIgnoreCase("BOOKS")){
        for (Product p: productsMap.values()){
          if (p.getCategory().equals(Product.Category.BOOKS)){
            toPrint.add(p);
          }
        }
      }
      else if (category.equalsIgnoreCase("FURNITURE")){
        for (Product p: productsMap.values()){
          if (p.getCategory().equals(Product.Category.FURNITURE)){
            toPrint.add(p);
          }
        }
      }
      else if (category.equalsIgnoreCase("COMPUTERS")){
        for (Product p: productsMap.values()){
          if (p.getCategory().equals(Product.Category.COMPUTERS)){
            toPrint.add(p);
          }
        }
      }
      else {
        throw new InvalidProductOptions("Category " +category+" is invalid");
      }
      for (Product p: toPrint){
        rating = p.getRatings();
        if (rating.calculateRating()>threshold){
          System.out.println("Product "+p.getId()+" Rating "+rating.calculateRating()+"/5.0");  //print all products above the threshold rating
        }
      }
    }
    
}

//exception sublclasses
class CustomerNotFound extends RuntimeException
{
  public CustomerNotFound(){

  }
  public CustomerNotFound(String message){
    super(message);
  }
}

class ProductNotFound extends RuntimeException
{
  public ProductNotFound(){

  }
  public ProductNotFound(String message){
    super(message);
  }
}

class InvalidProductOptions extends RuntimeException
{
  public InvalidProductOptions(){

  }
  public InvalidProductOptions(String message){
    super(message);
  }
}

class OutOfStock extends RuntimeException
{
  public OutOfStock(){

  }
  public OutOfStock(String message){
    super(message);
  }
}

class InvalidCustName extends RuntimeException
{
  public InvalidCustName(){

  }
  public InvalidCustName(String message){
    super(message);
  }
}

class InvalidCustAddress extends RuntimeException
{
  public InvalidCustAddress(){

  }
  public InvalidCustAddress(String message){
    super(message);
  }
}

class InvalidOrderNumber extends RuntimeException
{
  public InvalidOrderNumber(){

  }
  public InvalidOrderNumber(String message){
    super(message);
  }
}

//for a1 bonus
class AuthorNotFound extends RuntimeException
{
  public AuthorNotFound(){

  }
  public AuthorNotFound(String message){
    super(message);
  }
}