//Sadaf Saadman Jawad Ryerson Id #501126527

/*
 *  class Customer defines a registered customer. It keeps track of the customer's name and address. 
 *  A unique id is generated when when a new customer is created. 
 *  
 *  Implement the Comparable interface and compare two customers based on name
 */
public class Customer 
{
	private String id;  
	private String name;
	private String shippingAddress;
	private Cart cart;
	
	public Customer(String id)
	{
		this.id = id;
		this.name = "";								//initialize when given id only
		this.shippingAddress = "";
		this.cart = new Cart();
	}
	
	public Customer(String id, String name, String address)
	{
		this.id = id;
		this.name = name;						//initialize when given id, name , address
		this.shippingAddress = address;
		this.cart = new Cart();
	}
	
	public String getId()
	{
		return id;								//reutn cutomer id
	}
	public void setId(String id)
	{
		this.id = id;						//set the customer id
	}
	public String getName()
	{
		return name;							//return name of the customer
	}
	
	public void setName(String name)
	{
		this.name = name;							//set the name of a customer
	}
	
	public String getShippingAddress()
	{
		return shippingAddress;							//get shipping address of a customer
	}

	public Cart getCart()
	{
		return cart;									//return the cart object of a customer
	}
	
	public void setShippingAddress(String shippingAddress)
	{
		this.shippingAddress = shippingAddress;						//set the shipping address to a given parameter
	}
	
	public void print()
	{
		System.out.printf("\nName: %-20s ID: %3s Address: %-35s", name, id, shippingAddress);		//print all the info
	}
	
	public boolean equals(Object other)
	{
		Customer otherC = (Customer) other;							//override the default equals method for objects
		return this.id.equals(otherC.id);
	}
	
}
