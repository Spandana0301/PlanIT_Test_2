package data;

public class ProductDetails {

	String itemName1;
	String itemName2;
	String itemName3;
    int quantityforItem1 ;
    int quantityforItem2;
    String[] productNames;
    double[] productPrices;
	public ProductDetails(String itemName1, String itemName2, String itemName3) {

		this.itemName1 = itemName1;
		this.itemName2 = itemName2;
		this.itemName3 = itemName3;
       }
	
	public ProductDetails(String itemName1, String itemName2, int quantityforItem1, int quantityforItem2) {
		this.itemName1=itemName1;
		this.itemName2=itemName2;
		this.quantityforItem1=quantityforItem1;
		this.quantityforItem2=quantityforItem2;
		
	}

	public ProductDetails() {
		// TODO Auto-generated constructor stub
	}

	
	public String getProductNames(int i) {
		
		return productNames[i];
	}
	
	public double getProductPrices(int i) {
		
		return productPrices[i];
	}
	
	public int getNumberofproducts() {
		
		return productNames.length;
	}
	 public void setProductPrices(double[] price) {
	    	productPrices=price;
	    	
	    }
	 
	 public void setProductNames(String[] names) {
	    	productNames=names;
	    	
	    }
	
			
	public void setitemName1(String itemName1) {
		this.itemName1 = itemName1;
	}

	public void setitemName2(String itemName2) {
		this.itemName2 = itemName2;
	}

	public void setitemName3(String itemName3) {
		this.itemName3 = itemName3;
	}
	
	public void setQuantityForItem1(int quantityforItem1) {
		this.quantityforItem1=quantityforItem1;
	}
	public void setQuantityForItem2(int quantityforItem2) {
		this.quantityforItem2=quantityforItem2;
	}
	public String getitemName1() {
		return itemName1;
	}

	public String getitemName2() {
		return itemName2;
	}

	public String getitemName3() {
		return itemName3;
	}
	public int getQuantityForItem1() {
		return quantityforItem1;
	}
	public int getQuantityForItem2() {
		return quantityforItem2;
	}
	

}
