//Sadaf Saadman Jawad Ryerson Id #501126527

import java.util.ArrayList;

public class Cart 
{

    private ArrayList<CartItem> cartList = new ArrayList<CartItem>();

    public Cart()                                   //initializes cart object
    {

    }

    public int getSize()
    {
        return cartList.size();                     //return cart size
    }

    public CartItem getItem(String productId)
    {
        CartItem newItem = null;
        for (CartItem c: cartList){
            if(c.getProductId().equals(productId)){             //return a reference of CartItem that matches give id
                newItem=c;
            }
        }
        return newItem;
    }

    public ArrayList<CartItem> getItems()
    {
        return cartList;                            //return a reference to the list
    }
    
    public void addItem(CartItem item)
    {
        cartList.add(item);                         //add item to the cart
    }

    public void removeItem(CartItem item)
    {
        cartList.remove(item);                          //remove item from a cart
    }

    public boolean checkItem(String productId)
    {
        for (CartItem c: cartList){
            if (c.getProductId().equals(productId)){            //check whether an item exists or not
                return true;
            }
        }
        return false;
    }

    public void clearCart()
    {
        cartList.clear();                                   //remove all items in cart
    }

    public void printItems()
    {
        for (CartItem c: cartList){                     //print all products in cart
            c.print();
        }
    }
    


}
