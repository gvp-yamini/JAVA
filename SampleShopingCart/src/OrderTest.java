import java.util.Iterator;


public class OrderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Order o = new Order("Yamini Thota");		
		o.addProduct(new Product("p101","Lux Soap",12,120));
		o.addProduct(new Product("p102","Olive Oil",4,140));
		
		System.out.println("\nNo. of Product : "+o.productCount());
		System.out.println ("Order Places By: "+o.uid);
			
    System.out.println ("Cart Total : "+o.getCartPrice());   
		final Iterator<Product> it = o.getCartDetails().iterator();
		while(it.hasNext()){		
			System.out.println (it.next());
		}

	}

}
