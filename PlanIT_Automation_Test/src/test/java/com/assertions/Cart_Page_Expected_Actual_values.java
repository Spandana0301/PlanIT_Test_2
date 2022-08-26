package com.assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.base.TestBase;

public class Cart_Page_Expected_Actual_values extends TestBase{
 
	public WebDriver driver;
	
	 public Cart_Page_Expected_Actual_values(WebDriver driver) {
		this.driver=driver;
    }
	 
	//Expected subtotal 
    public  String StuffedFrogsubtotal = "$21.98";
	public   String FluffyBunnysubtotal = "$49.95";
	public  String ValentineBearsubtotal = "$44.97";

	// Expected values for prices
	public  String StuffedFrogprice = "$10.99";
	public   String FluffyBunnyprice = "$9.99";
	public   String ValentineBearprice = "$14.99";
	
	// Expected value for Total
    public   double price = 116.9;
    
    //Actual subtotal
    public String stuffedFrogSubtotal() {
	String Stuffedfrogitem = driver.findElement(By.xpath("//*[contains(.,'Stuffed Frog')]//td[4]")).getText();
	return Stuffedfrogitem;
    }
    
    public String valentineBearsubtotal() {
	String ValentineBearitem = driver.findElement(By.xpath("//*[contains(.,'Valentine Bear')]//tr[3]//td[4]")).getText();
    return ValentineBearitem;
    }

    public String fluffybunnySubtotal() {
	String Fluffybunnyitem = driver.findElement(By.xpath("//*[contains(.,'Fluffy Bunny')]//tr[2]//td[4]")).getText();
    return Fluffybunnyitem;
    }
    
    //Actual prices
    public String stuffedFrogPrices() {
	String StuffedFrogprice = driver.findElement(By.xpath("//*[contains(.,'Stuffed Frog')]//td[2]")).getText();
	return StuffedFrogprice;
	}
    
    public String fluffyBunnyPrices() {
	String FluffyBunnyprice = driver.findElement(By.xpath("//*[contains(.,'Fluffy Bunny')]//tr[2]//td[2]")).getText();
	return FluffyBunnyprice;
	}

    public String valentineBearPrices() {
	String ValentineBearprice= driver.findElement(By.xpath("//*[contains(.,'Valentine Bear')]//tr[3]//td[2]")).getText();
	return ValentineBearprice;
	}
    
    //Actual total price
    public double totalPrice() {
	double StuffedFrogpricesValue= Double.valueOf(stuffedFrogSubtotal().substring(1));
	double FluffyBunnypricesValue= Double.valueOf(fluffybunnySubtotal().substring(1));
	double ValentineBearpricesValue= Double.valueOf(valentineBearsubtotal().substring(1));		
	double totalprice = StuffedFrogpricesValue + FluffyBunnypricesValue + ValentineBearpricesValue;
	return totalprice;
    }

    
    //Actual Successful Message
	public String actualSucessfullMessage() {
	String actualmsg = driver.findElement(By.xpath("//strong[contains(@class,'ng-binding')]")).getText().substring(0, 6);
	return actualmsg;
	}
	
    public  String expectedsuccessfulmes = "Thanks";
	
}
