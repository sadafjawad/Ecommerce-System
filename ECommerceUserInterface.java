//Sadaf Saadman Jawad Ryerson Id #501126527

import java.util.Scanner;

// Simulation of a Simple E-Commerce System (like Amazon)

public class ECommerceUserInterface
{
	public static void main(String[] args)
	{
		// Create the system
		ECommerceSystem amazon = new ECommerceSystem();

		Scanner scanner = new Scanner(System.in);
		System.out.print(">");
		
		// Process keyboard actions
		while (scanner.hasNextLine())
		{
			String action = scanner.nextLine();

			try
			{
				if (action == null || action.equals("")) 
				{
					System.out.print("\n>");
					continue;
				}
				else if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT"))
					return;
	
				else if (action.equalsIgnoreCase("PRODS"))	// List all products for sale
				{
					amazon.printAllProducts(); 
				}
				else if (action.equalsIgnoreCase("BOOKS"))	// List all books for sale
				{
					amazon.printAllBooks(); 
				}
				else if (action.equalsIgnoreCase("SHOES")) // list all shoes for sale
				{
					amazon.printAllShoes();												//added new option to print all shoes
				}
				else if (action.equalsIgnoreCase("CUSTS")) 	// List all registered customers
				{
					amazon.printCustomers();	
				}
				else if (action.equalsIgnoreCase("ORDERS")) // List all current product orders
				{
					amazon.printAllOrders();	
				}
				else if (action.equalsIgnoreCase("SHIPPED"))	// List all orders that have been shipped
				{
					amazon.printAllShippedOrders();	
				}
				else if (action.equalsIgnoreCase("NEWCUST"))	// Create a new registered customer
				{
					String name = "";
					String address = "";
					
					System.out.print("Name: ");
					if (scanner.hasNextLine())
						name = scanner.nextLine();
					
					System.out.print("\nAddress: ");
					if (scanner.hasNextLine())
						address = scanner.nextLine();
					
					amazon.createCustomer(name, address);	

				}
				else if (action.equalsIgnoreCase("SHIP"))	// ship an order to a customer
				{
						String orderNumber = "";
			
						System.out.print("Order Number: ");
						// Get order number from scanner
						orderNumber+=scanner.nextLine();						//add order number to orderNumber
						amazon.shipOrder(orderNumber).print();

				}
				else if (action.equalsIgnoreCase("CUSTORDERS")) // List all the current orders and shipped orders for this customer id
				{
					String customerId = "";
	
					System.out.print("Customer Id: ");									//add input to customer id
					// Get customer Id from scanner
					customerId+=scanner.nextLine();
					// Print all current orders and all shipped orders for this customer
					amazon.printOrderHistory(customerId);

				}
				else if (action.equalsIgnoreCase("ORDER")) // order a product for a certain customer
				{
					String productId = "";
					String customerId = "";
	
					System.out.print("Product Id: ");							//add product id from input
				  // Get product Id from scanner
					  productId+=scanner.nextLine();
					System.out.print("\nCustomer Id: ");						//add customer id from input
				  // Get customer Id from scanner
					customerId+=scanner.nextLine();
					System.out.println(amazon.orderProduct(productId, customerId, ""));

				}
				else if (action.equalsIgnoreCase("ORDERBOOK")) // order a book for a customer, provide a format (Paperback, Hardcover or EBook)
				{
					String productId = "";
					String customerId = "";
					String options = "";
	
					System.out.print("Product Id: ");						//add product id from input
					// get product id
					productId+=scanner.nextLine();
					System.out.print("\nCustomer Id: ");							//add customer id from input
					// get customer id
					customerId+=scanner.nextLine();
					System.out.print("\nFormat [Paperback Hardcover EBook]: ");		//also add option for Book type
					// get book forma and store in options string
					options+=scanner.nextLine();
					
					// Order product. Check for error mesage set in ECommerceSystem
					System.out.println(amazon.orderProduct(productId, customerId, options));

				}
				else if (action.equalsIgnoreCase("ORDERSHOES")) // order shoes for a customer, provide size and color 
				{
					String productId = "";
					String customerId = "";
					String options = "";
					
					System.out.print("Product Id: ");								//take input for product id
					// get product id
					productId+=scanner.nextLine();
					System.out.print("\nCustomer Id: ");							//take input for customer id
					// get customer id
					customerId+=scanner.nextLine();
					System.out.print("\nSize: \"6\" \"7\" \"8\" \"9\" \"10\": ");		//take input for size
					// get shoe size and store in options	
					options+=scanner.nextLine();
					System.out.print("\nColor: \"Black\" \"Brown\": ");					//take input for color
					// get shoe color and append to options
					options+=" "+scanner.nextLine();
					//order shoes
					System.out.println(amazon.orderProduct(productId, customerId, options));

				}
				
				
				else if (action.equalsIgnoreCase("CANCEL")) // Cancel an existing order
				{
					String orderNumber = "";
	
					System.out.print("Order Number: ");						//take order number from input
					// get order number from scanner
					orderNumber+=scanner.nextLine();
					// cancel order. Check for error
					amazon.cancelOrder(orderNumber);

				}
				else if (action.equalsIgnoreCase("PRINTBYPRICE")) // sort products by price
				{
					amazon.sortByPrice();
				}
				else if (action.equalsIgnoreCase("PRINTBYNAME")) // sort products by name (alphabetic)
				{
					amazon.sortByName();
				}
				else if (action.equalsIgnoreCase("SORTCUSTS")) // sort products by name (alphabetic)
				{
					amazon.sortCustomersByName();
				}
				else if (action.equalsIgnoreCase("BOOKSBYAUTHOR"))
				{
					String author = "";
	
					System.out.print("Author: ");										//take input for author name
	
					author+=scanner.nextLine();
	
					amazon.sortAndPrintByYear(author);

				}
				else if (action.equalsIgnoreCase("ADDTOCART"))		//add products to a cart of a customer
				{
					String productID = "";
					String customerID = "";
					String productOptions = "";
	
					System.out.print("Product Id: ");
					productID += scanner.nextLine();
	
					System.out.print("Customer Id: ");
					customerID += scanner.nextLine();
	
					System.out.print("Product Option: ");
					productOptions += scanner.nextLine();
	
					amazon.addToCart(productID, customerID, productOptions);

				}
				else if (action.equalsIgnoreCase("REMCARTITEM"))				//remove an item from the cart
				{
					String productID = "";
					String customerID = "";
					
					System.out.print("Product Id: ");
					productID += scanner.nextLine();
	
					System.out.print("Customer Id: ");
					customerID += scanner.nextLine();
	
					amazon.remCartItem(productID, customerID);

				}
				else if (action.equalsIgnoreCase("PRINTCART"))		//print all items in cart
				{
					String customerID = "";
	
					System.out.print("Customer Id: ");
					customerID += scanner.nextLine();
	
					amazon.printCart(customerID);

				}
				else if (action.equalsIgnoreCase("ORDERITEMS"))			//order all items in cart and empty cart
				{
					String customerID = "";
	
					System.out.print("Customer Id: ");
					customerID += scanner.nextLine();
	
					System.out.println(amazon.orderCart(customerID));

				}
				else if (action.equalsIgnoreCase("STATS"))			//print product and number of times it was ordered
				{
					amazon.printStats();
				}
				else if (action.equalsIgnoreCase("SETRATING"))			//rate a product
				{
					String productId = "";
					String rating = "";

					System.out.print("Product Id: ");
					productId+=scanner.nextLine();					

					System.out.print("Ratings [zerostar onestar twostar threestar fourstar fivestar]: ");
					rating+=scanner.nextLine();

					amazon.setRating(productId, rating);
				}
				else if (action.equalsIgnoreCase("PRINTRATING"))		//print ratings based on category and threshold
				{
					String category = "";
					double threshold = 0.0;

					System.out.print("Category [GENERAL,CLOTHING,BOOKS,FURNITURE,COMPUTERS]: ");
					category+=scanner.nextLine();

					System.out.print("Threshold [0-5]: ");
					threshold=scanner.nextDouble();

					amazon.getProdRating(category, threshold);
				}
			}
			//catch exceptions
			catch (CustomerNotFound ex)
			{
				System.out.println(ex.getMessage());
			}
			catch (ProductNotFound ex)
			{
				System.out.println(ex.getMessage());
			}
			catch (InvalidProductOptions ex)
			{
				System.out.println(ex.getMessage());
			}
			catch (OutOfStock ex)
			{
				System.out.println(ex.getMessage());
			}
			catch (InvalidCustName ex)
			{
				System.out.println(ex.getMessage());
			}
			catch (InvalidCustAddress ex)
			{
				System.out.println(ex.getMessage());
			}
			catch (InvalidOrderNumber ex)
			{
				System.out.println(ex.getMessage());
			}
			catch (AuthorNotFound ex)
			{
				System.out.println(ex.getMessage());
			}
			System.out.print("\n>");
		}
	}
}

