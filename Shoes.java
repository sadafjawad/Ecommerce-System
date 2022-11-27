//Sadaf Saadman Jawad Ryerson Id #501126527

public class Shoes extends Product 
{
    
   private String color;

   private int size6brown;
   private int size7brown;
   private int size8brown;
   private int size9brown;                              //instance variables to hold brown shoe stock based on size
   private int size10brown;

   private int size6black;
   private int size7black;
   private int size8black;                      //instance variables to hold black shoe stock based on size
   private int size9black;
   private int size10black;


    public Shoes(String name, String id, double price, int stock, Category category, String color) {
     

     super(name, id, price, 0, Product.Category.SHOES);    //using the constructor from parent class to initialize exisitng variables
     this.color=color;
     if (color.equalsIgnoreCase("brown")){
        this.size6brown = stock;
        this.size7brown = stock;                        //if shoe is brown then set stock for brown shoe instance variables
        this.size8brown = stock;
        this.size9brown = stock;
        this.size10brown = stock;
     }
     else if (color.equalsIgnoreCase("black")){
        this.size6black = stock;
        this.size7black = stock;                            //if shoe is black then set stock for black shoe instacne variables
        this.size8black = stock;
        this.size9black = stock;
        this.size10black = stock;
     }
     
   }

    public boolean validOptions(String productOptions){

        if (productOptions.equalsIgnoreCase("6 brown") || productOptions.equalsIgnoreCase("7 brown") || productOptions.equalsIgnoreCase("8 brown") || productOptions.equalsIgnoreCase("9 brown") || productOptions.equalsIgnoreCase("10 brown") || productOptions.equalsIgnoreCase("6 black") || productOptions.equalsIgnoreCase("7 black") || productOptions.equalsIgnoreCase("8 black") || productOptions.equalsIgnoreCase("9 black") || productOptions.equalsIgnoreCase("10 black")){
            return true;                    //check to see wether options are valid ot not
        }
        return false;
    }

    public int getStockCount(String productOptions)
	{
        if (productOptions.equalsIgnoreCase("6 brown")) {          
            return size6brown;
        }
        if (productOptions.equalsIgnoreCase("7 brown")) {         
            return size7brown;
        }
        if (productOptions.equalsIgnoreCase("8 brown")) {             
            return size8brown;
        }
        if (productOptions.equalsIgnoreCase("9 brown")) {            
            return size9brown;
        }
        if (productOptions.equalsIgnoreCase("10 brown")) {                  //return stockcount of specific size and color
            return size10brown; 
        }
        if (productOptions.equalsIgnoreCase("6 black")) {             
            return size6black;
        }
        if (productOptions.equalsIgnoreCase("7 black")) {             
            return size7black;
        }
        if (productOptions.equalsIgnoreCase("8 black")) {             
            return size8black;
        }
        if (productOptions.equalsIgnoreCase("9 black")) {             
            return size9black;
        }
        if (productOptions.equalsIgnoreCase("10 black")) {             
            return size10black;
        }
        return 1;
    }


    public void setStockCount(int stockCount, String productOptions)
	{
        if (productOptions.equalsIgnoreCase("6 brown")) {           
            size6brown=stockCount;
        }
        if (productOptions.equalsIgnoreCase("7 brown")) {         
            size7brown=stockCount;
        }
        if (productOptions.equalsIgnoreCase("8 brown")) {             
            size8brown=stockCount;
        }
        if (productOptions.equalsIgnoreCase("9 brown")) {             
            size9brown=stockCount;
        }
        if (productOptions.equalsIgnoreCase("10 brown")) {             
            size10brown=stockCount;
        }
        if (productOptions.equalsIgnoreCase("6 black")) {            
            size6black=stockCount;
        }
        if (productOptions.equalsIgnoreCase("7 black")) {             //set stockcount for specific size and color
            size7black=stockCount;
        }
        if (productOptions.equalsIgnoreCase("8 black")) {             
            size8black=stockCount;
        }
        if (productOptions.equalsIgnoreCase("9 black")) {            
            size9black=stockCount;
        }
        if (productOptions.equalsIgnoreCase("10 black")) {            
            size10black=stockCount;
        }
	}



    public void reduceStockCount(String productOptions)
	{
        if (productOptions.equalsIgnoreCase("6 brown")) {           
            size6brown--;
        }
        if (productOptions.equalsIgnoreCase("7 brown")) {        
            size7brown--;
        }
        if (productOptions.equalsIgnoreCase("8 brown")) {             
            size8brown--;
        }
        if (productOptions.equalsIgnoreCase("9 brown")) {             
            size9brown--;
        }
        if (productOptions.equalsIgnoreCase("10 brown")) {             //reduce stockcount for specific size and color
            size10brown--;
        }
        if (productOptions.equalsIgnoreCase("6 black")) {             
            size6black--;
        }
        if (productOptions.equalsIgnoreCase("7 black")) {             
            size7black--;
        }
        if (productOptions.equalsIgnoreCase("8 black")) {             
            size8black--;
        }
        if (productOptions.equalsIgnoreCase("9 black")) {             
            size9black--;
        }
        if (productOptions.equalsIgnoreCase("10 black")) {             
            size10black--;
        }
	}

    public void print()
    {
        super.print();
        System.out.print(" "+"Shoe size: 6, 7, 8, 9, 10"+" Color: "+color);       //use the inherited print method and add additional info to print
    }

}
