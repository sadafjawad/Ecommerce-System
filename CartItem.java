//Sadaf Saadman Jawad Ryerson Id #501126527

public class CartItem 
{

    private String productOptions;
    private Product product; 

    public CartItem(Product product, String productOptions)
    {
        this.productOptions=productOptions;                     //initialize
        this.product=product;
    }


    public Product getProduct()
    {
        return product;                         //return reference of the product
    }

    public String getProductId()
    {
        return product.getId();                 //return the id of the product
    }

    public String getProductOptions()
    {
        return productOptions;                  //return the product option
    }


    public void print()
    {
        product.print();                //print a CartItem object
    }



}
