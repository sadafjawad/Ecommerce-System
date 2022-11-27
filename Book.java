//Sadaf Saadman Jawad Ryerson Id #501126527

/* A book IS A product that has additional information - e.g. title, author

 	 A book also comes in different formats ("Paperback", "Hardcover", "EBook")
 	 
 	 The format is specified as a specific "stock type" in get/set/reduce stockCount methods.

*/
public class Book extends Product 
{
  private String author;
  private String title;
  private int year;
  
  // Stock related information NOTE: inherited stockCount variable is used for EBooks
  int paperbackStock;
  int hardcoverStock;
  

  public Book(String name, String id, double price, int paperbackStock, int hardcoverStock, String title, String author, int year)
  {
  	 // Make use of the constructor in the super class Product. Initialize additional Book instance variables. 
  	 // Set category to BOOKS 
     super(name, id, price, 100000, Product.Category.BOOKS);    //using the constructor from parent class to initialize exisitng variables
     this.title = title;
     this.author = author;                                //initializing new instance variables
     this.year = year;
     this.paperbackStock = paperbackStock;
     this.hardcoverStock = hardcoverStock;
  }
    
  // Check if a valid format  
  public boolean validOptions(String productOptions)
  {
  	// check productOptions for "Paperback" or "Hardcover" or "EBook"
  	// if it is one of these, return true, else return false
    if (productOptions.equalsIgnoreCase("Paperback") ||  productOptions.equalsIgnoreCase("Hardcover") || productOptions.equalsIgnoreCase("Ebook")) {
      return true;
    }                                       // if productoptions is paperback, hardcover, or ebook then return true else return false
    return false;
  }
  
  // Override getStockCount() in super class.
  public int getStockCount(String productOptions)
	{
  	// Use the productOptions to check for (and return) the number of stock for "Paperback" etc
  	// Use the variables paperbackStock and hardcoverStock at the top. 
  	// For "EBook", use the inherited stockCount variable.
    if (productOptions.equalsIgnoreCase("Paperback")) {           //if paper back then return paperback stock count
      return paperbackStock;
    }
    if (productOptions.equalsIgnoreCase("Hardcover")) {         //if hardcover then return hardcover stock count
      return hardcoverStock;
    }
    if (productOptions.equalsIgnoreCase("Ebook")) {             //if ebook then use super. to use the getstockcount method from the parent class
      return super.getStockCount(productOptions);
    }
  	return 1;
	}
  
  public void setStockCount(int stockCount, String productOptions)
	{
    // Use the productOptions to check for (and set) the number of stock for "Paperback" etc
   	// Use the variables paperbackStock and hardcoverStock at the top. 
   	// For "EBook", set the inherited stockCount variable.
    if (productOptions.equalsIgnoreCase("Paperback")){        //if option is paperback then set paperback stockcount
       paperbackStock=stockCount;
     }
    if (productOptions.equalsIgnoreCase("Hardcover")){        //if option is harcover then set harcover stockcount
       hardcoverStock=stockCount;
    }
    if (productOptions.equalsIgnoreCase("Ebook")){          //if option is ebook then use super. to access set method from parent class and set stocl count
      super.setStockCount(stockCount, productOptions);
    }
	}
  
  /*
   * When a book is ordered, reduce the stock count for the specific stock type
   */
  public void reduceStockCount(String productOptions)
	{
  	// Use the productOptions to check for (and reduce) the number of stock for "Paperback" etc
   	// Use the variables paperbackStock and hardcoverStock at the top. 
   	// For "EBook", set the inherited stockCount variable.
     if (productOptions.equalsIgnoreCase("Paperback")){     //if paperback then reduce paperback decrement paperback stockount by 1
       paperbackStock--;
     }
     if (productOptions.equalsIgnoreCase("Hardcover")){     //if hardcover then reduce paperback decrement hardcover stockount by 1
      hardcoverStock--;
     }
     if (productOptions.equalsIgnoreCase("Ebook")){       //if ebook then reduce paperback decrement ebook stockount by 1 by using the inherited reduceStockCount method
      super.reduceStockCount(productOptions);
     }
	}
  /*
   * Print product information in super class and append Book specific information title and author
   */
  public void print()
  {
  	// Replace the line below.
  	// Make use of the super class print() method and append the title and author info. See the video
    super.print();
  	System.out.print(" "+"Book Title: "+title+" Author: "+author);       //use the inherited print method and add additional info to print
  }

  // (BONUS) Helper methods used for the bonus
  public void printWithYear()
  {
    super.print();
    System.out.print(" "+"Book Title: "+title+" Author: "+author+" Year: "+year);   //use the inherited print method and add additional info to print along with year
  }

  public int getYear()
  {
    return year;                      //return year
  }

  public String getAuthor()
  {
    return author;        //return author
  }

}
