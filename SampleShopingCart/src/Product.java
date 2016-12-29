public class Product implements java.io.Serializable{
	public String pid;
	public String pname;
	public int qty;
	public double price;
	
	public Product(){};
	public Product(String pid,String pname,int qty,double price){
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
	}	
	public String toString(){
		String foo;
		foo="pid: "+this.pid+" pname: "+this.pname+" qty:"+this.qty+" price:"+this.price;
	    return foo;
	}
	public String getPid(){
		return this.pid;
	}
	public String getPname(){
		return this.pname;
	}
	public int getQty(){
		return this.qty;
	}
	public double getPrice(){
		return this.price;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	public void setPid(String pid){
		this.pid=pid;
	}
	public void setPname(String pname){
		this.pname = pname;
	}
	public void setQty(int qty){
		this.qty = qty;
	}
}
